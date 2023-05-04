package com.solvd.laba.classes;

public abstract class Department {

    protected String structureName;

    public Department() {
    }

    public Department(String structureName) {
        this.structureName = structureName;
    }

    public String getStructureUnitName() {
        return structureName;
    }

    public void setStructureUnitName(String structureName) {
        this.structureName = structureName;
    }

    protected abstract void getResultsOfMonth();
}
