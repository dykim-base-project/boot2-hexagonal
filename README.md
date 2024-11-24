# boot2-hexagonal
스프링 부트2 헥사고날 아키텍쳐 프로젝트

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
  * api
    * input port 모듈
    * useCase 정의(UseCase 인터페이스)
  * core
    * 도메인, output port/adapter 모듈
    * useCase 구현(Service 클래스)
    * 도메인 구현(domains 패키지)
    * output port 정의(domains.ports 패키지)
    * output adapter 구현(adapters 패키지)
  * server 
    * input adapter 구현 모듈
    * server 방식으로 구현(Spring Boot MVC)

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
[//]: # (주소 기준 캐싱되므로 변경 시, plantUML 온라인 서버 또는 기타 방법으로 이미지를 복사하여 github 이미지 캐시로 업데이트할 것)

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

