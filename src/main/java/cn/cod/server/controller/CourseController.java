package cn.cod.server.controller;

import cn.cod.server.domain.Course;
import cn.cod.server.result.Result;
import cn.cod.server.service.CourseService;
import cn.cod.server.vo.CourseVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static cn.cod.server.utils.TimeUtils.getTime;

@RestController
@RequestMapping("course")
public class CourseController {

    @Resource
    private CourseService courseService;


    /* 获取课程页面 */
    @GetMapping("/{page}")
    public Result<Page> page(int page,int pageSize,String name){
        Page pageInfo = new Page(page,pageSize);
        LambdaQueryWrapper<Course> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(name != null,Course::getCourseName,name);
        queryWrapper.orderByDesc(Course::getUpdateTime);
        courseService.page(pageInfo,queryWrapper);
        return Result.ok(pageInfo);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable String id){
        Course course = courseService.getById(id);
        if (course != null){
            return Result.ok(course);
        }
        return Result.fail("查询失败,请重试");
    }



    @PutMapping()
    public Result update(@RequestBody CourseVo courseVo,String id){
        Course course = courseService.getById(id);
        course.setCourseHost(courseVo.getCourseHost());
        course.setCourseName(courseVo.getCourseName());
        course.setCoursePictureUrl(courseVo.getCoursePictureUrl());
        course.setCourseDetails(courseVo.getCourseDetails());
        course.setUpdateTime(getTime());
        courseService.updateById(course);
        return Result.ok();
    }

    @PostMapping("create")
    public Result createCourse(@RequestBody CourseVo courseVo){
        Course course = new Course();
        course.setCourseName(courseVo.getCourseName());
        course.setCourseHost(courseVo.getCourseHost());
        course.setCoursePictureUrl(courseVo.getCoursePictureUrl());
        course.setCourseDetails(courseVo.getCourseDetails());
        course.setCreateTime(getTime());
        course.setUpdateTime(getTime());
        boolean save = courseService.save(course);
        if (save){
            return Result.ok("课程创建成功");
        }
        return Result.fail("课程创建失败，请重试");
    }


    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable String id){
        boolean remove = courseService.removeById(id);
        if (remove){
            return Result.ok("删除成功");
        }
        return Result.fail("删除失败");
    }






}
