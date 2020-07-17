package com.group8.dalsmartteamwork.courseadmin.models;

import com.group8.dalsmartteamwork.accesscontrol.User;
import com.group8.dalsmartteamwork.courseadmin.dao.IStudentEnrollmentDao;
import com.group8.dalsmartteamwork.login.model.IEncryption;
import com.group8.dalsmartteamwork.register.dao.IRegistrationDao;
import com.group8.dalsmartteamwork.register.models.IRegistrationFactory;
import com.group8.dalsmartteamwork.resetpassword.models.IMail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class StudentImportManagerImpl implements IStudentImportManager {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private final IRegistrationDao registrationDao;
    private final IStudentEnrollmentDao studentEnrollmentDao;
    private final IMail mail;
    private final IEncryption encryption;
    private final IPasswordGenerator passwordGenerator;
    private final int courseId;

    public StudentImportManagerImpl(int courseId, IRegistrationFactory iRegistrationFactory, IStudentEnrollmentFactory iStudentEnrollmentFactory) {
        this.courseId = courseId;
        registrationDao = iRegistrationFactory.getRegistrationDaoObject();
        mail = iRegistrationFactory.getMailObject();
        encryption = iRegistrationFactory.getEncryptionObject();
        studentEnrollmentDao = iStudentEnrollmentFactory.getStudentEnrollmentDaoObject();
        passwordGenerator = iStudentEnrollmentFactory.getPasswordGeneratorObject();
    }

    @Override
    public List<Boolean> verifyRegistration(List<User> users) {
        List<Boolean> status = new ArrayList<>();
        try {
            if (users.size() == 0) {
                return status;
            }
            for (User user : users) {
                String password = passwordGenerator.generatePassword();
                String encrypted_password = encryption.encrypt(password);
                user.setPassword(encrypted_password);
                Boolean userDbStatus = this.registrationDao.isUserInDb(user.getId());
                if (userDbStatus) {
                    status.add(false);
                    studentEnrollmentDao.assignCourseToUser(user.getId(), courseId);
                } else {
                    registrationDao.addUserToDb(user);
                    studentEnrollmentDao.assignCourseToUser(user.getId(), courseId);
                    final String INVITE_TEXT_FORMAT = "You have been registered to CatME and registered for the course %d. You can login with your email and password: %s";
                    final String INVITE_SUBJECT = "CatME Registration";
                    status.add(true);
                    String message = String.format(INVITE_TEXT_FORMAT, courseId, password);
                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            mail.sendEmail(user.getEmail(), INVITE_SUBJECT, message);
                        }
                    });
                    t.start();
                }
            }
        } catch (Exception e) {
            LOGGER.error("Exception occurred while verifying user registration.", e);
        }
        return status;
    }
}