package com.cp.DAO.Impl;

import com.cp.DAO.StaffDAO;
import com.cp.model.Check;
import com.cp.model.Staff;
import com.cp.utils.JDBCUtil;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 熊康 on 2017/12/21.
 */
public class StaffDAOIpml implements StaffDAO {
    private JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();


    @Override
    public List<Staff> getAll() throws SQLException {
//        String sql = "SELECT staffNumber AND staffName FROM t_staff";
//        List<Object> list = jdbcUtil.excuteQuery(sql, null);
//        return getAll(list);
        return null;
    }

//    private List<Staff> getAll(List<Object> list) {
//        List<Staff> staffsList = new ArrayList<>();
//        for (Object object : list) {
//            Map<String, Object> map = (Map<String, Object>) object;
//            Staff staff = new Staff(map.get("staffNumber").toString(),map.get("staffName").toString(),null,
//                    null,null,null,null,null,null,
//                    null,null,null);
//        }
//        return staffsList;
//    }
}

