## 게시글
> 게시글과 관련된 내용을 기술합니다.


#### 게시글 (TB_POST)
```
Path: /api/post
```

| 항목              | 타입       | 설명                                                      |
| ----------------- | ---------- | --------------------------------------------------------- |
| id                | Number     | PK                                                        |
|title|Text(100)|제목|
|content|Text|내용|
|status|Text(1)|A: 정상|
|~~type~~|~~Text(1)~~|~~Q(question)~~|
|progress_status|Text(1)|진행 상태|
|complete_at|Datetime|완료일자|
|privacy|Boolean|개인정보 포함 여부|
|category|Text|게시글 카테고리| 
|created_at      | Datetime   | 생성일                                                    |
|created_by        | Text(32)   | 생성자                                                    |
|modified_at     | Datetime   | 수정일                                                    |
|modified_by       | Text(32)   | 수정자                                                    |

