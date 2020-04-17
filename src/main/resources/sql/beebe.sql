create database bebee;
use bebee;
SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `be_school`;
create table be_school
(
	school_id int auto_increment NOT NULL COMMENT '学校id',
	school_name varchar(20) not null comment '学校名称',
	school_principal varchar(20) not null comment '学校校长',
	school_site varchar(200) not null comment '学校地址',
	school_email varchar(200) not null comment '学校邮箱',
	school_tell bigint(18) not null comment '学校电话',
	school_website varchar(200) not null comment '学校官网地址',
	school_des varchar(200) not null comment '学校简介',
	primary key (school_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '学校表';

DROP TABLE IF EXISTS `be_college`;
create table be_college
(
	college_id varchar(20) not null comment '二级学院编号',
	college_name varchar(20) not null comment '二级学院名称',
	college_room varchar(20) not null comment '二级学院办公室',
	college_deanId varchar(20) not null comment '院长编号',
	college_tell varchar(20) not null comment '二级学院电话',
	college_email varchar(20) not null comment 'collegeEmail',
	school_id int default null comment '学校id',
	constraint be_college_pk
		primary key (college_id),
	constraint school_id___fk
		foreign key (school_id) references be_school (school_id)
)
comment '学院表';

DROP TABLE IF EXISTS `be_major`;
create table be_major
(
	major_id varchar(20) not null comment '专业编号',
	major_name varchar(20) not null comment '专业名称',
	college_id varchar(20) default null comment '所属学院id',
	constraint be_major_pk
		primary key (major_id),
	constraint college_id___fk
		foreign key (college_id) references be_college (college_id)
)
comment '专业表';



DROP TABLE IF EXISTS `be_teacher`;
create table be_teacher
(
	teacher_id varchar(20) not null comment '教师编号',
	teacher_name varchar(10) not null comment '教师名字',
	password varchar(20) not null comment '登录密码',
	id_card varchar(18) not null comment '身份证编号',
	sex varchar(2) not null comment '性别',
	teacher_title varchar(20) not null comment '教师职称',
	entry_date Date not null comment '入职日期',
	birther Date not null comment '出生日期',
	status varchar(8) not null comment '状态',
	tel varchar(20) not null comment '电话',
	second_tel varchar(20) comment '第二联系号码',
	qq varchar(20) default ''comment 'QQ',
	email varchar(100) default '' comment '邮箱',
	address varchar(200) default ''comment '地址',
	school_id int(20) not null comment '学校id',
	college_id varchar(20) not null comment '学院id',
	major_id varchar(20) not null comment '专业id',
	photo_path varchar(200) comment '头像地址',
	is_instructor int not null comment '是否辅导员',
	constraint be_teacher_pk
		primary key (teacher_id),

	constraint teacher_id___fk
		foreign key (college_id) references be_college (college_id),
		foreign key (school_id)references be_school(school_id),
		foreign key (major_id)references be_major(major_id),
		foreign key (teacher_id) references be_student_teacher_activity(teacher_id)
)
comment '教师表';


DROP TABLE IF EXISTS `be_student`;
create table be_student
(
	student_id int auto_increment not null comment '学生编号',
	student_name varchar(10) not null comment '学生名字',
	password varchar(20) not null comment '登录密码',
	id_card varchar(18) not null comment '身份证编号',
	sex varchar(2) not null comment '性别',
	student_title varchar(20) not null comment '职务',
	entry_date Date not null comment '入学日期',
	birther Date not null comment '出生日期',
	status varchar(8) not null comment '状态',
	tel varchar(20) not null comment '电话',
	second_tel varchar(20)  comment '第二联系号码',
	qq varchar(20) comment 'QQ',
	email varchar(100)  comment '邮箱',
	address varchar(200)  comment '地址',
	school_id int(20) not null comment '学校id',
	college_id varchar(20) not null comment '学院id',
	major_id varchar(20) not null comment '专业id',
	photo_path varchar(200) comment '头像地址',
	class_name varchar(10) not null comment '班级名称',
	teacher_id varchar(20) not null comment '辅导员id',
	constraint student_pk
		primary key (student_id),
	constraint student_id___fk
	    foreign key (school_id) references be_school(school_id),
		foreign key (college_id) references be_college (college_id),
		foreign key (major_id) references be_major(major_id),
		foreign key (teacher_id)references be_teacher(teacher_id),
		foreign key (student_id) references be_student_teacher_activity(student_id)
)
comment '学生表';


DROP TABLE IF EXISTS `be_course`;
create table be_course
(
	course_id int not null auto_increment comment '课程编号',
	course_name varchar(20) not null comment '课程编号',
	teacher_id varchar(20) not null comment '任课老师编号',
	classroom_id int not null comment '课程教室id',
	maxStudent_num varchar(20) not null comment '最大可选人数',
	college_id varchar(20) not null comment '课程分类(所属学院)',
	constraint be_course_pk
		primary key (course_id),
	constraint course_id___fk
		foreign key (teacher_id) references be_teacher (teacher_id),
		foreign key (classroom_id)references be_classroom(classroom_id),
		foreign key (college_id)references be_college(college_id)
)
comment '课程表';


DROP TABLE IF EXISTS `be_score`;
create table be_score
(
	score_id int not null AUTO_INCREMENT comment '课程编号',
	student_id int not null comment '学生id',
	course_id int not null comment '课程id',
	score float comment '成绩分数',
	teacher_id varchar(20) not null comment '任课教师id',
	constraint be_score_pk
		primary key (score_id),
	constraint score_id___fk
		foreign key (teacher_id) references be_teacher (teacher_id),
		foreign key (student_id) references be_student(student_id),
		foreign key (course_id) references be_course(course_id)
)
ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 comment '成绩表';

DROP TABLE IF EXISTS `be_student_course`;
create table be_student_course
(
	student_course_id varchar(20) not null comment '个人课程表id',
	course_id int not null comment '课程id',
	begin_time Date not null comment '开始时间',
	continued_id int comment '课程时长',
	end_time Date not null comment '结束时间',
	constraint be_student_course
		primary key (student_course_id),
	constraint student_course_id___fk
		foreign key (course_id) references be_course(course_id)
)
comment '学生个人课程表';

# 中间表 关联学生 教师 活动
DROP TABLE IF EXISTS `be_student_teacher_activity`;
create table be_student_teacher_activity
(
    id int not null auto_increment comment '主键',
    teacher_id varchar(20) not null ,
    student_id int not null ,
    activity_id int not null ,
    constraint be_student_course
	    primary key (id),
    constraint be_student_teacher_activity
	foreign key (teacher_id) references be_teacher(teacher_id),
	foreign key (student_id) references be_student(student_id),
	foreign key (activity_id) references be_activity(activity_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `be_activity`;
create table be_activity
(
	activity_id int not null auto_increment comment '活动id',
	activity_type varchar(10) not null comment '活动类型',
	activity_add varchar(20) not null comment '活动地点',
	activity_begin_time Date not null comment '活动开始时间',
	activity_tnd_time Date not null comment '活动结束时间',
	activity_context varchar(200) not null comment '活动内容',
	organization_id varchar(20) not null comment '组织人id',
	activityLaunch_id int not null comment '活动发起人id',
	activity_photo varchar(200) comment '活动图片',
	constraint be_activity_pk
		primary key (activity_id),
	constraint activity_id___fk
		foreign key (activityLaunch_id) references be_student_teacher_activity(student_id),
		foreign key (organization_id) references be_student_teacher_activity(teacher_id),
		foreign key (activity_id) references be_student_teacher_activity(activity_id)
)
comment '活动表';

DROP TABLE IF EXISTS `be_sign_in`;
create table be_sign_in
(
	sign_in_id int not null AUTO_INCREMENT comment '签到id',
	sign_type varchar(20) not null comment '签到类型（课程/活动)',
	status varchar(10) not null comment '签到状态',
	isLeave int not null comment '是否请假',
	sign_person_id int not null comment '签到人id',
	sign_time Date comment '签到时间',
	person_id varchar(20) not null comment '负责人id',
	sign_activity_id int not null comment '当前签到活动id',
	class_id  int not null comment '所在班级id',
    constraint be_sign_in_pk
		primary key (sign_in_id),
	constraint signid_fk
        foreign key (sign_person_id) references be_student(student_id),
        foreign key (sign_activity_id) references be_activity(activity_id),
        foreign key (person_id)references be_teacher(teacher_id),
        foreign key (class_id)references be_classroom(classroom_id)

)
ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 comment '签到表';

DROP TABLE IF EXISTS `be_process`;
create table be_process
(
	process_id varchar(20) not null comment '流程id',
	process_status varchar(20) not null comment '流程状态(开启/关闭)',
	submit_persian_id int not null comment '发起人',
	doProcess_persian_id varchar(20) not null comment '当前处理人',
	process_type varchar(10) not null comment '流程类型',
	process_context varchar(200) not null comment '流程主内容',
	begin_time Date not null comment '开始时间',
	end_time Date not null comment '处理时间',
	process_opinion varchar(20) not null comment '处理意见',
	thing_id varchar(20) not null comment '事项id(课程/或者活动请假)',

	constraint be_process_pk
		primary key (process_id),
	constraint process_id_fk
        foreign key (submit_persian_id) references be_student(student_id),
        foreign key (doProcess_persian_id) references be_teacher(teacher_id)

)
comment '请假表';

DROP TABLE IF EXISTS `be_pay`;
create table be_pay
(
	pay_id varchar(20) not null comment '缴费id',
	student_id int not null comment '学生id',
	type varchar(20) not null comment '类型/条目',
	money float not null comment '金额',
	is_pay int not null comment '是否缴费',
	begin_time Date not null comment '开始时间',
	end_time Date not null comment '截止时间',
	pay_type varchar(10) not null comment '缴费方式(微信/支付宝)',
	pay_time Date comment '缴费时间',
	state varchar(20) comment '说明',
    constraint be_pay_pk
		primary key (pay_id),
	constraint pay_id_fk
        foreign key (student_id) references be_student(student_id)

)
comment '缴费表';

DROP TABLE IF EXISTS `be_classroom`;
create table be_classroom
(
	classroom_id int auto_increment not null comment '教室id',
	name varchar(10) not null comment '名称',
	site varchar(20) not null comment '地址',

	constraint be_classroom
		primary key (classroom_id)

)
comment '教室表';

DROP TABLE IF EXISTS `be_classroom_plan`;
create table be_classroom_plan
(
	plan_id int not null comment '安排id',
	course_id int not null comment '课程id',
	college_id varchar(20) not null comment '学院id',
	begin_time Date not null comment '开始时间',
	end_time Date not null comment '结束时间',

    constraint be_classroom_plan_pk
		primary key (plan_id),
	constraint plan_id_fk
        foreign key (course_id) references be_course(course_id),
        foreign key (college_id)references be_college(college_id)

)
comment '教室安排表';

DROP TABLE IF EXISTS `be_notice`;
create table be_notice
(
	notice_id int not null auto_increment comment '通知id',
	notice_type varchar(20) not null comment '通知类型',
	notice_begin_time Date not null comment '通知开始时间',
	notice_context varchar(200) not null comment '通知内容',
	notice_launch_id int not null comment '通知发起人id',
	is_student int not null comment '是否学生发起通知（是进行流程提交',
	notice_photo varchar(200) comment '通知图片',

    constraint be_notice_pk
		primary key (notice_id),
	constraint notice_id_fk
        foreign key (notice_launch_id) references be_student(student_id)

)
comment '通知表';