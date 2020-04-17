package com.bee.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import com.bee.manage.entity.BeRoleSys;
import com.bee.manage.mapper.BeRoleSysMapper;
import com.bee.manage.service.IBeRoleSysService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员信息 服务实现类
 * </p>
 *
 * @author be
 * @since 2020-04-16
 */
@Service
public class BeRoleSysServiceImpl extends ServiceImpl<BeRoleSysMapper, BeRoleSys> implements IBeRoleSysService {
    @Autowired
    BeRoleSysMapper mapper;
    @Override
    public boolean isRole(BeRoleSys role) {
        BeRoleSys roleName = mapper.isRoleName(role.getUsername());
        if (StringUtils.isEmpty(roleName)){
            return false;
        }
        BeRoleSys roleWord = mapper.isRolWord(role.getPassword());
        if (StringUtils.isEmpty(roleWord)){
            return false;
        }
        return true;
    }
}
