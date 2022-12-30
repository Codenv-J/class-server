package cn.cod.server.service;

import cn.cod.server.domain.CourseMenu;
import cn.cod.server.vo.MenuVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface CourseMenuService extends IService<CourseMenu> {

    boolean createMenu(MenuVo vo);

    List<CourseMenu> getMenusByCourseId(String courseId);

    boolean deleteMenuByCourseId(String courseId);
}
