package cn.cod.server.controller;

import cn.cod.server.domain.Comment;
import cn.cod.server.domain.Reply;
import cn.cod.server.result.Result;
import cn.cod.server.service.CommentService;
import cn.cod.server.service.ReplyService;
import cn.cod.server.vo.CommentReplyVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static cn.cod.server.utils.TimeUtils.getTime;

@RestController
@RequestMapping("comment")
public class CommentController {

    @Resource
    private CommentService commentService;

    @Resource
    private ReplyService replyService;



    /* 获取课程Id的评论内容和回复内容 */
    @PostMapping("/{id}")
    public Result getCommentReplyList(@PathVariable String id){
        List<CommentReplyVo> commentReplyVoList = null;
        String courseId = id;
        //得到问题情况列表
        List<Comment> commentList = commentService.getCommentList(courseId);
        for (Comment comment : commentList) {
            String commentId = comment.getCommentId();
            //根据问题情况的ID,得到每个问题的回复情况
            List<Reply> replyList =  replyService.getReplyListByCommentId(commentId);
            //封装成Vo对象
            CommentReplyVo commentReplyVo = new CommentReplyVo();
            commentReplyVo.setComment(comment);
            commentReplyVo.setReplyList(replyList);
            commentReplyVoList.add(commentReplyVo);
        }
        return Result.ok(commentReplyVoList);
    }


    /* 添加评论 */
    @PostMapping("add")
    public Result addComment(@RequestBody Comment comment){
        /* 判断评论内容是否合法 */
        if (comment.getContent() == null){
            return Result.fail("评论不可未空");
        }
        /* 需要加评论校验 */
        comment.setCommentTime(getTime());
        boolean save = commentService.save(comment);
        if (save){
            return Result.ok("评论成功");
        }
        return Result.fail("评论失败");
    }
}
