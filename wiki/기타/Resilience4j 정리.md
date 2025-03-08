# Resilience4j
- Java, Spring Boot 에서 resilience(회복성) 을 관리하기 위한 경량화된 오픈소스 라이브러리
- 마이크로서비스 아키텍처에서 발생할 수 있는 네트워크 오류, 지연, 장애 등의 문제에 대응하기 위해 설계

### 요소

##### Circuit Breaker
- 외부 서비스나 API 호출에서 장애가 지속되면 추가 요청 차단
- 장애 회복 시 요청 재개

##### Rate Limiter
- 특정 시간 동안의 요청 횟수를 제한하여 과도한 트래픽을 방지

##### Retry
- 외부 서비스 호출이 실패했을 때 자동으로 재시도

##### TimeLimiter (시간 제한)
- 특정 작업의 최대 실행 시간을 제한하고 타임아웃 시 예외 발생

##### Bulkhead (벌크헤드)
- 시스템 자원을 보호하기 위해 특정 서비스에 대한 동시 실행 수를 제한

##### Cache (캐싱)
- 외부 서비스의 응답을 캐시하여 반복적인 호출을 줄이고 성능 향상

### 예시
```java 
    @CircuitBreaker(name = "apiA", fallbackMethod = "fallbackMethod")
    public String external() {
              xxx
    }
```

