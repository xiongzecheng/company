package com.cp.DAO;

import com.cp.model.Check;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by 熊康 on 2017/12/19.
 */
public interface CheckDAO {
    /**
     * 得到所有考勤信息
     * @return
     * @throws SQLException
     */
    List<Check> getAll() throws SQLException;


    /**
     * 根据工号查询个人考勤信息
     * @param staffNumber
     * @return
     * @throws SQLException
     */

    List<Check> getCheck(String staffNumber)throws SQLException;

    /**
     * 批量增加考核情况
     * @param checks
     * @return
     * @throws SQLException
     */

    int InsertCheck(Check checks) throws SQLException;

    /**
     * 根据工号删除信息
     * @param staffNumber
     * @return
     * @throws SQLException
     */
    int deleteCheck(String staffNumber) throws SQLException;
}
