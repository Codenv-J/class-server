package cn.cod.server.controller;

import cn.cod.server.domain.Reply;
import cn.cod.server.result.Result;
import cn.cod.server.service.ReplyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("reply")
public class ReplyController {

    @Resource
    private ReplyService replyService;


    @PostMapping("add")
    public Result addReply(@RequestBody Reply reply){
        /* 需要对内容进行校验 */
        if (reply.getReplyContent() == null){
            return Result.fail("评论失败");
        }
        boolean save = replyService.save(reply);
        if (save){
            return Result.ok("评论成功");
        }
        return Result.fail("评论失败");
    }

}
