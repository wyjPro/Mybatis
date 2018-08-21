import com.mybatis.bean.EmployeeMapper;
import com.mybatis.dao.EmployeeDao01;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestCache {

    //测试一级缓存
    @Test
    public void test01() throws IOException {
        String resource = "resource";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            EmployeeDao01 empDao = session.getMapper(EmployeeDao01.class);

            long start01 = System.currentTimeMillis();
            EmployeeMapper emp = empDao.selectone("2");
            System.out.println(emp);
            long end01 = System.currentTimeMillis();
            System.out.println(end01 - start01);

            System.out.println();
            //session.clearCache();
            //session.close();
            //empDao.deleteEmp("4");

            long start02 = System.currentTimeMillis();
            EmployeeMapper emp02 = empDao.selectone("2");
            System.out.println(emp02);
            long end02 = System.currentTimeMillis();
            System.out.println(end02 - start02);

            session.commit();
        }finally {
            session.close();
        }
    }

    //测试二级缓存
    @Test
    public void test02() throws IOException {
        String resource = "resource";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            EmployeeDao01 empDao = session.getMapper(EmployeeDao01.class);
            System.out.println();
            long start01 = System.currentTimeMillis();
            EmployeeMapper emp = empDao.selectone("2");
            System.out.println(emp);
            long end01 = System.currentTimeMillis();
            System.out.println(end01 - start01);

            //在新的SqlSession对象使用二级缓存的时候，需要先将前面的SqlSession对象关闭，数据才会进入二级缓存
            //session.close();

            SqlSession session01 = sqlSessionFactory.openSession();
            EmployeeDao01 empDao01 = session01.getMapper(EmployeeDao01.class);
            long start02 = System.currentTimeMillis();
            EmployeeMapper emp02 = empDao01.selectone("2");
            System.out.println(emp02);
            long end02 = System.currentTimeMillis();
            System.out.println(end02 - start02);

        }finally {

        }
    }
}
