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

### 사용법
```kotlin
class enum TestEnum (val value Int) {
        ACTIVE(10)
        STOP(20)
}


TestEntity.kt
val testCode = customEnumeration(
    name = "STAT_CODE", 
    sql = "VARCHAR(5)",  // ex) NUMBER(5) sqlType 이 들어가야함
    fromDb = {dbValue -> TestEnum.values().first { it.value == (dbValue as BigDecimal).toInt } },
    toDb = { enumValue -> enumValue.value }
}


// 변환할려고 하는 enum value 가 String 이면
//  fromDb = {dbValue -> TestEnum.values().first { it.value == dbValue as String } },

```

