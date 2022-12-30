package cn.cod.server.service.impl;


import cn.cod.server.domain.User;
import cn.cod.server.mapper.UserMapper;
import cn.cod.server.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public User getUserInfoByEmail(String email) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("email",email);
        return baseMapper.selectOne(wrapper);
    }

    @Override
    public User getUserById(String userId) {
        return baseMapper.selectById(userId);
    }
}
