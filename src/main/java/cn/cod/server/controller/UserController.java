package cn.cod.server.controller;

import cn.cod.server.domain.User;
import cn.cod.server.result.Result;
import cn.cod.server.service.UserService;
import cn.cod.server.vo.UpdateUserVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static cn.cod.server.utils.TimeUtils.getTime;

@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("getUser")
    public Result getUser(HttpServletRequest request){
        HttpSession session = request.getSession();
        //session存的是用户ID
        String userId = (String) session.getAttribute("user");
        User user = null;
        if (userId == null || userId == ""){
            user = userService.getUserById(userId);
        }
        if (user == null){
            return Result.fail("该用户已过期,请重新登录");
        }
        return Result.ok(user);
    }

    @PostMapping("updateUserInfo")
    public Result updateUserInfo(@RequestBody UpdateUserVo vo,HttpServletRequest request){
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("user");
        User user = null;
        user.setUserId(userId);
        //如果换头像了，就开启一个新的线程去处理头像的上传
        user.setAvatar(vo.getAvatar());
        user.setNickName(vo.getNickName());
        user.setUserDetails(vo.getNickName());
        user.setUpdateTime(getTime());
        user.setSex(vo.getSex());
        user.setBirthday(vo.getBirthday());
        boolean update = userService.updateById(user);
        if (update){
            return Result.ok("编辑成功");
        }
        return Result.fail("编辑失败，请重试");
    }



}
