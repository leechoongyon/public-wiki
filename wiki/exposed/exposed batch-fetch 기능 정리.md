# exposed batch-fetch 기능 정리

# 내용
- kotlin exposed fetchBatched
- 사용할려면 pk 에 AutoIncrement 선언 필요. sorting 때문에 그런거 같음.
- selectAll().xxx.fetchBatchResults(1000, sort) 이렇게 하면 Iterable<Iterable<ResultRow>> 가 나옴

