## [Git] Commit Message Convention

> Git을 사용할 때 커밋 메시지에 대한 규칙 정의를 정리합니다.



### Format

```
Type: Subject
(공백)
Body
(공백)
Footer
```



### Header

> Type과 Subject를 작성하여 Header 영역을 구성한다.

#### Type 종류

| Type     | Description                                           |
| -------- | ----------------------------------------------------- |
| Feature  | 새로운 기능 추가                                      |
| Bugfix   | 버그 수정                                             |
| Hotfix   | 긴급히 배포되어야 되는 수정                           |
| Refactor | 프로덕션 코드 리팩토링                                |
| Test     | 테스트 코드 추가 및 수정                              |
| Release  | 버전 릴리즈                                           |
| Docs     | 문서 수정                                             |
| Style    | 코드 스타일, 포맷팅 수정                              |
| Chore    | 빌드 업무 수정, 패키지 메니저 수정, 기타 (.gitignore) |
|          |                                                       |

#### Subject

- 간결한 개조식 구문 사용과 Type과 함께 헤더를 구성한다.

```
ex) Feature: 로그인 API 추가
```



### Body

> 코드 변경의 이유(`무엇을`, `왜` 변경했는지)를 명확하고 상세하게 작성한다.



### Footer

> 선택사항으로 어떤 이슈에 대한 commit 인지 issue number를 포함시킨다.

- Fixes: 이슈 수정중 (아직 해결되지 않은 경우)
- Resolves: 이슈를 해결했을 때
    - <<Github에서 이슈 종료로 인식하는 키워드>>
    - close, closes, closed
    - fix, fixes, fixed
    - resolve,resolves, resolved
- Ref: 참고할 이슈가 있을 때
- Related to: 해당 커밋에 관련된 이슈번호 (아직 해결되지 않은 경우)

```
ex1) Close #1 - refactoring wrap-up

ex2) Closes #1 - , Closes #2 - , Closes #3 - ,
```

