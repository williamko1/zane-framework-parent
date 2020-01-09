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
