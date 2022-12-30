package cn.cod.server.service;


import cn.cod.server.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;



public interface UserService extends IService<User> {
    User getUserInfoByEmail(String email);

    User getUserById(String userId);
}
