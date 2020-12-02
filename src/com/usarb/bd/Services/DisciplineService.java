package com.usarb.bd.Services;

import com.usarb.bd.connection.BdConnection;
import com.usarb.bd.dao.DisciplineDao;
import com.usarb.bd.entities.Discipline;

import java.sql.Connection;
import java.sql.SQLException;

public class DisciplineService {
    private DisciplineDao disciplineDao;


    public DisciplineService(){
        Connection connection = new BdConnection().getConnection();
        this.disciplineDao = new DisciplineDao(connection);
    }
    public Discipline getDisciplines() throws SQLException {
        return disciplineDao.getDiscipline(1);
    }
}
