## 게시글 답글
> 게시글 답글과 관련된 내용을 기술합니다.

#### 게시글 답글 (TB_POST_COMMENT)

```
Path: /api/post/{postId}/comment
```

| 항목              | 타입       | 설명                                                      |
| ----------------- | ---------- | --------------------------------------------------------- |
| id                | Number     | PK                                                        |
|post_id|Number|[게시글 테이블](Post.md)의 ID|
|content|Text|답글 내용|
||||
|created_date      | Datetime   | 생성일                                                    |
|created_by        | Text(32)   | 생성자                                                    |
|modified_date     | Datetime   | 수정일                                                    |
|modified_by       | Text(32)   | 수정자      