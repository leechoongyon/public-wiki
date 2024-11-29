# kotlin-supplier 정리


### 내용
```kotlin
둘다 동일
val supplier: () -> Int? = { xxx.test() }  // xxx.test() 는 Int return
val supplier:  { xxx.test() }

**java**
void process(Supplier<String> supplier) {
    System.out.println(supplier.get());
}

process(() -> "Hello, Kotlin!");


**코틀린:**

kotlin
fun process(supplier: () -> String) {
    println(supplier())
}

process { "Hello, Kotlin!" }

```
