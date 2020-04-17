package com.bee.manage.service;

import com.bee.manage.entity.BeRoleSys;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
