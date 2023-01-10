## Notification
> 알림정보와 관련된 내용을 기술합니다.

#### 알람 (TB_NOTIFICATION)
```
Path: /api/notification
```

| 항목              | 타입       | 설명                                                      |
| ----------------- | ---------- | --------------------------------------------------------- |
| id                | Number     | PK                                                        |
|user_id|Number|알림 대상 유저 ID|
|content|Text|알림 내용|
|content_type|Text|알림 타입(NEW_ANSWER, EMPATHY, ...)|
|content_link|알림 원본 링크|ex1. /api/post/1234, ex2. /api/post/1234/comment/1|
|read|Boolean|true: 읽음, false: 안읽음|
|notification_type|Text|EMAIL, ALIMTALK, MT, ...|
|created_date      | Datetime   | 생성일                                                    |
|created_by        | Text(32)   | 생성자                                                    |
|modified_date     | Datetime   | 수정일                                                    |
|modified_by       | Text(32)   | 수정자                                                    |