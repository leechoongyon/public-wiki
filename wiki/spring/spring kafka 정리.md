# spring kafka 정리


### autoConfiguration 이용하는 방법
- 아래와 같이 선언하면 AutoConfiguration 이 작동하면서 세팅
- consume, produce 에서는 String 으로 주고 받는게 좋을듯. 객체가 들어가는 순간 클래스를 찾아야하는 문제가 발생
```yaml
spring:
  kafka: 
    xxx
```

```kotlin
@Component
class SampleListener {
    @KafkaListener(topics = ["test"])
    fun listen(payload: String) {
        xxx
    }
}
```

### kafka config 수동으로 세팅

```yaml
kafka:
  targets:
    sample1:
      producer:
        xxxxx
      consumer:
        xxxxx
    sample2:
      producer:
        xxxxx
      consumer:
        xxxxx
```
