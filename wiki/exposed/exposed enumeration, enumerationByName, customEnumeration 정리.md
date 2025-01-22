# exposed enumeration, enumerationByName 차이
- enumeration ordinal 값 사용. 열거형의 순서
- enumerationByName 이름을 사용


# exposed customEnumeration 사용법

### exposed Table 의 customEnumeration 소스
```kotlin
fun <T : Enum<T>> customEnumeration(
        name: String,
        sql: String? = null,
        fromDb: (Any) -> T,
        toDb: (T) -> Any
    ): Column<T> = registerColumn(name, CustomEnumerationColumnType(name, sql, fromDb, toDb))

```



