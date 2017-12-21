package test;

import com.cp.DAO.CheckDAO;
import com.cp.factory.CheckDAOFactory;
import com.cp.model.Check;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by 熊康 on 2017/12/19.
 */
public class CheckDAOTest {
    private CheckDAO checkDAO;

    @Before
    public void setUp() throws Exception {
        checkDAO = CheckDAOFactory.getCheckDAOInstance();
    }

    @Test
    public void getAll() throws Exception {
        List<Check> list = checkDAO.getAll();
        list.forEach(check -> System.out.println(check));
    }

    @Test
    public void getCheck() throws Exception {
        List<Check> list = checkDAO.getCheck("20012");
        list.forEach(check -> System.out.println(check));
    }

    @Test
    public void InsertCheck() throws Exception {
        java.util.Date date = new java.util.Date();
       Check check = new Check("20010","迟到",new Date(date.getTime()));
       int n = checkDAO.InsertCheck(check);
       assertEquals(1,n);
    }

    @Test
    public void deleteCheck() throws Exception {
        int n = checkDAO.deleteCheck("20011");
        assertEquals(n,n);
    }

}