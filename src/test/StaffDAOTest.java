package test;

import com.cp.DAO.StaffDAO;
import com.cp.factory.StaffDAOFactory;
import com.cp.model.Check;
import com.cp.model.Staff;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by 熊康 on 2017/12/21.
 */
public class StaffDAOTest {
    private StaffDAO staffDAO;
    @Before
    public void setUp() throws Exception {
        staffDAO = StaffDAOFactory.getCheckDAOInstance();
    }

    @Test
    public void getAll() throws Exception {
        List<Staff> list = staffDAO.getAll();
        list.forEach(staff -> System.out.println(staff));
    }

}