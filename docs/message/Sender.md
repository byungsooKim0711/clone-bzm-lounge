## 발신프로필
> 발신프로필(Sender) 과 관련된 내용을 기술합니다.



#### 발신프로필 (TB_SENDER)

```
Path: /api/sender/{senderId}
```



| 항목 | 타입   | 설명 |
| ---- | ------ | ---- |
| id   | Number | PK   |
|sender_key|Text(40)|발신프로필 키|
|uuid|Text|@가 들어간 검색용 아이디|
|status|Text|프로필 상태 (A: 정상, )|
|dormant|Boolean|휴면여부 (true: 휴면)|
|hub_partner_id|Number|파트너 테이블의 ID|
|profile_category_id|Number|프로필 카테고리 테이블의 ID|
|created_date|Datetime|생성일|
|created_by|Text(32)|생성자|
|modified_date|Datetime|수정일|
|modified_by|Text(32)|수정자|


#### 발신프로필 히스토리 (TB_SENDER_HISTORY)

```
Path: /api/sender/{senderId}/history
```



| 항목 | 타입   | 설명 |
| ---- | ------ | ---- |
| id   | Number | PK   |
|sender_id|Number|발신프로필 테이블의 ID|
|ccontent|Text|변경내용 (ex.  xxx 상태변경 : false - > true)|
|status|Text|SENDER_GROUP, ALIMTALK, SPAMVIEW, BLOCK, DORMANT...)|
|created_date|Datetime|생성일|
|created_by|Text(32)|생성자|
