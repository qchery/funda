DROP TABLE IF EXISTS sys_user;
CREATE TABLE sys_user (
  id int AUTO_INCREMENT COMMENT 'ID',
  username VARCHAR(20) NOT NULL COMMENT '用户名',
  password VARCHAR(20) NOT NULL COMMENT '密码',
  age int COMMENT '年龄',
  nick_name VARCHAR(20) COMMENT '昵称',
  PRIMARY KEY (id)
) COMMENT '用户表';