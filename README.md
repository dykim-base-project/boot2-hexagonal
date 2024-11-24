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
  * api
    * input port 모듈
    * useCase 정의(UseCase 인터페이스)
    * 특이사항 - 도메인 id record
      * id 에 대한 명세, Validation 을 record 로 설정하여 관리함.
      * 값이 아닌 자료형 자체로 해당 도메인을 구분할 수 있다는 장점이 있음.
  * core
    * 도메인, output port/adapter 모듈
    * useCase 구현(Service 클래스)
    * 도메인 구현(domains 패키지)
    * output port 정의(domains.ports 패키지)
    * output adapter 구현(adapters 패키지)
  * server 
    * input adapter 구현 모듈
    * server 방식으로 구현(Spring Boot MVC)

#### 이슈 & 브랜치 관리
1. 이슈 생성
   * 깃허브에서 이슈 템플릿으로 이슈를 생성합니다.
   * 생성 시, 이슈 브랜치가 자동 생성됩니다.(GitHub Action create-issue-branch)
2. 브랜치 병합
   * 생성된 브랜치에 작업 후 PR 생성할 경우 프로젝트 빌드 테스트를 진행합니다. (GitHub Action gradle-build)

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
      * create-issue-branch: 이슈 작성 시 브랜치 자동 생성
      * gradle-build: main 브랜치로 PR 또는 main 푸시할 경우 gradle build 테스트 수행

# 도메인 별 명세서
[//]: # (주소 기준 캐싱되므로 변경 시, plantUML 온라인 서버 또는 기타 방법으로 이미지를 복사하여 github 이미지 캐시로 업데이트할 것)

## 1. 회원
### Sequence
![회원 Sequence](https://github.com/user-attachments/assets/7a885fe3-f859-4769-a7c6-775142aaf512)

### UseCase
![회원 Use](https://github.com/user-attachments/assets/2fb426f7-548e-4cbd-a22e-d100e66d658e)

### Domain
![회원 Domain](https://github.com/user-attachments/assets/5f75ba11-feb5-42b0-8377-34af9d859423)

## 2. 이메일
### Sequence
![이메일 Sequence](https://github.com/user-attachments/assets/57c122cc-1128-4936-bc46-4257bdac0f0e)

### UseCase
![이메일 UseCase](https://github.com/user-attachments/assets/28f965d1-e4ba-4328-9521-6dc19a5364cc)

### Domain
![이메일 Domain](https://github.com/user-attachments/assets/b4e80e93-1c7e-486c-ac35-980ca1986cc2)

## 3. 인증
### Sequence
![인증 Sequence](https://github.com/user-attachments/assets/cdaeca92-2c8a-42a6-a9a4-2a18217fe0ba)

### UseCase
![인증 UseCase](https://github.com/user-attachments/assets/a9387f3f-3d10-4d76-af5c-2aabba74daea)

### Domain
![인증 Domain](https://github.com/user-attachments/assets/2393ccaa-db87-4849-a2a2-99edd1b8bda4)

