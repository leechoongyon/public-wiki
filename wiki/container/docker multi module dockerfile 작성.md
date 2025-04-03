# gradle, jdk, multimodule build 및 실행 dockerfile 작성

### 목적
- gradle, jdk, multimodule build 및 실행 dockerfile 작성
- gradle, jdk, multi module 기준
- multi module 이여서 필요한 submodule 여러개 있을 수 있어서 그걸 가정하고 copy 해야함
- build 할 때, 캐시 처리도 하기
- 중간중간 테스트 하기 위해 CMD sleep 1000000 을 걸어놓고 어느 지점에서 잘되는지 체크 가능

### dockerfile
```dockerfile
FROM xxxxxx/image as builder  # 이미지를 가져옴
WORKDIR /user/test  # 작업 디렉터리 설정

USER root # user 설정
COPY .. /user/build # 현재 위치에서 한칸 위에 있는 위치 모든 폴더 파일들을 /user/build 로 copy
RUN chmod 644 /user/build/gradlew

WORKDIR /user/build
RUN --mount=type=cache, target=xxxxxx, uid, gid \
       ./gradlew :subModule:bootJar               

WORKDIR jar 파일 위치
CMD ["java", "-jar", xxxxx.jar"]  # 실행
```
