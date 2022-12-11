package it.com.controller;

import com.alibaba.fastjson2.JSON;
import it.com.pojo.JsonResult;
import it.com.pojo.User;
import it.com.service.UserService;
import it.com.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    private JsonResult jsonResult;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/findAll")
    public JsonResult findAll(){
        System.out.println("second commit");
        System.out.println("third commit");
        System.out.println("hot-fix test");
        List<User> lists = userService.findAll();
        String s = JSON.toJSONString(lists);
        jsonResult.setObject(lists);
        jsonResult.setMsg("查询成功");
        jsonResult.setCode(200);
        return jsonResult;
    }

    @RequestMapping("/user/login")
    public Map<String, Object> login(User user){
        System.out.println("用户名:" + user.getUsername());
        System.out.println("密码:" + user.getPassword());
        HashMap<String,Object> map = new HashMap<>();
        try{
            //获取user对象
            List<User> login = userService.login(user);
            //将user对象添加到map中
            Map<String,String> payload = new HashMap<>();
            payload.put("username",login.get(0).getUsername());

            //生成令牌
            String token = JWTUtils.getToken(payload);
            System.out.println("token:" + token);

            map.put("state", true);
            map.put("msg", "认证成功");
            map.put("token", token);
        } catch (Exception e) {
            map.put("state", false);
            map.put("msg", e.getMessage());
        }
        return map;
    }

    @PostMapping("/test")
    public Map<String,Object> test(HttpServletRequest request){
        System.out.println("test()...");
        Map<String,Object> map = new HashMap<>();
        map.put("state",true);
        map.put("msg","请求成功");

        String token = request.getHeader("token");
        String username = JWTUtils.verify(token).getClaim("username").asString();
        System.out.println("username:" + username);

        return map;
    }
}