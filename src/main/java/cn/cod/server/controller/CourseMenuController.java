package cn.cod.server.controller;

import cn.cod.server.domain.CourseMenu;
import cn.cod.server.result.Result;
import cn.cod.server.service.CourseMenuService;
import cn.cod.server.vo.MenuVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("menu")
public class CourseMenuController {

    @Resource
    private CourseMenuService menuService;

    /*  根据courseId 查询相关的menu信息 */
    @GetMapping("/{id}")
    public Result getMenusByCourseId(@PathVariable String id){
        String courseId = id;
        List<CourseMenu> menus = menuService.getMenusByCourseId(courseId);
        if (menus == null){
            return Result.ok("课程目录内容未编辑");
        }
        return Result.ok(menus);
    }

    @PostMapping("create")
    public Result createMenu(@RequestBody MenuVo vo){
        boolean flag = menuService.createMenu(vo);
        if (flag){
            return Result.ok("目录编辑成功");
        }
        return Result.fail("目录编辑失败");
    }


    @PostMapping("update")
    public Result updateMenu(@RequestBody MenuVo vo){
        CourseMenu[] menus = vo.getMenus();
        for (CourseMenu menu : menus) {
            menuService.saveOrUpdate(menu);
        }
        return Result.ok("修改成功");
    }


    @DeleteMapping("delete/{id}")
    public Result deleteMenuByCourseId(@PathVariable String id){
        String courseId = id;
        boolean flag = menuService.deleteMenuByCourseId(courseId);
        if (flag){
            return Result.ok("删除成功");
        }
        return Result.fail("删除失败");
    }
}
