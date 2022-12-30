package cn.cod.server.vo;

import lombok.Data;

@Data
public class UpdateUserVo {
    String nickName;
    Integer sex;
    String birthday;
    String userDetails;
    String avatar;
}
