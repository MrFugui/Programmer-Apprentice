/*
 Navicat Premium Data Transfer

 Source Server         : 120.76.201.118_3306
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : 120.76.201.118:3306
 Source Schema         : apprentice

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 11/01/2022 17:34:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for apprent
-- ----------------------------
DROP TABLE IF EXISTS `apprent`;
CREATE TABLE `apprent`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名称',
  `parent_id` int(11) NULL DEFAULT NULL COMMENT '师父用户id',
  `parent_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '师父名称',
  `parent_level` int(10) NULL DEFAULT NULL COMMENT '师父等级',
  `apprent_time` datetime(0) NULL DEFAULT NULL COMMENT '拜师时间',
  `apprent_status` int(10) NULL DEFAULT NULL COMMENT '师徒关系状态0申请中1已拜师2已解除3已拒绝',
  `dismiss_time` datetime(0) NULL DEFAULT NULL COMMENT '解除关系时间',
  `finish_time` datetime(0) NULL DEFAULT NULL COMMENT '出师时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '师徒表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of apprent
-- ----------------------------
INSERT INTO `apprent` VALUES (1, 5, '123', 5, '1', NULL, NULL, 0, NULL, NULL);

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `blog_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '博客标题',
  `blog_text` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '博客内容',
  `file_id` int(11) NULL DEFAULT NULL COMMENT '图片id',
  `good_number` int(11) NULL DEFAULT NULL COMMENT '点赞数量',
  `talk_number` int(11) NULL DEFAULT NULL COMMENT '评论数量',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `delete_flag` tinyint(1) NULL DEFAULT NULL COMMENT '是否删除',
  `create_user` int(11) NULL DEFAULT NULL COMMENT '创建人',
  `look_number` int(11) NULL DEFAULT NULL COMMENT '浏览量',
  `star_number` int(11) NULL DEFAULT NULL COMMENT '收藏量',
  `creation` tinyint(1) NULL DEFAULT NULL COMMENT '0原创1转载',
  `blog_status` tinyint(2) NULL DEFAULT NULL COMMENT '0未审核1审核中2审核失败3已发布',
  `copyright_link` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '版权地址',
  `elsearch_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'elasticSearch中的ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '博客表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES (1, 'string撒打发斯蒂芬水电费是', 'string', 0, 1, 7, NULL, 0, 5, 0, 0, 0, 0, 'string', NULL);
INSERT INTO `blog` VALUES (2, 'string', 'string', 0, 2, 6, NULL, 0, 5, 0, 0, 0, 0, 'string', NULL);
INSERT INTO `blog` VALUES (3, 'string', 'string', 0, 3, 5, NULL, 0, 5, 0, 0, 0, 0, 'string', NULL);
INSERT INTO `blog` VALUES (4, 'string', 'string', 0, 4, 4, NULL, 0, 5, 0, 0, 0, 0, 'string', NULL);
INSERT INTO `blog` VALUES (5, 'string', 'string', 0, 5, 3, NULL, 0, 0, 0, 0, 0, 0, 'string', NULL);
INSERT INTO `blog` VALUES (6, 'string', 'string', 0, 6, 2, NULL, 0, 0, 0, 0, 0, 0, 'string', NULL);
INSERT INTO `blog` VALUES (7, 'string', 'string', 0, 7, 1, NULL, 0, NULL, 0, 0, 0, 0, 'string', NULL);
INSERT INTO `blog` VALUES (8, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `blog` VALUES (9, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `blog` VALUES (10, 'string', 'string', 0, 0, 0, '2021-11-26 08:52:28', 0, 0, 0, 0, 0, 0, 'string', NULL);
INSERT INTO `blog` VALUES (11, 'string', 'string', 0, 0, 0, '2021-11-27 01:13:02', 0, 0, 0, 0, 0, 0, 'string', 'WJ4MX30B9JvC1FeAomZQ');

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `blog_id` int(11) NULL DEFAULT NULL COMMENT '博客id',
  `create_user` int(11) NULL DEFAULT NULL COMMENT '收藏人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '收藏时间',
  `blog_auth_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '博客作者id(userId)',
  `blog_auth_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '博客作者名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '收藏表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `dynamic_id` int(11) NULL DEFAULT NULL COMMENT '动态id',
  `blog_id` int(11) NULL DEFAULT NULL COMMENT '博客id',
  `comment_text` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论内容',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_user` int(11) NULL DEFAULT NULL COMMENT '创建人',
  `good_number` int(11) NULL DEFAULT NULL COMMENT '点赞数量',
  `delete_flag` tinyint(1) NULL DEFAULT NULL COMMENT '是否删除',
  `talk_number` int(11) NULL DEFAULT NULL COMMENT '评论数量',
  `comment_id` int(11) NULL DEFAULT NULL COMMENT '评论表父id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '评论表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, NULL, 1, 'string', '2021-12-06 11:29:31', 5, 0, 0, 0, 0);
INSERT INTO `comment` VALUES (2, 0, 1, 'string', '2021-12-06 11:31:46', 5, 0, 0, 0, 0);
INSERT INTO `comment` VALUES (3, NULL, 1, 'string', '2021-12-06 11:38:24', 5, 0, 0, 0, 0);
INSERT INTO `comment` VALUES (4, 0, 1, 'string', '2021-12-06 11:38:30', 5, 0, 0, 0, 0);
INSERT INTO `comment` VALUES (5, 1, NULL, 'string', '2021-12-06 11:41:52', 5, 0, 0, 0, 0);
INSERT INTO `comment` VALUES (6, 0, 1, 'string', '2021-12-06 11:42:28', 5, 0, 0, 0, 0);
INSERT INTO `comment` VALUES (7, 0, 1, 'string', '2021-12-06 11:58:35', 5, 0, 0, 0, 0);
INSERT INTO `comment` VALUES (8, 0, 1, 'string', '2021-12-06 15:05:12', 5, 0, 0, 0, 0);
INSERT INTO `comment` VALUES (9, 1, NULL, 'string', '2021-12-06 15:08:11', 5, 0, 0, 0, 0);
INSERT INTO `comment` VALUES (10, 1, NULL, 'string', '2021-12-06 15:14:14', 5, 0, 0, 0, 0);
INSERT INTO `comment` VALUES (11, 1, NULL, 'string', '2021-12-06 15:14:46', 5, 0, 0, 0, 0);
INSERT INTO `comment` VALUES (12, 1, NULL, 'string', '2021-12-06 15:15:03', 5, 0, 0, 0, 1);
INSERT INTO `comment` VALUES (13, 0, 1, 'string', '2021-12-06 15:17:05', 5, 0, 0, 0, 0);
INSERT INTO `comment` VALUES (14, 1, 0, 'string', '2021-12-06 15:28:57', 5, 0, 0, 0, 0);

-- ----------------------------
-- Table structure for dynamic
-- ----------------------------
DROP TABLE IF EXISTS `dynamic`;
CREATE TABLE `dynamic`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '表id',
  `dynamic_text` varchar(5000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '动态内容',
  `file_id` int(11) NULL DEFAULT NULL COMMENT '图片id',
  `good_number` int(11) NULL DEFAULT NULL COMMENT '点赞数量',
  `talk_number` int(11) NULL DEFAULT NULL COMMENT '评论数量',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `delete_flag` tinyint(1) NULL DEFAULT NULL COMMENT '是否删除',
  `create_user` int(11) NULL DEFAULT NULL COMMENT '创建人',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '动态表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dynamic
-- ----------------------------
INSERT INTO `dynamic` VALUES (1, 'string少时诵诗书', 0, 0, 0, '2021-11-26 08:52:28', 0, 0, 'string');
INSERT INTO `dynamic` VALUES (2, 'string', 0, 0, 0, '2021-11-26 08:52:28', 0, 0, 'string');
INSERT INTO `dynamic` VALUES (3, 'string', 0, 0, 0, '2021-11-26 08:52:28', 0, 0, 'string');
INSERT INTO `dynamic` VALUES (4, 'sdf', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `dynamic` VALUES (5, '123123113', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `dynamic` VALUES (6, '123', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `dynamic` VALUES (7, '11', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for follow
-- ----------------------------
DROP TABLE IF EXISTS `follow`;
CREATE TABLE `follow`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_user` int(11) NULL DEFAULT NULL COMMENT '关注人',
  `create_user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关注人名称',
  `follow_user` int(11) NULL DEFAULT NULL COMMENT '被关注人',
  `follow_user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '被关注人名称',
  `follow_time` datetime(0) NULL DEFAULT NULL COMMENT '关注时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '关注表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for function
-- ----------------------------
DROP TABLE IF EXISTS `function`;
CREATE TABLE `function`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编号',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `parent_number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上级编号',
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '链接',
  `component` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组件',
  `state` bit(1) NULL DEFAULT NULL COMMENT '收缩',
  `sort` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '排序',
  `enabled` bit(1) NULL DEFAULT NULL COMMENT '启用',
  `type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `push_btn` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '功能按钮',
  `icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `delete_flag` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标记，0未删除，1删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `url`(`url`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 249 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '功能模块表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of function
-- ----------------------------
INSERT INTO `function` VALUES (1, '0001', '系统管理', '0', '/system', '/layouts/TabLayout', b'1', '0910', b'1', '电脑版', '', 'setting', '0');
INSERT INTO `function` VALUES (13, '000102', '角色管理', '0001', '/system/role', '/system/RoleList', b'0', '0130', b'1', '电脑版', '1', 'profile', '0');
INSERT INTO `function` VALUES (14, '000103', '用户管理', '0001', '/system/user', '/system/UserList', b'0', '0140', b'1', '电脑版', '1', 'profile', '0');
INSERT INTO `function` VALUES (15, '000104', '日志管理', '0001', '/system/log', '/system/LogList', b'0', '0160', b'1', '电脑版', '', 'profile', '0');
INSERT INTO `function` VALUES (16, '000105', '功能管理', '0001', '/system/function', '/system/FunctionList', b'0', '0166', b'1', '电脑版', '1', 'profile', '0');
INSERT INTO `function` VALUES (18, '000109', '租户管理', '0001', '/system/tenant', '/system/TenantList', b'0', '0167', b'1', '电脑版', '1', 'profile', '0');
INSERT INTO `function` VALUES (21, '0101', '商品管理', '0', '/material', '/layouts/TabLayout', b'0', '0620', b'1', '电脑版', NULL, 'shopping', '0');
INSERT INTO `function` VALUES (22, '010101', '商品类别', '0101', '/material/material_category', '/material/MaterialCategoryList', b'0', '0230', b'1', '电脑版', '1', 'profile', '0');
INSERT INTO `function` VALUES (23, '010102', '商品信息', '0101', '/material/material', '/material/MaterialList', b'0', '0240', b'1', '电脑版', '1', 'profile', '0');
INSERT INTO `function` VALUES (24, '0102', '基本资料', '0', '/systemA', '/layouts/TabLayout', b'0', '0750', b'1', '电脑版', NULL, 'appstore', '0');
INSERT INTO `function` VALUES (25, '01020101', '供应商信息', '0102', '/system/vendor', '/system/VendorList', b'0', '0260', b'1', '电脑版', '1', 'profile', '0');
INSERT INTO `function` VALUES (26, '010202', '仓库信息', '0102', '/system/depot', '/system/DepotList', b'0', '0270', b'1', '电脑版', '1', 'profile', '0');
INSERT INTO `function` VALUES (31, '010206', '经手人管理', '0102', '/system/person', '/system/PersonList', b'0', '0284', b'1', '电脑版', '1', 'profile', '0');
INSERT INTO `function` VALUES (32, '0502', '采购管理', '0', '/bill', '/layouts/TabLayout', b'0', '0330', b'1', '电脑版', '', 'retweet', '0');
INSERT INTO `function` VALUES (33, '050201', '采购入库', '0502', '/bill/purchase_in', '/bill/PurchaseInList', b'0', '0340', b'1', '电脑版', '1,2,7', 'profile', '0');
INSERT INTO `function` VALUES (38, '0603', '销售管理', '0', '/billB', '/layouts/TabLayout', b'0', '0390', b'1', '电脑版', '', 'shopping-cart', '0');
INSERT INTO `function` VALUES (40, '080107', '调拨出库', '0801', '/bill/allocation_out', '/bill/AllocationOutList', b'0', '0807', b'1', '电脑版', '1,2,7', 'profile', '0');
INSERT INTO `function` VALUES (41, '060303', '销售出库', '0603', '/bill/sale_out', '/bill/SaleOutList', b'0', '0394', b'1', '电脑版', '1,2,7', 'profile', '0');
INSERT INTO `function` VALUES (44, '0704', '财务管理', '0', '/financial', '/layouts/TabLayout', b'0', '0450', b'1', '电脑版', '', 'money-collect', '0');
INSERT INTO `function` VALUES (59, '030101', '进销存统计', '0301', '/report/in_out_stock_report', '/report/InOutStockReport', b'0', '0658', b'1', '电脑版', '', 'profile', '0');
INSERT INTO `function` VALUES (194, '010204', '收支项目', '0102', '/system/in_out_item', '/system/InOutItemList', b'0', '0282', b'1', '电脑版', '1', 'profile', '0');
INSERT INTO `function` VALUES (195, '010205', '结算账户', '0102', '/system/account', '/system/AccountList', b'0', '0283', b'1', '电脑版', '1', 'profile', '0');
INSERT INTO `function` VALUES (197, '070402', '收入单', '0704', '/financial/item_in', '/financial/ItemInList', b'0', '0465', b'1', '电脑版', '1,2,7', 'profile', '0');
INSERT INTO `function` VALUES (198, '0301', '报表查询', '0', '/report', '/layouts/TabLayout', b'0', '0570', b'1', '电脑版', NULL, 'pie-chart', '0');
INSERT INTO `function` VALUES (199, '050204', '采购退货', '0502', '/bill/purchase_back', '/bill/PurchaseBackList', b'0', '0345', b'1', '电脑版', '1,2,7', 'profile', '0');
INSERT INTO `function` VALUES (200, '060305', '销售退货', '0603', '/bill/sale_back', '/bill/SaleBackList', b'0', '0396', b'1', '电脑版', '1,2,7', 'profile', '0');
INSERT INTO `function` VALUES (201, '080103', '其它入库', '0801', '/bill/other_in', '/bill/OtherInList', b'0', '0803', b'1', '电脑版', '1,2,7', 'profile', '0');
INSERT INTO `function` VALUES (202, '080105', '其它出库', '0801', '/bill/other_out', '/bill/OtherOutList', b'0', '0805', b'1', '电脑版', '1,2,7', 'profile', '0');
INSERT INTO `function` VALUES (203, '070403', '支出单', '0704', '/financial/item_out', '/financial/ItemOutList', b'0', '0470', b'1', '电脑版', '1,2,7', 'profile', '0');
INSERT INTO `function` VALUES (204, '070404', '收款单', '0704', '/financial/money_in', '/financial/MoneyInList', b'0', '0475', b'1', '电脑版', '1,2,7', 'profile', '0');
INSERT INTO `function` VALUES (205, '070405', '付款单', '0704', '/financial/money_out', '/financial/MoneyOutList', b'0', '0480', b'1', '电脑版', '1,2,7', 'profile', '0');
INSERT INTO `function` VALUES (206, '070406', '转账单', '0704', '/financial/giro', '/financial/GiroList', b'0', '0490', b'1', '电脑版', '1,2,7', 'profile', '0');
INSERT INTO `function` VALUES (207, '030102', '账户统计', '0301', '/report/account_report', '/report/AccountReport', b'0', '0610', b'1', '电脑版', '', 'profile', '0');
INSERT INTO `function` VALUES (208, '030103', '进货统计', '0301', '/report/buy_in_report', '/report/BuyInReport', b'0', '0620', b'1', '电脑版', '', 'profile', '0');
INSERT INTO `function` VALUES (209, '030104', '销售统计', '0301', '/report/sale_out_report', '/report/SaleOutReport', b'0', '0630', b'1', '电脑版', '', 'profile', '0');
INSERT INTO `function` VALUES (210, '040102', '零售出库', '0401', '/bill/retail_out', '/bill/RetailOutList', b'0', '0405', b'1', '电脑版', '1,2,7', 'profile', '0');
INSERT INTO `function` VALUES (211, '040104', '零售退货', '0401', '/bill/retail_back', '/bill/RetailBackList', b'0', '0407', b'1', '电脑版', '1,2,7', 'profile', '0');
INSERT INTO `function` VALUES (212, '070407', '收预付款', '0704', '/financial/advance_in', '/financial/AdvanceInList', b'0', '0495', b'1', '电脑版', '1,2,7', 'profile', '0');
INSERT INTO `function` VALUES (217, '01020102', '客户信息', '0102', '/system/customer', '/system/CustomerList', b'0', '0262', b'1', '电脑版', '1', 'profile', '0');
INSERT INTO `function` VALUES (218, '01020103', '会员信息', '0102', '/system/member', '/system/MemberList', b'0', '0263', b'1', '电脑版', '1', 'profile', '0');
INSERT INTO `function` VALUES (220, '010103', '计量单位', '0101', '/system/unit', '/system/UnitList', b'0', '0245', b'1', '电脑版', '1', 'profile', '0');
INSERT INTO `function` VALUES (225, '0401', '零售管理', '0', '/billC', '/layouts/TabLayout', b'0', '0101', b'1', '电脑版', '', 'gift', '0');
INSERT INTO `function` VALUES (226, '030106', '入库明细', '0301', '/report/in_detail', '/report/InDetail', b'0', '0640', b'1', '电脑版', '', 'profile', '0');
INSERT INTO `function` VALUES (227, '030107', '出库明细', '0301', '/report/out_detail', '/report/OutDetail', b'0', '0645', b'1', '电脑版', '', 'profile', '0');
INSERT INTO `function` VALUES (228, '030108', '入库汇总', '0301', '/report/in_material_count', '/report/InMaterialCount', b'0', '0650', b'1', '电脑版', '', 'profile', '0');
INSERT INTO `function` VALUES (229, '030109', '出库汇总', '0301', '/report/out_material_count', '/report/OutMaterialCount', b'0', '0655', b'1', '电脑版', '', 'profile', '0');
INSERT INTO `function` VALUES (232, '080109', '组装单', '0801', '/bill/assemble', '/bill/AssembleList', b'0', '0809', b'1', '电脑版', '1,2,7', 'profile', '0');
INSERT INTO `function` VALUES (233, '080111', '拆卸单', '0801', '/bill/disassemble', '/bill/DisassembleList', b'0', '0811', b'1', '电脑版', '1,2,7', 'profile', '0');
INSERT INTO `function` VALUES (234, '000105', '系统配置', '0001', '/system/system_config', '/system/SystemConfigList', b'0', '0165', b'1', '电脑版', '1', 'profile', '0');
INSERT INTO `function` VALUES (235, '030110', '客户对账', '0301', '/report/customer_account', '/report/CustomerAccount', b'0', '0660', b'1', '电脑版', '', 'profile', '0');
INSERT INTO `function` VALUES (236, '000106', '商品属性', '0001', '/material/material_property', '/material/MaterialPropertyList', b'0', '0168', b'1', '电脑版', '1', 'profile', '0');
INSERT INTO `function` VALUES (237, '030111', '供应商对账', '0301', '/report/vendor_account', '/report/VendorAccount', b'0', '0665', b'1', '电脑版', '', 'profile', '0');
INSERT INTO `function` VALUES (239, '0801', '仓库管理', '0', '/billD', '/layouts/TabLayout', b'0', '0420', b'1', '电脑版', '', 'hdd', '0');
INSERT INTO `function` VALUES (241, '050202', '采购订单', '0502', '/bill/purchase_order', '/bill/PurchaseOrderList', b'0', '0335', b'1', '电脑版', '1,2,7', 'profile', '0');
INSERT INTO `function` VALUES (242, '060301', '销售订单', '0603', '/bill/sale_order', '/bill/SaleOrderList', b'0', '0392', b'1', '电脑版', '1,2,7', 'profile', '0');
INSERT INTO `function` VALUES (243, '000108', '机构管理', '0001', '/system/organization', '/system/OrganizationList', b'1', '0150', b'1', '电脑版', '1', 'profile', '0');
INSERT INTO `function` VALUES (244, '030112', '库存预警', '0301', '/report/stock_warning_report', '/report/StockWarningReport', b'0', '0670', b'1', '电脑版', '', 'profile', '0');
INSERT INTO `function` VALUES (245, '000107', '插件管理', '0001', '/system/plugin', '/system/PluginList', b'0', '0170', b'1', '电脑版', '1', 'profile', '0');
INSERT INTO `function` VALUES (246, '030113', '商品库存', '0301', '/report/material_stock', '/report/MaterialStock', b'0', '0605', b'1', '电脑版', '', 'profile', '0');
INSERT INTO `function` VALUES (247, '010105', '多属性', '0101', '/material/material_attribute', '/material/MaterialAttributeList', b'0', '0250', b'1', '电脑版', '1', 'profile', '0');
INSERT INTO `function` VALUES (248, '030150', '调拨明细', '0301', '/report/allocation_detail', '/report/AllocationDetail', b'0', '0646', b'1', '电脑版', '', 'profile', '0');

-- ----------------------------
-- Table structure for good
-- ----------------------------
DROP TABLE IF EXISTS `good`;
CREATE TABLE `good`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '点赞表id',
  `blog_id` int(11) NULL DEFAULT NULL COMMENT '博客id',
  `dynamic_id` int(11) NULL DEFAULT NULL COMMENT '动态表id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_user` int(11) NULL DEFAULT NULL COMMENT '创建用户',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '点赞表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of good
-- ----------------------------
INSERT INTO `good` VALUES (1, 0, NULL, '2021-12-06 09:45:31', 5);
INSERT INTO `good` VALUES (2, 1, 0, '2021-12-06 15:29:34', 5);
INSERT INTO `good` VALUES (3, 1, 0, '2021-12-06 15:43:48', 5);
INSERT INTO `good` VALUES (4, 1, 0, '2021-12-06 15:43:53', 5);

-- ----------------------------
-- Table structure for notify
-- ----------------------------
DROP TABLE IF EXISTS `notify`;
CREATE TABLE `notify`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通知类型',
  `notify_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通知标题',
  `notify_value` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通知内容',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `touser_id` int(11) NULL DEFAULT NULL COMMENT '发送至用户id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '通知时间',
  `read_time` datetime(0) NULL DEFAULT NULL COMMENT '查看时间',
  `notify_status` int(11) NULL DEFAULT 0 COMMENT '通知状态1已读0未读',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '通知表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notify
-- ----------------------------
INSERT INTO `notify` VALUES (1, 'comment', '评论通知', '123评论了您的string', 5, 0, '2021-12-06 11:29:56', NULL, 0);
INSERT INTO `notify` VALUES (2, 'comment', '评论通知', '123评论了您的string', 5, 0, '2021-12-06 11:31:46', NULL, 0);
INSERT INTO `notify` VALUES (3, 'comment', '评论通知', '123评论了您的string', 5, 0, '2021-12-06 11:38:24', NULL, 0);
INSERT INTO `notify` VALUES (4, 'comment', '评论通知', '123评论了您的string', 5, 0, '2021-12-06 11:38:30', NULL, 0);
INSERT INTO `notify` VALUES (5, 'comment', '评论通知', '123评论了您的string', 5, 0, '2021-12-06 11:41:52', NULL, 0);
INSERT INTO `notify` VALUES (6, 'comment', '评论通知', '123评论了您的string', 5, 0, '2021-12-06 11:42:28', NULL, 0);
INSERT INTO `notify` VALUES (7, 'comment', '评论通知', '123评论了您的string', 5, 0, '2021-12-06 11:58:35', NULL, 0);
INSERT INTO `notify` VALUES (8, 'good', '点赞通知', '123点赞了您的string', 5, 0, '2021-12-06 14:46:39', NULL, 0);
INSERT INTO `notify` VALUES (9, 'good', '点赞通知', '123点赞了您的string', 5, 0, '2021-12-06 14:47:04', NULL, 0);
INSERT INTO `notify` VALUES (10, 'good', '点赞通知', '123点赞了您的string', 5, 0, '2021-12-06 14:47:26', NULL, 0);
INSERT INTO `notify` VALUES (11, 'good', '点赞通知', '123点赞了您的string', 5, 0, '2021-12-06 14:48:07', NULL, 0);
INSERT INTO `notify` VALUES (12, 'good', '点赞通知', '123点赞了您的string撒打发斯...', 5, 0, '2021-12-06 14:48:41', NULL, 0);
INSERT INTO `notify` VALUES (13, 'good', '点赞通知', '123点赞了您的string撒打发斯...', 5, 0, '2021-12-06 15:02:40', NULL, 0);
INSERT INTO `notify` VALUES (14, 'comment', '评论通知', '123评论了您的string撒打发斯...', 5, 0, '2021-12-06 15:05:12', NULL, 0);
INSERT INTO `notify` VALUES (15, 'comment', '评论通知', '123评论了您的string', 5, 0, '2021-12-06 15:08:11', NULL, 0);
INSERT INTO `notify` VALUES (16, 'comment', '评论通知', '123评论了您的string', 5, 0, '2021-12-06 15:14:14', NULL, 0);
INSERT INTO `notify` VALUES (17, 'comment', '评论通知', '123评论了您的string少时诵诗...', 5, 0, '2021-12-06 15:14:46', NULL, 0);
INSERT INTO `notify` VALUES (18, 'comment', '评论通知', '123评论了您的string少时诵诗...', 5, 0, '2021-12-06 15:15:03', NULL, 0);
INSERT INTO `notify` VALUES (19, 'comment', '评论通知', '123评论了您的string撒打发斯...', 5, 0, '2021-12-06 15:17:05', NULL, 0);
INSERT INTO `notify` VALUES (20, 'comment', '评论通知', '123评论了您的string少时诵诗...', 5, 0, '2021-12-06 15:28:57', NULL, 0);
INSERT INTO `notify` VALUES (21, 'good', '点赞通知', '123点赞了您的string撒打发斯...', 5, 0, '2021-12-06 15:29:34', NULL, 0);
INSERT INTO `notify` VALUES (22, 'good', '点赞通知', '123点赞了您的string撒打发斯...', 5, 0, '2021-12-06 15:43:47', NULL, 0);
INSERT INTO `notify` VALUES (23, 'good', '点赞通知', '123点赞了您的string撒打发斯...', 5, 0, '2021-12-06 15:43:53', NULL, 0);
INSERT INTO `notify` VALUES (24, 'master', '拜师通知', '您收到了一条拜师请求', 0, 1111, '2021-12-09 16:54:18', NULL, 0);
INSERT INTO `notify` VALUES (25, 'master', '拜师通知', '您收到了一条拜师请求', 0, 1111, '2021-12-09 16:54:35', NULL, 0);
INSERT INTO `notify` VALUES (26, 'apprentice', '收徒通知', '您收到了一条收徒请求', 0, 5, '2022-01-11 17:30:31', NULL, 0);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `sort` int(11) NULL DEFAULT NULL,
  `role_desc` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '平台角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'admin', NULL, NULL);
INSERT INTO `role` VALUES (2, 'test', NULL, NULL);

-- ----------------------------
-- Table structure for system_config
-- ----------------------------
DROP TABLE IF EXISTS `system_config`;
CREATE TABLE `system_config`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'key',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'value',
  `group` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '组别',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT '状态0开启1关闭',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of system_config
-- ----------------------------
INSERT INTO `system_config` VALUES (14, 'mapperDir', 'E:\\msyWorkspace\\Programmer-Apprentice\\apprentice\\src\\main\\resources\\mapper', NULL, 1, NULL, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '用户角色',
  `photo` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户头像地址',
  `status` int(11) NULL DEFAULT 1 COMMENT '用户状态 1 启用 2 停止',
  `register_date` datetime(0) NULL DEFAULT NULL COMMENT '用户注册时间',
  `contact_no` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `del_flag` int(11) NULL DEFAULT 0 COMMENT '0 存在，1 删除',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '166358@', 'fugui', '123', 2, NULL, 1, NULL, NULL, 0, NULL, '2021-12-28 16:37:52');
INSERT INTO `user` VALUES (2, '166358@', 'admin', '123', 1, NULL, 1, NULL, NULL, 0, NULL, '2021-12-28 16:37:52');
INSERT INTO `user` VALUES (4, '166358@', 'wangfugui', '$2a$10$gpq7aq5CM0JijheXM7M53.SaM/5t6JZFa9oTH3HfMIJ3fgT4BWTYO', 1, NULL, 1, NULL, NULL, 0, NULL, '2021-12-28 16:37:52');
INSERT INTO `user` VALUES (5, '166358@', '123', '$2a$10$guUqq8QDoSqT6tuYjLAJBetAPWFJSL4QBVmnrUAT.T42AmEpiG3.q', 2, 'http://120.76.201.118:9000/apprentice/profile.png', 1, NULL, NULL, 0, NULL, '2022-01-11 14:29:58');
INSERT INTO `user` VALUES (7, '166358@', 'masiyi', '$2a$10$jo4bwvJS5pRYbn7Zqv7YD.sAbOBn.SY2i8ZiIZXptnyHMT60Vorfy', NULL, NULL, 1, NULL, NULL, 0, NULL, '2021-12-28 16:37:52');
INSERT INTO `user` VALUES (8, 'string', 'string', '$2a$10$IT.A7pXA1Mxy63zf07qscu8lf.g4jLJOSWnTBvNDiM0.OGnEZoHmu', 0, 'string', 0, NULL, 'string', 0, NULL, '2021-11-22 16:38:58');

-- ----------------------------
-- Table structure for user_business
-- ----------------------------
DROP TABLE IF EXISTS `user_business`;
CREATE TABLE `user_business`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类别',
  `key_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主id',
  `value` varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '值',
  `btn_str` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '按钮权限',
  `delete_flag` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标记，0未删除，1删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 70 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户/角色/模块关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_business
-- ----------------------------
INSERT INTO `user_business` VALUES (5, 'RoleFunctions', '4', '[210][225][211][241][32][33][199][242][38][41][200][201][239][202][40][232][233][197][44][203][204][205][206][212][246][207][208][209][226][227][228][229][59][235][237][244][22][21][23][220][240][247][25][24][217][218][26][194][195][31][13][1][14][243][15][234][16][18][236][245][248][198]', '[{\"funId\":13,\"btnStr\":\"1\"},{\"funId\":14,\"btnStr\":\"1\"},{\"funId\":243,\"btnStr\":\"1\"},{\"funId\":234,\"btnStr\":\"1\"},{\"funId\":16,\"btnStr\":\"1\"},{\"funId\":18,\"btnStr\":\"1\"},{\"funId\":236,\"btnStr\":\"1\"},{\"funId\":245,\"btnStr\":\"1\"},{\"funId\":22,\"btnStr\":\"1\"},{\"funId\":23,\"btnStr\":\"1\"},{\"funId\":220,\"btnStr\":\"1\"},{\"funId\":240,\"btnStr\":\"1\"},{\"funId\":247,\"btnStr\":\"1\"},{\"funId\":25,\"btnStr\":\"1\"},{\"funId\":217,\"btnStr\":\"1\"},{\"funId\":218,\"btnStr\":\"1\"},{\"funId\":26,\"btnStr\":\"1\"},{\"funId\":194,\"btnStr\":\"1\"},{\"funId\":195,\"btnStr\":\"1\"},{\"funId\":31,\"btnStr\":\"1\"},{\"funId\":241,\"btnStr\":\"1,2,7\"},{\"funId\":33,\"btnStr\":\"1,2,7\"},{\"funId\":199,\"btnStr\":\"1,2,7\"},{\"funId\":242,\"btnStr\":\"1,2,7\"},{\"funId\":41,\"btnStr\":\"1,2,7\"},{\"funId\":200,\"btnStr\":\"1,2,7\"},{\"funId\":210,\"btnStr\":\"1,2,7\"},{\"funId\":211,\"btnStr\":\"1,2,7\"},{\"funId\":197,\"btnStr\":\"1,7,2\"},{\"funId\":203,\"btnStr\":\"1,7,2\"},{\"funId\":204,\"btnStr\":\"1,7,2\"},{\"funId\":205,\"btnStr\":\"1,7,2\"},{\"funId\":206,\"btnStr\":\"1,2,7\"},{\"funId\":212,\"btnStr\":\"1,7,2\"},{\"funId\":201,\"btnStr\":\"1,2,7\"},{\"funId\":202,\"btnStr\":\"1,2,7\"},{\"funId\":40,\"btnStr\":\"1,2,7\"},{\"funId\":232,\"btnStr\":\"1,2,7\"},{\"funId\":233,\"btnStr\":\"1,2,7\"}]', '0');
INSERT INTO `user_business` VALUES (6, 'RoleFunctions', '5', '[22][23][25][26][194][195][31][33][200][201][41][199][202]', NULL, '0');
INSERT INTO `user_business` VALUES (7, 'RoleFunctions', '6', '[22][23][220][240][25][217][218][26][194][195][31][59][207][208][209][226][227][228][229][235][237][210][211][241][33][199][242][41][200][201][202][40][232][233][197][203][204][205][206][212]', '[{\"funId\":\"33\",\"btnStr\":\"4\"}]', '0');
INSERT INTO `user_business` VALUES (9, 'RoleFunctions', '7', '[168][13][12][16][14][15][189][18][19][132]', NULL, '0');
INSERT INTO `user_business` VALUES (10, 'RoleFunctions', '8', '[168][13][12][16][14][15][189][18][19][132][22][23][25][26][27][157][158][155][156][125][31][127][126][128][33][34][35][36][37][39][40][41][42][43][46][47][48][49][50][51][52][53][54][55][56][57][192][59][60][61][62][63][65][66][68][69][70][71][73][74][76][77][79][191][81][82][83][85][89][161][86][176][165][160][28][134][91][92][29][94][95][97][104][99][100][101][102][105][107][108][110][111][113][114][116][117][118][120][121][131][135][123][122][20][130][146][147][138][148][149][153][140][145][184][152][143][170][171][169][166][167][163][164][172][173][179][178][181][182][183][186][187][247]', NULL, '0');
INSERT INTO `user_business` VALUES (11, 'RoleFunctions', '9', '[168][13][12][16][14][15][189][18][19][132][22][23][25][26][27][157][158][155][156][125][31][127][126][128][33][34][35][36][37][39][40][41][42][43][46][47][48][49][50][51][52][53][54][55][56][57][192][59][60][61][62][63][65][66][68][69][70][71][73][74][76][77][79][191][81][82][83][85][89][161][86][176][165][160][28][134][91][92][29][94][95][97][104][99][100][101][102][105][107][108][110][111][113][114][116][117][118][120][121][131][135][123][122][20][130][146][147][138][148][149][153][140][145][184][152][143][170][171][169][166][167][163][164][172][173][179][178][181][182][183][186][187][188]', NULL, '0');
INSERT INTO `user_business` VALUES (12, 'UserRole', '1', '[5]', NULL, '0');
INSERT INTO `user_business` VALUES (13, 'UserRole', '2', '[6][7]', NULL, '0');
INSERT INTO `user_business` VALUES (14, 'UserDepot', '2', '[1][2][6][7]', NULL, '0');
INSERT INTO `user_business` VALUES (15, 'UserDepot', '1', '[1][2][5][6][7][10][12][14][15][17]', NULL, '0');
INSERT INTO `user_business` VALUES (16, 'UserRole', '63', '[10]', NULL, '0');
INSERT INTO `user_business` VALUES (18, 'UserDepot', '63', '[14][15]', NULL, '0');
INSERT INTO `user_business` VALUES (19, 'UserDepot', '5', '[6][45][46][50]', NULL, '0');
INSERT INTO `user_business` VALUES (20, 'UserRole', '5', '[5]', NULL, '0');
INSERT INTO `user_business` VALUES (21, 'UserRole', '64', '[13]', NULL, '0');
INSERT INTO `user_business` VALUES (22, 'UserDepot', '64', '[1]', NULL, '0');
INSERT INTO `user_business` VALUES (23, 'UserRole', '65', '[5]', NULL, '0');
INSERT INTO `user_business` VALUES (24, 'UserDepot', '65', '[1]', NULL, '0');
INSERT INTO `user_business` VALUES (25, 'UserCustomer', '64', '[5][2]', NULL, '0');
INSERT INTO `user_business` VALUES (26, 'UserCustomer', '65', '[6]', NULL, '0');
INSERT INTO `user_business` VALUES (27, 'UserCustomer', '63', '[58]', NULL, '0');
INSERT INTO `user_business` VALUES (28, 'UserDepot', '96', '[7]', NULL, '0');
INSERT INTO `user_business` VALUES (29, 'UserRole', '96', '[6]', NULL, '0');
INSERT INTO `user_business` VALUES (30, 'UserRole', '113', '[10]', NULL, '0');
INSERT INTO `user_business` VALUES (32, 'RoleFunctions', '10', '[210][225][211][241][32][33][199][242][38][41][200][201][239][202][40][232][233][197][44][203][204][205][206][212][246][207][208][209][226][227][228][229][59][235][237][244][22][21][23][220][240][247][25][24][217][218][26][194][195][31][13][14][243][15][234][248][198]', '[{\"funId\":13,\"btnStr\":\"1\"},{\"funId\":14,\"btnStr\":\"1\"},{\"funId\":243,\"btnStr\":\"1\"},{\"funId\":234,\"btnStr\":\"1\"},{\"funId\":22,\"btnStr\":\"1\"},{\"funId\":23,\"btnStr\":\"1\"},{\"funId\":220,\"btnStr\":\"1\"},{\"funId\":240,\"btnStr\":\"1\"},{\"funId\":247,\"btnStr\":\"1\"},{\"funId\":25,\"btnStr\":\"1\"},{\"funId\":217,\"btnStr\":\"1\"},{\"funId\":218,\"btnStr\":\"1\"},{\"funId\":26,\"btnStr\":\"1\"},{\"funId\":194,\"btnStr\":\"1\"},{\"funId\":195,\"btnStr\":\"1\"},{\"funId\":31,\"btnStr\":\"1\"},{\"funId\":241,\"btnStr\":\"1,2,7\"},{\"funId\":33,\"btnStr\":\"1,2,7\"},{\"funId\":199,\"btnStr\":\"1,7,2\"},{\"funId\":242,\"btnStr\":\"1,2,7\"},{\"funId\":41,\"btnStr\":\"1,2,7\"},{\"funId\":200,\"btnStr\":\"1,2,7\"},{\"funId\":210,\"btnStr\":\"1,2,7\"},{\"funId\":211,\"btnStr\":\"1,2,7\"},{\"funId\":197,\"btnStr\":\"1,2,7\"},{\"funId\":203,\"btnStr\":\"1,7,2\"},{\"funId\":204,\"btnStr\":\"1,7,2\"},{\"funId\":205,\"btnStr\":\"1,2,7\"},{\"funId\":206,\"btnStr\":\"1,7,2\"},{\"funId\":212,\"btnStr\":\"1,2,7\"},{\"funId\":201,\"btnStr\":\"1,2,7\"},{\"funId\":202,\"btnStr\":\"1,2,7\"},{\"funId\":40,\"btnStr\":\"1,2,7\"},{\"funId\":232,\"btnStr\":\"1,2,7\"},{\"funId\":233,\"btnStr\":\"1,2,7\"}]', '0');
INSERT INTO `user_business` VALUES (34, 'UserRole', '115', '[10]', NULL, '0');
INSERT INTO `user_business` VALUES (35, 'UserRole', '117', '[10]', NULL, '0');
INSERT INTO `user_business` VALUES (36, 'UserDepot', '117', '[8][9]', NULL, '0');
INSERT INTO `user_business` VALUES (37, 'UserCustomer', '117', '[52]', NULL, '0');
INSERT INTO `user_business` VALUES (38, 'UserRole', '120', '[4]', NULL, '0');
INSERT INTO `user_business` VALUES (41, 'RoleFunctions', '12', '', NULL, '0');
INSERT INTO `user_business` VALUES (48, 'RoleFunctions', '13', '[59][207][208][209][226][227][228][229][235][237][210][211][241][33][199][242][41][200]', NULL, '0');
INSERT INTO `user_business` VALUES (51, 'UserRole', '74', '[10]', NULL, '0');
INSERT INTO `user_business` VALUES (52, 'UserDepot', '121', '[13]', NULL, '0');
INSERT INTO `user_business` VALUES (54, 'UserDepot', '115', '[13]', NULL, '0');
INSERT INTO `user_business` VALUES (56, 'UserCustomer', '115', '[56]', NULL, '0');
INSERT INTO `user_business` VALUES (57, 'UserCustomer', '121', '[56]', NULL, '0');
INSERT INTO `user_business` VALUES (67, 'UserRole', '131', '[17]', NULL, '0');
INSERT INTO `user_business` VALUES (68, 'RoleFunctions', '16', '[210]', NULL, '0');
INSERT INTO `user_business` VALUES (69, 'RoleFunctions', '17', '[210][211][241][33][199][242][41][200][201][202][40][232][233][197][203][204][205][206][212]', '[{\"funId\":\"241\",\"btnStr\":\"1,2\"},{\"funId\":\"33\",\"btnStr\":\"1,2\"},{\"funId\":\"199\",\"btnStr\":\"1,2\"},{\"funId\":\"242\",\"btnStr\":\"1,2\"},{\"funId\":\"41\",\"btnStr\":\"1,2\"},{\"funId\":\"200\",\"btnStr\":\"1,2\"},{\"funId\":\"210\",\"btnStr\":\"1,2\"},{\"funId\":\"211\",\"btnStr\":\"1,2\"},{\"funId\":\"197\",\"btnStr\":\"1\"},{\"funId\":\"203\",\"btnStr\":\"1\"},{\"funId\":\"204\",\"btnStr\":\"1\"},{\"funId\":\"205\",\"btnStr\":\"1\"},{\"funId\":\"206\",\"btnStr\":\"1\"},{\"funId\":\"212\",\"btnStr\":\"1\"},{\"funId\":\"201\",\"btnStr\":\"1,2\"},{\"funId\":\"202\",\"btnStr\":\"1,2\"},{\"funId\":\"40\",\"btnStr\":\"1,2\"},{\"funId\":\"232\",\"btnStr\":\"1,2\"},{\"funId\":\"233\",\"btnStr\":\"1,2\"}]', '0');

-- ----------------------------
-- Table structure for user_extend
-- ----------------------------
DROP TABLE IF EXISTS `user_extend`;
CREATE TABLE `user_extend`  (
  `id` int(11) NOT NULL,
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `email_id` int(11) NULL DEFAULT NULL COMMENT '邮箱',
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号名称',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `gender` tinyint(2) NULL DEFAULT NULL COMMENT '性别1男0女2不透露',
  `flag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息拓展表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_setting
-- ----------------------------
DROP TABLE IF EXISTS `user_setting`;
CREATE TABLE `user_setting`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户信息',
  `setting_key` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设置类型',
  `setting_value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设置值',
  `system_config_id` int(11) NULL DEFAULT NULL COMMENT '系统配置表id-默认值',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `setting_group` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设置模块',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户设置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_setting
-- ----------------------------
INSERT INTO `user_setting` VALUES (1, 5, 'applicationForApprenticeship', 'false', NULL, '2021-12-06 08:58:35', '2021-12-06 08:58:35', 'NotifyUserSetting');
INSERT INTO `user_setting` VALUES (2, 5, 'apprenticeshipApplication', 'false', NULL, '2021-12-06 08:58:35', '2021-12-06 08:58:35', 'NotifyUserSetting');
INSERT INTO `user_setting` VALUES (3, 5, 'privateMessageReception', 'false', NULL, '2021-12-06 08:58:35', '2021-12-06 08:58:35', 'NotifyUserSetting');
INSERT INTO `user_setting` VALUES (4, 5, 'likeNotification', 'false', NULL, '2021-12-06 08:58:35', '2021-12-06 08:58:35', 'NotifyUserSetting');
INSERT INTO `user_setting` VALUES (5, 5, 'commentNotification', 'false', NULL, '2021-12-06 08:58:35', '2021-12-06 08:58:35', 'NotifyUserSetting');
INSERT INTO `user_setting` VALUES (6, 5, 'collectionNotice', 'false', NULL, '2021-12-06 08:58:35', '2021-12-06 08:58:35', 'NotifyUserSetting');
INSERT INTO `user_setting` VALUES (7, 5, 'followNotifications', 'false', NULL, '2021-12-06 08:58:35', '2021-12-06 08:58:35', 'NotifyUserSetting');
INSERT INTO `user_setting` VALUES (8, 5, 'apprenticeValue', 'string', NULL, '2021-12-06 09:17:25', '2021-12-06 09:17:25', 'ApprenticeSetting');
INSERT INTO `user_setting` VALUES (9, 5, 'apprenticeValue', 'string', NULL, '2021-12-06 09:17:56', '2021-12-06 09:17:56', 'ApprenticeSetting');
INSERT INTO `user_setting` VALUES (10, 5, 'ApprenticeValue', '师父', NULL, '2021-12-06 09:28:54', '2021-12-06 09:28:54', 'ApprenticeValue');
INSERT INTO `user_setting` VALUES (11, 5, 'personalProfile', 'string', NULL, '2021-12-06 09:28:54', '2021-12-06 09:28:54', 'ApprenticeSetting');
INSERT INTO `user_setting` VALUES (12, 5, 'label', 'string', NULL, '2021-12-06 09:28:54', '2021-12-06 09:28:54', 'ApprenticeSetting');
INSERT INTO `user_setting` VALUES (13, 5, 'wantApprentice', 'string', NULL, '2021-12-06 09:28:54', '2021-12-06 09:28:54', 'ApprenticeSetting');

-- ----------------------------
-- Table structure for user_statistics
-- ----------------------------
DROP TABLE IF EXISTS `user_statistics`;
CREATE TABLE `user_statistics`  (
  `id` int(11) NOT NULL COMMENT 'id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `followers` int(11) NULL DEFAULT NULL COMMENT '粉丝数量',
  `following` int(11) NULL DEFAULT NULL COMMENT '关注数量',
  `good_number` int(11) NULL DEFAULT NULL COMMENT '点赞数量',
  `watch_number` int(11) NULL DEFAULT NULL COMMENT '访问数量',
  `master_number` int(11) NULL DEFAULT NULL COMMENT '师傅数量',
  `apprentice_number` int(11) NULL DEFAULT NULL COMMENT '徒弟数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户统计表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
