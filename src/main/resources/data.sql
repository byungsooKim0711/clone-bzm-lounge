insert into tb_category(id, created_at, created_by, modified_at, modified_by, name, parent_id)
values (1, now(), -1, now(), -1, '알림톡', null),
       (2, now(), -1, now(), -1, '친구톡', null),
       (3, now(), -1, now(), -1, '상담톡', null),
       (4, now(), -1, now(), -1, '브랜드톡', null),
       (5, now(), -1, now(), -1, '심사', null),
       (6, now(), -1, now(), -1, '비즈메시지센터', null),
       (7, now(), -1, now(), -1, '개발환경', null),
       (8, now(), -1, now(), -1, '비즈니스채널 전환', null),
       (9, now(), -1, now(), -1, '기타', null),

       (10, now(), -1, now(), -1, '상품/서비스 문의', 1),
       (11, now(), -1, now(), -1, '템플릿 관련', 1),
       (null, now(), -1, now(), -1, '메시지발송 확인', 1),
       (null, now(), -1, now(), -1, '어뷰징 차단 및 해제문의', 1),
       (null, now(), -1, now(), -1, '템플릿 불일치', 1),
       (null, now(), -1, now(), -1, '템플릿 자동 복사 규칙 적용', 1),
       (null, now(), -1, now(), -1, '템플릿 복사', 1),
       (null, now(), -1, now(), -1, '발신프로필 복사', 1),
       (null, now(), -1, now(), -1, '발신프로필 관련', 1),
       (null, now(), -1, now(), -1, '비즈니스채널 관련 문의', 1),
       (null, now(), -1, now(), -1, '공식딜러사 정보 변경', 1),
       (null, now(), -1, now(), -1, '개인정보점검', 1),
       (null, now(), -1, now(), -1, '전용선 문의', 1),
       (null, now(), -1, now(), -1, '성능(부하)테스트', 1),
       (null, now(), -1, now(), -1, 'API 사용 문의', 1),
       (null, now(), -1, now(), -1, '기타', 1),
       (null, now(), -1, now(), -1, '대량발송 건 공유(법적고지 포함)', 1),

       (null, now(), -1, now(), -1, '메시지 발송 확인', 2),
       (null, now(), -1, now(), -1, '상품/서비스 문의', 2),
       (null, now(), -1, now(), -1, '친구톡 발송 가능 모수 확인 API', 2),
       (null, now(), -1, now(), -1, '기타', 2),


       (null, now(), -1, now(), -1, '기타', 9),
       (null, now(), -1, now(), -1, '채널 메시지 제재 문의', 9)
;

insert into tb_post
(id, completed_at, content, created_at, created_by, modified_at, modified_by, privacy, progress_status, title,
 category_id)
values
       (1, now(), '상품/서비스 문의 게시글 본문', now(), 1, now(), 1, false, 'C', '상품/서비스 문의 게시글 제목', 10),
       (2, now(), '템플릿 관련 문의 게시글 본문', now(), 1, now(), 1, false, 'C', '템플릿 관련 문의 게시글 제목', 11)

;
