package com.cp.service;

import com.cp.DAO.CheckDAO;
import com.cp.factory.CheckDAOFactory;
import com.cp.model.Check;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 熊康 on 2017/12/20.
 */
public class AdminServiceImpl implements AdminService {
    private CheckDAO checkDAO = CheckDAOFactory.getCheckDAOInstance();


    @Override
    public List<Check> getAll() throws SQLException {
        List<Check> checkList = new ArrayList<>();
        try{
            checkList = checkDAO.getAll();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return checkList;
    }
}

