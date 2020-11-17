# Spring  프로젝트 기획하기

해당 문서는 PMC 스프링 프로젝트를 기획하며 진행했던 내용을 정리한 문서입니다.

---

##  1. 프로젝트 주제 선정하기

 첫 스터디 모임. 첫 날은 간단히 스프링 프로젝트를 진행하면서 어떤 식으로 진행할 것인지에 대한 논의와 토이 프로젝트 주제를 선정했다. 주제는 회의하다가 15분간 생각해보고 그 자리에서 바로 어떤 주제로 하면 좋을지, 어떤 기능이 들어가면 좋을지를 대략적으로 생각해보고 공유했다.

첫 번째로 나온 주제는 카페 리뷰시스템으로, 대략적인 기능리스트는 아래와 같았다.

-   카페쿠폰발급
-   카페별점기능,리뷰기능(사진/글리뷰)
-   분위기/인스타용/스터디용등의그룹을나누어관리
-   가격정보를1단계, 2단계, 3단계로분류해서보여주기
-   위치로검색할수있는기능
-   메뉴로검색할수있는기능
-   휴일(영업시간저장)
-   예약기능추가 (추후)
-   지역별인기카페보기 (추후)

두 번째로 나온 주제는 지역 중심 기반 스터디로, 대략적인 기능 리스트는 아래와 같았다.

-   스터디등록기능\->지도기반으로변경
-   네이버/구글 지도 연동하여 화면에 지도 띄워주기
-   커뮤니티,메시지를보낼수있는기능
-   참고사이트) meetup,소모임앱
-   초기기능
    -   회원가입/스터디등록/리스트조회

두 가지 주제 내에서 투표한 결과, 주제는 2번인 지역 중심 기반 스터디로 하기로 결정되었다.

각자 추가적인 기능들을 더 고민해서 차주 평일 저녁에 온라인으로 UI/UX 기획을 진행하기로 하며 마무리 되었다.

---

##  2. UX 설계하기

UX 디자인 프로토타입을 설계하는데에는 다양한 툴이 있지만, 발사믹 목업을 사용하여 UX 설계를 진행했다.

발사믹 목업은 마치 PPT와 같이 편하게 사용할 수 있는 UX 프로토타입 설계 툴로 상당히 직관적이라 처음 접하는 사람도 사용하기 쉽다. (자세한 내용은 [링크](https://balsamiq.com/wireframes/) 참고)

발사믹 목업을 사용하여 설계한 UX는 아래와 같다.

[balsamiq.cloud/ssseu1y/pagmbma](https://balsamiq.cloud/ssseu1y/pagmbma)


<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FdU0Lyf%2FbtqNeHz7v8U%2FePMRiQ8FrKWp2luT3fh7A0%2Fimg.png" width="700">

이와 같이 발사믹 목업을 이용하면, 유저가 화면에서 어떤 것을 클릭했을 때 어떤 페이지로 이동할지를 편리하게 짤 수 있다. 목업으로 모든 페이지에 대한 설계를 한 것은 아니고, 메인 페이지를 어떤식으로 구성하고 상단바나 왼쪽바에 어떤 메뉴들이 구성될지를 정하고, 대략적인 페이지들만 작성했다.

작성한 페이지 리스트는 아래와 같다.

-   메인화면 (로그인 전/후)
-   주제별 펼쳐보기
-   주제별 메인
-   스터디 세부 내용
-   지역별 메인
-   지역별 사이드바
-   내모임 메인
-   회원가입
-   로그인
-   알림창
-   채팅창

---

###  3. 화면별 기능리스트 작성하기

 앞서 진행한 대략적인 UX 설계를 토대로, 각 화면에서 어떤 기능들이 필요할지 각자 작성해오기로 하였다. 또한 erd 설계를 위해 각 기능을 구현할 때 필요한 컬럼들을 정리해 오기로 하였다. 아래는 스터디 하면서 정리했던 각 화면별 기능리스트이다.

-   메인화면 (로그인 전/후)
    -   메인화면 / 주제-지역 별 스터디 모임 보기 / 내 스터디 이동
    -   스터디별 카테고리 보기
    -   스터디 검색 기능
        -   날짜 / 스터디원 / 제목 / 위치 / 스터디 제목으로 검색 가능
        -   리스트 페이징 처리 필요
        -   일정으로 검색하는 기능 (달력으로 해당 일/주/월에 있는 스터디를 확인 가능)
    -   주제별 스터디 리스트 보기
    -   지역별 스터디 리스트 보기
-   스터디 세부 내용
    -   아이디, 제목, 일정, 모임장, 멤버, 지역(위치), 카테고리, 기간, 정원, 일정(일정 id), 날짜, 설명
    -   날짜 세팅은 자동/수동 가능
        -   (수동) 직접 스터디 일정을 달력에 클릭하면 해당 날짜/시간으로 추가
        -   (자동) 특정 기간 내의 매주 토요일 n시로 설정하면 자동으로 해당 기간내에 날짜를 db에 추가
    -   모집/진행/종료 스터디장이 status 변경 가능
    -   모임 강퇴 기능 (스터디장만 권한)
    -   모임 설정 기능
-   내 모임 메인
    -   스터디 권한 설정
    -   즐겨찾기한 모임 보기
    -   내 스터디 일정 보기
    -   내가 가입한 스터디 리스트 보기
    -   스터디(모임) 만들기
        -   아무나 만들 수 있는 권한이 있음. (유저 평가를 보며 참가할지 정함)
-   프로필
    -   유저 평점
-   회원가입
    -   회원가입 / 약관 동의 / 기본은 이메일로 인증
    -   이후 oauth 연동하여 네이버/카카오/구글 연동 추가
-   로그인
    -   일반 로그인
    -   네이버/카카오/구글 oauth 연동 추가
-   알림창
    -   가입한 스터디의 일정을 보여주는 알림
    -   {스터디 제목} 시간 (날짜) 형식으로 알림
-   채팅창
    -   스터디별 채팅방 생성
    -   스터디장이 채팅방 설정 권한이 있음. (채팅방 공개 유무 등)
-   (추가 내용)
    -   인물평가가몇점이상이면유료스터디도개설이가능하다(혹은유료기능을사용할수있다.
    -   스터디원의스터디히스토리를관리해야함.
    -   스터디는무료,유료스터디가있다(컬럼필요)
    -   공공데이터를사용하는것은없음(스터디룸과같은것은아직기능상추가가안됨.)

기능리스트는 백엔드에서 어떤 서비스를 개발해야 하고 ERD를 설계할 때 어떤 것들이 고려되어야 하는지를 정리하기 위해 필요하다. 필요한 기능이 정리되지 않은 상태에서 무작정 개발을 시작하다보면 나중에 테이블의 형태나 연결관계가 변경될 가능성이 높으니 미리 정리하고 프로젝트를 시작하도록 하자.

---

## 마무리

다음 스터디에서는 ERD 설계를 하면서 고려한 사항들에 대해 정리해 보려 한다.