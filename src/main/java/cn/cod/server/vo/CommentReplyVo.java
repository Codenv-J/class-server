package cn.cod.server.vo;

import cn.cod.server.domain.Comment;
import cn.cod.server.domain.Reply;
import lombok.Data;

import java.util.List;

@Data
public class CommentReplyVo {
    private Comment comment;
    private List<Reply> replyList;
}
