package com.solvd.laba.classes;

import com.solvd.laba.enums.ProjectType;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Project {

    protected String projectName;
    protected ProjectType projectType;
    protected int projectCost;
    protected static int daysWorksOnProject;
    protected static int costPerDay;
    public String architectorName;

    public Project() {
    }

    public Project(String projectName, ProjectType projectType, int projectCost, String architectorName) {
        this.projectName = projectName;
        this.projectType = projectType;
        this.projectCost = projectCost;
        this.architectorName = architectorName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public ProjectType getProjectType() {
        return projectType;
    }

    public void setProjectType(ProjectType projectType) {
        this.projectType = projectType;
    }

    public int getProjectCost() {
        return projectCost;
    }

    public void setProjectCost(int projectCost) {
        this.projectCost = projectCost;
    }

    public String getArchitectorName() {
        return architectorName;
    }

    public void setArchitectorName(String architectorName) {
        this.architectorName = architectorName;
    }

    @Override
    public String toString() {
        return "название проекта " + getProjectName() + "\n" + "тип дома " + getProjectType() + "\n" + "стоимость проекта " + getProjectCost()
                + "\n" + "имя архитектора " + getArchitectorName();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return projectCost == project.projectCost && Objects.equals(projectName, project.projectName) && projectType == project.projectType && Objects.equals(architectorName, project.architectorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectName, projectType, projectCost, architectorName);
    }

    public static int calculateCost(int daysWorksOnProject, int costPerDay, BiFunction<Integer, Integer,Integer> function){
        return function.apply(daysWorksOnProject, costPerDay);
    }

    public static void printProjectInfo(Project project){
        Consumer<Project> consumer1 = info -> System.out.println("All information about project :" + info);
        consumer1.accept(project);
    }

}


