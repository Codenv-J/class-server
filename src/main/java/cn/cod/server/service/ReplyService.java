package cn.cod.server.service;

import cn.cod.server.domain.Reply;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface ReplyService extends IService<Reply> {
    List<Reply> getReplyListByCommentId(String commentId);
}
