- 영속성 컨텍스트란 엔티티를 영구 저장하는 환경
- EntityManager는 영속성 컨텍스트 내에서 Entity들을 관리하고 있다.
- Query Method, Simple JPA repository는 직접적으로 entityManager를 사용하지 않도록 wrapping
- Spring에서는 EntityManager를 주입하여 사용하면 같은 트렌잭션의 범위에 있는 EntityManager 는 같은 영속성 컨텍스트에 접근
- 1차 캐시를 사용하는 조건은 식별자 (id) 로 조회하는 경우에만 조회
    - 아래 예시의 경우 총 3번의 쿼리가 수행. 1번 쿼리를 통해 영속성 컨텍스트에 데이터를 저장하지만, 영속성 컨텍스트 내부적으로 식별자(pk) 로 Entity 를 관리하기 때문에 2,3번은 1차 캐시를 사용하지 않음
```java
@Transactional
public void test() {
    Team teama = teamRepository.findById(id);   // 1
    Team teamb = teamRepository.findByType("test1");  // 2
    Team teamc = teamRepository.findByName("test2"); // 3
}
```

- JPQL로 데이터베이스에서 조회한 엔티티가 영속성 컨텍스트에 이미 존재하면, JPQL로 데이터베이스에서 조회한 결과를 버림. 영속성 컨텍스트에 있던 엔티티를 반환. 식별자 값을 이용하여 비교
  - 왜냐하면 식별자 값은 유일해야하므로 영속성 컨텍스트에 새로운 엔티티를 추가하는 것은 X
  - 기존 영속성 컨텍스트 엔티티를 변경하는 것은 위험
  - 즉, 그래서 기존 영속성 컨텍스트를 유지하고, 새로 조회한 것을 버림.
  - querydsl 이 JPQL 로 데이터베이스를 조회함
  - findBy, findAll 등 기본 메소드는 영속성 컨텍스트에서 먼저 찾고 없으면 데이터베이스 조회
  - JPQL 은 데이터베이스 조회
