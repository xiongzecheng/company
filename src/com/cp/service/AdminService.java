package com.cp.service;

import com.cp.model.Check;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by 熊康 on 2017/12/20.
 */
public interface AdminService {

    /**
     * 管理员查看所有考勤信息
     * @return
     * @throws SQLException
     */
    List<Check> getAll() throws SQLException;

}
