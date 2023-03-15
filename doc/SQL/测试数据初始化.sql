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
insert into platform (id, name)
values  (1, 'Web'),
    (2, '安卓'),
    (3, '苹果');

-- ----------------------------
-- Records of function
-- ----------------------------
INSERT INTO `function` (`id`, `name`, `document_link`, `originator_id`, `participant_ids`, `platform_id`, `department_id`, `planned_test_date`, `actual_test_date`, `planned_release_date`, `actual_release_date`, `status`, `delayed`, `remark`, `create_at`, `create_by`, `last_updated_at`, `last_updated_by`) VALUES (2, '开门', '', 1, '1,2,3', 2, 1, 20230101, 20230302, 20230303, 20230304, 1, 0, '测试', 1678201872197, 1, NULL, NULL);
INSERT INTO `function` (`id`, `name`, `document_link`, `originator_id`, `participant_ids`, `platform_id`, `department_id`, `planned_test_date`, `actual_test_date`, `planned_release_date`, `actual_release_date`, `status`, `delayed`, `remark`, `create_at`, `create_by`, `last_updated_at`, `last_updated_by`) VALUES (3, '开门', 'https://www.deepl.com/', 1, '1,2,3', 2, 1, 20230101, 20230302, 20230303, 20230304, 1, 0, '测试', 1678201933237, 1, NULL, NULL);
INSERT INTO `function` (`id`, `name`, `document_link`, `originator_id`, `participant_ids`, `platform_id`, `department_id`, `planned_test_date`, `actual_test_date`, `planned_release_date`, `actual_release_date`, `status`, `delayed`, `remark`, `create_at`, `create_by`, `last_updated_at`, `last_updated_by`) VALUES (4, '开门', 'https://www.deepl.com/', 1, '1,2,3', 3, 1, 20230101, 20230302, 20230303, 20230304, 1, 0, '测试', 1678204552904, 1, NULL, NULL);
INSERT INTO `function` (`id`, `name`, `document_link`, `originator_id`, `participant_ids`, `platform_id`, `department_id`, `planned_test_date`, `actual_test_date`, `planned_release_date`, `actual_release_date`, `status`, `delayed`, `remark`, `create_at`, `create_by`, `last_updated_at`, `last_updated_by`) VALUES (5, '开门', 'https://www.deepl.com/', 1, '1,2,3', 1, 1, 20230101, 20230302, 20230303, 20230304, 1, 0, '测试', 1678206234354, 1, NULL, NULL);
INSERT INTO `function` (`id`, `name`, `document_link`, `originator_id`, `participant_ids`, `platform_id`, `department_id`, `planned_test_date`, `actual_test_date`, `planned_release_date`, `actual_release_date`, `status`, `delayed`, `remark`, `create_at`, `create_by`, `last_updated_at`, `last_updated_by`) VALUES (6, '开门', 'https://www.deepl.com/', 1, '1,2,3', 1, 1, 20230101, 20230302, 20230303, 20230304, 1, 0, '测试', 1678207432827, 1, NULL, NULL);
INSERT INTO `function` (`id`, `name`, `document_link`, `originator_id`, `participant_ids`, `platform_id`, `department_id`, `planned_test_date`, `actual_test_date`, `planned_release_date`, `actual_release_date`, `status`, `delayed`, `remark`, `create_at`, `create_by`, `last_updated_at`, `last_updated_by`) VALUES (7, '开门', 'https://www.deepl.com/', 1, '1,2,3', 1, 1, 20230101, 20230302, 20230303, 20230304, 1, 0, '测试', 1678207433594, 1, NULL, NULL);
INSERT INTO `function` (`id`, `name`, `document_link`, `originator_id`, `participant_ids`, `platform_id`, `department_id`, `planned_test_date`, `actual_test_date`, `planned_release_date`, `actual_release_date`, `status`, `delayed`, `remark`, `create_at`, `create_by`, `last_updated_at`, `last_updated_by`) VALUES (8, '开门', 'https://www.deepl.com/', 1, '1,2,3', 1, 1, 20230101, 20230302, 20230303, 20230304, 1, 0, '测试', 1678280708634, 1, NULL, NULL);
INSERT INTO `function` (`id`, `name`, `document_link`, `originator_id`, `participant_ids`, `platform_id`, `department_id`, `planned_test_date`, `actual_test_date`, `planned_release_date`, `actual_release_date`, `status`, `delayed`, `remark`, `create_at`, `create_by`, `last_updated_at`, `last_updated_by`) VALUES (9, '开门', 'https://www.deepl.com/', 1, '1,2,3', 1, 1, 20230101, 20230302, 20230303, 20230304, 1, 0, '测试', 1678280709339, 1, NULL, NULL);
INSERT INTO `function` (`id`, `name`, `document_link`, `originator_id`, `participant_ids`, `platform_id`, `department_id`, `planned_test_date`, `actual_test_date`, `planned_release_date`, `actual_release_date`, `status`, `delayed`, `remark`, `create_at`, `create_by`, `last_updated_at`, `last_updated_by`) VALUES (33, '开门', 'https://www.deepl.com/', 1, '1,2,3', 1, 1, 20230101, 20230302, 20230303, 20230304, 1, 0, '测试', 1678377192742, 1, NULL, NULL);

-- ----------------------------
-- Records of employee
-- ----------------------------
insert into employee (id, nickname, department_id)
values  (1, '苹果', 1),
    (2, '葡萄', 1),
    (3, '草莓', 2),
    (4, '荔枝', 2),
    (5, '香蕉', 2),
    (6, '菠萝', 3),
    (7, '樱桃', 3),
    (8, '枇杷', 3),
    (9, '椰子', 3);