package cn.cod.server.vo;

import cn.cod.server.domain.CourseMenu;
import lombok.Data;


@Data
public class MenuVo {
    private CourseMenu[] menus;

    public MenuVo(CourseMenu[] menus) {
        this.menus = menus;
    }
}
