# spring batch 에서 Step 데이터 공유

### 내용
- JobScope 를 선언한 DTO 를 통해 Step 단 데이터를 공유

### Source

```kotlin
@JobScope
@Component
public class JobDataHolder {
	mapOf (xxx)
}

@StepScope
@Component
public JobDataHolderSetTasklet: Tasklet(
    private val jobDataHolder: JobDataHolder
) {
	
    // jobDataHolder 에 데이터를 set 하는 Step  

}

@StepScope
@Component
public JobDataHolderGetTasklet: Tasklet(
    private val jobDataHolder: JobDataHolder
) {
	
    // jobDataHolder 에 데이터를 get 하는 Step  

}


```


### 참고
- https://velog.io/@gongmeda/Spring-Batch%EC%97%90%EC%84%9C-Step%EA%B0%84-%EB%8D%B0%EC%9D%B4%ED%84%B0-%EA%B3%B5%EC%9C%A0%ED%95%98%EB%8A%94-%EB%B0%A9%EB%B2%95

