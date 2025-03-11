# exposed, jdbcTemplate 트랜잭션 정리 (spring-batch 에서 테스트)

### exposed, spring-batch chunk transaction
- exposed, spring-batch chunk tasklet 에서 총 2건읽고, chunkSize = 1, 첫번째는 정상 처리. 두번째 에러 -> 첫번째만 반영됨
- 즉, 트랜잭션 정상 동작 (exposed 만 사용했을 때)


### exposed, spring-batch chunk, jdbcTemplate transaction
- exposed 로 조회하고 jdbcTemplate 을 writer 에서 update 진행
- writer 쪽에서 에러가 나도 JdbcTemplate 으로 진행하는건 update 되네
- 즉, 트랜잭션으로 안묶임
- ex) spring-batch 에서 exposed, jdbcTemplate 으로 cud 하면 트랜잭션이 묶이지 않음. 트랜잭션 매니저는 exposed SpringTransactionManager 사용
- 이건 분석글 https://youtrack.jetbrains.com/issue/EXPOSED-657/Transaction-manager-provided-by-Exposed-is-not-compatible-with-JdbcTemplate
- 요약하면 Exposed SpringTransactionManager 에서 Spring Jdbc Transaction 을 포함하지 않아서 그걸 포함시키기 위한 PR

### 개선 PR
- 관련 개선 PR 이 진행중. 얼마 안됐음 (https://github.com/JetBrains/Exposed/pull/2400)
