# jdbc template batch update

### 내용
- batch update 를 jdbc template 사용해서 처리

```kotlin
       private val jdbcTemplate = JdbcTemplate(dataSource)

	fun batchUpdate(actors: List<Actor>): IntArray {
		val batch = mutableListOf<Array<Any>>()
		for (actor in actors) {
			batch.add(arrayOf(actor.firstName, actor.lastName, actor.id))
		}
		return jdbcTemplate.batchUpdate(
				"update t_actor set first_name = ?, last_name = ? where id = ?", batch)
	}

```

```kotlin
@Configuration
class JdbcTemplateConfig {
   @Bean("jdbcTemplate")
   fun jdbcTemplate(dataSource: DataSource): NamedParameterJdbcTemplate{
         return NamedParameterJdbcTemplate(dataSource)
   } 
}

```

### 참고
- https://docs.spring.io/spring-framework/reference/data-access/jdbc/advanced.html
