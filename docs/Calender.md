## 캘린더
> 캘린더와 관련된 내용을 기술합니다.

#### 추가 적용해볼 수 있는 것
- 구글 캘린더 연동

#### 캘린더 (TB_CALENDER)
```
Path: /api/calender?startDate=yyyy-MM-dd HH:mm:ss&endDate=yyyy-MM-dd HH:mm:ss
```

| 항목 | 타입   | 설명 |
| ---- | ------ | ---- |
| id   | Number | PK   |
|title|Text|스케줄 제목|
|content|Text|스케줄 내용|
|start_date|Datetime|스케줄 시작 시간|
|end_date|Datetime|스케줄 종료 시간|
|status|Text(1)|상태|
|type|Text|EXTERNAL, INTERNAL|
||||
|created_date|Datetime|생성일|
|created_by|Text(32)|생성자|
|modified_date|Datetime|수정일|
|modified_by|Text(32)|수정자|