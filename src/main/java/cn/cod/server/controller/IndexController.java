package cn.cod.server.controller;


import cn.cod.server.result.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("index")
public class IndexController {









    @PostMapping("/logout")
    public Result logout(){
        return Result.ok("退出登录");
    }
}
