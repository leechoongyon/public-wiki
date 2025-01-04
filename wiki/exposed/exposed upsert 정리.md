# exposed upsert 정리 
- upsert = merge into
- 데이터가 없으면 INSERT, 데이터가 존재하면 UPDATE

```kotlin

// 변경 전 출력
TestEntity.selectAll().forEach {
   println(it)
}

// merge into
TestEntity.upsert(
    keys = arrayOf(TestEntity.id),
    onUpdate = {
          listOf(TestEntity.name to "testName")
    },
    where = {
              TestEntity.id.eq(1L)
    }. 
) {
   it[name] = "test12345"
  
}

// 변경 후 출력
TestEntity.selectAll().forEach {
   println(it)
}

```
