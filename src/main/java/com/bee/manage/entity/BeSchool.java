package com.bee.manage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 学校表
 * </p>
 *
 * @author be
 * @since 2020-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BeSchool implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 学校id
     */
    @TableId(value = "school_id", type = IdType.AUTO)
    private Integer schoolId;

    /**
     * 学校名称
     */
    private String schoolName;

    /**
     * 学校校长
     */
    private String schoolPrincipal;

    /**
     * 学校地址
     */
    private String schoolSite;

    /**
     * 学校邮箱
     */
    private String schoolEmail;

    /**
     * 学校电话
     */
    private Long schoolTell;

    /**
     * 学校官网地址
     */
    private String schoolWebsite;

    /**
     * 学校简介
     */
    private String schoolDes;


}
