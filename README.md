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
  * core 모듈 - output port, adapter
    * useCase 구현(Service 클래스)
    * 도메인 구현(domains 패키지)
    * output port 정의(domains.ports 패키지)
    * output adapter 구현(adapters 패키지)
  * server 모듈 - input adapter
    * server 방식으로 구현(Spring Boot MVC)

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
![Sequence](https://www.plantuml.com/plantuml/png/nLNDJjjS4DtxAQxoRK0etmD41D6gtNR3ikh24AkDb1_asApxuo9KWWGY5JID8wAcLP6ev2P1PG4lb3jvXqxYoOtdrd5YHMfta7lcPywSETwkEQRjkEMIOUuvLLjauEqDDA-XVPeHPasuDSiszX5Ht2lkcnL7P4RDEdmE7yjMULT_1dyWhnlWtmlmx-2RFm5QPRDOUkGwhpXsvzbE55Mhr98m0hoMx7bHw8vb7-WDgFw5QaLDydJSXr4m7NFNh5aYy-JnvAcmQnZvV7uM86J_3ejE2m_xzt3rKUJpXkawrOexcNgSJsItPhFbX3wxaBsZqIMcQJQWzyCmIuuXn4kxwkv7e66_0hfduuh3tWCq0uIfj2ARVVwVRHLUR4r6o8dDlMgfQkVmfwsuB9ZwJ1xV6bQbOAWal56zlRO7noq1xtpmVl8OHTeVCLSU77OO66cCK408CRmBPCV7_rv3-siKJzdZ4oCF0R8-dMKPiedbjGsUS3sf9giIQY2KjnW6sE_xjOEY-V-iqdgy1EWESZnsRZyXUi4qj8quwN1jmd5tLF-EZ_egw8KlO5bXiUGHHStJCC4x0sZVfEXbGk1cs4KsEmlZlNJFPF-MMENgvbNcahX1VsZrQH6Rl3A58do8LQaSGQaExHazGVO7E7M0Ft1cRbimEAAMsLad9QAsSBHOZH1Q7ShH9SQHG6Au8D6T1CZAo0lWuZGsGIXYpe7YMd6WpaDsMiDVO_sbF0qLHmqlkW8TltZPSNlGIH1mSIW_D9ZBhdWqL08JWrzFuRsZmwlH6sp8w-8Iec15sb9IL3pnbjLMunRmoPDVwejC3x-xsavrPX4juA4XpriOVoBFVNoShfs-ppaDHxiKqtU4ya_vt00rJp9SqR-iDxDuycO-0HAnq9C9n4qGCwItG5Lshklnj37jRSotEPMTI-gVsPkYETdS4BIQjM62bCQ6jAvWQKmyEYvfW-ajR2MP9TWNlz04w-BrYTh54lmxvhQDexZbqcy0)

## UseCase
![UseCase](https://www.plantuml.com/plantuml/png/XPDDIiD05CVtESNGJNNX5QGYRjtq06LCXXZCHyaaRgHGQXKNBWGhIcrAkn4A2h48Tg4NIfztC3FFC1acuAQTpl_ttlzzJ3iyeN6I1hvbKJk9OjA2qIjCLp2_Qn7AISfPR5bzQfzHbv7Mp_GMdb49M732Od9X4RA3rwJ8Xp2_sXKgzzmmxGjjkvmLdnl8DlBUZrmlj0QrbAK2Bnc1nxnOvp8pJPFJdXs58PCLcGu4Osf6FH6ZkTKOD4L4T_xOhYQGVVsnqfm5rFCbYyPLUT-JxVsCm68CrqiqPg5pK6A7aSCGrBEHOZsi2ZYdlkVGX1s9v2AeCG0kCnY_om0xPl_ZoxoSYiHTbYYstGZVFC7YGS9fNo-bcH-zmM8cUOVvJF7w2Bl7tVhmUCXherEYsLetvDYOmeoMAgQjGMOh9jVKWk86bdZLP6zVto5UbhVcjbG0Fcly4h3s_cfdeHbRD7Hj5Ae0_9F8J_KRBTHHAFhYJQrAtIdxJ0F_5m00)

## Domain
![Domain](https://www.plantuml.com/plantuml/png/fLHVIzjG57_FfpZqfNKimRctiQbbblrHh4m7srE8pTK6cxHBRhQ921KgZDanXPQvsRW9GoS8wx1g1twYt9lli6DkpUxQuP2zz9vxJiuvlpz9nprgkDItIuf27Dy6mwT5tIQqM3PXHG6u_oINdSjXy7HcGWGJkQbS74pb7poQLbOLfL0oF0zIFEYmmmOFpe47NRuVfC3mWDY6LT8lfiRZRe1bug6gAlxQn9udhXvdUi-Pfaiy3-yL7Fcgx9fNp8UmssPx_MlqekNHihkSh0CLvgr5ow5NxSL6SPVuuytp2mM1noKlVE9HtQhW1O4jNGuekCIWnDGDYb0bjkhANq0fWodGj55vQy-7rEpqh3xtV2ONq_CSJwVB5HAJcinEPlCAOACcgOFFoxfZnxzLJ-QAKEHSie0U57LQNYAET2UlAvOhY0vkbTqGow_lHT8sWEt_J4caGA6JeKbILLS6y8hg5IOb_ADFTRwp6PCMJ6AgVMGpZsUoy704MBtAWoqUr82tQb6p0xxZMOiECU7PKDmb905m39l0IyCj50qtCp8iYXurgE_rfMMgO690BPjaRekINJQj1MkW9jd7zbhXMHSDbDqhbH7qzQoJdUXJ_yzfgsglJH47tDKqI0rhsgsKzBb8nT_cA4gwXpeyhKVDLWgXfG40iOaJKOb0rE7UA2H_6RfuIMzA6VQzUvcy-DP4F2OcyBTVeqQD7Qm1tsX5Qvji_oZQQADQ49uSHTjetZPV_yQ3kWQiqMR1UTYkikCEtztKCknzBTw0qpl0cpMsKGz_j25iV-H1bRt3wApBFX-nmywGaaOhqZ2NdyZV0NxQY7Pgm7Ut-8TruDjl-9ScKfRVCxMFkSZ60aYy1_KuERx04dQguN4DelKwtbYt4VwiyuFgM0nYd3YcRvT-0G00)

