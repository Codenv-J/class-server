package cn.cod.server.service.impl;

import cn.cod.server.domain.Comment;
import cn.cod.server.mapper.CommentMapper;
import cn.cod.server.service.CommentService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    @Override
    public List<Comment> getCommentList(String courseId) {
        LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Comment::getCommentId,courseId);
        return baseMapper.selectList(queryWrapper);
    }
}
