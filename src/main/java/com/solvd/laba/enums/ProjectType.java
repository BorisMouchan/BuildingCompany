package com.solvd.laba.enums;

public enum ProjectType {
    COTTAGE("COTTAGE"),
    LARGE_BULDING("LARGE BUILDING"),
    SMALL_BUILDING("SMALL BUILDING"),
    GARAGE("GARAGE");

    private final String projectType;

    public String getProjectType() {
        return projectType;
    }

    ProjectType(String projectType) {
        this.projectType = projectType;
    }
}
