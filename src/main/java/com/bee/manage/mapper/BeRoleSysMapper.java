package com.bee.manage.mapper;

import com.baomidou.mybatisplus.core.injector.methods.SelectOne;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bee.manage.entity.BeRoleSys;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * <p>
 * 管理员信息 Mapper 接口
 * </p>
 *
 * @author be
 * @since 2020-04-16
 */
public interface BeRoleSysMapper extends BaseMapper<BeRoleSys> {
    BeRoleSys isRoleName(String username);
    BeRoleSys isRolWord(String password);
//    @Select("select * from be_role_sys")
//    List<BeRoleSys> findRole();
    @Select("select * from be_role_sys")
    IPage<BeRoleSys> selectPageVo(Page<BeRoleSys> page);
}
