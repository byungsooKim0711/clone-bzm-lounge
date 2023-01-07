
## 알림톡 템플릿
> **알림톡 템플릿과 관련된 내용을 기술합니다.**
>
> 테이블 설계는 추가적으로 적용할게 없다면 최대한 간단하게 작성합니다.







#### 적용해볼 수 있는 것

- 휴면 배치적용
- 검수 상태에 따른 State pattern 적용?
- 이력적재 방법





#### 알림톡 템플릿 (TB_TEMPLATE)

```
Path: /api/sender/{senderId}/template/{templateId}
```

| 항목              | 타입       | 설명                                                      |
| ----------------- | ---------- | --------------------------------------------------------- |
| id                | Number     | 템플릿 테이블 PK                                          |
| code              | Text(30)   | 템플릿 코드                                               |
| content           | Text(1000) | 템플릿 내용                                               |
| dormant           | Boolean    | 휴면 여부 (true: 휴면, false: 정상)                       |
| button            | Array      | 버튼 정보 (ex. `[{"name": "", "type": ""}]`)              |
| inspection_status | Text(3)    | 검수상태 (REG(등록), REQ(검수요청), APR(승인), REJ(반려)) |
| sender_id         | Number     | 프로필 테이블의 ID                                        |
| category_id       | Number     | 템플릿 카테고리 테이블의 ID                               |
| status            | Text(1)    | 상태 (R: 대기, A: 정상)                                   |
| ... 이하 생략     |            |                                                           |
| created_date      | Datetime   | 생성일                                                    |
| created_by        | Text(32)   | 생성자                                                    |
| modified_date     | Datetime   | 수정일                                                    |
| modified_by       | Text(32)   | 수정자                                                    |



#### 알림톡 템플릿 코멘트 (TB_TEMPLATE_COMMENT)

```
Path: /api/sender/{senderId}/template/{templateId}/comment

```

| 항목         | 타입     | 설명             |
| ------------ | -------- | ---------------- |
| id           | Number   | 템플릿 테이블 PK |
| comment      | Text     | 검수 내용        |
| status       | Text(3)  | REQ, REJ, APR    |
|template_id|Number|템플릿 테이블의 ID|
| user_id      | Number   | 코멘트 등록자 ID |
| created_date | Datetime | 생성일           |
| created_by   | Text(32) | 생성자           |



#### 알림톡 템플릿 히스토리 (TB_TEMPLATE_HISTORY)

```
Path: /api/sender/{senderId}/template/{templateId}/history

```

- 상태변경에 대한 내용은 어떻게 적재하는가?
  - 카테고리 변경은 변경된 시점의 카테고리를 content에 넣으면 될 듯 함
  - 휴면, 차단, ... 등이 있을텐데 어떻게 넣을까? → 상태변경 API가 다르니까 이미 알고있다?

| 항목 | 타입   | 설명             |
| ---- | ------ | ---------------- |
| id   | Number | 템플릿 테이블 PK |
|content|Text|상태변경 내용 (ex. 휴면 해제 -> 휴면) / (ex. 회원 > 회원가입)|
|type|Text|CATEGORY(카테고리 변경), STATUS(상태변경), DORMANT(휴면상태 변경)|
|template_id|Number|템플릿 테이블의 ID|
|created_date|Datetime|생성일|
|created_by|Text(32)|생성자|

