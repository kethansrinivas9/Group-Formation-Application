package com.group8.dalsmartteamwork.courseadmin.models;

import com.group8.dalsmartteamwork.courseadmin.dao.IStudentEnrollmentDao;
import com.group8.dalsmartteamwork.register.dao.RegistrationDao;
import com.group8.dalsmartteamwork.utils.*;

import java.util.ArrayList;
import java.util.List;

public class StudentImportManagerImpl implements IStudentImportManager {
    private RegistrationDao registrationDao;
    private IStudentEnrollmentDao studentEnrollmentDao;
    private Mail mail;
    private int courseId;
    private IEncryption encryption;
    private IPasswordGenerator passwordGenerator;

    public StudentImportManagerImpl(int courseId, RegistrationDao registrationDao, IStudentEnrollmentDao studentEnrollmentDao, Mail mail){
        this.courseId = courseId;
        this.registrationDao = registrationDao;
        this.studentEnrollmentDao = studentEnrollmentDao;
        this.mail = mail;
        encryption = new Encryption();
        passwordGenerator = new PasswordGenerator();
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
                if(userDbStatus){
                    status.add(false);
                    studentEnrollmentDao.assignCourseToUser(user.getId(), courseId);
                }
                else {
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
            // TODO: Add to Log
            e.printStackTrace();
        }
        return status;
    }
}