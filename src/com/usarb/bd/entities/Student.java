package com.usarb.bd.entities;

import java.util.List;

public class Student extends Person{
    private List<Discipline> disciplines;
    private Group group;

    public List<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(List<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
