package com.cp.factory;

import com.cp.DAO.Impl.StaffDAOIpml;
import com.cp.DAO.StaffDAO;

/**
 * Created by 熊康 on 2017/12/21.
 */
public class StaffDAOFactory {
    public static StaffDAO getCheckDAOInstance(){
        return new StaffDAOIpml();
    }
}
