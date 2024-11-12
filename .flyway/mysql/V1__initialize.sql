CREATE TABLE `member` (
                          `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
                          `created_at` datetime(3) NOT NULL COMMENT '생성 일시',
                          `email_address` varchar(254) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '이메일 주소',
                          `email_validated` bit(1) NOT NULL COMMENT '이메일 검증 여부',
                          `modified_at` datetime(3) NOT NULL COMMENT '수정 일시',
                          `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '이름',
                          `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '비밀번호',
                          `status` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '상태',
                          PRIMARY KEY (`id`),
                          UNIQUE KEY `uk__email_address` (`email_address`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='회원';

CREATE TABLE `email_send_history` (
                                      `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
                                      `body` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '내용',
                                      `recipient` varchar(254) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '수신자',
                                      `sender` varchar(254) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '발신자',
                                      `sent_at` datetime(3) NOT NULL COMMENT '발신 일시',
                                      `subject` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '제목',
                                      PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='이메일 발신 이력';
