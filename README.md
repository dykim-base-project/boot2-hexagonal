# boot2-hexagonal
> 헥사고날 아키텍쳐를 적용하기 위한 프로젝트 입니다.  
> 각 영역(port, adapter) 에 대해 멀티 모듈 프로젝트로 분리하여 관리하고 있습니다. 

# 프로젝트 스펙
#### 스킬 셋
  * Spring boot 2 / Gradle build
  * Java 17

#### 테스트
  * Groovy4 / Spock Framework

#### 아키텍쳐
  * Hexagonal
  * Spring multi module

#### 멀티 모듈 구조 설명
  * api 모듈 - input port
    * useCase 정의(UseCase 인터페이스)
    * 특이사항 - 도메인 id record
      * id 에 대한 명세, Validation 을 record 로 설정하여 관리함.
      * 값이 아닌 자료형 자체로 해당 도메인을 구분할 수 있다는 장점이 있음.
  * core 모듈 - input adapter, output port/adapter
    * input adapter 구현(Service 클래스)
    * 도메인 구현(domains 패키지)
    * output port 정의(domains.ports 패키지)
    * output adapter 구현(adapters 패키지)
    * 특이사항
      * 과도한 UseCase 생성을 방지하기 위해 동일 모듈 기준 Service 영역에서 다른 UseCase 호출을 허용합니다.
  * server 모듈 - 웹 연동
    * 하위 모듈을 종합하여 하나의 스프링 어플리케이션으로 종합하는 상위 모듈 (Spring Boot MVC)

#### 이슈 & 브랜치 관리
1. 이슈 생성
   * 깃허브에서 이슈 템플릿으로 이슈를 생성합니다.
   * 생성 시, 이슈 브랜치가 자동 생성됩니다.(GitHub Action create-issue-branch)
2. PR 생성
   * PR 생성 시 빌드 및 테스트 커버리지를 기록합니다. (GitHub Action pr-build-test-coverage-report.yml)
3. PR 병합
   * 병합 시, main 브랜치 기준 프로젝트 빌드 테스트를 진행합니다. (GitHub Action main-build.yml) 

#### 기타
  * .flyway
    * 데이터베이스 마이그레이션 툴
    * DDL 쿼리 검증용으로 사용함
  * .uml
    * UseCase, Sequence, Domain uml
  * .github
    * 깃허브 설정용 디렉토리
    * issue template - 이슈 작성용 markdown 템플릿
    * workflows - gitHub action
      * create-issue-branch
        * 이슈 작성 시 브랜치 자동 생성
        * PR 생성 시 이슈와 자동 연결
      * build-test-coverage-report
        * main 브랜치로 PR 또는 main 푸시할 경우 gradle build 테스트 수행
        * jacoco test coverage report 코멘트 생성

# 명세서
[//]: # (주소 기준 캐싱되므로 변경 시, plantUML 온라인 서버 또는 기타 방법으로 이미지를 복사하여 github 이미지 캐시로 업데이트할 것)

## Sequence
![Sequence](https://uml.planttext.com/plantuml/png/VPFBJi9058RtynGdRDGGO4-iGUDQ5pn1WKP8Ui5Uzbwg0N61YIO4AO7444qmLiJOP-fCty7Jbi42nLqpv_l_yvypqv9XYhffAJBPgPjcqoWM2arPLCEJV5LJ2ePqRabgLShL6kAPBYg4Y5LJqo73hgQi_yQ6tGo81bY6f9CcEZMgZIRAiUvuRE94HT4owwl5qqCy0cOFwCoE46sJ2Vhtx3bsLoIbikv_V1ILQXLCP9cQQaK84GG1w7ZW_tWO00I1XCaWTn25A4Bvf9mei_uZcxs7-dg8Q3635T-zWE1s55owd8bizdCv3gKQyLxfpCYcdUc6KRmdtYqBT3AbdHVcpEce7TnvOEaoCW-qyxqsoa91tO7ljRUCifr99E23nlcM5hLA4NpFPUCvpyZ6BbuA4MLpzOHsN_C482dazT4J_K9zguTVH98D2UY7XvPiE4qeull59D6L0swV3MzuN5YKao0dPZrSrmeHDb_OyERN3hC_URTmxhLsd8kN_EySaTLkbYlfh1Nql3qYgJMIeiBjqR730oI1lrUHpgG-n1XPlfzK9fw1b30H_i6_)

## UseCase
![UseCase](https://uml.planttext.com/plantuml/png/TP9FJy8m6CRl_HHlTX4Eo9q3mN1LEU0Ng5k51RQIhJiOO-8VGZHoqAY9uaRmOcBY0Ks8k_Y5MFSTR8UoTGkNfUtxs_CyR_isN8OTvbbzjDLbRE3MgjL17zloP5kdLjLpIKN7ucEOkEDW2o6iC-g0nYy--EITJsyrm2u8p45eWFKUxX3GuicOlwmg5h4EYGCd22GafQ34BmC-_2odvQP3C2CASlN4PuyPP8yQvj4nEisuy23aRq7YWZtMLJrQE_8eUlMNtw404oKgiLtQCUqi6OzcyVaSehc_3AyJpdHTZyZ_3sYFs8hdIfOF_UXhgAqrS-q5uN9-1lpd8Rht2xg9GfCQf9XsGvAM4aLUDLJgsMRI9LH49MUZRg40rA2ztqvlghH-MVuicXYDuz6YN10HAZ983THcUN0NtIp-CluxfV7LRIxiHaIPaNozhiu7QX3R4CFx2m00)

## Domain
![Domain](https://uml.planttext.com/plantuml/png/fP91Im9H58NtyoikRjhCvBwLin03mu64DkBYfQ83Coepuo8YKBGQKAY5aPKJ2Y45BIQrceNzeNdt_OUUCw8Yug8s3ywxl7k-StWnqoA6LTCrOQzaMLNp81gjQgGylzdFLVHeJYEcAULLKZI8BWY1X0XxxE3JRGI82Nf1FoqOS2u0g7b-I9B4ptGg3UXCwLiNdHbaqF5mvFYJ6U2zIsyUHA2JkZ_-0Vfb-suzorzWiy6QVSY4gqLWJPjTJyE9WwqFlcw6xVvA1svezt1mjpOBDPzTB67fiEz_Unm1VC-bGoV0rYf5jNoecbR5EDk43n4M1W4vfwdZy-LcCAvNozNgMWeEw4y-HS3s2-kyxawn8WtD0ZvIiqe1rmA6ZctMypQ1CaavAIiY91GbSHGN8IMVn8-poo1qzCwwBJgmkIMmgm5hk5iY_BVV1T5QkNFutTrkZxCLxa-5nWhbFF_2lm00)

