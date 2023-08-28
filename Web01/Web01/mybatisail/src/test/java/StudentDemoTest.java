
import entity.Student;
import mapper.StudentMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.SqlSessionFactoryUtils;

import java.io.IOException;
import java.util.*;

/**
 * @author 兰舟千帆
 * @version 1.0
 * @date 2023/8/26 15:46
 * @Description 功能描述:
 */

public class StudentDemoTest {
    SqlSessionFactory instance  =  null;
    StudentMapper mapper  =  null;
    SqlSession sqlSession =  null;
    @Before
    public void openSqlSession() throws IOException {
        this.instance  = SqlSessionFactoryUtils.getInstance();
        this.sqlSession = instance.openSession();
        this.mapper = sqlSession.getMapper(StudentMapper.class);
    }
    @After
    public void closeSqlSession()
    {
        sqlSession.close();
    }
    @Test
    public void testStudentDemo() throws IOException {



        List<Student> students = mapper.selectAll();
        System.out.println(students);



    }
    @Test
    public void testSelectById() throws IOException {
        int  id  = 3;
        Student student = mapper.selectById(id);
        System.out.println(student);
    }
    @Test
    public void testSelectByCondition() throws Exception{
        String name  =  "张三";

        String email  =  "@163";
        email  =  "zhangsan@126.com";
         int    age  = 22;

        Student student = mapper.selectByCondition(name, email, age);
        System.out.println(student);


    }
    @Test
    public void testSelectByDynamicCondition() throws IOException {

        String name  =  "张三";
        Map map  = new HashMap<>();
        map.put("name",name);
        List<Student> students = mapper.selectByDynamicCondition(map);
        System.out.println(students);

    }
    @Test
    public void testInsertIntoStudent() throws IOException {

        String name  =  "李九";
        String email  =  "250@sb.com";
        int age  =  22;
        Map  map  =  new HashMap<>();
        map.put("name",name);
        map.put("email",email);
        map.put("age",age);
        Integer integer = mapper.insertInto(map);
        sqlSession.commit();
        System.out.println(integer);

    }
    @Test
    public void testDelete() throws IOException {
         Map map = new HashMap<>();
         Integer id  = 3;
         map.put("id",id);


        Integer delete = mapper.delete(map);
        sqlSession.commit();
        System.out.println(delete);

    }
    @Test
    public void testDeleteById() throws IOException {

        Integer integer = mapper.deleteById(1);
        System.out.println(integer);

        sqlSession.commit();

    }
    @Test
    public void testDeleteByName()
    {
        Integer integer = mapper.deleteByName("李九");
        System.out.println(integer);
        sqlSession.commit();
    }
    @Test
    public void testUpdate() throws IOException {

        Map map = new HashMap<>();
        map.put("name","兰舟千帆");
        map.put("email","2121325875@qq.com");
        map.put("id",4);
        Integer update = mapper.update(map);
        sqlSession.commit();

    }
    @Test
    public void testInsertIntoByBatch()
    {
        ArrayList<Student> students = new ArrayList<>();
        Student student01 = new Student();
        student01.setName("小黑");
        student01.setAge(19);
        student01.setEmail("qqq@qq.com");
        Student student02 = new Student();
        student02.setEmail("qkmk@qq.com");
        student02.setName("小白");
        student02.setAge(22);
        students.add(student01);
        students.add(student02);
        Integer integer = mapper.insertIntoBatch(students);
        System.out.println(integer);
        sqlSession.commit();
    }


}
