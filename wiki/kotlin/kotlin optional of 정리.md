# kotlin 에서 java optional of 사용


### 내용
```kotlin
// java
Optional.of(getValue())
        .filter(data -> Objects.equals(data, "expected"))
        .orElseThrow(() -> new RuntimeException("Value not found"));

// kotlin
getValue()?.takeIf { it == "expected" } ?: throw RuntimeException("Value not found")
```
