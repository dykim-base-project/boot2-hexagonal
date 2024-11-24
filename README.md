# boot2-hexagonal
스프링 부트2 헥사고날 아키텍쳐 프로젝트

# 프로젝트 스펙
#### 스킬 셋
  * Spring boot 2 / Gradle build
  * java 17

#### 테스트
  * Groovy / Spock Framework

#### 아키텍쳐
  * Hexagonal
  * Spring multi module

#### 멀티 모듈 구조
  * api
    * useCase - input port
  * core
    * domain - business logic
    * repository - output port
    * adapter - output adapter
  * server 
    * input adapter

#### 기타
  * flyway
    * database migration
    * DDL sql validate
  * uml
    * UseCase, Sequence, Domain
  * github
    * issue template
    * action
      * auto create issue branch
      * gradle build

# 도메인 별 명세서
## 1. 회원
### Sequence
![회원 Sequence](http://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/dykim-base-project/boot2-hexagonal/main/.uml/member/Sequence.puml)

### UseCase
![회원 UseCase](http://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/dykim-base-project/boot2-hexagonal/main/.uml/member/UseCase.puml)

### Domain
![회원 Domain](http://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/dykim-base-project/boot2-hexagonal/main/.uml/member/Domain.puml)

## 2. 이메일
### Sequence
![이메일 Sequence](http://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/dykim-base-project/boot2-hexagonal/main/.uml/email/Sequence.puml)

### UseCase
![이메일 UseCase](http://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/dykim-base-project/boot2-hexagonal/main/.uml/email/UseCase.puml)

### Domain
![이메일 Domain](http://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/dykim-base-project/boot2-hexagonal/main/.uml/email/Domain.puml)

## 3. 인증
### Sequence
![인증 Sequence](http://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/dykim-base-project/boot2-hexagonal/main/.uml/authentication/Sequence.puml)

### UseCase
![인증 UseCase](http://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/dykim-base-project/boot2-hexagonal/main/.uml/authentication/UseCase.puml)

### Domain
![인증 Domain](http://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/dykim-base-project/boot2-hexagonal/main/.uml/authentication/Domain.puml)

