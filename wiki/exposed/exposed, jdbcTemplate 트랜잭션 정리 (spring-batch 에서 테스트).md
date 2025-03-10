# exposed, jdbcTemplate 트랜잭션 정리 (spring-batch 에서 테스트)

### exposed, spring-batch chunk transaction
- exposed, spring-batch chunk tasklet 에서 총 2건읽고, chunkSize = 1, 첫번째는 정상 처리. 두번째 에러 -> 첫번째만 반영됨
- 즉, 트랜잭션 정상 동작 (exposed 만 사용했을 때)
