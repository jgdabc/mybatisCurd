package mapper;

import entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 兰舟千帆
 * @version 1.0
 * @date 2023/8/26 15:37
 * @Description 功能描述:
 */
public interface StudentMapper {

        Integer insertInto(Map map);
        Integer insertInto(Student student);
        Integer insertIntoBatch(List list);
        Integer insertIntoDynamicCondition(Map map);
        Integer delete(Map map);
        Integer deleteById(Integer id);
        Integer deleteByName(String name);
        Integer deleteByNames(String[] names);
        Integer delete(Student student);
        Integer update(Map map);
        Integer update(Student student);
        List<Student> selectAll();
        Student selectById(int Id);
        Student selectByCondition(@Param("name") String name,@Param("email") String email,@Param("age") int age);//多条件查询,非动态条件
        List<Student>selectByDynamicCondition(Map map);
        List<Student>selectByDynamicCondition(Student student);


}
