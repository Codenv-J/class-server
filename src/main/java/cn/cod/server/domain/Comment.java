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
@TableName("comment")
public class Comment {

    @TableField("comment_id")
    private String commentId;

    @TableField("course_id")
    private String courseId;

    @TableField("user_id")
    private String userId;

    @TableField("content")
    private String content;

    @TableField(value = "comment_time",fill = FieldFill.INSERT_UPDATE)
    private String commentTime;

}