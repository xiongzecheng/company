package com.cp.DAO;

import com.cp.model.Staff;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by 熊康 on 2017/12/21.
 */
public interface StaffDAO {

    /**
     * 查看所有人信息
     * @return
     * @throws SQLException
     */
    List<Staff> getAll() throws SQLException;
}
