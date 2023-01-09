## 첨부파일
> 첨부파일과 관련된 내용을 기술합니다.

#### 첨부파일(TB_ATTACHMENT)
| 항목              | 타입       | 설명                                                      |
| ----------------- | ---------- | --------------------------------------------------------- |
| id                | Number     | PK                                                        |
|file_name|Text|업로드된 파일 이름|
|file_type|Text||
|file_url|Text|파일 URL|
|status|Text(1)|A: 정상|
|thumbnail_url|Text|썸네일 URL|
|created_date      | Datetime   | 생성일                                                    |
|created_by        | Text(32)   | 생성자                                                    |


#### 게시글 첨부파일 (TB_POST_ATTACHMENT)
| 항목              | 타입       | 설명                                                      |
| ----------------- | ---------- | --------------------------------------------------------- |
| id                | Number     | PK                                                        |
|post_id|Number|[게시글 테이블](Post.md)의 ID|
|attachment_id|Number|첨부파일 테이블의 ID|


#### 답글 첨부파일 (TB_COMMENT_ATTACHMENT)
| 항목              | 타입       | 설명                                                      |
| ----------------- | ---------- | --------------------------------------------------------- |
| id                | Number     | PK                                                        |
|comment_id|Number|[답글 테이블](Comment.md)의 ID|
|attachment_id|Number|첨부파일 테이블의 ID|
