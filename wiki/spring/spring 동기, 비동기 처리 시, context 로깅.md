# spring 동기, 비동기 처리 시, context 로깅


### 참고
- https://blog.gangnamunni.com/post/mdc-context-task-decorator/


### 내용

- spring boot 환경에서 rest api 호출하면 하나의 스레드에서 처리가 되기 때문에 MDC.put, ThreadLocal 등을 사용하면 보통 context 가 유지됨.
- 문제는 메인스레드나 @Async 같은 것을 사용해서 별도 스레드가 수행될 때는 context 가 유지가 안될 수 있음. Thread 가 바뀌니.
- 이것을 해결하기 위해 TaskDecorator 와 같은 기능이 나왔음. 요약하면 Thread 내에서 다른 스레드로 전환이 일어나거나 생성할 때, context 를 유지할 수 있도록 customize interface 를 열어놓은 것
