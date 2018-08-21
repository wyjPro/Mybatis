import com.mybatis.bean.Department;
import com.mybatis.bean.Employee;
import com.mybatis.dao.DepartmentDao;
import com.mybatis.dao.EmployeeDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestStepAndLazyLoading {

    //测试分布查询和延迟加载
    @Test
    public void test01() throws IOException {
        String resource = "resource";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        try{
            EmployeeDao employeeDao = session.getMapper(EmployeeDao.class);
            Employee emp = employeeDao.selone("1");
            System.out.println(emp.getE_name());

            //System.out.println(emp);
            session.commit();
        }finally {
            session.close();
        }
    }

    @Test
    public void test02() throws IOException {
        String resource = "resource";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            DepartmentDao departmentDao = session.getMapper(DepartmentDao.class);
            Department department = departmentDao.getDeptWithEmpByStep("001");
            System.out.println(department);
            //System.out.println(department.getEmps());
        }finally {

        }
    }
}
