# boot2-hexagonal
스프링 부트2 헥사고날 아키텍쳐 프로젝트

# 프로젝트 스펙
* Skill set
  * Spring boot 2 / Gradle build
  * java 17
* Architecture
  * hexagonal
  * spring multi module
* Module
  * TBD

# 도메인 별 명세서
## 1. 회원
### Sequence
![회원 Sequence](http://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/dykim-base-project/boot2-hexagonal/main/.uml/member/Sequence.puml)

### UseCase
![회원 UseCase](http://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/dykim-base-project/boot2-hexagonal/main/.uml/member/UseCase.puml)

### Domain
![회원 Domain](http://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/dykim-base-project/boot2-hexagonal/main/.uml/member/Domain.puml)

## 2. 이메일
### UseCase
![이메일 UseCase](http://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/dykim-base-project/boot2-hexagonal/main/.uml/email/UseCase.puml)

### Domain
![이메일 Domain](http://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/dykim-base-project/boot2-hexagonal/main/.uml/email/Domain.puml)

## 3. 인증
### UseCase
![인증 UseCase](http://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/dykim-base-project/boot2-hexagonal/main/.uml/authentication/UseCase.puml)

### Domain
![인증 Domain](http://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/dykim-base-project/boot2-hexagonal/main/.uml/authentication/Domain.puml)

