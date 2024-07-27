# 내용
- https://hub.docker.com/r/doctorkirk/oracle-19c 보고 설치 진행
- https://github.com/oracle/docker-images 제공하는 oracle 이미지
- UPL license (https://olis.or.kr/license/Detailselect.do?lId=1124&mapCode=010015) 

# docker oracle 실행
- KO16KSC5601 euc kr CHARACTERSET

```shell
docker run --name oracle-19c -p 1521:1521 -e ORACLE_SID=test -e ORACLE_PWD=test1234 -e ORACLE_CHARACTERSET=KO16KSC5601 doctorkirk/oracle-19c
```

- 명령어 실행 시, 이런식으로 나옴 
  - 노트북이 안좋아서 그런가.. 20분이 넘어도 46% 에서 넘어가지를 않네..
```text
Prepare for db operation
10% complete
Copying database files
40% complete
Creating and starting Oracle instance
42% complete
46% complete
```

- oracle container 접속
```shell
docker exec -it container_id /bin/bash
```  

- sysdba 접속
```shell
sqlplus / as sysdba
```  

- 계정생성
```shell
create test identified by test1234;
```

# 시행착오
- docker run 실행 시, 해당 이름이 이미 있다고 할 경우 
  - docker rm oracle-19c
