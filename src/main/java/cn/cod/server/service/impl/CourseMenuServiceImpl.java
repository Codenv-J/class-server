package cn.cod.server.service.impl;

import cn.cod.server.domain.CourseMenu;
import cn.cod.server.mapper.CourseMenuMapper;
import cn.cod.server.service.CourseMenuService;
import cn.cod.server.vo.MenuVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CourseMenuServiceImpl extends ServiceImpl<CourseMenuMapper, CourseMenu> implements CourseMenuService {

    @Override
    public boolean createMenu(MenuVo vo) {
        CourseMenu[] menus = vo.getMenus();
        Boolean[] flag = new Boolean[menus.length];
        int num = 0;
        for (CourseMenu menu : menus) {
            boolean save = saveOrUpdate(menu);
            flag[num++] = save;
        }
        num = 0;
        for (int i = 0; i < flag.length; i++){
            if (!flag[i]){
                return false;
            }
        }
        return true;
    }

    /* 根据课程ID 查询该课程 */
    @Override
    public List<CourseMenu> getMenusByCourseId(String courseId) {
        LambdaQueryWrapper<CourseMenu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CourseMenu::getCourseId,courseId);
        List<CourseMenu> courseMenus = baseMapper.selectList(queryWrapper);
        return courseMenus;
    }

    @Override
    public boolean deleteMenuByCourseId(String courseId) {
        LambdaQueryWrapper<CourseMenu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CourseMenu::getCourseId,courseId);
        int delete = baseMapper.delete(queryWrapper);
        if (delete <= 0){
            return false;
        }
        return true;
    }
}
