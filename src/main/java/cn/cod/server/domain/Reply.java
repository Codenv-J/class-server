package cn.cod.server.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("reply")
public class Reply {

    @TableField("reply_id")
    private String replyId;

    @TableField("comment_id")
    private String commentId;

    @TableField("reply_user_id")
    private String replyUserId;

    @TableField("reply_to_user_id")
    private String replyToUserId;

    @TableField("reply_content")
    private String replyContent;

    @TableField(value = "reply_time",fill = FieldFill.INSERT)
    private String replyTime;
}
