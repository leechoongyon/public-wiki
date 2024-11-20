# ForkJoinPool vs ExecutorService



### 내용

- 둘다 스레드풀을 managing 하는 것
- 병렬 처리는 내부적으로 ForkJoinPool.commonPool() 사용. 공통 풀은 JVM 당 하나만 존재하며, 병렬 처리에 사용
- https://tech-monster.tistory.com/246 참고 내용을 보면 ExecutorService 가 IO 처리에 더 좋다고 함
- ForkJoinPool 은 재귀처리에 특화 됐다고 함. Crawling 같은거