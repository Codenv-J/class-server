package cn.cod.server.service.impl;

import cn.cod.server.domain.Course;
import cn.cod.server.mapper.CourseMapper;
import cn.cod.server.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {
}
