package com.bee.manage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 教师表
 * </p>
 *
 * @author be
 * @since 2020-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BeTeacher implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 教师编号
     */
    @TableId(value = "teacher_id", type = IdType.AUTO)
    private Integer teacherId;

    /**
     * 教师名字
     */
    private String teacherName;

    /**
     * 身份证编号
     */
    private String idCard;

    /**
     * 性别
     */
    private String sex;

    /**
     * 教师职称
     */
    private String teacherTitle;

    /**
     * 入职日期
     */
    private LocalDate entryDate;

    /**
     * 出生日期
     */
    private LocalDate birther;

    /**
     * 状态
     */
    private String status;

    /**
     * 电话
     */
    private String tel;

    /**
     * 第二联系号码
     */
    private String secondTel;

    /**
     * QQ
     */
    private String qq;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 地址
     */
    private String address;

    /**
     * 学校id
     */
    private Integer schoolId;

    /**
     * 学院id
     */
    private String collegeId;

    /**
     * 专业id
     */
    private String majorId;

    /**
     * 头像地址
     */
    private String photoPath;

    /**
     * 是否辅导员
     */
    private Integer isInstructor;


}
