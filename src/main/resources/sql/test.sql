/*
 Navicat Premium Data Transfer

 Source Server         : 162.14.117.124
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : 162.14.117.124:3310
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 16/11/2022 00:06:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for batch
-- ----------------------------
DROP TABLE IF EXISTS `batch`;
CREATE TABLE `batch`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '批次ID',
  `b_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '批次名',
  `start_time` datetime NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime NULL DEFAULT NULL COMMENT '结束时间',
  `status` int NULL DEFAULT NULL COMMENT '批次状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of batch
-- ----------------------------
INSERT INTO `batch` VALUES (1, '2019-2020学年第一学期', '2019-09-06 00:00:00', '2020-01-23 00:00:00', 1);
INSERT INTO `batch` VALUES (2, '2019-2020学年第二学期', '2020-03-05 00:00:00', '2020-07-10 00:00:00', 1);
INSERT INTO `batch` VALUES (3, '2020-2021学年第一学期', '2020-09-03 00:00:00', '2021-01-26 00:00:00', 1);
INSERT INTO `batch` VALUES (4, '2020-2021学年第二学期', '2021-03-04 00:00:00', '2021-07-03 00:00:00', 1);
INSERT INTO `batch` VALUES (5, '2021-2022学年第一学期', '2021-09-01 00:00:00', '2022-01-12 00:00:00', 1);
INSERT INTO `batch` VALUES (6, '2021-2022学年第二学期', '2022-03-01 00:00:00', '2022-07-10 00:00:00', 1);
INSERT INTO `batch` VALUES (7, '2022-2023学年第一学期', '2022-09-12 00:00:00', '2023-01-20 00:00:00', 1);
INSERT INTO `batch` VALUES (8, '2022-2023学年第二学期', '2023-03-02 00:00:00', '2023-07-01 00:00:00', 1);

-- ----------------------------
-- Table structure for catalogue
-- ----------------------------
DROP TABLE IF EXISTS `catalogue`;
CREATE TABLE `catalogue`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '目录ID',
  `course_id` int NOT NULL COMMENT '课程id',
  `resoure_id` int NOT NULL COMMENT '资料id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of catalogue
-- ----------------------------
INSERT INTO `catalogue` VALUES (1, 4, 44);

-- ----------------------------
-- Table structure for class_info
-- ----------------------------
DROP TABLE IF EXISTS `class_info`;
CREATE TABLE `class_info`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '班级id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班级名称',
  `status` int NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class_info
-- ----------------------------
INSERT INTO `class_info` VALUES (1, 'Java1班', 1);
INSERT INTO `class_info` VALUES (2, '计算机1班', 1);
INSERT INTO `class_info` VALUES (3, '营销1班', 1);
INSERT INTO `class_info` VALUES (4, '建筑1班', 1);
INSERT INTO `class_info` VALUES (5, '物联网2班', 1);

-- ----------------------------
-- Table structure for college_info
-- ----------------------------
DROP TABLE IF EXISTS `college_info`;
CREATE TABLE `college_info`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '学院id',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学院名称',
  `status` int NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of college_info
-- ----------------------------
INSERT INTO `college_info` VALUES (1, '软件与人工智能学院', 1);
INSERT INTO `college_info` VALUES (2, '计算机学院', 1);
INSERT INTO `college_info` VALUES (3, '管理学院', 1);
INSERT INTO `college_info` VALUES (4, '土木学院', 1);
INSERT INTO `college_info` VALUES (5, '通识学院', 1);

-- ----------------------------
-- Table structure for college_teacher
-- ----------------------------
DROP TABLE IF EXISTS `college_teacher`;
CREATE TABLE `college_teacher`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '学院教师表id',
  `college_id` int NOT NULL COMMENT '学院id',
  `user_id` int NOT NULL COMMENT '用户id',
  `role_id` int NULL DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of college_teacher
-- ----------------------------
INSERT INTO `college_teacher` VALUES (7, 1, 6, 9);
INSERT INTO `college_teacher` VALUES (9, 1, 7, 9);
INSERT INTO `college_teacher` VALUES (10, 1, 5, 10);
INSERT INTO `college_teacher` VALUES (12, 1, 4, 9);

-- ----------------------------
-- Table structure for course_batch
-- ----------------------------
DROP TABLE IF EXISTS `course_batch`;
CREATE TABLE `course_batch`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `batch_id` int NULL DEFAULT NULL COMMENT '批次ID',
  `course_id` int NULL DEFAULT NULL COMMENT '课程ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course_batch
-- ----------------------------
INSERT INTO `course_batch` VALUES (3, 1, 3);
INSERT INTO `course_batch` VALUES (5, 2, 5);
INSERT INTO `course_batch` VALUES (8, 6, 1);
INSERT INTO `course_batch` VALUES (11, 1, 4);
INSERT INTO `course_batch` VALUES (12, 8, 2);
INSERT INTO `course_batch` VALUES (13, 8, 6);

-- ----------------------------
-- Table structure for course_info
-- ----------------------------
DROP TABLE IF EXISTS `course_info`;
CREATE TABLE `course_info`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '课程ID',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程名',
  `publisher_id` int NOT NULL COMMENT '发布人',
  `status` int NOT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course_info
-- ----------------------------
INSERT INTO `course_info` VALUES (1, '计算机操作系统', 1, 1);
INSERT INTO `course_info` VALUES (2, '软件工程', 1, 1);
INSERT INTO `course_info` VALUES (3, '数据库设计', 1, 1);
INSERT INTO `course_info` VALUES (4, 'java基础', 1, 1);
INSERT INTO `course_info` VALUES (5, 'ssm框架', 1, 1);
INSERT INTO `course_info` VALUES (6, '项目管理', 1, 1);

-- ----------------------------
-- Table structure for evaluation
-- ----------------------------
DROP TABLE IF EXISTS `evaluation`;
CREATE TABLE `evaluation`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '评教ID',
  `role_id` int NOT NULL COMMENT '授课id',
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `status` int NOT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of evaluation
-- ----------------------------
INSERT INTO `evaluation` VALUES (1, 3, '2022-11-03 12:10:27', '2022-11-30 00:00:00', 0);
INSERT INTO `evaluation` VALUES (2, 9, '2022-11-05 00:00:00', '2022-11-28 00:00:00', 0);
INSERT INTO `evaluation` VALUES (3, 8, '2022-11-02 00:00:00', '2022-11-07 09:03:47', 0);
INSERT INTO `evaluation` VALUES (4, 10, '2022-11-12 18:15:34', '2022-11-24 00:00:00', 1);

-- ----------------------------
-- Table structure for exam_score
-- ----------------------------
DROP TABLE IF EXISTS `exam_score`;
CREATE TABLE `exam_score`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '成绩分析表ID',
  `sc_id` int NOT NULL COMMENT '学生课程表ID',
  `score` decimal(10, 0) NOT NULL COMMENT '成绩分数',
  `ca_id` int NOT NULL COMMENT '目录表',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exam_score
-- ----------------------------
INSERT INTO `exam_score` VALUES (1, 2, 88, 1);

-- ----------------------------
-- Table structure for quota
-- ----------------------------
DROP TABLE IF EXISTS `quota`;
CREATE TABLE `quota`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `quota_name` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '指标名称',
  `quota_right` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权重',
  `parent_id` int NULL DEFAULT NULL COMMENT '父指标id',
  `CREATED_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_TIME` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1200 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of quota
-- ----------------------------
INSERT INTO `quota` VALUES (1135, '学 生 方 面', '0.3', 0, '2022-11-14 18:56:56', '2022-11-14 18:56:56');
INSERT INTO `quota` VALUES (1136, '概念的讲解', '0.15', 1135, '2022-11-14 18:56:56', '2022-11-14 18:56:56');
INSERT INTO `quota` VALUES (1137, '重点和难点', '0.15', 1135, '2022-11-14 18:56:56', '2022-11-14 18:56:56');
INSERT INTO `quota` VALUES (1138, '逻辑性和条理', '0.1', 1135, '2022-11-14 18:56:56', '2022-11-14 18:56:56');
INSERT INTO `quota` VALUES (1139, '趣味性和生动性', '0.1', 1135, '2022-11-14 18:56:56', '2022-11-14 18:56:56');
INSERT INTO `quota` VALUES (1140, '板书', '0.05', 1135, '2022-11-14 18:56:56', '2022-11-14 18:56:56');
INSERT INTO `quota` VALUES (1141, '辅导（阅读指导）', '0.08', 1135, '2022-11-14 18:56:56', '2022-11-14 18:56:56');
INSERT INTO `quota` VALUES (1142, '作业与批改', '0.1', 1135, '2022-11-14 18:56:56', '2022-11-14 18:56:56');
INSERT INTO `quota` VALUES (1143, '能力培养', '0.1', 1135, '2022-11-14 18:56:56', '2022-11-14 18:56:56');
INSERT INTO `quota` VALUES (1144, '教书育人', '0.1', 1135, '2022-11-14 18:56:56', '2022-11-14 18:56:56');
INSERT INTO `quota` VALUES (1145, '为人师表', '0.07', 1135, '2022-11-14 18:56:56', '2022-11-14 18:56:56');
INSERT INTO `quota` VALUES (1146, '系  （部） 方  面', '0.25', 0, '2022-11-14 18:56:56', '2022-11-14 18:56:56');
INSERT INTO `quota` VALUES (1147, '量考核', '0.3', 1146, '2022-11-14 18:56:56', '2022-11-14 18:56:56');
INSERT INTO `quota` VALUES (1148, '教学工作量', '0.75', 1147, '2022-11-14 18:56:56', '2022-11-14 18:56:56');
INSERT INTO `quota` VALUES (1149, '社会工作量', '0.15', 1147, '2022-11-14 18:56:56', '2022-11-14 18:56:56');
INSERT INTO `quota` VALUES (1150, '任课班级', '0.1', 1147, '2022-11-14 18:56:56', '2022-11-14 18:56:56');
INSERT INTO `quota` VALUES (1151, '质考核', '0.7', 1146, '2022-11-14 18:56:56', '2022-11-14 18:56:56');
INSERT INTO `quota` VALUES (1152, '工作态度', '0.4', 1151, '2022-11-14 18:56:57', '2022-11-14 18:56:57');
INSERT INTO `quota` VALUES (1153, '接受任务态度', '0.1', 1152, '2022-11-14 18:56:57', '2022-11-14 18:56:57');
INSERT INTO `quota` VALUES (1154, '教学常规', '0.9', 1152, '2022-11-14 18:56:57', '2022-11-14 18:56:57');
INSERT INTO `quota` VALUES (1155, '授课计划的制定', '0.1', 1154, '2022-11-14 18:56:57', '2022-11-14 18:56:57');
INSERT INTO `quota` VALUES (1156, '教案首页', '0.2', 1154, '2022-11-14 18:56:57', '2022-11-14 18:56:57');
INSERT INTO `quota` VALUES (1157, '备课余量', '0.1', 1154, '2022-11-14 18:56:57', '2022-11-14 18:56:57');
INSERT INTO `quota` VALUES (1158, '教学日志手册的填写', '0.1', 1154, '2022-11-14 18:56:57', '2022-11-14 18:56:57');
INSERT INTO `quota` VALUES (1159, '教学表格的填写', '0.1', 1154, '2022-11-14 18:56:57', '2022-11-14 18:56:57');
INSERT INTO `quota` VALUES (1160, '辅导', '0.2', 1154, '2022-11-14 18:56:57', '2022-11-14 18:56:57');
INSERT INTO `quota` VALUES (1161, '教学秩序的掌握', '0.2', 1154, '2022-11-14 18:56:57', '2022-11-14 18:56:57');
INSERT INTO `quota` VALUES (1162, '学术与研究水平', '0.15', 1151, '2022-11-14 18:56:57', '2022-11-14 18:56:57');
INSERT INTO `quota` VALUES (1163, '职称', '0.1', 1162, '2022-11-14 18:56:57', '2022-11-14 18:56:57');
INSERT INTO `quota` VALUES (1164, '运用新知识、新技术能力', '0.4', 1162, '2022-11-14 18:56:57', '2022-11-14 18:56:57');
INSERT INTO `quota` VALUES (1165, '论文撰写、教材编写能力', '0.5', 1162, '2022-11-14 18:56:57', '2022-11-14 18:56:57');
INSERT INTO `quota` VALUES (1166, '完成任务情况', '0.05', 1151, '2022-11-14 18:56:57', '2022-11-14 18:56:57');
INSERT INTO `quota` VALUES (1167, '教学水平变化', '0.05', 1151, '2022-11-14 18:56:57', '2022-11-14 18:56:57');
INSERT INTO `quota` VALUES (1168, '教学反映', '0.15', 1151, '2022-11-14 18:56:57', '2022-11-14 18:56:57');
INSERT INTO `quota` VALUES (1169, '能力培养', '0.1', 1151, '2022-11-14 18:56:57', '2022-11-14 18:56:57');
INSERT INTO `quota` VALUES (1170, '汲取新信息新技术', '0.05', 1151, '2022-11-14 18:56:57', '2022-11-14 18:56:57');
INSERT INTO `quota` VALUES (1171, '考试命题', '0.05', 1151, '2022-11-14 18:56:57', '2022-11-14 18:56:57');
INSERT INTO `quota` VALUES (1172, '教  研  室  方  面', '0.2', 0, '2022-11-14 18:56:57', '2022-11-14 18:56:57');
INSERT INTO `quota` VALUES (1173, '教学环节', '0.6', 1172, '2022-11-14 18:56:57', '2022-11-14 18:56:57');
INSERT INTO `quota` VALUES (1174, '概念的讲解', '0.15', 1173, '2022-11-14 18:56:57', '2022-11-14 18:56:57');
INSERT INTO `quota` VALUES (1175, '重点和难点', '0.15', 1173, '2022-11-14 18:56:58', '2022-11-14 18:56:58');
INSERT INTO `quota` VALUES (1176, '逻辑性、条理性', '0.1', 1173, '2022-11-14 18:56:58', '2022-11-14 18:56:58');
INSERT INTO `quota` VALUES (1177, '趣味性、生动性', '0.1', 1173, '2022-11-14 18:56:58', '2022-11-14 18:56:58');
INSERT INTO `quota` VALUES (1178, '板书', '0.05', 1173, '2022-11-14 18:56:58', '2022-11-14 18:56:58');
INSERT INTO `quota` VALUES (1179, '能力培养', '0.15', 1173, '2022-11-14 18:56:58', '2022-11-14 18:56:58');
INSERT INTO `quota` VALUES (1180, '理论联系实际', '0.1', 1173, '2022-11-14 18:56:58', '2022-11-14 18:56:58');
INSERT INTO `quota` VALUES (1181, '辅导（阅读指导）', '0.1', 1173, '2022-11-14 18:56:58', '2022-11-14 18:56:58');
INSERT INTO `quota` VALUES (1182, '作业与批改', '0.1', 1173, '2022-11-14 18:56:58', '2022-11-14 18:56:58');
INSERT INTO `quota` VALUES (1183, '接受任务的态度', '0.05', 1172, '2022-11-14 18:56:58', '2022-11-14 18:56:58');
INSERT INTO `quota` VALUES (1184, '汲取新技术', '0.05', 1172, '2022-11-14 18:56:58', '2022-11-14 18:56:58');
INSERT INTO `quota` VALUES (1185, '学术与研究水平', '0.1', 1172, '2022-11-14 18:56:58', '2022-11-14 18:56:58');
INSERT INTO `quota` VALUES (1186, '参加教研活动', '0.2', 1172, '2022-11-14 18:56:58', '2022-11-14 18:56:58');
INSERT INTO `quota` VALUES (1187, '同行方面（领导、督导）', '0.15', 0, '2022-11-14 18:56:58', '2022-11-14 18:56:58');
INSERT INTO `quota` VALUES (1188, '组织教学', '0.15', 1187, '2022-11-14 18:56:58', '2022-11-14 18:56:58');
INSERT INTO `quota` VALUES (1189, '教学内容与教学要求', '0.15', 1187, '2022-11-14 18:56:58', '2022-11-14 18:56:58');
INSERT INTO `quota` VALUES (1190, '概念讲解', '0.1', 1187, '2022-11-14 18:56:58', '2022-11-14 18:56:58');
INSERT INTO `quota` VALUES (1191, '重点和难点', '0.1', 1187, '2022-11-14 18:56:58', '2022-11-14 18:56:58');
INSERT INTO `quota` VALUES (1192, '趣味性与生动性', '0.08', 1187, '2022-11-14 18:56:58', '2022-11-14 18:56:58');
INSERT INTO `quota` VALUES (1193, '直观教学与板书', '0.07', 1187, '2022-11-14 18:56:58', '2022-11-14 18:56:58');
INSERT INTO `quota` VALUES (1194, '智力能力的培养', '0.1', 1187, '2022-11-14 18:56:58', '2022-11-14 18:56:58');
INSERT INTO `quota` VALUES (1195, '理论联系实际', '0.1', 1187, '2022-11-14 18:56:58', '2022-11-14 18:56:58');
INSERT INTO `quota` VALUES (1196, '教材处理', '0.15', 1187, '2022-11-14 18:56:58', '2022-11-14 18:56:58');
INSERT INTO `quota` VALUES (1197, '教师个人方面', '0.1', 0, '2022-11-14 18:56:58', '2022-11-14 18:56:58');
INSERT INTO `quota` VALUES (1198, '自我评价', '0.5', 1197, '2022-11-14 18:56:59', '2022-11-14 18:56:59');
INSERT INTO `quota` VALUES (1199, '自我评价的工作', '0.5', 1197, '2022-11-14 18:56:59', '2022-11-14 18:56:59');

-- ----------------------------
-- Table structure for quota_options
-- ----------------------------
DROP TABLE IF EXISTS `quota_options`;
CREATE TABLE `quota_options`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `quota_id` int NULL DEFAULT NULL COMMENT '指标id',
  `options_name` varchar(5000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '选项名称',
  `score` int NULL DEFAULT NULL COMMENT '分数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3107 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of quota_options
-- ----------------------------
INSERT INTO `quota_options` VALUES (2891, 1136, '语言精练，深入浅出，讲解准确', 100);
INSERT INTO `quota_options` VALUES (2892, 1136, '讲解清晰，容易接受', 75);
INSERT INTO `quota_options` VALUES (2893, 1136, '讲解基本准确，但不易接受', 50);
INSERT INTO `quota_options` VALUES (2894, 1136, '概念紊乱，时有差错', 25);
INSERT INTO `quota_options` VALUES (2895, 1137, '重点突出，讲清难点，举一反三', 100);
INSERT INTO `quota_options` VALUES (2896, 1137, '能把握重点、难点，但讲解不够明确', 75);
INSERT INTO `quota_options` VALUES (2897, 1137, '重点不明显，难点讲不透', 50);
INSERT INTO `quota_options` VALUES (2898, 1137, '重点一言而过，难点草率了事', 25);
INSERT INTO `quota_options` VALUES (2899, 1138, '层次分明，融会贯通', 100);
INSERT INTO `quota_options` VALUES (2900, 1138, '条目较清楚，有分析归纳', 75);
INSERT INTO `quota_options` VALUES (2901, 1138, '平淡叙述，缺乏连贯性', 50);
INSERT INTO `quota_options` VALUES (2902, 1138, '杂乱无章，前后矛盾', 25);
INSERT INTO `quota_options` VALUES (2903, 1139, '讲解方法新颖，举例生动，有吸引力', 100);
INSERT INTO `quota_options` VALUES (2904, 1139, '讲解较熟练，语言通俗', 75);
INSERT INTO `quota_options` VALUES (2905, 1139, '讲解平淡，语言单调', 50);
INSERT INTO `quota_options` VALUES (2906, 1139, '讲解生疏，远离课题，语言枯燥', 25);
INSERT INTO `quota_options` VALUES (2907, 1140, '简繁适度，清楚醒目', 100);
INSERT INTO `quota_options` VALUES (2908, 1140, '条目明白，书写整洁', 75);
INSERT INTO `quota_options` VALUES (2909, 1140, '布局较差，详略失当', 50);
INSERT INTO `quota_options` VALUES (2910, 1140, '次序凌乱，书写潦草', 25);
INSERT INTO `quota_options` VALUES (2911, 1141, '辅导及时、并指导课外阅读', 100);
INSERT INTO `quota_options` VALUES (2912, 1141, '定期辅导，并布置课外阅读', 75);
INSERT INTO `quota_options` VALUES (2913, 1141, '辅导较少', 50);
INSERT INTO `quota_options` VALUES (2914, 1141, '没有辅导', 25);
INSERT INTO `quota_options` VALUES (2915, 1142, '选题得当，批改及时，注意讲评', 100);
INSERT INTO `quota_options` VALUES (2916, 1142, '作业适量，批改及时', 75);
INSERT INTO `quota_options` VALUES (2917, 1142, '作业量时轻时重，批改不够及时', 50);
INSERT INTO `quota_options` VALUES (2918, 1142, '选题随便，批改马虎', 25);
INSERT INTO `quota_options` VALUES (2919, 1143, '思路开阔，鼓励创新，注意能力培养、效果明显', 100);
INSERT INTO `quota_options` VALUES (2920, 1143, '注意学生能力培养，并在教学中有所体现', 75);
INSERT INTO `quota_options` VALUES (2921, 1143, '能提出能力培养的要求，但缺乏具体的办法', 50);
INSERT INTO `quota_options` VALUES (2922, 1143, '忽视能力培养，单纯灌输书本知识', 25);
INSERT INTO `quota_options` VALUES (2923, 1144, '全面关心学生，经常接触学生，亲切、严格', 100);
INSERT INTO `quota_options` VALUES (2924, 1144, '关心学生的学业，引导学生学好本门课程', 75);
INSERT INTO `quota_options` VALUES (2925, 1144, '单纯完成上课任务，与同学接触较少', 50);
INSERT INTO `quota_options` VALUES (2926, 1144, '对学生漠不关心，放任自流', 25);
INSERT INTO `quota_options` VALUES (2927, 1145, '严于律己，以身作则，堪称楷模', 100);
INSERT INTO `quota_options` VALUES (2928, 1145, '举止文明，待人热情', 75);
INSERT INTO `quota_options` VALUES (2929, 1145, '注意礼貌，待人和气', 50);
INSERT INTO `quota_options` VALUES (2930, 1145, '要求不严，言谈失当', 25);
INSERT INTO `quota_options` VALUES (2931, 1148, '超工作量', 100);
INSERT INTO `quota_options` VALUES (2932, 1148, '满工作量', 75);
INSERT INTO `quota_options` VALUES (2933, 1148, '接近完成（70%）', 50);
INSERT INTO `quota_options` VALUES (2934, 1148, '差距较大', 25);
INSERT INTO `quota_options` VALUES (2935, 1149, '担任教研室主任', 100);
INSERT INTO `quota_options` VALUES (2936, 1149, '担任办公室、工作室主任', 75);
INSERT INTO `quota_options` VALUES (2937, 1149, '担任专业班主任（辅导员）等其他工作', 50);
INSERT INTO `quota_options` VALUES (2938, 1149, '未承担', 25);
INSERT INTO `quota_options` VALUES (2939, 1150, '任4个班级以上，或双进度', 100);
INSERT INTO `quota_options` VALUES (2940, 1150, '任3个班级', 75);
INSERT INTO `quota_options` VALUES (2941, 1150, '任2个班级', 50);
INSERT INTO `quota_options` VALUES (2942, 1150, '任1个班级', 25);
INSERT INTO `quota_options` VALUES (2943, 1153, '勇挑重担', 100);
INSERT INTO `quota_options` VALUES (2944, 1153, '主动承担', 75);
INSERT INTO `quota_options` VALUES (2945, 1153, '一    般', 50);
INSERT INTO `quota_options` VALUES (2946, 1153, '较    差', 25);
INSERT INTO `quota_options` VALUES (2947, 1155, '清晰', 100);
INSERT INTO `quota_options` VALUES (2948, 1155, '完整', 75);
INSERT INTO `quota_options` VALUES (2949, 1155, '一般', 50);
INSERT INTO `quota_options` VALUES (2950, 1155, '潦草', 25);
INSERT INTO `quota_options` VALUES (2951, 1156, '完整', 100);
INSERT INTO `quota_options` VALUES (2952, 1156, '缺一项', 75);
INSERT INTO `quota_options` VALUES (2953, 1156, '缺二项', 50);
INSERT INTO `quota_options` VALUES (2954, 1156, '缺二项以上', 25);
INSERT INTO `quota_options` VALUES (2955, 1157, '一周以上', 100);
INSERT INTO `quota_options` VALUES (2956, 1157, '一周', 75);
INSERT INTO `quota_options` VALUES (2957, 1157, '接近一周', 50);
INSERT INTO `quota_options` VALUES (2958, 1157, '没有余量', 25);
INSERT INTO `quota_options` VALUES (2959, 1158, '清楚、准确', 100);
INSERT INTO `quota_options` VALUES (2960, 1158, '正确、及时', 75);
INSERT INTO `quota_options` VALUES (2961, 1158, '填写缺项', 50);
INSERT INTO `quota_options` VALUES (2962, 1158, '填写马虎', 25);
INSERT INTO `quota_options` VALUES (2963, 1159, '认真且有见解', 100);
INSERT INTO `quota_options` VALUES (2964, 1159, '详尽、整洁', 75);
INSERT INTO `quota_options` VALUES (2965, 1159, '正确', 50);
INSERT INTO `quota_options` VALUES (2966, 1159, '潦草、拖拉', 25);
INSERT INTO `quota_options` VALUES (2967, 1160, '每周有辅导', 100);
INSERT INTO `quota_options` VALUES (2968, 1160, '辅导较经常', 75);
INSERT INTO `quota_options` VALUES (2969, 1160, '辅导较少', 50);
INSERT INTO `quota_options` VALUES (2970, 1160, '不辅导', 25);
INSERT INTO `quota_options` VALUES (2971, 1161, '严格', 100);
INSERT INTO `quota_options` VALUES (2972, 1161, '较严格', 75);
INSERT INTO `quota_options` VALUES (2973, 1161, '一般', 50);
INSERT INTO `quota_options` VALUES (2974, 1161, '出现教学事故', 25);
INSERT INTO `quota_options` VALUES (2975, 1163, '副教授', 100);
INSERT INTO `quota_options` VALUES (2976, 1163, '讲师', 75);
INSERT INTO `quota_options` VALUES (2977, 1163, '助教', 50);
INSERT INTO `quota_options` VALUES (2978, 1163, '未评职称', 25);
INSERT INTO `quota_options` VALUES (2979, 1164, '开出有一定水平的选修课、讲座、院级公开课或指导兴趣小组有成效', 100);
INSERT INTO `quota_options` VALUES (2980, 1164, '开出选修课、讲座、科内公开课或指导兴趣小组活动', 75);
INSERT INTO `quota_options` VALUES (2981, 1164, '承担室内研究课、协助开出讲座或配合指导学生课外活动', 50);
INSERT INTO `quota_options` VALUES (2982, 1164, '无', 25);
INSERT INTO `quota_options` VALUES (2983, 1165, '在核心刊物上发表、教材正式出版（三年内）', 100);
INSERT INTO `quota_options` VALUES (2984, 1165, '在公开刊物上发表，教材兄弟院校使用（二年内）', 75);
INSERT INTO `quota_options` VALUES (2985, 1165, '在内部刊上发表，教材在校内使用（一年内）', 50);
INSERT INTO `quota_options` VALUES (2986, 1165, '无', 25);
INSERT INTO `quota_options` VALUES (2987, 1166, '高质量完成', 100);
INSERT INTO `quota_options` VALUES (2988, 1166, '及时完成', 75);
INSERT INTO `quota_options` VALUES (2989, 1166, '基本完成', 50);
INSERT INTO `quota_options` VALUES (2990, 1166, '完不成', 25);
INSERT INTO `quota_options` VALUES (2991, 1167, '显著提高', 100);
INSERT INTO `quota_options` VALUES (2992, 1167, '有所提高', 75);
INSERT INTO `quota_options` VALUES (2993, 1167, '变化很小', 50);
INSERT INTO `quota_options` VALUES (2994, 1167, '下降', 25);
INSERT INTO `quota_options` VALUES (2995, 1168, '优秀', 100);
INSERT INTO `quota_options` VALUES (2996, 1168, '良好', 75);
INSERT INTO `quota_options` VALUES (2997, 1168, '一般', 50);
INSERT INTO `quota_options` VALUES (2998, 1168, '较差', 25);
INSERT INTO `quota_options` VALUES (2999, 1169, '思路开阔，鼓励创新，注意能力培养、效果明显', 100);
INSERT INTO `quota_options` VALUES (3000, 1169, '注意学生能力培养，并在教学中有所体现', 75);
INSERT INTO `quota_options` VALUES (3001, 1169, '能提出能力培养的要求，但缺乏具体的办法', 50);
INSERT INTO `quota_options` VALUES (3002, 1169, '忽视能力培养，单纯灌输书本知识', 25);
INSERT INTO `quota_options` VALUES (3003, 1170, '及时在教学中体现', 100);
INSERT INTO `quota_options` VALUES (3004, 1170, '教学中注意联系新信息新技术', 75);
INSERT INTO `quota_options` VALUES (3005, 1170, '教学中联系新信息新技术不够', 50);
INSERT INTO `quota_options` VALUES (3006, 1170, '教学中根本不联系新信息新技术', 25);
INSERT INTO `quota_options` VALUES (3007, 1171, '试题的水平、题型、题量、分布、覆盖面符合教学目标的要求；难度适中，区分度适当；表述准确、严密、简洁。', 100);
INSERT INTO `quota_options` VALUES (3008, 1171, '有2项不符合要求', 75);
INSERT INTO `quota_options` VALUES (3009, 1171, '有3项不符合要求', 50);
INSERT INTO `quota_options` VALUES (3010, 1171, '有3项以上（不含3项）不符合要求', 25);
INSERT INTO `quota_options` VALUES (3011, 1174, '语言精练，深入浅出，讲解准确', 100);
INSERT INTO `quota_options` VALUES (3012, 1174, '讲解清晰，容易接受', 75);
INSERT INTO `quota_options` VALUES (3013, 1174, '讲解基本准确，但不易接受', 50);
INSERT INTO `quota_options` VALUES (3014, 1174, '概念紊乱，时有差错', 25);
INSERT INTO `quota_options` VALUES (3015, 1175, '重点突出，讲清难点，举一反三', 100);
INSERT INTO `quota_options` VALUES (3016, 1175, '能把握重点、难点，但讲解不够明确', 75);
INSERT INTO `quota_options` VALUES (3017, 1175, '重点不明显，难点讲不透', 50);
INSERT INTO `quota_options` VALUES (3018, 1175, '重点一言而过，难点草率了事', 25);
INSERT INTO `quota_options` VALUES (3019, 1176, '层次分明，融会贯通', 100);
INSERT INTO `quota_options` VALUES (3020, 1176, '条目较清楚，有分析归纳', 75);
INSERT INTO `quota_options` VALUES (3021, 1176, '平淡叙述，缺乏连贯性', 50);
INSERT INTO `quota_options` VALUES (3022, 1176, '杂乱无章，前后矛盾', 25);
INSERT INTO `quota_options` VALUES (3023, 1177, '讲解方法新颖，举例生动，有吸引力', 100);
INSERT INTO `quota_options` VALUES (3024, 1177, '讲解较熟练，语言通俗', 75);
INSERT INTO `quota_options` VALUES (3025, 1177, '讲解平淡，语言单调', 50);
INSERT INTO `quota_options` VALUES (3026, 1177, '讲解生疏，远离课题，语言枯燥', 25);
INSERT INTO `quota_options` VALUES (3027, 1178, '简繁适度，清楚醒目', 100);
INSERT INTO `quota_options` VALUES (3028, 1178, '条目明白，书写整洁', 75);
INSERT INTO `quota_options` VALUES (3029, 1178, '布局较差，详略适当', 50);
INSERT INTO `quota_options` VALUES (3030, 1178, '次序凌乱，书写潦草', 25);
INSERT INTO `quota_options` VALUES (3031, 1179, '思路开阔，鼓励创新，注意能力培养、效果明显', 100);
INSERT INTO `quota_options` VALUES (3032, 1179, '注意学生能力培养，并在教学中有所体现', 75);
INSERT INTO `quota_options` VALUES (3033, 1179, '能提出能力培养的要求，但缺乏具体的办法', 50);
INSERT INTO `quota_options` VALUES (3034, 1179, '忽视能力培养，单纯灌输书本知识', 25);
INSERT INTO `quota_options` VALUES (3035, 1180, '理论紧密联系当前实际', 100);
INSERT INTO `quota_options` VALUES (3036, 1180, '理论能联系具体事例', 75);
INSERT INTO `quota_options` VALUES (3037, 1180, '联系实际较勉强', 50);
INSERT INTO `quota_options` VALUES (3038, 1180, '只有理论没有实际', 25);
INSERT INTO `quota_options` VALUES (3039, 1181, '辅导及时、并指导课外阅读', 100);
INSERT INTO `quota_options` VALUES (3040, 1181, '定期辅导，并布置课外阅读', 75);
INSERT INTO `quota_options` VALUES (3041, 1181, '辅导较少', 50);
INSERT INTO `quota_options` VALUES (3042, 1181, '没有辅导', 25);
INSERT INTO `quota_options` VALUES (3043, 1182, '选题得当，批改及时，注意讲评', 100);
INSERT INTO `quota_options` VALUES (3044, 1182, '作业适量，批改及时', 75);
INSERT INTO `quota_options` VALUES (3045, 1182, '作业量时轻时重，批改不够及时', 50);
INSERT INTO `quota_options` VALUES (3046, 1182, '选题随便，批改马虎', 25);
INSERT INTO `quota_options` VALUES (3047, 1183, '勇挑重担', 100);
INSERT INTO `quota_options` VALUES (3048, 1183, '主动承担', 75);
INSERT INTO `quota_options` VALUES (3049, 1183, '一    般', 50);
INSERT INTO `quota_options` VALUES (3050, 1183, '较    差', 25);
INSERT INTO `quota_options` VALUES (3051, 1184, '及时在教学中体现', 100);
INSERT INTO `quota_options` VALUES (3052, 1184, '教学中注意联系新信息新技术', 75);
INSERT INTO `quota_options` VALUES (3053, 1184, '教学中联系新信息新技术不够', 50);
INSERT INTO `quota_options` VALUES (3054, 1184, '教学中根本不联系新信息新技术', 25);
INSERT INTO `quota_options` VALUES (3055, 1185, '开出有一定水平的选修课、讲座、院级公开课或指导兴趣小组有成效', 100);
INSERT INTO `quota_options` VALUES (3056, 1185, '开出选修课、讲座、系内公开课或指导兴趣小组活动', 75);
INSERT INTO `quota_options` VALUES (3057, 1185, '承担室内研究课、协助开出讲座或配合指导学生课外活动', 50);
INSERT INTO `quota_options` VALUES (3058, 1185, '无', 25);
INSERT INTO `quota_options` VALUES (3059, 1186, '出主意、提建议、协助室主任搞好教研活动', 100);
INSERT INTO `quota_options` VALUES (3060, 1186, '积极参加讨论', 75);
INSERT INTO `quota_options` VALUES (3061, 1186, '能按时参加活动', 50);
INSERT INTO `quota_options` VALUES (3062, 1186, '参加活动不正常', 25);
INSERT INTO `quota_options` VALUES (3063, 1188, '教学组织安排得当，气氛活跃，纪律良好', 100);
INSERT INTO `quota_options` VALUES (3064, 1188, '注意学生动态，教学有条不紊', 75);
INSERT INTO `quota_options` VALUES (3065, 1188, '忽视教学步骤，师生双边活动较差', 50);
INSERT INTO `quota_options` VALUES (3066, 1188, '只顾自己讲，不管学生情况', 25);
INSERT INTO `quota_options` VALUES (3067, 1189, '切合教学大纲要求与实际，内容组织科学严密', 100);
INSERT INTO `quota_options` VALUES (3068, 1189, '符合教学大纲要求，内容正确', 75);
INSERT INTO `quota_options` VALUES (3069, 1189, '基本达到教学大纲要求，内容偶有差错', 50);
INSERT INTO `quota_options` VALUES (3070, 1189, '降低教学标准，内容时有差错', 25);
INSERT INTO `quota_options` VALUES (3071, 1190, '语言精练，深入浅出，讲解准确', 100);
INSERT INTO `quota_options` VALUES (3072, 1190, '讲解清晰，容易接受', 75);
INSERT INTO `quota_options` VALUES (3073, 1190, '讲解基本准确，但不易接受', 50);
INSERT INTO `quota_options` VALUES (3074, 1190, '概念紊乱，时有差错', 25);
INSERT INTO `quota_options` VALUES (3075, 1191, '重点突出，讲清难点，举一反三', 100);
INSERT INTO `quota_options` VALUES (3076, 1191, '能把握重点、难点，但讲解不够明确', 75);
INSERT INTO `quota_options` VALUES (3077, 1191, '重点不明显，难点讲不透', 50);
INSERT INTO `quota_options` VALUES (3078, 1191, '重点一言而过，难点草率了事', 25);
INSERT INTO `quota_options` VALUES (3079, 1192, '讲解方法新颖，举例生动，有吸引力', 100);
INSERT INTO `quota_options` VALUES (3080, 1192, '讲解较熟练，语言通俗', 75);
INSERT INTO `quota_options` VALUES (3081, 1192, '讲解平淡，语言单调', 50);
INSERT INTO `quota_options` VALUES (3082, 1192, '讲解生疏，远离课题，语言枯燥', 25);
INSERT INTO `quota_options` VALUES (3083, 1193, '教具使用合理，板书清晰，示教形象、直观', 100);
INSERT INTO `quota_options` VALUES (3084, 1193, '注意直观教学，板书条目明白、整洁', 75);
INSERT INTO `quota_options` VALUES (3085, 1193, '教具使用失当，板书布局较差', 50);
INSERT INTO `quota_options` VALUES (3086, 1193, '忽视直观教学，板书凌乱', 25);
INSERT INTO `quota_options` VALUES (3087, 1194, '运用各种方法，调动学生积极思维，注重能力培养', 100);
INSERT INTO `quota_options` VALUES (3088, 1194, '注意调动学生思维和能力培养，方法和效果欠佳', 75);
INSERT INTO `quota_options` VALUES (3089, 1194, '缺乏启发式方法和能力培养手段', 50);
INSERT INTO `quota_options` VALUES (3090, 1194, '照本宣科，不搞启发式教学', 25);
INSERT INTO `quota_options` VALUES (3091, 1195, '理论与实例、实验、实际密切结合', 100);
INSERT INTO `quota_options` VALUES (3092, 1195, '理论能结合实际进行教学', 75);
INSERT INTO `quota_options` VALUES (3093, 1195, '理论与实际结合不理想', 50);
INSERT INTO `quota_options` VALUES (3094, 1195, '理论与实际严重脱节', 25);
INSERT INTO `quota_options` VALUES (3095, 1196, '科学的处理教材，繁简增删适当，收事半功倍之效', 100);
INSERT INTO `quota_options` VALUES (3096, 1196, '对教材的处理，有助于学生理解和掌握内在联系', 75);
INSERT INTO `quota_options` VALUES (3097, 1196, '基本按照教材讲课，没有给学生什么新东西', 50);
INSERT INTO `quota_options` VALUES (3098, 1196, '对教材毫无处理，完全重复课本内容', 25);
INSERT INTO `quota_options` VALUES (3099, 1198, '十分敬业', 100);
INSERT INTO `quota_options` VALUES (3100, 1198, '较为敬业', 75);
INSERT INTO `quota_options` VALUES (3101, 1198, '一般敬业', 50);
INSERT INTO `quota_options` VALUES (3102, 1198, '不敬业', 25);
INSERT INTO `quota_options` VALUES (3103, 1199, '班级学风优秀', 100);
INSERT INTO `quota_options` VALUES (3104, 1199, '班级学风良好', 75);
INSERT INTO `quota_options` VALUES (3105, 1199, '班级学风一般', 50);
INSERT INTO `quota_options` VALUES (3106, 1199, '班级学风较差', 25);

-- ----------------------------
-- Table structure for score_result
-- ----------------------------
DROP TABLE IF EXISTS `score_result`;
CREATE TABLE `score_result`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `teach_id` int NOT NULL COMMENT ' 授课表id',
  `score` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '閸掑棙鏆?',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of score_result
-- ----------------------------
INSERT INTO `score_result` VALUES (5, 1, '30.0');
INSERT INTO `score_result` VALUES (6, 2, '30.0');
INSERT INTO `score_result` VALUES (7, 8, '15.0');
INSERT INTO `score_result` VALUES (8, 5, '87.5');
INSERT INTO `score_result` VALUES (9, 9, '15.0');

-- ----------------------------
-- Table structure for student_class
-- ----------------------------
DROP TABLE IF EXISTS `student_class`;
CREATE TABLE `student_class`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '学院班级ID',
  `student_id` int NULL DEFAULT NULL COMMENT '学院ID',
  `class_id` int NULL DEFAULT NULL COMMENT '班级ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_class
-- ----------------------------
INSERT INTO `student_class` VALUES (1, 2, 1);
INSERT INTO `student_class` VALUES (2, 1, 3);

-- ----------------------------
-- Table structure for student_teach
-- ----------------------------
DROP TABLE IF EXISTS `student_teach`;
CREATE TABLE `student_teach`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `batch_id` int NULL DEFAULT NULL COMMENT '学期Id',
  `teach_id` int NULL DEFAULT NULL COMMENT '授课表id',
  `student_id` int NULL DEFAULT NULL COMMENT '学生id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_teach
-- ----------------------------
INSERT INTO `student_teach` VALUES (7, 1, 1, 5);
INSERT INTO `student_teach` VALUES (8, 1, 2, 5);
INSERT INTO `student_teach` VALUES (9, 1, 5, 5);

-- ----------------------------
-- Table structure for study_record
-- ----------------------------
DROP TABLE IF EXISTS `study_record`;
CREATE TABLE `study_record`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '学习时间表ID',
  `b_id` int NOT NULL COMMENT '批次ID',
  `sc_id` int NOT NULL COMMENT '学生课程表ID',
  `sr_id` int NOT NULL COMMENT '课件表ID',
  `time` int NOT NULL COMMENT '学习时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `b_id`(`b_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of study_record
-- ----------------------------
INSERT INTO `study_record` VALUES (1, 4, 2, 44, 11);

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `parent_id` bigint NULL DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `component` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` int NOT NULL COMMENT '类型     0：目录   1：菜单   2：按钮',
  `icon` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `orderNum` int NULL DEFAULT NULL COMMENT '排序',
  `created` datetime NOT NULL,
  `updated` datetime NULL DEFAULT NULL,
  `statu` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 99 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, '系统管理', '', 'sys:manage', '', 0, 'el-icon-s-operation', 1, '2021-01-15 18:58:18', '2021-01-15 18:58:20', 1);
INSERT INTO `sys_menu` VALUES (2, 1, '用户管理', '/sys/users', 'sys:user:list', 'sys/User', 1, 'el-icon-s-custom', 1, '2021-01-15 19:03:45', '2021-01-15 19:03:48', 1);
INSERT INTO `sys_menu` VALUES (3, 1, '角色管理', '/sys/roles', 'sys:role:list', 'sys/Role', 1, 'el-icon-rank', 2, '2021-01-15 19:03:45', '2021-01-15 19:03:48', 1);
INSERT INTO `sys_menu` VALUES (4, 1, '菜单管理', '/sys/menus', 'sys:menu:list', 'sys/Menu', 1, 'el-icon-menu', 3, '2021-01-15 19:03:45', '2021-01-15 19:03:48', 1);
INSERT INTO `sys_menu` VALUES (5, 0, '业务管理', '', 'work:manage', NULL, 0, 'el-icon-s-tools', 2, '2021-01-15 19:06:11', '2022-10-17 16:50:48', 1);
INSERT INTO `sys_menu` VALUES (6, 5, '学期管理', '/work/batch', 'work:batch:list', 'work/Batch', 1, 'el-icon-s-order', 1, '2021-01-15 19:07:18', '2022-10-24 10:12:21', 1);
INSERT INTO `sys_menu` VALUES (7, 3, '添加角色', '', 'sys:role:save', '', 2, '', 1, '2021-01-15 23:02:25', '2021-01-17 21:53:14', 0);
INSERT INTO `sys_menu` VALUES (9, 2, '添加用户', NULL, 'sys:user:save', NULL, 2, NULL, 1, '2021-01-17 21:48:32', NULL, 1);
INSERT INTO `sys_menu` VALUES (10, 2, '修改用户', NULL, 'sys:user:update', NULL, 2, NULL, 2, '2021-01-17 21:49:03', '2021-01-17 21:53:04', 1);
INSERT INTO `sys_menu` VALUES (11, 2, '删除用户', NULL, 'sys:user:delete', NULL, 2, NULL, 3, '2021-01-17 21:49:21', NULL, 1);
INSERT INTO `sys_menu` VALUES (12, 2, '分配角色', NULL, 'sys:user:role', NULL, 2, NULL, 4, '2021-01-17 21:49:58', NULL, 1);
INSERT INTO `sys_menu` VALUES (13, 2, '重置密码', NULL, 'sys:user:repass', NULL, 2, NULL, 5, '2021-01-17 21:50:36', NULL, 1);
INSERT INTO `sys_menu` VALUES (14, 3, '修改角色', NULL, 'sys:role:update', NULL, 2, NULL, 2, '2021-01-17 21:51:14', NULL, 1);
INSERT INTO `sys_menu` VALUES (15, 3, '删除角色', NULL, 'sys:role:delete', NULL, 2, NULL, 3, '2021-01-17 21:51:39', NULL, 1);
INSERT INTO `sys_menu` VALUES (16, 3, '分配权限', NULL, 'sys:role:perm', NULL, 2, NULL, 5, '2021-01-17 21:52:02', NULL, 1);
INSERT INTO `sys_menu` VALUES (17, 4, '添加菜单', NULL, 'sys:menu:save', NULL, 2, NULL, 1, '2021-01-17 21:53:53', '2021-01-17 21:55:28', 1);
INSERT INTO `sys_menu` VALUES (18, 4, '修改菜单', NULL, 'sys:menu:update', NULL, 2, NULL, 2, '2021-01-17 21:56:12', NULL, 1);
INSERT INTO `sys_menu` VALUES (19, 4, '删除菜单', NULL, 'sys:menu:delete', NULL, 2, NULL, 3, '2021-01-17 21:56:36', NULL, 1);
INSERT INTO `sys_menu` VALUES (20, 6, '添加学期', NULL, 'work:batch:save', NULL, 2, NULL, 1, '2022-10-17 16:53:36', '2022-10-24 10:12:37', 1);
INSERT INTO `sys_menu` VALUES (21, 6, '修改学期', NULL, 'work:batch:update', NULL, 2, NULL, 2, '2022-10-17 16:54:27', '2022-10-24 10:12:52', 1);
INSERT INTO `sys_menu` VALUES (22, 6, '删除学期', NULL, 'work:batch:delete', NULL, 2, NULL, 3, '2022-10-17 16:55:01', '2022-10-24 10:16:09', 1);
INSERT INTO `sys_menu` VALUES (23, 5, '课程管理', '/work/course', 'work:course:list', 'work/Course', 1, NULL, 4, '2022-10-17 16:56:41', '2022-10-24 11:20:50', 1);
INSERT INTO `sys_menu` VALUES (24, 23, '添加课程', NULL, 'work:course:save', NULL, 2, NULL, 1, '2022-10-17 16:57:29', NULL, 1);
INSERT INTO `sys_menu` VALUES (25, 23, '修改课程', NULL, 'work:course:update', NULL, 2, NULL, 2, '2022-10-17 16:58:12', NULL, 1);
INSERT INTO `sys_menu` VALUES (26, 23, '删除课程', NULL, 'work:course:delete', NULL, 2, NULL, 3, '2022-10-17 16:58:39', NULL, 1);
INSERT INTO `sys_menu` VALUES (27, 23, '分配批次', NULL, 'work:course:batch', NULL, 2, NULL, 4, '2022-10-17 16:59:06', NULL, 1);
INSERT INTO `sys_menu` VALUES (28, 5, '学院管理', '/work/college', 'work:college:list', 'work/College', 1, NULL, 2, '2022-10-17 17:01:36', '2022-10-24 10:36:32', 1);
INSERT INTO `sys_menu` VALUES (29, 28, '添加学院', NULL, 'work:college:save', NULL, 2, NULL, 1, '2022-10-17 17:02:08', '2022-10-25 12:59:43', 1);
INSERT INTO `sys_menu` VALUES (30, 28, '修改学院', NULL, 'work:college:update', NULL, 2, NULL, 2, '2022-10-17 17:02:40', '2022-10-25 12:59:48', 1);
INSERT INTO `sys_menu` VALUES (31, 28, '删除学院', NULL, 'work:college:delete', NULL, 2, NULL, 3, '2022-10-17 17:03:06', '2022-10-25 12:59:55', 1);
INSERT INTO `sys_menu` VALUES (33, 5, '评教管理', '/work/evaluation', 'work:evaluation:list', 'work/Evaluation', 1, NULL, 6, '2022-10-17 17:05:44', '2022-10-24 12:17:00', 1);
INSERT INTO `sys_menu` VALUES (34, 33, '添加评教信息', NULL, 'work:evaluation:save', NULL, 2, NULL, 1, '2022-10-17 17:06:16', '2022-10-24 12:17:35', 1);
INSERT INTO `sys_menu` VALUES (35, 33, '开启评教', NULL, 'work:evaluation:update', NULL, 2, NULL, 5, '2022-10-17 17:06:47', '2022-11-15 19:19:04', 1);
INSERT INTO `sys_menu` VALUES (36, 5, '授课管理', '/work/teach', 'work:teach:list', 'work/Teach', 1, NULL, 5, '2022-10-17 17:08:46', '2022-10-24 12:20:45', 1);
INSERT INTO `sys_menu` VALUES (37, 36, '添加授课', NULL, 'work:teach:save', NULL, 2, NULL, 1, '2022-10-17 17:09:37', '2022-11-07 09:07:31', 1);
INSERT INTO `sys_menu` VALUES (38, 36, '修改授课', NULL, 'work:teach:update', NULL, 2, NULL, 2, '2022-10-17 17:10:06', '2022-11-15 12:46:42', 1);
INSERT INTO `sys_menu` VALUES (39, 0, '学生操作', NULL, 'student:manage', NULL, 0, NULL, 6, '2022-10-17 17:15:42', '2022-11-02 11:33:39', 1);
INSERT INTO `sys_menu` VALUES (40, 39, '学生选课', '/student/train', 'student:train:list', 'student/Train', 1, NULL, 1, '2022-10-17 17:22:16', NULL, 1);
INSERT INTO `sys_menu` VALUES (43, 40, '选择课程', NULL, 'student:train:course', NULL, 2, NULL, 2, '2022-10-17 17:24:22', '2022-11-02 10:50:50', 1);
INSERT INTO `sys_menu` VALUES (45, 39, '学生评教', '/student/infomation', 'student:infomation:list', 'student/Infomation', 1, NULL, 2, '2022-10-17 17:28:12', '2022-11-02 10:18:00', 1);
INSERT INTO `sys_menu` VALUES (46, 45, '学生进行评教', NULL, 'student:infomation:evaluation', NULL, 2, NULL, 1, '2022-10-17 17:30:13', '2022-11-02 10:21:23', 1);
INSERT INTO `sys_menu` VALUES (47, 45, '退选课程', NULL, 'student:infomation:back', NULL, 2, NULL, 2, '2022-10-17 17:31:06', NULL, 1);
INSERT INTO `sys_menu` VALUES (48, 1, '指标管理', '/sys/quota', 'sys:quota:list', 'sys/Quota', 1, NULL, 4, '2022-10-19 12:53:41', '2022-10-24 11:12:50', 1);
INSERT INTO `sys_menu` VALUES (49, 5, '班级管理', '/work/class', 'work:class:list', 'work/Class', 1, NULL, 3, '2022-10-24 11:15:20', NULL, 1);
INSERT INTO `sys_menu` VALUES (50, 49, '添加班级', NULL, 'work:class:save', NULL, 2, NULL, 1, '2022-10-24 11:16:09', NULL, 1);
INSERT INTO `sys_menu` VALUES (51, 49, '修改班级', NULL, 'work:class:update', NULL, 2, NULL, 2, '2022-10-24 11:16:43', NULL, 1);
INSERT INTO `sys_menu` VALUES (52, 49, '删除班级', NULL, 'work:class:delete', NULL, 2, NULL, 3, '2022-10-24 11:17:12', NULL, 1);
INSERT INTO `sys_menu` VALUES (53, 33, '删除评教信息', NULL, 'work:evaluation:delete', NULL, 2, NULL, 3, '2022-10-24 12:18:46', NULL, 1);
INSERT INTO `sys_menu` VALUES (55, 2, '分配学院', NULL, 'sys:user:college', NULL, 2, NULL, 6, '2022-10-25 12:25:12', '2022-10-25 12:25:27', 1);
INSERT INTO `sys_menu` VALUES (62, 23, '分配教师', NULL, 'work:course:teacher', NULL, 2, NULL, 5, '2022-10-25 13:00:32', NULL, 1);
INSERT INTO `sys_menu` VALUES (65, 2, '分配班级', NULL, 'sys:user:class', NULL, 2, NULL, 7, '2022-11-01 09:03:48', NULL, 1);
INSERT INTO `sys_menu` VALUES (66, 40, '选择批次1', NULL, 'student:train:batch', NULL, 2, NULL, 1, '2022-11-02 10:51:58', '2022-11-02 11:13:37', 1);
INSERT INTO `sys_menu` VALUES (67, 45, '选择批次2', NULL, 'student:infomation:batch', NULL, 2, NULL, 3, '2022-11-02 10:52:50', '2022-11-02 11:13:49', 1);
INSERT INTO `sys_menu` VALUES (68, 0, '教师操作', NULL, 'teacher:manage', NULL, 0, NULL, 5, '2022-11-02 11:27:43', '2022-11-02 11:33:23', 1);
INSERT INTO `sys_menu` VALUES (69, 0, '系主任操作', NULL, 'department:manage', NULL, 0, NULL, 4, '2022-11-02 11:30:35', '2022-11-02 11:33:13', 1);
INSERT INTO `sys_menu` VALUES (70, 0, '教研人员操作', NULL, 'reseach:manage', NULL, 0, NULL, 3, '2022-11-02 11:31:45', '2022-11-02 11:33:01', 1);
INSERT INTO `sys_menu` VALUES (71, 68, '同行评教', '/teacher/infomation', 'teacher:infomation:list', 'teacher/Infomation', 1, NULL, 1, '2022-11-02 11:36:37', '2022-11-02 12:10:32', 1);
INSERT INTO `sys_menu` VALUES (72, 71, '选择批次', NULL, 'teacher:infomation:batch', NULL, 2, NULL, 1, '2022-11-02 11:38:44', '2022-11-02 12:16:12', 1);
INSERT INTO `sys_menu` VALUES (73, 71, '老师进行评教', NULL, 'teacher:infomation:evaluation', NULL, 2, NULL, 2, '2022-11-02 11:39:18', NULL, 1);
INSERT INTO `sys_menu` VALUES (74, 69, '系主任评教', '/department/infomation', 'department:infomation:list', 'department/Infomation', 1, NULL, 1, '2022-11-02 12:42:19', NULL, 1);
INSERT INTO `sys_menu` VALUES (75, 74, '选择批次4', NULL, 'department:infomation:batch', NULL, 2, NULL, 1, '2022-11-02 12:42:59', '2022-11-02 12:45:43', 1);
INSERT INTO `sys_menu` VALUES (76, 74, '系主任进行评教', NULL, 'department:infomation:evaluation', NULL, 2, '', 2, '2022-11-02 12:44:49', '2022-11-02 12:46:11', 1);
INSERT INTO `sys_menu` VALUES (77, 70, '教研人员评教', '/reseach/infomation', 'reseach:infomation:list', 'reseach/Infomation', 1, NULL, 1, '2022-11-02 12:54:54', NULL, 1);
INSERT INTO `sys_menu` VALUES (78, 77, '选择批次5', NULL, 'reseach:infomation:batch', NULL, 2, NULL, 1, '2022-11-02 12:55:36', NULL, 1);
INSERT INTO `sys_menu` VALUES (79, 77, '教研人员进行评教', NULL, 'reseach:infomation:evaluation', NULL, 2, NULL, 2, '2022-11-02 12:56:19', NULL, 1);
INSERT INTO `sys_menu` VALUES (80, 48, '上传文件', NULL, 'sys:quota:upload', NULL, 2, NULL, 1, '2022-11-02 13:42:14', NULL, 1);
INSERT INTO `sys_menu` VALUES (81, 33, '选择评教人群', NULL, 'work:evaluation:role', NULL, 2, NULL, 4, '2022-11-03 10:12:59', NULL, 1);
INSERT INTO `sys_menu` VALUES (82, 48, '修改指标', NULL, 'sys:quota:update', NULL, 2, NULL, 2, '2022-11-08 09:14:17', NULL, 1);
INSERT INTO `sys_menu` VALUES (83, 48, '删除指标', NULL, 'sys:quota:delete', NULL, 2, NULL, 3, '2022-11-08 09:14:59', NULL, 1);
INSERT INTO `sys_menu` VALUES (84, 33, '分配指标', NULL, 'sys:evaluation:perm', NULL, 2, NULL, 2, '2022-11-08 11:58:39', NULL, 1);
INSERT INTO `sys_menu` VALUES (86, 71, '显示指标选项', NULL, 'teacher:infomation:quotas', NULL, 2, NULL, 3, '2022-11-08 14:47:32', NULL, 1);
INSERT INTO `sys_menu` VALUES (87, 71, '提交问卷1', NULL, 'teacher:infomation:options', NULL, 2, NULL, 4, '2022-11-10 23:24:03', '2022-11-13 21:41:06', 1);
INSERT INTO `sys_menu` VALUES (88, 45, '提交问卷2', NULL, 'student:infomation:options', NULL, 2, NULL, 4, '2022-11-13 21:41:58', NULL, 1);
INSERT INTO `sys_menu` VALUES (90, 74, '提交问卷3', NULL, 'department:infomation:options', NULL, 2, NULL, 3, '2022-11-13 22:04:59', '2022-11-13 22:05:42', 1);
INSERT INTO `sys_menu` VALUES (91, 77, '提交问卷4', NULL, 'reseach:infomation:options', NULL, 2, NULL, 3, '2022-11-13 23:09:52', '2022-11-13 23:17:29', 1);
INSERT INTO `sys_menu` VALUES (92, 5, '评教记录', '/work/record', 'work:record:list', 'work/Record', 1, NULL, 7, '2022-11-14 15:41:33', NULL, 1);
INSERT INTO `sys_menu` VALUES (93, 68, '自我评教', '/teacher/myEvaluate', 'teacher:myEvaluate:list', 'teacher/MyEvaluate', 1, NULL, 2, '2022-11-14 19:02:11', '2022-11-14 19:22:45', 1);
INSERT INTO `sys_menu` VALUES (94, 93, '选择批次6', NULL, 'teacher:myEvaluate:batch', NULL, 2, NULL, 1, '2022-11-14 19:05:55', NULL, 1);
INSERT INTO `sys_menu` VALUES (95, 93, '老师进行自我评教', NULL, 'teacher:myEvaluate:evaluation', NULL, 2, NULL, 2, '2022-11-14 19:07:30', NULL, 1);
INSERT INTO `sys_menu` VALUES (96, 93, '提交问卷5', NULL, 'teacher:myEvaluate:options', NULL, 2, NULL, 3, '2022-11-14 19:08:29', NULL, 1);
INSERT INTO `sys_menu` VALUES (98, 5, '授课得分', '/work/scoreResult', 'work:score:list', 'work/ScoreResult', 1, NULL, 8, '2022-11-15 09:21:53', '2022-11-15 09:22:54', 1);
INSERT INTO `sys_menu` VALUES (99, 36, '删除授课', NULL, 'work:teach:delete', NULL, 2, NULL, 3, '2022-11-15 12:47:46', '2022-11-15 12:48:02', 1);
INSERT INTO `sys_menu` VALUES (100, 33, '结束评教', NULL, 'work:evaluation:end', NULL, 2, NULL, 6, '2022-11-15 19:19:50', '2022-11-15 19:28:11', 1);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `remark` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `created` datetime NULL DEFAULT NULL,
  `updated` datetime NULL DEFAULT NULL,
  `statu` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE,
  UNIQUE INDEX `code`(`code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (3, '教研室人员', 'normal', '只有基本查看功能', '2021-01-04 10:09:14', '2022-10-24 08:50:45', 1);
INSERT INTO `sys_role` VALUES (6, '超级管理员', 'admin', '系统默认最高权限，不可以编辑和任意修改', '2021-01-16 13:29:03', '2021-01-17 15:50:45', 1);
INSERT INTO `sys_role` VALUES (8, '系主任', 'dept', '只有一些基础功能', '2022-10-24 08:52:44', '2022-10-24 08:52:53', 1);
INSERT INTO `sys_role` VALUES (9, '教师', 'teacher', '只有一些基础功能', '2022-10-24 08:53:30', '2022-10-24 08:54:03', 1);
INSERT INTO `sys_role` VALUES (10, '学生', 'student', '只有一些基础功能', '2022-10-24 08:53:56', '2022-10-24 08:54:08', 1);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_id` bigint NOT NULL,
  `menu_id` bigint NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1478 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (1341, 10, 39);
INSERT INTO `sys_role_menu` VALUES (1342, 10, 40);
INSERT INTO `sys_role_menu` VALUES (1343, 10, 66);
INSERT INTO `sys_role_menu` VALUES (1344, 10, 43);
INSERT INTO `sys_role_menu` VALUES (1345, 10, 45);
INSERT INTO `sys_role_menu` VALUES (1346, 10, 46);
INSERT INTO `sys_role_menu` VALUES (1347, 10, 47);
INSERT INTO `sys_role_menu` VALUES (1348, 10, 67);
INSERT INTO `sys_role_menu` VALUES (1349, 10, 88);
INSERT INTO `sys_role_menu` VALUES (1350, 8, 69);
INSERT INTO `sys_role_menu` VALUES (1351, 8, 74);
INSERT INTO `sys_role_menu` VALUES (1352, 8, 75);
INSERT INTO `sys_role_menu` VALUES (1353, 8, 76);
INSERT INTO `sys_role_menu` VALUES (1354, 8, 90);
INSERT INTO `sys_role_menu` VALUES (1360, 3, 70);
INSERT INTO `sys_role_menu` VALUES (1361, 3, 77);
INSERT INTO `sys_role_menu` VALUES (1362, 3, 78);
INSERT INTO `sys_role_menu` VALUES (1363, 3, 79);
INSERT INTO `sys_role_menu` VALUES (1364, 3, 91);
INSERT INTO `sys_role_menu` VALUES (1416, 9, 68);
INSERT INTO `sys_role_menu` VALUES (1417, 9, 71);
INSERT INTO `sys_role_menu` VALUES (1418, 9, 72);
INSERT INTO `sys_role_menu` VALUES (1419, 9, 73);
INSERT INTO `sys_role_menu` VALUES (1420, 9, 86);
INSERT INTO `sys_role_menu` VALUES (1421, 9, 87);
INSERT INTO `sys_role_menu` VALUES (1422, 9, 93);
INSERT INTO `sys_role_menu` VALUES (1423, 9, 94);
INSERT INTO `sys_role_menu` VALUES (1424, 9, 95);
INSERT INTO `sys_role_menu` VALUES (1425, 9, 96);
INSERT INTO `sys_role_menu` VALUES (1692, 6, 1);
INSERT INTO `sys_role_menu` VALUES (1693, 6, 2);
INSERT INTO `sys_role_menu` VALUES (1694, 6, 9);
INSERT INTO `sys_role_menu` VALUES (1695, 6, 10);
INSERT INTO `sys_role_menu` VALUES (1696, 6, 11);
INSERT INTO `sys_role_menu` VALUES (1697, 6, 12);
INSERT INTO `sys_role_menu` VALUES (1698, 6, 13);
INSERT INTO `sys_role_menu` VALUES (1699, 6, 55);
INSERT INTO `sys_role_menu` VALUES (1700, 6, 65);
INSERT INTO `sys_role_menu` VALUES (1701, 6, 3);
INSERT INTO `sys_role_menu` VALUES (1702, 6, 7);
INSERT INTO `sys_role_menu` VALUES (1703, 6, 14);
INSERT INTO `sys_role_menu` VALUES (1704, 6, 15);
INSERT INTO `sys_role_menu` VALUES (1705, 6, 16);
INSERT INTO `sys_role_menu` VALUES (1706, 6, 4);
INSERT INTO `sys_role_menu` VALUES (1707, 6, 17);
INSERT INTO `sys_role_menu` VALUES (1708, 6, 18);
INSERT INTO `sys_role_menu` VALUES (1709, 6, 19);
INSERT INTO `sys_role_menu` VALUES (1710, 6, 48);
INSERT INTO `sys_role_menu` VALUES (1711, 6, 80);
INSERT INTO `sys_role_menu` VALUES (1712, 6, 82);
INSERT INTO `sys_role_menu` VALUES (1713, 6, 83);
INSERT INTO `sys_role_menu` VALUES (1714, 6, 5);
INSERT INTO `sys_role_menu` VALUES (1715, 6, 6);
INSERT INTO `sys_role_menu` VALUES (1716, 6, 20);
INSERT INTO `sys_role_menu` VALUES (1717, 6, 21);
INSERT INTO `sys_role_menu` VALUES (1718, 6, 22);
INSERT INTO `sys_role_menu` VALUES (1719, 6, 28);
INSERT INTO `sys_role_menu` VALUES (1720, 6, 29);
INSERT INTO `sys_role_menu` VALUES (1721, 6, 30);
INSERT INTO `sys_role_menu` VALUES (1722, 6, 31);
INSERT INTO `sys_role_menu` VALUES (1723, 6, 49);
INSERT INTO `sys_role_menu` VALUES (1724, 6, 50);
INSERT INTO `sys_role_menu` VALUES (1725, 6, 51);
INSERT INTO `sys_role_menu` VALUES (1726, 6, 52);
INSERT INTO `sys_role_menu` VALUES (1727, 6, 23);
INSERT INTO `sys_role_menu` VALUES (1728, 6, 24);
INSERT INTO `sys_role_menu` VALUES (1729, 6, 25);
INSERT INTO `sys_role_menu` VALUES (1730, 6, 26);
INSERT INTO `sys_role_menu` VALUES (1731, 6, 27);
INSERT INTO `sys_role_menu` VALUES (1732, 6, 62);
INSERT INTO `sys_role_menu` VALUES (1733, 6, 36);
INSERT INTO `sys_role_menu` VALUES (1734, 6, 37);
INSERT INTO `sys_role_menu` VALUES (1735, 6, 38);
INSERT INTO `sys_role_menu` VALUES (1736, 6, 99);
INSERT INTO `sys_role_menu` VALUES (1737, 6, 33);
INSERT INTO `sys_role_menu` VALUES (1738, 6, 34);
INSERT INTO `sys_role_menu` VALUES (1739, 6, 84);
INSERT INTO `sys_role_menu` VALUES (1740, 6, 53);
INSERT INTO `sys_role_menu` VALUES (1741, 6, 81);
INSERT INTO `sys_role_menu` VALUES (1742, 6, 35);
INSERT INTO `sys_role_menu` VALUES (1743, 6, 100);
INSERT INTO `sys_role_menu` VALUES (1744, 6, 92);
INSERT INTO `sys_role_menu` VALUES (1745, 6, 98);

-- ----------------------------
-- Table structure for sys_role_quota
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_quota`;
CREATE TABLE `sys_role_quota`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_id` int NULL DEFAULT NULL,
  `quota_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 245 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_quota
-- ----------------------------
INSERT INTO `sys_role_quota` VALUES (169, 3, 1172);
INSERT INTO `sys_role_quota` VALUES (170, 3, 1173);
INSERT INTO `sys_role_quota` VALUES (171, 3, 1174);
INSERT INTO `sys_role_quota` VALUES (172, 3, 1175);
INSERT INTO `sys_role_quota` VALUES (173, 3, 1176);
INSERT INTO `sys_role_quota` VALUES (174, 3, 1177);
INSERT INTO `sys_role_quota` VALUES (175, 3, 1178);
INSERT INTO `sys_role_quota` VALUES (176, 3, 1179);
INSERT INTO `sys_role_quota` VALUES (177, 3, 1180);
INSERT INTO `sys_role_quota` VALUES (178, 3, 1181);
INSERT INTO `sys_role_quota` VALUES (179, 3, 1182);
INSERT INTO `sys_role_quota` VALUES (180, 3, 1183);
INSERT INTO `sys_role_quota` VALUES (181, 3, 1184);
INSERT INTO `sys_role_quota` VALUES (182, 3, 1185);
INSERT INTO `sys_role_quota` VALUES (183, 3, 1186);
INSERT INTO `sys_role_quota` VALUES (184, 9, 1187);
INSERT INTO `sys_role_quota` VALUES (185, 9, 1188);
INSERT INTO `sys_role_quota` VALUES (186, 9, 1189);
INSERT INTO `sys_role_quota` VALUES (187, 9, 1190);
INSERT INTO `sys_role_quota` VALUES (188, 9, 1191);
INSERT INTO `sys_role_quota` VALUES (189, 9, 1192);
INSERT INTO `sys_role_quota` VALUES (190, 9, 1193);
INSERT INTO `sys_role_quota` VALUES (191, 9, 1194);
INSERT INTO `sys_role_quota` VALUES (192, 9, 1195);
INSERT INTO `sys_role_quota` VALUES (193, 9, 1196);
INSERT INTO `sys_role_quota` VALUES (194, 9, 1197);
INSERT INTO `sys_role_quota` VALUES (195, 9, 1198);
INSERT INTO `sys_role_quota` VALUES (196, 9, 1199);
INSERT INTO `sys_role_quota` VALUES (197, 8, 1146);
INSERT INTO `sys_role_quota` VALUES (198, 8, 1147);
INSERT INTO `sys_role_quota` VALUES (199, 8, 1148);
INSERT INTO `sys_role_quota` VALUES (200, 8, 1149);
INSERT INTO `sys_role_quota` VALUES (201, 8, 1150);
INSERT INTO `sys_role_quota` VALUES (202, 8, 1151);
INSERT INTO `sys_role_quota` VALUES (203, 8, 1152);
INSERT INTO `sys_role_quota` VALUES (204, 8, 1153);
INSERT INTO `sys_role_quota` VALUES (205, 8, 1154);
INSERT INTO `sys_role_quota` VALUES (206, 8, 1155);
INSERT INTO `sys_role_quota` VALUES (207, 8, 1156);
INSERT INTO `sys_role_quota` VALUES (208, 8, 1157);
INSERT INTO `sys_role_quota` VALUES (209, 8, 1158);
INSERT INTO `sys_role_quota` VALUES (210, 8, 1159);
INSERT INTO `sys_role_quota` VALUES (211, 8, 1160);
INSERT INTO `sys_role_quota` VALUES (212, 8, 1161);
INSERT INTO `sys_role_quota` VALUES (213, 8, 1162);
INSERT INTO `sys_role_quota` VALUES (214, 8, 1163);
INSERT INTO `sys_role_quota` VALUES (215, 8, 1164);
INSERT INTO `sys_role_quota` VALUES (216, 8, 1165);
INSERT INTO `sys_role_quota` VALUES (217, 8, 1166);
INSERT INTO `sys_role_quota` VALUES (218, 8, 1167);
INSERT INTO `sys_role_quota` VALUES (219, 8, 1168);
INSERT INTO `sys_role_quota` VALUES (220, 8, 1169);
INSERT INTO `sys_role_quota` VALUES (221, 8, 1170);
INSERT INTO `sys_role_quota` VALUES (222, 8, 1171);
INSERT INTO `sys_role_quota` VALUES (234, 10, 1135);
INSERT INTO `sys_role_quota` VALUES (235, 10, 1136);
INSERT INTO `sys_role_quota` VALUES (236, 10, 1137);
INSERT INTO `sys_role_quota` VALUES (237, 10, 1138);
INSERT INTO `sys_role_quota` VALUES (238, 10, 1139);
INSERT INTO `sys_role_quota` VALUES (239, 10, 1140);
INSERT INTO `sys_role_quota` VALUES (240, 10, 1141);
INSERT INTO `sys_role_quota` VALUES (241, 10, 1142);
INSERT INTO `sys_role_quota` VALUES (242, 10, 1143);
INSERT INTO `sys_role_quota` VALUES (243, 10, 1144);
INSERT INTO `sys_role_quota` VALUES (244, 10, 1145);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `city` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `created` datetime NULL DEFAULT NULL,
  `updated` datetime NULL DEFAULT NULL,
  `last_login` datetime NULL DEFAULT NULL,
  `statu` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_USERNAME`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '$2a$10$oPjB9M1TZkqV4zIRffYX2ON6VrKLf05zBw4BpRd2HzOcpmC/i/YEi', '', '123@qq.com', '广州', '2021-01-12 22:13:53', '2021-01-16 16:57:32', '2020-12-30 08:38:37', 1);
INSERT INTO `sys_user` VALUES (2, 'test', '$2a$10$oPjB9M1TZkqV4zIRffYX2ON6VrKLf05zBw4BpRd2HzOcpmC/i/YEi', '', 'test@qq.com', NULL, '2021-01-30 08:20:22', '2021-01-30 08:55:57', NULL, 1);
INSERT INTO `sys_user` VALUES (3, 'zhuren', '$2a$10$ecT2MLBWi2PrEY8mCObpBetfKEjOeSDWzbiv76vTMxcxcpHXpLEWG', '', '123@qq.com', NULL, '2022-10-17 17:57:44', '2022-10-25 09:40:18', NULL, 1);
INSERT INTO `sys_user` VALUES (4, '张三', '$2a$10$n62wgbBwbLoDXk8UiCKjqupKtHS1MUMFYVGJcP49t41kIk1MUjIZK', '', '123@qq.com', NULL, '2022-10-25 09:05:42', '2022-10-25 09:39:57', NULL, 1);
INSERT INTO `sys_user` VALUES (5, '小明', '$2a$10$EfnDVqlHqgEUgort5Hn4auf4Tz.rWaiUpiT1j2MQ9eWGHV9hEZpJG', '', '123@qq.com', NULL, '2022-10-25 09:06:35', '2022-10-25 09:40:38', NULL, 1);
INSERT INTO `sys_user` VALUES (6, '李四', '$2a$10$O83aXBZcww/53MY7qwYaZuFAJUgixJEt1ijzaLTNuOvyXdtQDOIsq', NULL, '123@qq.com', NULL, '2022-10-25 09:37:02', '2022-10-25 09:41:02', NULL, 1);
INSERT INTO `sys_user` VALUES (7, '王五', '$2a$10$YcdBKcNU.LV0xJnTTkYvJ.qcG1AqLkAzFvDQeH2VQ8d5JoJpzSD6G', NULL, '123@qq.com', NULL, '2022-10-25 09:37:54', '2022-10-25 09:41:11', NULL, 1);
INSERT INTO `sys_user` VALUES (8, '花花', '$2a$10$A1SgxiWjNhud11lgrRYSVOkIuEJGdw8kp.PIVrI1cKHwrvcOzA7Vu', NULL, '123@qq.com', NULL, '2022-10-25 09:38:03', '2022-10-25 09:42:18', NULL, 1);
INSERT INTO `sys_user` VALUES (9, '波波', '$2a$10$FLbALggy2A4vX2Plp5.Kj.H94.0/k8rlpS7vuN7WTm06lIUsmuvHa', NULL, '123@qq.com', NULL, '2022-10-25 09:38:18', '2022-10-25 09:42:26', NULL, 1);
INSERT INTO `sys_user` VALUES (10, '委委', '$2a$10$Gr5/qN6Z/dDEIL7KSeV03.jzt9PZ1Zc./igvD0UT2Qbp4098ZeOzy', NULL, '123@qq.com', NULL, '2022-10-25 09:38:40', '2022-10-25 09:42:50', NULL, 1);
INSERT INTO `sys_user` VALUES (11, '成成', '$2a$10$OrbeF1yRAeftkviuNOouJOlo8.3Pj63V8upRnLXEaO27Y19cd52GC', NULL, '123@qq.com', NULL, '2022-10-31 11:39:10', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (12, '佳佳', '$2a$10$4pu0YAiEYW8B99VcSP6ow.XuQT3Nh4QjZScGhPmJypaLk9hwoI2Za', NULL, '123@qq.com', NULL, '2022-11-03 11:16:02', NULL, NULL, 1);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (13, 2, 3);
INSERT INTO `sys_user_role` VALUES (17, 4, 9);
INSERT INTO `sys_user_role` VALUES (18, 5, 10);
INSERT INTO `sys_user_role` VALUES (19, 6, 9);
INSERT INTO `sys_user_role` VALUES (20, 7, 9);
INSERT INTO `sys_user_role` VALUES (22, 8, 10);
INSERT INTO `sys_user_role` VALUES (23, 9, 10);
INSERT INTO `sys_user_role` VALUES (24, 10, 10);
INSERT INTO `sys_user_role` VALUES (25, 1, 6);
INSERT INTO `sys_user_role` VALUES (26, 12, 9);
INSERT INTO `sys_user_role` VALUES (32, 3, 8);

-- ----------------------------
-- Table structure for teach
-- ----------------------------
DROP TABLE IF EXISTS `teach`;
CREATE TABLE `teach`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `batch_id` int NOT NULL COMMENT '学期id',
  `college_id` int NULL DEFAULT NULL COMMENT '学院Id',
  `teacher_id` int NULL DEFAULT NULL COMMENT '学院id',
  `class_id` int NULL DEFAULT NULL COMMENT '班级id',
  `course_id` int NULL DEFAULT NULL COMMENT '课程id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teach
-- ----------------------------
INSERT INTO `teach` VALUES (1, 1, 3, 7, 1, 1);
INSERT INTO `teach` VALUES (2, 1, 5, 12, 4, 3);
INSERT INTO `teach` VALUES (3, 2, 2, 12, 2, 2);
INSERT INTO `teach` VALUES (4, 4, 2, 12, 2, 2);
INSERT INTO `teach` VALUES (5, 1, 2, 6, 2, 1);
INSERT INTO `teach` VALUES (6, 1, 1, 4, 1, 1);
INSERT INTO `teach` VALUES (7, 1, 1, 3, 1, 1);
INSERT INTO `teach` VALUES (9, 1, 3, 7, 4, 1);

-- ----------------------------
-- Table structure for teacher_course
-- ----------------------------
DROP TABLE IF EXISTS `teacher_course`;
CREATE TABLE `teacher_course`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `teacher_id` int NOT NULL COMMENT '教师id',
  `course_id` int NOT NULL COMMENT '课程id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher_course
-- ----------------------------
INSERT INTO `teacher_course` VALUES (18, 4, 5);
INSERT INTO `teacher_course` VALUES (19, 6, 3);
INSERT INTO `teacher_course` VALUES (20, 6, 1);
INSERT INTO `teacher_course` VALUES (21, 7, 2);
INSERT INTO `teacher_course` VALUES (22, 7, 4);

-- ----------------------------
-- Table structure for user_course
-- ----------------------------
DROP TABLE IF EXISTS `user_course`;
CREATE TABLE `user_course`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int NOT NULL COMMENT '用户ID',
  `course_id` int NOT NULL COMMENT '课程ID',
  `batch_id` int NOT NULL COMMENT '课程ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_course
-- ----------------------------

-- ----------------------------
-- Table structure for user_evaluate
-- ----------------------------
DROP TABLE IF EXISTS `user_evaluate`;
CREATE TABLE `user_evaluate`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int NOT NULL COMMENT '本次评教得分',
  `first_score` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '得分',
  `teach_id` int NOT NULL COMMENT '授课id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_evaluate
-- ----------------------------
INSERT INTO `user_evaluate` VALUES (12, 6, '10.0', 5);
INSERT INTO `user_evaluate` VALUES (13, 2, '20.0', 5);
INSERT INTO `user_evaluate` VALUES (18, 3, '25.0', 5);
INSERT INTO `user_evaluate` VALUES (22, 5, '30.0', 5);
INSERT INTO `user_evaluate` VALUES (25, 7, '15.0', 5);
INSERT INTO `user_evaluate` VALUES (27, 6, '15.0', 9);

SET FOREIGN_KEY_CHECKS = 1;
