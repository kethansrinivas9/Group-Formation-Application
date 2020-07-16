package com.group8.dalsmartteamwork.courseadmin.models;

public class CourseAdminModelsFactory extends CourseAdminModelsAbstractFactory {
    private static CourseAdminModelsFactory instance = null;
    private IPasswordGenerator passwordGenerator;
    private IStudentImportManager studentImportManager;
    private MakePairService makePairService;

    CourseAdminModelsFactory() {
    }

    public static CourseAdminModelsFactory instance() {
        if (null == instance) {
            instance = new CourseAdminModelsFactory();
        }
        return instance;
    }

    @Override
    public IPasswordGenerator passwordGenerator() {
        if (null == passwordGenerator) {
            passwordGenerator = new PasswordGenerator();
        }
        return passwordGenerator;
    }

    @Override
    public MakePairService makePairService() {
        if (null == makePairService) {
            makePairService = new MakePairServiceImpl();
        }
        return makePairService;
    }
}
