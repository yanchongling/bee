package com.bee.manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bee.manage.entity.BeRoleSys;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 管理员信息 服务类
 * </p>
 *
 * @author be
 * @since 2020-04-16
 */
public interface IBeRoleSysService extends IService<BeRoleSys> {

    boolean isRole(BeRoleSys role);
    IPage findRoleList(Page<BeRoleSys> page);
    IPage findRoleStart(Page<BeRoleSys>page,String start);

    IPage findRoleEnd(Page<BeRoleSys> page, String end);
}
