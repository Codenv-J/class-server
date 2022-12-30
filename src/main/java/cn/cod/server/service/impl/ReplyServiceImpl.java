package cn.cod.server.service.impl;

import cn.cod.server.domain.Reply;
import cn.cod.server.mapper.ReplyMapper;
import cn.cod.server.service.ReplyService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl extends ServiceImpl<ReplyMapper, Reply> implements ReplyService {
    @Override
    public List<Reply> getReplyListByCommentId(String commentId) {
        LambdaQueryWrapper<Reply> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Reply::getCommentId,commentId);
        List<Reply> replyList = baseMapper.selectList(queryWrapper);
        return replyList;
    }
}
