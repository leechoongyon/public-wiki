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

```kotlin
class Builder (
    var whereQuery: Op<Boolean> = Op.TRUE
) {
    companion object {
        fun of(): Builder {
            return Builder()
        }
    }

    fun <E> andEquals(
        value: E?,
        column: Column<E>
    ): Builder {
        if (value != null) {
            andExpr(column.eq(value))
        }
        return this
    }
    
    andExpr(booleanExpr: Op<Boolean>) : Builder {
      this.whereQuery = whereQuery and booleanExpr 
         return this
    }
    
    fun build(): Op<Boolean> {
        return whereQuery
    }
}

```

- 사용예제
```kotlin
   TestEntity.selectAll().where {
        Builder.of().andExpr(TestEntity.id, 1L).build   
    }   
   
```
