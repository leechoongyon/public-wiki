# exposed 조회 관련 정리

### select 할 때, 특정 컬럼만 조회
- slice 가 deprecated 되서 select 를 통해 원하는 컬럼만 추출

```kotlin
TestEntity.select(TestEntity.id, TestEntity.name) // 이런식으로
```
