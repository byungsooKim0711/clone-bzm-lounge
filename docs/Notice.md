## 공지사항
> 공지사항과 관련된 내용을 기술합니다.


#### 공지사항 (TB_NOTICE)
```
Path: /api/notice?page=1&count=10
```

| 항목              | 타입       | 설명                                                      |
| ----------------- | ---------- | --------------------------------------------------------- |
| id                | Number     | PK                                                        |
|title|Text(100)|공지사항 제목|
|content|Text|공지사항 내용|
|popup|Boolean|팝업 노출 여부|
|popup_end_date|Datetime|팝업 노출 시작시간|
|popup_start_date|Datetime|팝업 노출 종료시간|
|fix|Boolean|상단 고정 여부|
||||
| created_date      | Datetime   | 생성일                                                    |
| created_by        | Text(32)   | 생성자                                                    |
| modified_date     | Datetime   | 수정일                                                    |
| modified_by       | Text(32)   | 수정자                                                    |

