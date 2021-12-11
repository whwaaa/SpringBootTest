package pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Description:
 * @Auther: whw
 * @Date: 2021/12/11
 * @Week: 星期六
 */
@Data
@Accessors(chain = true)
@TableName(value = "user2")
public class User {
    private Long id;
    private String userName;
    private int age;
    private String email;

    @TableField(exist = false)
    private Integer count;

//    // Accessors(chain = true) 相当于以下作用
//    public User setUserName(String userName){
//        this.userName = userName;
//        return this;
//    }
}
