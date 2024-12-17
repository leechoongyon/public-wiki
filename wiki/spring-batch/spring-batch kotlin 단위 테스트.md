spring batch kotlin 단위 테스트

```kotlin
class xxxTasklet: ItemReader, ItemProcesor, ItemWriter, ItemStream {
xxx
xxx
}



@ExtendWith(MockitoExtension::class)
class xxxTaskletTest {

     @InjectMocks 
     lateinit var     xxxTasklet

    @Test
    testRead() {
           xxxTasklet.read()
    }
}

```
