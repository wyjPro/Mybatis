import com.mybatis.bean.Employee;
import com.mybatis.bean.EmployeeMapper;
import com.mybatis.dao.EmployeeDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatisResultMap {

    //测试ResultMap
    @Test
    public void test01() throws IOException {
        String resource = "resource";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        try{
            EmployeeDao employeeDao = session.getMapper(EmployeeDao.class);
            //List list = employeeDao.getAll();
            //List list = employeeDao.getAll2();
            List list = employeeDao.getAll3();
            System.out.println(list);
        }finally {
            session.close();
        }
    }

}
