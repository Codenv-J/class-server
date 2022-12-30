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
@TableName("user")
public class User {
    @TableField("user_id")
    private String userId;

    @TableField("nick_name")
    private String nickName;

    @TableField("password")
    private String password;

    @TableField("user_type")
    private int userType;

    @TableField("email")
    private String email;

    @TableField("avatar")
    private String avatar;

    @TableField("sex")
    private Integer sex;

    @TableField("birthday")
    private String birthday;

    @TableField("user_details")
    private String userDetails;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private String createTime;

    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private String updateTime;
}
