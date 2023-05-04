package com.solvd.laba.classes;

import java.util.ArrayList;

public class ArchiveData extends Department {

    private static int totalProjectsDone;
    private static int totalProjectsCost;

    static ArrayList<Project> projects = new ArrayList<>();

    public ArchiveData(String structureName) {
        super(structureName);
    }

    public static int getTotalProjectsDone() {
        return totalProjectsDone;
    }

    public static void setTotalProjectsDone(int totalProjectsDone) {
        ArchiveData.totalProjectsDone = totalProjectsDone;
    }

    public static int getTotalProjectsCost() {
        return totalProjectsCost;
    }

    public static void setTotalProjectsCost(int totalProjectsCost) {
        ArchiveData.totalProjectsCost = totalProjectsCost;
    }

    @Override
    public String toString() {
        return "ArchiveData{" +
                "projects=" + projects +
                '}';
    }

    @Override
    public void getResultsOfMonth() {
        System.out.println("Total cost^ " + getTotalProjectsCost());
        System.out.println("Total projects done " + getTotalProjectsDone());
    }

    public static ArrayList<Project> addProjectData(Project project) {
        projects.add(project);
        totalProjectsDone++;
        System.out.println("Total " + getTotalProjectsDone());
        return projects;
    }

    public static void showListOfProjects() {
        projects.toString();
    }

}
