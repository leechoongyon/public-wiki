# exposed 동적 builder 만드는법



# 내용

- 아래 내용 참고해서 where 절에 추가

```kotlin
fun <E> xxxMethod(
    code: E?,
    column: Column<E>
): Builder  {
    val builder = Builder()
    code?.let {
        builder.addCondition(column.eq(code)) // 조건 추가
    }
    return builder
}

// 호출
Builder.xxxMethod(xxxEnum, xxxEntity.xxxEnum)
```
