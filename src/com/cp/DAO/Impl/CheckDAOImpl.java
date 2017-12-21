package com.cp.DAO.Impl;

import com.cp.DAO.CheckDAO;
import com.cp.model.Check;
import com.cp.model.Staff;
import com.cp.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 熊康 on 2017/12/19.
 */
public class CheckDAOImpl implements CheckDAO {
    private JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();

    @Override
    public List<Check> getAll() throws SQLException {
        String sql = "SELECT * FROM t_check ";
        List<Object> list = jdbcUtil.excuteQuery(sql, null);
        return getCheckList(list);
    }

    @Override
    public List<Check> getCheck(String staffNumber) throws SQLException {
        String sql = "SELECT * FROM t_check WHERE staffNumber = ? ";
        List<Object> list = jdbcUtil.excuteQuery(sql,new Object[]{staffNumber});
        List<Check> checks = new ArrayList<>();
        for (Object object : list){
            Map<String,Object> map = (Map<String, Object>) object;
            Check check = new Check((Integer)map.get("id"),map.get("staffNumber").toString(),
                    map.get("checkType").toString(),(Date)map.get("checkDate"));
            checks.add(check);
        }
        return checks;
    }

    @Override
    public int InsertCheck(Check checks) throws SQLException {
        int n;
        String sql = "INSERT INTO t_check VALUES(null,?,?,?) ";
        Object[] params = {checks.getStaffNumber(),checks.getCheckType(),checks.getCheckDate()};
        n = jdbcUtil.executeUpdate(sql,params);
        return n;
    }

    @Override
    public int deleteCheck(String staffNumber) throws SQLException {
        int n;
        String sql = "DELETE FROM t_check WHERE staffNumber = ? ";
        Object[]params = {staffNumber};
        n = jdbcUtil.executeUpdate(sql,params);
        return n;
    }

    private List<Check> getCheckList(List<Object> list) {
        List<Check> checkList = new ArrayList<>();
        for (Object object : list) {
            Map<String, Object> map = (Map<String, Object>) object;
            Check check = new Check(map.get("staffNumber").toString(),map.get("checkType").toString(),(Date)map.get("checkDate"));
            //给id设置值
            check.setId(((Integer) map.get("id")));
            checkList.add(check);
        }
        return checkList;
    }
}

