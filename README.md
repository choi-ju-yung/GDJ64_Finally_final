## 프로젝트 이름 및 로고 
![image](https://github.com/choi-ju-yung/GDJ64_Finally_final/assets/112717817/552e24c1-413c-4978-9b82-e809dde42847) 
<br>


## 🖥️ 프로젝트 소개
IT학원의 업무 효율성을 극대화하고 강사들 간의 원활한 협업을 강화하기 위한 그룹웨어 웹 서비스이며, 행정 업무와 강사들의 업무를 체계적으로 관리할 수 있는 다양한 기능을 제공
<br>

## 🕰️ 개발 기간
* 23.07.24일 - 23.08.21일

### 🧑‍🤝‍🧑 맴버구성
 - 팀장  : 조윤진 - 근태관리, 수업관리, 회의실 예약, 게시판(공지사항/부서별게시판)
 - 팀원1 : 최주영 - 전자결재 담당 (결재신청, 결재대기문서함, 기안문서함, 참조문서함, 임시저장함), 메인페이지, TODO리스트 구현
 - 팀원2 : 이은지 - 인사관리 담당. 로그인 및 이메일 인증 기능 구현. Spring Security 사용해 인증, 인가 처리. Springboot mail 사용
 - 팀원3 : 최하리 - 메신저 메뉴 담당 WebSocket 이용한 실시간 채팅 기능


### ⚙️ 개발 환경
![image](https://github.com/choi-ju-yung/GDJ64_Finally_final/assets/112717817/2f3397a0-d7b2-4862-9869-bed2b51525bd)


## 📌 주요 기능
#### 로그인 - <a href="https://github.com/chaehyuenwoo/SpringBoot-Project-MEGABOX/wiki/%EC%A3%BC%EC%9A%94-%EA%B8%B0%EB%8A%A5-%EC%86%8C%EA%B0%9C(Login)" >상세보기 - WIKI 이동</a>
- DB값 검증
- ID찾기, PW찾기
- 로그인 시 쿠키(Cookie) 및 세션(Session) 생성
#### 회원가입 - <a href="https://github.com/chaehyuenwoo/SpringBoot-Project-MEGABOX/wiki/%EC%A3%BC%EC%9A%94-%EA%B8%B0%EB%8A%A5-%EC%86%8C%EA%B0%9C(Member)" >상세보기 - WIKI 이동</a>
- 주소 API 연동
- ID 중복 체크
#### 마이 페이지 - <a href="https://github.com/chaehyuenwoo/SpringBoot-Project-MEGABOX/wiki/%EC%A3%BC%EC%9A%94-%EA%B8%B0%EB%8A%A5-%EC%86%8C%EA%B0%9C(Member)" >상세보기 - WIKI 이동</a>
- 주소 API 연동
- 회원정보 변경

#### 영화 예매 - <a href="https://github.com/chaehyuenwoo/SpringBoot-Project-MEGABOX/wiki/%EC%A3%BC%EC%9A%94-%EA%B8%B0%EB%8A%A5-%EC%86%8C%EA%B0%9C(%EC%98%81%ED%99%94-%EC%98%88%EB%A7%A4)" >상세보기 - WIKI 이동</a>
- 영화 선택(날짜 지정)
- 영화관 선택(대분류/소분류 선택) 및 시간 선택
- 좌석 선택
- 결제 페이지
- 예매 완료
#### 메인 페이지 - <a href="https://github.com/chaehyuenwoo/SpringBoot-Project-MEGABOX/wiki/%EC%A3%BC%EC%9A%94-%EA%B8%B0%EB%8A%A5-%EC%86%8C%EA%B0%9C(%EB%A9%94%EC%9D%B8-Page)" >상세보기 - WIKI 이동</a>
- YouTube API 연동
- 메인 포스터(영화) 이미지 슬라이드(CSS)
#### 1대1문의 및 공지사항 - <a href="" >상세보기 - WIKI 이동</a> 
- 글 작성, 읽기, 수정, 삭제(CRUD)

#### 관리자 페이지 
- 영화관 추가(대분류, 소분류)
- 영화 추가(상영시간 및 상영관 설정)
