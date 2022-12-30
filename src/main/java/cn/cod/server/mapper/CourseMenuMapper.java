package cn.cod.server.mapper;


import cn.cod.server.domain.CourseMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CourseMenuMapper extends BaseMapper<CourseMenu> {
}
