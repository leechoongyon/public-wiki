# Open
- kotlin 은 기본적으로 클래스와 메서드에서 final 로 선언됩니다. 즉, 상속이 안됩니다.
- 상속이 필요하다면 open 을 사용해야 합니다.

### example
```kotlin
class Cup<out T>
open class Dog      // 상속 가능
clsss Puppy: Dog() // Puppy 가 Dog 를 상속

```