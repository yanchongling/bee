package com.bee.manage.mapper;

import com.baomidou.mybatisplus.core.injector.methods.SelectOne;
import com.bee.manage.entity.BeRoleSys;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Bean;

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
}
