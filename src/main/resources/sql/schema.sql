-- 数据库初始化脚本
-- select version();
-- +-----------+
-- | version() |
-- +-----------+
-- | 5.6.26    |
-- +-----------+
-- 创建数据库
CREATE DATABASE test;
-- 使用数据库
use test;

--
-- 创建user表
--
CREATE TABLE `t_user`(
  `ID` bigint NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `name` VARCHAR(120) NOT NULL COMMENT '用户名字',
  `age` INTEGER NOT NULL COMMENT '年龄',
  PRIMARY KEY (ID)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='用户表';
