package com.usarb.bd.entities;

import com.usarb.bd.entities.Discipline;
import com.usarb.bd.entities.Group;

import java.util.List;

public class Student {
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
