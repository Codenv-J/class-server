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
@TableName("course")
public class Course {
    @TableField("course_id")
    private String courseId;

    @TableField("course_name")
    private String courseName;

    @TableField("course_host")
    private String courseHost;

    @TableField("course_picture_url")
    private String coursePictureUrl;

    @TableField("course_details")
    private String courseDetails;

    @TableField("create_user_id")
    private String createUserId;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private String createTime;

    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private String updateTime;
}
