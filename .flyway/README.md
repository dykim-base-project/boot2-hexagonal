# flyway 실행

## local
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
