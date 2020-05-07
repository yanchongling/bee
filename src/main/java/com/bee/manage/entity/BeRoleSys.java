package com.bee.manage.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 管理员信息
 * </p>
 *
 * @author be
 * @since 2020-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BeRoleSys implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 管理员id
     */
    @TableId(value = "role_id", type = IdType.AUTO)
    private Integer roleId;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;
    private String email;
    private Integer state;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")//页面写入数据库时格式化
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")//页面写入数据库时格式化
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;


}
