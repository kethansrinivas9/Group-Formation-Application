package com.group8.dalsmartteamwork.groupformationlogic.models;

import com.group8.dalsmartteamwork.groupformationlogic.dao.GroupFormationHandlerDaoImpl;
import com.group8.dalsmartteamwork.groupformationlogic.dao.IGroupFormationHandlerDao;

import java.util.*;

public class GroupFormationAlgorithm implements IGroupFormationAlgorithm {

    @Override
    public void createGroups() {
        IGroupFormationHandlerDao iGroupFormationHandlerDao = new GroupFormationHandlerDaoImpl();
        IGroupFormationHandler iGroupFormationHandler = new GroupFormationHandler(iGroupFormationHandlerDao);
        List<StudentResponses> studentResponses = iGroupFormationHandler.getStudentsSurveyResponses();
        IStudentComparator studentComparator = new StudentComparator();
        IGroupFormationRules iGroupFormationRules = iGroupFormationHandlerDao.getRules(5308);

        int currentGroupID = 1;
        int maxGroupSize = iGroupFormationRules.getGroupSize();
        int[][] distanceMatrix = getDistanceMatrix(studentResponses, studentComparator);
        List<String> studentIDs = new ArrayList<String>();
        List<String> tempStudentIDs = new ArrayList<>();
        Map<Integer, List<String>> groups = new HashMap<>();


        for (int i = 0; i < studentResponses.size(); i++) {
            studentIDs.add(studentResponses.get(i).getBannerID());
            tempStudentIDs.add(studentResponses.get(i).getBannerID());
        }


        int index = 0;
        while (tempStudentIDs.size() > 0) {
            index = studentIDs.indexOf(tempStudentIDs.get(0));
            List<String> group = new ArrayList<>();
            group.add(studentIDs.get(index));
            maxGroupSize = Math.min(maxGroupSize, tempStudentIDs.size());
            tempStudentIDs.remove(0);
            while (group.size() < maxGroupSize) {
                int maxDistance = -1;
                int maxIndex = -1;
                for (int j = 0; j < studentIDs.size(); j++) {
                    if (distanceMatrix[index][j] > maxDistance && tempStudentIDs.contains(studentIDs.get(j))) {
                        maxDistance = distanceMatrix[index][j];
                        maxIndex = j;
                    }
                }
                if (tempStudentIDs.contains(studentIDs.get(maxIndex))) {
                    group.add(studentIDs.get(maxIndex));
                }
                if (tempStudentIDs.size() > 0) {
                    tempStudentIDs.remove(studentIDs.get(maxIndex));
                }
            }
            groups.put(currentGroupID, group);
            currentGroupID += 1;
        }

        System.out.println(groups);
        System.out.println("test");
    }

    private int[][] getDistanceMatrix(List<StudentResponses> studentResponses, IStudentComparator studentComparator) {
        int distance;
        int numOfStudents = studentResponses.size();
        int[][] distanceMatrix = new int[numOfStudents][numOfStudents];
        Arrays.stream(distanceMatrix).forEach(row -> Arrays.fill(row, 0));

        for (int i = 0; i < studentResponses.size(); i++) {
            for (int j = i + 1; j < studentResponses.size(); j++) {
                distance = studentComparator.getDistanceBetweenStudents(studentResponses.get(i), studentResponses.get(j));
                distanceMatrix[i][j] = distance;
                distanceMatrix[j][i] = distance;
            }
        }

        for (int i = 0; i < studentResponses.size(); i++) {
            for (int j = i + 1; j < studentResponses.size(); j++) {
                System.out.print(distanceMatrix[i][j] + " ");
            }
            System.out.println();
        }

        return distanceMatrix;
    }
}
