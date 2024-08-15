create table members
(
    id               bigint unsigned auto_increment comment 'id',
    email            varchar(320) not null comment '이메일',
    password         varchar(100) not null comment '비밀번호',
    name             varchar(50) not null comment '이름',
    status           varchar(20) not null comment '상태',
    sign_up_at        bigint unsigned not null comment '가입 일시',
    modified_at      bigint unsigned not null comment '수정 일시',
    primary key (id),
    unique key `uk-email` (email),
    key `idx-status` (status)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='회원';
