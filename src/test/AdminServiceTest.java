package test;

import com.cp.factory.ServiceFactory;
import com.cp.model.Check;
import com.cp.service.AdminService;
import com.cp.utils.JDBCUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by 熊康 on 2017/12/20.
 */
public class AdminServiceTest {
    private AdminService adminService;
    @Before
    public void setUp() throws Exception {
        adminService = ServiceFactory.getAdminServiceInstance();
    }

    @Test
    public void getAll() throws Exception {
        List<Check> checks = adminService.getAll();
        checks.forEach(check -> System.out.println(check));
    }

}