-- ----------------------------
-- Records of department
-- ----------------------------
BEGIN;
INSERT INTO `department` (`id`, `name`) VALUES (1, '产品');
INSERT INTO `department` (`id`, `name`) VALUES (2, '服务端');
INSERT INTO `department` (`id`, `name`) VALUES (3, '测试');
COMMIT;

-- ----------------------------
-- Records of platform
-- ----------------------------
BEGIN;
INSERT INTO `platform` (`id`, `name`) VALUES (1, '腾讯');
INSERT INTO `platform` (`id`, `name`) VALUES (2, '微软');
INSERT INTO `platform` (`id`, `name`) VALUES (3, 'Open AI');
COMMIT;