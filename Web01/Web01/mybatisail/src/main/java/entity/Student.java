package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 兰舟千帆
 * @version 1.0
 * @date 2023/8/26 15:21
 * @Description 功能描述:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer id;
    private  String name;
    private String email;
    private Integer age;

}
