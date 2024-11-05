# unit test 기본 작성
### source code

```kotlin
@ExtendWith(MockitoExtension::class)
class ExampleServiceTest2 {

  @InjectMocks
  private lateinit var exampleService: ExampleService

  @Mock
  private lateinit var exampleService2: ExampleService2


  @Test
  fun `test processExample returns expected result`() {

     // Given
    val exampleData = ExampleData("testValue", "testParam")
    given(exampleService2.processExample(exampleData)).willReturn(ExampleResult("testValue"))

    // When
    val result = exampleService.processExample(exampleData)

    // Then
    assertEquals("testValue", result.data)
  }
}
```



### 참고

- https://stackoverflow.com/questions/59230041/argumentmatchers-any-must-not-be-null
  https://beomseok95.tistory.com/297





# ArgumentCaptor 사용방법

- 아래 방법은 mockito-kotlin 이 아니라 일반 mockito library 써야함



### source code

```kotlin
class MocktiToTest {
  @Captor
  lateinit var captor: ArgumentCaptor<TestDto>

  @Test
  fun test() {
     verify(testService).test(MockitoHelper.capture(captor))

     // captor.value.column1 검증
  }  
}


object MockitoHelper {
    fun <T> anyObject(): T {
        Mockito.any<T>()
        return uninitialized()
   }  

   @Suppress("UNCHECKED_CAST")
   fun <T> uninitialized() : T = null as T

   fun <T> eq(obj: T): T {
      return Mockito.eq(obj)
   }

   fun <T> capture(argumentCaptor: ArgumentCaptor<T>): T {
      return argumentCaptor.capture()
   }
}

```



### 참고

- https://v3.leedo.me/devs/44





# mockito MockStatic 예시

```kotlin
    @Test
    fun `test static method`() {
        val mockStatic: MockedStatic<MyClass> = Mockito.mockStatic(MyClass::class.java)

        mockStatic.use {
            `when`(MyClass.staticMethod()).thenReturn("Mocked Result")
            val result = MyClass.staticMethod()
            assertEquals("Mocked Result", result)
        }
    }
```

