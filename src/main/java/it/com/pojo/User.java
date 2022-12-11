package it.com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data//提供get、set、equals、hashCode、toString、canEquals方法
@NoArgsConstructor//构建无参构造函数
@AllArgsConstructor//构建全残构造函数
public class User {
//    用户名
    private String username;
//    密码
    private String password;
}