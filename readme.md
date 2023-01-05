## 카카오 비즈니스 라운지 Clone Coding Project

> 해당 프로젝트의 목표는 `카카오 비즈니스 라운지`를 분석하고, 새로운 것들을 학습하며 진행하는 것입니다.

- `카카오 비즈니스 라운지`란 카카오 비즈메시지 딜러사에게 제공하는 문의/공지 사이트입니다.



### 프로젝트 기간

> 시간적 여유가 있을 때 틈틈히 진행합니다.



### 기술스택

> 학습하고 싶었던 기술스택 위주로 선택했습니다.

| 항목                      | 학습 필요 | 비고                                                         |
| ------------------------- | --------- | ------------------------------------------------------------ |
| `Kotlin`                  | `○`       |                                                              |
| `Spring Boot > 3.x?`      | `△`       |                                                              |
| `JPA`                     | `△`       |                                                              |
| `SSE (Server Sent Event)` | `△`       | 1. SSE 프로토콜의 이해<br />2. Application이 Scale out 되었을 때의 고려 |
| `QueryDSL`                | `△`       |                                                              |
| `MySQL`                   | `△`       |                                                              |
| `Gradle`                  | `△`       |                                                              |
| `Junit5`                  | `△`       |                                                              |
| `nginx`                   | `○`       |                                                              |
| `docker`                  | `○`       |                                                              |
| `k83`                     | `○`       |                                                              |
| `Vue`                     | `△`       | - 우선순위 최하,                                             |
| `SSO`                     | `○`       | 1. 서로다른 domain/site 간 로그인 유지 방안 이해             |





### 필요항목

| 항목                                       | 엔티티          | 비고                                                         |
| ------------------------------------------ | --------------- | ------------------------------------------------------------ |
| [유저](./docs/User.md)                | User            |                                                              |
| [관리자](./docs/AdminUser.md)       | AdminUser       |                                                              |
| [공지사항](./docs/Notice.md)         | Notice          | 팝업용(시작~종료), 상단고정                                  |
| [문의사항](./docs/Post.md)                 | Post  | 문의사항 등록 시 사업/심사운영/상담운영/개발주번/            |
| [문의사항 답글](./docs/Comment.md)        | Comment, Answer |                                                              |
| [문의사항 참조](./docs/Mention.md)   | Mention         |                                                              |
| [SSE, 답글 알림(web)](./docs/Notification.md) | Notification    |                                                              |
| 개인정보 포함 관련 여부 (망분리)           |                 | 기술적으로 망분리는 어떻게 진행하는지 이해/고민 필요         |
| [발신프로필](./docs/Sender.md)             | Sender          | 해당 항목의 내용과 필요한 필드는 알 고 있으나 autocomplete 용 api로 단순하게 설계합니다. |
| [알림톡 템플릿](./docs/Template.md)        | Template        | 해당 항목의 내용과 필요한 필드는 알 고 있으나 autocomplete 용 api로 단순하게 설계합니다. |
| [캘린더](./docs/Calender.md)       | Calender        |                                                              |
| [첨부파일](./docs/Attachment.md) | Attachment      |                                                              |
| [공감/좋아요](./docs/Empathy.md)           | Empathy         |                                                              |
| searchEngine (별도 검색엔진으로 사용? es?) |                 |                                                              |
| [문의 카테고리](./docs/Category.md)       | Category        |                                                              |
|                                            |                 |                                                              |
|                                            |                 |                                                              |

- trace-id > msa 방식으로 사용중인가? sleuth?

#### 




### Conventions
#### Git Commit Convention
- [링크](./docs/Convention.md)








