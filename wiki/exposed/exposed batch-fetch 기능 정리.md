# exposed batch-fetch 기능 정리

# 내용
- kotlin exposed fetchBatched
- 사용할려면 pk 에 AutoIncrement 선언 필요. sorting 때문에 그런거 같음.
- selectAll().xxx.fetchBatchResults(1000, sort) 이렇게 하면 Iterable<Iterable<ResultRow>> 가 나옴


### example 1

```kotlin
result = Iterable<Iterable<ResultRow>>
iterator = <Iterable<ResultRow>

// 이 때, select 문이 한 번 날아감
// 1번 로직
if (result.iterator().hasNext()) {
iterator = result.iterator().next().iterator()
}

//
override fun read(): xxxDto? {
if (iterator == null || !iterator!!.hasNext()) {
// 여기 온다는건 iterator 데이터가 없다는거고, result 를 다시 데이터를 세팅해주기 위해 위에 1번 로직을 불러줘야 함.
}
}

```

- open 에서 내부 iterator, 외부 iterator 초기화를 해줘야할듯
- read 에서 내부 iterator 가 값이 없으면 외부 iterator 에서 찾고, 외부 iterator 가 없으면 종료 



### example 2
- 아래 내용 참고

```kotlin

fun getDataUsingCursor(): Iterator<Iterable<ResultRow>>? {
     return TestEntity.selectAll().fetchBatchedResults(1000, sortOrder = SortOrder.ASC).iterator()
}


class TestTasklet {
      private var external: Iterator<Iterable<ResultRow>> = emptyList<Iterable<ResultRow>>().iterator()
      private var internal: Iterator<ResultRow> = emptyList<ResultRow>().iterator()


      fun open () {
             this.external = getDataUsingCursor()?: return
      }  

     fun read() {
              if (!this.external.hasNext() && !this.internal.hasNext()) {
                return 
             }

              if (!this.internal.hasNext()) {
                    this.internal = this.external.next().iterator()
              }

              if (this.internal.hasNext()) {
                     return 데이터 가공한 것
              }
      } 
}
```
