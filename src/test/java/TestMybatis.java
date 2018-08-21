import com.mybatis.bean.EmployeeMapper;
import com.mybatis.dao.EmployeeDao01;
import com.mybatis.dao.EmployeeDao02;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMybatis {

    //Mybatis第一种实现方式
    @Test
    public void test01() throws IOException {
        String resource = "resource";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        try{
            //EmployeeMapper emp = session.getMapper(EmployeeMapper.class);
            EmployeeMapper emp = session.selectOne("com.mybatis.bean.EmployeeMapper.selOne", "1");
            System.out.println(emp.getId() + ";" + emp.getName());
        }finally {
            session.close();
        }
    }

    //Mybatis第二种实现方式
    @Test
    public void test02() throws IOException {
        String resource = "resource";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        try{
            EmployeeDao01 empDao = session.getMapper(EmployeeDao01.class);
            EmployeeMapper emp = empDao.selectone("2");
            List<EmployeeMapper> list = empDao.getAll();
            System.out.println(emp.getId() + ";" + emp.getName());
            System.out.println(list.size());
        }finally {
            session.close();
        }
    }

    //Mybatis第三种实现方式
    @Test
    public void test03() throws IOException {
        String resource = "resource";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        try{
            EmployeeDao02 empDao = session.getMapper(EmployeeDao02.class);
            List<EmployeeMapper> list = empDao.getAll();
            EmployeeMapper emp = empDao.selectone("1");
            System.out.println(emp.getId() + ";" + emp.getName());
            System.out.println(list.size());
        }finally {
            session.close();
        }
    }

    //测试增删改查操作
    @Test
    public void testCRUD() throws IOException {
        String resource = "resource";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeDao01 employeeDao01 = sqlSession.getMapper(EmployeeDao01.class);
            EmployeeMapper emp = new EmployeeMapper("3", "马化腾", '1', "阿里巴巴");
            //employeeDao01.insertEmp(emp);
            //employeeDao01.updateEmp(emp);
            employeeDao01.deleteEmp("3");
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    //测试多条件查询
    @Test
    public void test04() throws IOException {
        String resource = "resource";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeDao01 employeeDao01 = sqlSession.getMapper(EmployeeDao01.class);
            List<EmployeeMapper> list = employeeDao01.queryList("王",'1');
            System.out.println(list.size());
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    //测试多条件查询Map
    @Test
    public void test05() throws IOException {
        String resource = "resource";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeDao01 employeeDao01 = sqlSession.getMapper(EmployeeDao01.class);
            Map map = new HashMap();
            map.put("name", "王");
            map.put("gender", '1');
            List<EmployeeMapper> list = employeeDao01.queryList2(map);
            System.out.println(list.size());
        }finally {
            sqlSession.close();
        }
    }

    //测试SQL动态
    @Test
    public void test06() throws IOException {
        String resource = "resource";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeDao01 employeeDao01 = sqlSession.getMapper(EmployeeDao01.class);
            //EmployeeMapper emp = new EmployeeMapper("1",null, '1', null);
            //EmployeeMapper emp = new EmployeeMapper("1","马", '1', "杭州");
            EmployeeMapper emp = new EmployeeMapper("5","马云", '0', "杭州");
            //List list = employeeDao01.qureyByif(emp);
            //List list = employeeDao01.qureyBychoose(emp);
            //List list = employeeDao01.qureyBytrim(emp);
            //System.out.println(list.size());
            /*List list = new ArrayList();
            list.add("1");
            list.add("2");
            String[] strs = {"3","4"};
            int num01 = employeeDao01.deleteByList(list);
            int num02 = employeeDao01.deleteByArray(strs);
            System.out.println("num01 : " + num01 + " ; num02 : " + num02);*/
            int num03 = employeeDao01.updataBySet(emp);
            System.out.println("num03 : " + num03);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }


}
