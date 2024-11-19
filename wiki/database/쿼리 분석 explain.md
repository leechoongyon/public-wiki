# 쿼리 분석 explain



### 참고

- https://velog.io/@wisepine/MySQL-%EC%8A%AC%EB%A1%9C%EC%9A%B0%EC%BF%BC%EB%A6%AC-%EC%9E%A1%EB%8A%94-%EB%AA%85%EB%A0%B9%EC%96%B4-EXPLAIN-ANALIZE-%ED%95%B4%EC%84%9D%EB%B2%95



### 내용

- EXPLAIN - 쿼리 실행하지 않고 실행 과정 예측
- EXPLAIN ANALYZE - 쿼리 실행 후, 실행 과정 분석



##### 사용법

```
EXPLAIN ANALYZE
select * from test;
```



##### 분석 방법

- time (실행 시간) 이 가장 큰 부분을 찾는다.
- 실행계획과 실제 실행한 쿼리중 꽤 차이가 나는 부분을 중점적으로 본다.



##### 기타

- 추후 해당 블로그 보고 실제 해보면 될듯
- 추가로 driving table 이 중요함. driving 테이블에서 데이터를 적게 읽어올 수록 뒤에서 조인하는 테이블은 적은 Driving table 데이터로 조인하는거라 성능 향상이 있음
- 또한, 커버링 인덱스, 인덱스를 탔는지 등 확인하는 것도 좋음