# 데이터베이스 버전 관리용 Flyway
> 데이터베이스 스키마를 버전으로 구분하여 관리하기 위한 Flyway 입니다.

## flyway 실행
### local
.flyway 경로에서 docker-compose 실행
```shell
docker-compose up -d
# or
docker compose up -d
# or
nerdctl compose up -d
```

프로젝트 root 경로에서 gradlew flyway 실행
```shell
./gradlew flywayMigrate -Pflyway-profile=local
```

.flyway 경로에서 docker-compose 종료
```shell
docker-compose down
# or
docker compose down
# or
nerdctl compose down
``` 
