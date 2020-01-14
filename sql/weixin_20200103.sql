-- 微信粉丝表
create table wx_fans
(
    id              varchar(32)   not null comment '序号'
    primary key,
    openid          varchar(32)   null comment 'openid',
    nickname        varchar(100)  null comment '昵称',
    nickname_txt    varchar(100)  null comment '过滤后昵称',
    note_name       varchar(100)  null comment '备注名称',
    head_img_url    varchar(300)  null comment '用户头像',
    sex             varchar(10)   null comment '性别：''1'':男性；''2'':女性；''0'':未知',
    subscribe       varchar(10)   null comment '是否关注:''0'':未关注；''1'':关注',
    subscribe_time  datetime      null comment '关注时间',
    subscribe_scene varchar(50)   null comment '用户关注渠道来源',
    mobile          varchar(20)   null comment '手机号',
    bind_status     varchar(10)   null comment '绑定状态：''N'':未绑定；''Y'':已绑定；''V'':绑定中',
    bind_time       datetime      null comment '绑定时间',
    tag_list        varchar(1000) null comment '标签id',
    province        varchar(20)   null comment '省份',
    city            varchar(20)   null comment '城市',
    country         varchar(20)   null comment '地区',
    qr_scene        varchar(20)   null comment '二维码扫码场景',
    qr_scene_str    varchar(100)  null comment '二维码扫码常见描述',
    group_id        varchar(64)   null comment '用户所在分组id',
    language        varchar(20)   null comment '用户的语言，简体中文为zh_CN',
    union_id        varchar(64)   null comment 'unionId',
    wid             varchar(64)   null comment '公众号原始id',
    create_time     datetime      null comment '创建时间',
    create_by       varchar(64)   null comment '创建者',
    update_time     datetime      null comment '修改时间',
    update_by       varchar(64)   null comment '修改者',
    constraint uniq_openid
        unique (openid)
)
    comment '微信粉丝表' charset = utf8mb4;

create index index_bind_time
    on wx_fans (bind_time);

create index index_create_time
    on wx_fans (create_time);

create index index_mobile
    on wx_fans (mobile);

create index index_qr_scene
    on wx_fans (qr_scene);

create index index_subscribe_time
    on wx_fans (subscribe_time);

create index index_tagList
    on wx_fans (tag_list);

create index index_wid
    on wx_fans (wid);



-- 微信标签表
create table framework.wx_tag
(
	id bigint(32) auto_increment comment '主键'
		primary key,
	name varchar(64) null comment '标签名称',
	wid varchar(64) null comment '微信号',
	create_by varchar(64) default '' null comment '创建者',
	create_time datetime null comment '创建时间',
	update_by varchar(64) default '' null comment '更新者',
	update_time datetime null comment '更新时间'
)
comment '微信标签';





-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('微信粉丝管理', '403', '1', '/weixin/fans', 'C', '0', 'weixin:fans:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '微信粉丝菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('微信粉丝查询', @parentId, '1',  '#',  'F', '0', 'weixin:fans:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('微信粉丝新增', @parentId, '2',  '#',  'F', '0', 'weixin:fans:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('微信粉丝修改', @parentId, '3',  '#',  'F', '0', 'weixin:fans:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('微信粉丝删除', @parentId, '4',  '#',  'F', '0', 'weixin:fans:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('微信粉丝导出', @parentId, '5',  '#',  'F', '0', 'weixin:fans:export',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');



-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('微信标签', '403', '1', '/weixin/tag', 'C', '0', 'weixin:tag:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '微信标签菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('微信标签查询', @parentId, '1',  '#',  'F', '0', 'weixin:tag:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('微信标签新增', @parentId, '2',  '#',  'F', '0', 'weixin:tag:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('微信标签修改', @parentId, '3',  '#',  'F', '0', 'weixin:tag:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('微信标签删除', @parentId, '4',  '#',  'F', '0', 'weixin:tag:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('微信标签导出', @parentId, '5',  '#',  'F', '0', 'weixin:tag:export',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');
