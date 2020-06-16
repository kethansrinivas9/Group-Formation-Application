package com.group8.dalsmartteamwork.courseadmin.services;

import com.group8.dalsmartteamwork.register.dao.RegistrationDao;
import com.group8.dalsmartteamwork.utils.*;

import java.util.ArrayList;
import java.util.List;

public class ImportStudentServiceImpl implements ImportStudentService {
    private RegistrationDao dao;
    private Mail mail;
    private int courseId;
    private IEncryption encryption;
    private IPasswordGenerator passwordGenerator;

    public ImportStudentServiceImpl(int courseId, RegistrationDao dao, Mail mail){
        this.courseId = courseId;
        this.dao = dao;
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
                Boolean userDbStatus = this.dao.isUserInDb(user.getId());
                if(userDbStatus){
                    status.add(false);
                    this.dao.assignCourseToUser(user.getId(), courseId);
                }
                else {
                    this.dao.addUserToDb(user);
                    this.dao.assignCourseToUser(user.getId(), courseId);
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