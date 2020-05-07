package com.bee.manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import com.bee.manage.entity.BeRoleSys;
import com.bee.manage.mapper.BeRoleSysMapper;
import com.bee.manage.service.IBeRoleSysService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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

    @Override
    public IPage findRoleList(Page<BeRoleSys>page) {
        IPage<BeRoleSys> iPage = mapper.selectPageVo(page);
        if (StringUtils.isEmpty(iPage)){
            return null;
        }
        return iPage;
    }

    @Override
    public IPage findRoleStart(Page<BeRoleSys> page,String startDate) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        QueryWrapper query = new QueryWrapper();
        LocalDateTime parse = LocalDateTime.parse(startDate, df);
        query.apply("UNIX_TIMESTAMP(creation_time) >= UNIX_TIMESTAMP('" + parse + "')");
        IPage list=mapper.selectPage(page,query);
        if (StringUtils.isEmpty(list)){
            return null;
        }else {
            return list;
        }

    }

    @Override
    public IPage findRoleEnd(Page<BeRoleSys> page, String end) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        QueryWrapper query = new QueryWrapper();
        LocalDateTime parse = LocalDateTime.parse(end, df);
        query.apply("UNIX_TIMESTAMP(creation_time) <= UNIX_TIMESTAMP('" + parse + "')");
        IPage list=mapper.selectPage(page,query);
        if (StringUtils.isEmpty(list)){
            return null;
        }else {
            return list;
        }
    }

    @Override
    public List findRoleName(Page<BeRoleSys> page, String username) {
        QueryWrapper query = new QueryWrapper();
        query.like("username",username);
        List list = mapper.selectList(query);

        return list;
    }

    @Override
    public boolean insertRole(String username, String password, String email) {
        BeRoleSys role=new BeRoleSys();
        role.setUsername(username);
        role.setPassword(password);
        role.setEmail(email);
        int insert = mapper.insert(role);
        return false;
    }

    @Override
    public BeRoleSys findById(String id) {
        BeRoleSys beRoleSys = mapper.selectById(id);
        return beRoleSys;
    }

}
