package cn.cod.server;

import cn.cod.server.domain.CourseMenu;
import cn.cod.server.domain.User;
import cn.cod.server.service.CourseMenuService;
import cn.cod.server.service.UserService;
import cn.cod.server.vo.RegisterVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static cn.cod.server.utils.TimeUtils.getTime;

@SpringBootTest
class ServerApplicationTests {

    @Autowired
    private UserService userService;


    @Autowired
    private CourseMenuService menuService;

    @Test
    void contextLoads() {
    }

    @Test
    void testInsertUser(){
        RegisterVo registerVo = new RegisterVo();
        registerVo.setEmail("123454878@qq.com");
        registerVo.setPassword("A12345678.");
        registerVo.setNickName("hello");
        User user = new User();
        user.setEmail(registerVo.getEmail());
        user.setPassword(registerVo.getPassword());
        user.setNickName(registerVo.getNickName());
        user.setCreateTime(getTime());
        user.setUpdateTime(getTime());
        boolean save = userService.save(user);
        if (save){
            System.out.println("用户注册成功");
        } else {
            System.out.println("用户注册失败");
        }
    }

    @Test
    void getMenuByCourseId(){
        String courseId = "1";
        List<CourseMenu> menus = menuService.getMenusByCourseId(courseId);
        System.out.println(menus.toString());
    }
}
