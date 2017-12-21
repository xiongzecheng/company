package com.cp.factory;

import com.cp.DAO.CheckDAO;
import com.cp.DAO.Impl.CheckDAOImpl;

/**
 * Created by 熊康 on 2017/12/19.
 */
public class CheckDAOFactory {
    public static CheckDAO getCheckDAOInstance(){
        return new CheckDAOImpl();
    }
}
