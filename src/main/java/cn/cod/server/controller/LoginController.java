package cn.cod.server.controller;

import cn.cod.server.domain.User;
import cn.cod.server.result.Result;
import cn.cod.server.service.UserService;
import cn.cod.server.vo.LoginVo;
import cn.cod.server.vo.RegisterVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static cn.cod.server.utils.TimeUtils.getTime;

@RestController
@RequestMapping("login")
public class LoginController {
    @Resource
    private UserService userService;

    @PostMapping("login")
    public Result login(@RequestBody LoginVo loginVo, HttpServletRequest request){
        //判断服务器是否存有用户session
        HttpSession session = request.getSession();
        String hasUserId = (String) session.getAttribute("user");
        //如果服务器没有存储
        if (hasUserId == null){
            //通过服务层查询用户信息
            User user = userService.getUserInfoByEmail(loginVo.getEmail());
            if (user == null){
                return Result.fail("该用户不存在");
            }
            //用户邮箱存在，判断密码是否正确
            String password = loginVo.getPassword();
            /* 这里先不进行加密处理 */
            if (!user.getPassword().equals(password)){
                return Result.fail("密码错误");
            }
            //将用户信息，存入session
            session.setAttribute("user",user.getUserId());
            return Result.ok("登录成功");
        }
        User userById = userService.getUserById(hasUserId);
        if (userById.getPassword().equals(loginVo.getPassword())){
            return Result.ok("登录成功");
        }
        return Result.fail("密码错误");
    }

    @PostMapping("register")
    public Result register(@RequestBody RegisterVo registerVo, HttpServletRequest request){
        String email = registerVo.getEmail();
        User ifHasUser = userService.getUserInfoByEmail(email);
        if (ifHasUser != null){
            return Result.fail("该邮箱已被注册");
        }
        User user = new User();
        user.setEmail(registerVo.getEmail());
        user.setNickName(registerVo.getNickName());
        user.setPassword(registerVo.getPassword());
        user.setCreateTime(getTime());
        user.setUpdateTime(getTime());
        boolean save = userService.save(user);
        if (save){
            HttpSession session = request.getSession();
            session.setAttribute("user",user.getUserId());
            return Result.ok("注册成功！");
        }
        return Result.fail("注册失败！请重新检查");
    }


}
