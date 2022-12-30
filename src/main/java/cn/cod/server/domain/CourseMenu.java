package cn.cod.server.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

/*  id + content + [{id + content + children[ ]}] */
@TableName("course_menu")
public class CourseMenu {
    @TableField("menu_id")
    private String menuId;

    @TableField("content")
    private String content;

    @TableField("pid")
    private String pid;//子父关系

    @TableField("course_id")
    private String courseId;//课程ID

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private String createTime;

    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private String updateTime;

}
