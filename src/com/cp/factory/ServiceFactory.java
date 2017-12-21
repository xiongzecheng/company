package com.cp.factory;

import com.cp.service.AdminService;
import com.cp.service.AdminServiceImpl;

/**
 * Created by 熊康 on 2017/12/20.
 */
public class ServiceFactory {
    public static AdminService getAdminServiceInstance(){
        return new AdminServiceImpl();
    }
}
