# 실행 명령어
```shell
colima start --cpu 4 --memory 8

// mysql 9.x 버전은 x86 64 에러가 남
docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=test1234 -d -p 3306:3306 mysql:8.0.35

docker exec -it mysql-container /bin/bash

mysql -u root -p
(password test1234)

CREATE USER 'test100'@'%' IDENTIFIED BY 'test1234';

GRANT ALL PRIVILEGES ON *.* TO 'test100'@'%' WITH GRANT OPTION;

CREATE DATABASE testdatabases;

FLUSH PRIVILEGES;


mysql client tool 
url : jdbc:mysql://localhost:3306/testdatabases
user : test100
password : test1234
```

