package cn.cod.server.service;

import cn.cod.server.domain.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


public interface CommentService extends IService<Comment> {
    List<Comment> getCommentList(String courseId);
}
