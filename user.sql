SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` int(255) DEFAULT NULL,
  `classes` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `groupss` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `gender` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '张三', '18', '一班', '一组', '1');
INSERT INTO `user` VALUES ('2', '李四', '19', '二班', '3组', '0');
INSERT INTO `user` VALUES ('3', '网二', '18', '三班', '一组', '1');
INSERT INTO `user` VALUES ('4', '666', '66', '66', '66', '6');
INSERT INTO `user` VALUES ('5', '777', '77', '77', '77', '77');
INSERT INTO `user` VALUES ('6', '888', '88', '88', '88', '88');
