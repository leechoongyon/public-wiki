# spring batch 분기 처리 및 순환 JOB

### 내용
- JobExecutionDecider 를 통해 분기 처리 가능
- FlowExecutionStatus 를 return 해줘야 하는데, 별도로 생성해서 사용 가능
    - val RUNNING = FlowExecutionStatus("RUNNING")
- 아래 예시는 FAILED 를 만나면 계속 순환을 수행하는 JOB 구조

### 소스 예시
```kotlin

class TestJob ( xxx ) {
    fun xxxFlow(xxx) {
        return FlowBuilder<Flow>(xxxxxx)
            .start(xxxxStep(xxx))
            .next(xxxDecider(xxx)
            .on(FAILED.name).to(xxxStep(xxx)
            .from(xxxDecider(xxx).on(COMPLETED.name).end()
    }
} 

```


```kotlin

override fun decide(xxx) {
     if (xxxxx) {
           return FlowExecutionStatus.COMPLETED
     }
   
     return FlowExecutionStatus.FAILED
}

```


### 참고
- https://velog.io/@khc41/Spring-Batch-Step-%EB%B6%84%EA%B8%B0%EC%B2%98%EB%A6%AC
