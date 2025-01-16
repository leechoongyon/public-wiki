# exposed native query

### source
```kotlin

var query: String = TestEntity.selectAll()
    .where {
        xxx
    }
    .prepareSQL(QueryBuilder(false))


if (limit != 0) {
    query = query + " offset 0 limit 10"
}

return transaction {
    exec(query) {
        rs -> 
        val result = mutableListOf<xxx>()
        while (rs.next) {
            result.add(rs.getString(xxx))
        }
        result
    }
}

```
