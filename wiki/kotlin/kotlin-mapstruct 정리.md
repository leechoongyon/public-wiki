# kotlin-mapstruct 정리



### 내용



```
// build.grade
kotlin("jvm") version "2.0.10"
kotlin("kapt") version "2.0.10"
kotlin("plugin.spring") version "2.0.10" apply false

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.kapt")
}

implementation("org.mapstruct:mapstruct:version") 
kapt("org.mapstruct:mapstruct-processor:version")
kaptTest("org.mapstruct:mapstruct-processor:version")


// mapper
@Mapper (componentModel = "spring")
interface SampleMapper {
   fun map(vo: TestVo) : TestDto 
}

// service 
class TestService (
   sampleMapper: SampleMapper
) {
   sampleMapper.map(testVo)
}


여기서 주의할건 testVo 의 source field 는 private 붙이면 안됨. getter 로 가져와야하니
data class TestVo (
   val testField: String
)

data class TestDto (
   private val testField: String // 얘는 private 가능. mapperImpl 보니까 생성자로 생성해서 private val 로 선언해도 됨
)
```


### mapToList 인데, 파라미터가 2개 이상
```kotlin
@Mapper
interface xxxMapper {
   companion object {
      val INSTANCE  = xxxMapper = Mappers.getMapper(xxxMapper::class.java)
  } 

   fun map(xxxEntity: xxxEntity) : xxxDto
}

abstract class XxxMapper {

    companion object {
        val INSTANCE  = xxxMapper = Mappers.getMapper(xxxMapper::class.java)
    }

    fun mapToList(xxxDtoList: List<XxxDto>, test: String) : List<xxxResultDto> {
        xxxDtoList.map { map(it, test) }
    }

    @Mapping(source = "xxxDto.id", target, "id")
    @Mapping(source = "test", target = "test")
    abstract fun map(xxxDto: xxxDto, test: String) : xxxResultDto
}

```
