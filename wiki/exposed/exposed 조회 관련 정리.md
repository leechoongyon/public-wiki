# exposed 조회 관련 정리

### select 할 때, 특정 컬럼만 조회
- slice 가 deprecated 되서 select 를 통해 원하는 컬럼만 추출

```kotlin
TestEntity.select(TestEntity.id, TestEntity.name) // 이런식으로
```


### 중복 제거
- withDistinct 사용
- 아래와 같이 사용하면 PK 에 DISTINCT 붙는다.

```kotlin
selectAll().withDistinct(true)
```

- 만약 2개 이상 테이블 조인이라면 select 에서 특정컬럼들만 해줘야 select 해줘야하는거 같음
```kotlin
select (TestEntity.id, xxx).withDistinct(true)
```
