CREATE TABLE `member` (
                          `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
                          `created_at` datetime(3) NOT NULL COMMENT '생성 일시',
                          `creator_id` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '생성자 Id',
                          `modified_at` datetime(3) NOT NULL COMMENT '수정 일시',
                          `modifier_id` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '수정자 Id',
                          `sns_email_address` varchar(254) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'SNS 이메일 주소',
                          `status` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '상태',
                          PRIMARY KEY (`id`),
                          KEY `idx__sns_email_address` (`sns_email_address`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='회원';