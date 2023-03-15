CREATE TABLE `department` (
  `id` int NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '部门名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='部门';

CREATE TABLE `employee` (
  `id` int NOT NULL,
  `nickname` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '花名',
  `department_id` int NOT NULL COMMENT '部门id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='员工';

CREATE TABLE `function` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '功能名称',
  `document_link` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '文档链接',
  `originator_id` int NOT NULL COMMENT '功能发起人id',
  `participant_ids` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '参与人id列表',
  `platform_id` int NOT NULL COMMENT '平台id',
  `department_id` int NOT NULL COMMENT '部门id',
  `planned_test_date` int NOT NULL COMMENT '计划提测日期',
  `actual_test_date` int NOT NULL COMMENT '实际提测日期',
  `planned_release_date` int NOT NULL COMMENT '计划发布日期',
  `actual_release_date` int NOT NULL COMMENT '计划发布日期',
  `status` tinyint NOT NULL COMMENT '功能状态',
  `delayed` tinyint NOT NULL COMMENT '已延期',
  `remark` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '备注',
  `create_at` bigint NOT NULL,
  `create_by` int NOT NULL,
  `last_updated_at` bigint DEFAULT NULL,
  `last_updated_by` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='功能';

CREATE TABLE `platform` (
  `id` int NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '平台名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='平台';