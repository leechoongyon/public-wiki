# gradle, jdk, multimodule build 및 실행 dockerfile 작성

### 목적
- gradle, jdk, multimodule build 및 실행 dockerfile 작성
- gradle, jdk, multi module 기준
- multi module 이여서 필요한 submodule 여러개 있을 수 있어서 그걸 가정하고 copy 해야함
- build 할 때, 캐시 처리도 하기
- 중간중간 테스트 하기 위해 CMD sleep 1000000 을 걸어놓고 어느 지점에서 잘되는지 체크 가능
