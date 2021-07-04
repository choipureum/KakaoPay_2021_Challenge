<div class="assignment-topbar-wrap">
  <div class="assignment-topbar">
    <h6 class="title">2021 카카오페이 서버 개발자 과제 챌린지 for 최푸름</h6>
    <div class="topbar-button-group">
        <a onclick="Hera.assignmentChallenges.showChannelIO()" class="btn-topbar btn-chatting" data-remote="true" href="#">
          <span class="btn-topbar-icon">
            <svg class="ic-20 btn-topbar-icon__svg"><use xlink:href="/assets/svg-defs-85c488ea18b5a12778df9adc779a4ea8c1a0fdbb2da2f65a3812b7dfb19f6045.svg#ic-chat"/></svg>
          </span>
          <span>감독관 채팅</span>
</a>        <a class="btn-topbar btn-message-archive" data-remote="true" href="/tests/27145/notices">
          <span class="btn-topbar-icon">
            <svg class="ic-18 btn-topbar-icon__svg"><use xlink:href="/assets/svg-defs-85c488ea18b5a12778df9adc779a4ea8c1a0fdbb2da2f65a3812b7dfb19f6045.svg#ic-inbox-massage"/></svg>
          </span>
          <span>메시지 보관함</span>
</a>    </div>
  </div>
  <div class="assignment-nav nav nav-tabs-dark">
    <h6 class="description">vscode editor를 이용해 주어진 과제를 완료하세요.</h6>
    <ul class="list-options">
      <div id="responsive-dropdown" class="option-items-dropdown">
        <button id='js-responsive-dropdown' class="btn btn-dark btn-md responsive-dropdown-btn" role="button" data-target="#responsive-dropdown">
          메뉴<svg class="ic-16"><use xlink:href="/assets/svg-defs-85c488ea18b5a12778df9adc779a4ea8c1a0fdbb2da2f65a3812b7dfb19f6045.svg#ic-keyboard-arrow-down"/></svg>
        </button>
        <div class="dropdown-option-wrap">
          <li class="option-item"><button class="btn btn-dark btn-md" id="vscode-restart" disabled>vscode 재시작</button></li>
          <li class="option-item">
            <button class="btn btn-dark btn-md" data-toggle="modal" data-target="#challengeable-modal">문제 보기</button>
          </li>
          <li class="option-item">
            <a class="btn btn-dark btn-md" data-remote="true" href="/help_vscode">도움말</a>
          </li>
          <li class="option-item" data-toggle="tooltip" data-placement="bottom" data-original-title="버튼을 누르기 전 터미널에서 서버를 실행해주세요.">
            <button class="btn btn-primary btn-md" rel="noopener" data-url="#" data-test-token-id="1151009" id="vscode-launch" disabled>실행</button>
          </li>
            <li class="option-item">
              <button class="btn btn-primary btn-md" id="vscode-submit" disabled>최종 제출 및 테스트 종료</button>
            </li>
        </div>
      </div>
        <li class="option-item option-item-timer">
          <span class="timer text-xs-left hidden">
      <span class="end-label">종료까지</span><br>
      <span class="time"></span>
  </span>

        </li>
    </ul>
  </div>
</div>

<div class="modal fade" tabindex="-1" role="dialog" ref="modal" id="challengeable-modal">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        <h3 class="modal-title">문제 보기</h3>
      </div>
      <div class="modal-body">
        <div class="markdown github"><h1>카카오페이 서버개발 과제</h1>

<h2>안내</h2>

<p>과제 수행 및 제출은 프로그래머스 테스트 페이지 내의 VS Code로 진행하실 수 있습니다.</p>

<p>▪ 로컬 IDE 등 다른 환경에서 진행하는 것 또한 가능은 하나, 제출한 코드의 실행과 평가는 프로그래머스에서 제공하는 VS Code 환경에서 이루어집니다. 다른 IDE 사용과 관련하여 생기는 문제에 대해서는 프로그래머스에서 책임지지 않습니다.<br>
▪ 또한, 제출하려는 정답 코드나 문제와 관련된 코드를 public git repo에 올리는 것은 불가합니다.</p>

<p>익스텐션을 설치하신 후 정상적으로 실행이 안 되는 경우, 화면을 새로고침 (F5 또는 ctrl + R)을 한 후 정상적으로 작동하는지 확인해주세요.</p>

<p>▪ 다만, 웹 vscode의 마켓플레이스에서 설치할 수 있는 익스텐션은 프로그래머스 쪽에서 공식 지원하는 기능들이 아니기 때문에 개별 익스텐션의 정상 동작이나 테스트에 미칠 영향에 대해서는 프로그래머스 측에 문의하셔도 답변을 드리기 어려운 점 참고 부탁드립니다.</p>

<h1>Introduction</h1>

<hr>

<p>카카오페이에는 멤버십 적립 서비스가 있습니다.</p>

<p>▪ 사용자는 원하는 멤버십을 등록할 수 있습니다.<br>
(멤버십은 해피포인트, 신세계포인트, CJ ONE 3가지만 존재합니다.)<br>
▪ 포인트 적립비율은 결제금액의 1%로 고정됩니다.<br>
▪ 멤버십 사용에 대한 기능은 만들지 않습니다.</p>

<p>이번 과제에서는 UI를 제외한 RETS API를 구현하는 것이 목표입니다.</p>

<p>위 목표와 아래의 요구사항을 만족하는 API 서비스를 자유롭게 정의하여 구현해주시면 됩니다.</p>

<h1>기능 요구 사항</h1>

<hr>

<p>멤버십 연결하기, 나의 멤버십 조회, 멤버십 연결끊기, 포인트 적립 API 를 구현합니다.<br>
요청한 사용자 식별값은 문자열 형태이며 &quot;X-USER-ID&quot; 라는 HTTP<br>
Header 로 전달됩니다. 이 값은 포인트 적립할때 바코드 대신 사용됩니다.<br>
(SpringSecurity는 사용하지 않습니다.)<br>
Content-type 응답 형태는 application/json(JSON) 형식을 사용합니다.<br>
각 기능 및 제약사항에 대한 단위테스트를 반드시 작성합니다.</p>

<h1>요구사항에 따른 상세 기술 구현 사항</h1>

<hr>

<p><strong>1 멤버십 전체 조회</strong><br>
다음의 요건을 만족하는 나의 멤버십 조회 API 를 작성해주세요.</p>

<ul>
<li>모든 멤버십을 조회합니다.</li>
<li>사용자 식별값을 입력값으로 받습니다.</li>
<li>나의 멤버십 조회 응답은 다음 내용을 포함합니다.

<ul>
<li>멤버십 ID, 멤버십 이름, 포인트, 멤버십상태(활성, 비활성), 가입 일시</li>
</ul></li>
</ul>

<p><strong>2 멤버십 등록하기</strong><br>
다음의 요건을 만족하는 멤버십 등록하기 API 작성해주세요.</p>

<ul>
<li>사용자 식별값, 멤버십 ID, 멤버십 이름, 포인트를 입력값으로 받습니다.</li>
<li>나의 멤버십 응답은 다음 내용을 포함합니다.

<ul>
<li>멤버십 ID, 멤버십 이름</li>
</ul></li>
</ul>

<p><strong>3 멤버십 삭제(비활성화)하기</strong><br>
다음의 요건을 만족하는 멤버십 삭제(비활성화)하기 API 를 작성해주세요.</p>

<ul>
<li>멤버십을 비활성화 상태로 변경합니다.</li>
<li>사용자 식별값, 멤버십 ID를 입력값으로 받습니다.</li>
</ul>

<p><strong>4 멤버십 상세조회</strong><br>
다음의 요건을 만족하는 멤버십 상세 조회 API 를 작성해주세요.</p>

<ul>
<li>사용자 식별값, 멤버십 ID를 입력값으로 받습니다.</li>
<li>나의 멤버십 응답은 다음 내용을 포함합니다.

<ul>
<li>멤버십 ID, 멤버십 이름, 사용자 식별값, 포인트, 가입일시,멤버십 상태(활성, 비활성)을 응답합니다.</li>
</ul></li>
</ul>

<p><strong>5 포인트 적립</strong><br>
다음의 요건을 만족하는 멤버십 포인트 적립 API 를 작성해주세요.</p>

<ul>
<li>사용자 식별값, 멤버십 ID, 사용 금액을 입력값으로 받습니다.</li>
<li>포인트 적립은 결제 금액의 1%가 적립됩니다.</li>
</ul>

<h1>기술 요구 사항</h1>

<p>▪ 개발 언어 Java 8 or Kotlin<br>
▪ Framework - Spring Boot<br>
▪ Persistence Framework - JPA<br>
▪ 데이터베이스 mysql / redis / H2 활용 가능</p>

<ul>
<li>mysql ( host: mysql-server, port: 3306, user: root, password: password )</li>
<li>redis ( host: redis-server, port: 6379 )</li>
</ul>

<p>▪ 에러응답, 에러코드는 자유롭게 정의해주세요.<br>
▪ 개발 편의를 위해 2가지 라이브러리를 사용할수 있습니다.</p>

<ol>
<li>commons.lang3</li>
<li>guava</li>
</ol>

<h1>평가항목</h1>

<hr>

<p>과제는 다음 내용을 고려하여 평가하게 됩니다.</p>

<p>▪ 프로젝트 구성 방법 및 관련된 시스템 아키텍쳐 설계 방법이 적절한가?<br>
▪ 요구사항을 잘 이해하고 구현하였는가?<br>
▪ RESTAPI 의 응답 포맷이 일정한가?<br>
▪ DB 테이블 설계 및 쿼리는 효율적으로 작성 되었는가?<br>
▪ 예외처리를 적절하게 하였는가?(예외 타입별로 HTTP STATUS 코드의 처리가 적절한지)<br>
▪ 작성한 테스트 코드는 적절한 범위의 테스트를 수행하고 있는가? (예. 유닛/통합 테스트 등)</p>

<h1>API 명세서</h1>

<h2>요청공통</h2>

<h3>헤더</h3>
<table class="table">
        <thead><tr>
<th>항목</th>
<th>값(예)</th>
<th>설명</th>
</tr>
</thead>
        <tbody><tr>
<td>Content-Type</td>
<td>application/json</td>
<td>JSON 형태 사용</td>
</tr>
<tr>
<td>X-USER-ID</td>
<td>test1</td>
<td>사용자 식별값</td>
</tr>
</tbody>
      </table>
<h2>응답 공통</h2>

<h3>HTTP 응답코드</h3>
<table class="table">
        <thead><tr>
<th>응답코드</th>
<th>설명</th>
</tr>
</thead>
        <tbody><tr>
<td>200</td>
<td>성공</td>
</tr>
<tr>
<td>400</td>
<td>잘못된 요청</td>
</tr>
<tr>
<td>404</td>
<td>찾을 수 없음</td>
</tr>
<tr>
<td>500</td>
<td>내부 서버 오류</td>
</tr>
</tbody>
      </table>
<h3>헤더</h3>
<table class="table">
        <thead><tr>
<th>항목</th>
<th>값</th>
<th>설명</th>
</tr>
</thead>
        <tbody><tr>
<td>Content-Type</td>
<td>application/json</td>
<td>JSON 형식 응답</td>
</tr>
</tbody>
      </table>
<h3>내용</h3>
<table class="table">
        <thead><tr>
<th>이름</th>
<th>타입</th>
<th>필수</th>
<th>설명</th>
</tr>
</thead>
        <tbody><tr>
<td>success</td>
<td>boolean</td>
<td>O</td>
<td>성공 여부</td>
</tr>
<tr>
<td>response</td>
<td>object</td>
<td>O</td>
<td>성공 응답 내용</td>
</tr>
<tr>
<td>error</td>
<td>object</td>
<td>O</td>
<td>에러 응답 내용</td>
</tr>
</tbody>
      </table>
<h3><strong>응답 예</strong></h3>

<p>정상처리 및 오류처리 모두 success 필드를 포함합니다.</p>

<ul>
<li>정상처리라면 true, 오류처리라면 false 값을 출력합니다.
정상처리는 response 필드를 포함하고 error 필드는 null 입니다.
오류처리는 error 필드를 포함하고 response 필드는 null 입니다. error 필드는 status, message 필드를 포함합니다.</li>
<li>status : HTTP Response status code 값과 동일한 값을 출력해야 합니다.</li>
<li>message : 오류 메시지가 출력 됩니다.</li>
</ul>
<div class="highlight"><pre class="codehilite"><code><span class="err">정상</span><span class="w"> </span><span class="err">처리</span><span class="w">
</span><span class="p">{</span><span class="w">
   </span><span class="s2">"success"</span><span class="p">:</span><span class="kc">true</span><span class="p">,</span><span class="w">
   </span><span class="s2">"response"</span><span class="p">:[</span><span class="w">
      </span><span class="p">{</span><span class="w">
         </span><span class="s2">"seq"</span><span class="p">:</span><span class="mi">1</span><span class="p">,</span><span class="w">
         </span><span class="s2">"membershipId"</span><span class="p">:</span><span class="s2">"spc"</span><span class="p">,</span><span class="w">
         </span><span class="s2">"userId"</span><span class="p">:</span><span class="s2">"test1"</span><span class="p">,</span><span class="w">
         </span><span class="s2">"membershipName"</span><span class="p">:</span><span class="s2">"happypoint"</span><span class="p">,</span><span class="w">
         </span><span class="s2">"startDate"</span><span class="p">:</span><span class="s2">"2021-06-20T14:48:29.831"</span><span class="p">,</span><span class="w">
         </span><span class="s2">"membershipStatus"</span><span class="p">:</span><span class="s2">"Y"</span><span class="p">,</span><span class="w">
         </span><span class="s2">"point"</span><span class="p">:</span><span class="mi">120</span><span class="w">
      </span><span class="p">},</span><span class="w">
      </span><span class="p">{</span><span class="w">
         </span><span class="s2">"seq"</span><span class="p">:</span><span class="mi">2</span><span class="p">,</span><span class="w">
         </span><span class="s2">"membershipId"</span><span class="p">:</span><span class="s2">"shinsegae"</span><span class="p">,</span><span class="w">
         </span><span class="s2">"userId"</span><span class="p">:</span><span class="s2">"test1"</span><span class="p">,</span><span class="w">
         </span><span class="s2">"membershipName"</span><span class="p">:</span><span class="s2">"shinsegaepoint"</span><span class="p">,</span><span class="w">
         </span><span class="s2">"startDate"</span><span class="p">:</span><span class="s2">"2021-06-20T14:48:30.011"</span><span class="p">,</span><span class="w">
         </span><span class="s2">"membershipStatus"</span><span class="p">:</span><span class="s2">"Y"</span><span class="p">,</span><span class="w">
         </span><span class="s2">"point"</span><span class="p">:</span><span class="mi">3500</span><span class="w">
      </span><span class="p">},</span><span class="w">
      </span><span class="p">{</span><span class="w">
         </span><span class="s2">"seq"</span><span class="p">:</span><span class="mi">3</span><span class="p">,</span><span class="w">
         </span><span class="s2">"membershipId"</span><span class="p">:</span><span class="s2">"cj"</span><span class="p">,</span><span class="w">
         </span><span class="s2">"userId"</span><span class="p">:</span><span class="s2">"test1"</span><span class="p">,</span><span class="w">
         </span><span class="s2">"membershipName"</span><span class="p">:</span><span class="s2">"cjone"</span><span class="p">,</span><span class="w">
         </span><span class="s2">"startDate"</span><span class="p">:</span><span class="s2">"2021-06-20T14:48:30.043"</span><span class="p">,</span><span class="w">
         </span><span class="s2">"membershipStatus"</span><span class="p">:</span><span class="s2">"N"</span><span class="p">,</span><span class="w">
         </span><span class="s2">"point"</span><span class="p">:</span><span class="mi">1029</span><span class="w">
      </span><span class="p">}</span><span class="w">
   </span><span class="p">],</span><span class="w">
   </span><span class="s2">"error"</span><span class="p">:</span><span class="kc">null</span><span class="w">
</span><span class="p">}</span><span class="w">
</span><span class="err">오류</span><span class="w"> </span><span class="err">처리</span><span class="w">
</span><span class="p">{</span><span class="w">
   </span><span class="s2">"success"</span><span class="p">:</span><span class="kc">false</span><span class="p">,</span><span class="w">
   </span><span class="s2">"response"</span><span class="p">:</span><span class="kc">null</span><span class="p">,</span><span class="w">
   </span><span class="s2">"error"</span><span class="p">:{</span><span class="w">
      </span><span class="s2">"message"</span><span class="p">:</span><span class="s2">"membershipId must be provided"</span><span class="p">,</span><span class="w">
      </span><span class="s2">"status"</span><span class="p">:</span><span class="mi">400</span><span class="w">
   </span><span class="p">}</span><span class="w">
</span><span class="p">}</span><span class="w">
</span></code></pre></div>
<h2>1. <strong>멤버십 전체조회하기 API</strong></h2>

<h3>요청</h3>
<table class="table">
        <thead><tr>
<th>항목</th>
<th>값</th>
</tr>
</thead>
        <tbody><tr>
<td>URL</td>
<td>GET /api/v1/membership</td>
</tr>
</tbody>
      </table>
<h3>응답</h3>

<h3>응답 내용</h3>
<table class="table">
        <thead><tr>
<th>이름</th>
<th>타입</th>
<th>필수</th>
<th>설명</th>
</tr>
</thead>
        <tbody><tr>
<td>response</td>
<td>object</td>
<td>O</td>
<td>멤버십 전체조회하기에 대한 값</td>
</tr>
<tr>
<td>membership</td>
<td>List (Object)</td>
<td>O</td>
<td>멤버십 정보</td>
</tr>
</tbody>
      </table>
<h3>응답 예시</h3>
<div class="highlight"><pre class="codehilite"><code><span class="p">{</span><span class="w">
   </span><span class="s2">"success"</span><span class="p">:</span><span class="kc">true</span><span class="p">,</span><span class="w">
   </span><span class="s2">"response"</span><span class="p">:[</span><span class="w">
      </span><span class="p">{</span><span class="w">
         </span><span class="s2">"seq"</span><span class="p">:</span><span class="mi">1</span><span class="p">,</span><span class="w">
         </span><span class="s2">"membershipId"</span><span class="p">:</span><span class="s2">"spc"</span><span class="p">,</span><span class="w">
         </span><span class="s2">"userId"</span><span class="p">:</span><span class="s2">"test1"</span><span class="p">,</span><span class="w">
         </span><span class="s2">"membershipName"</span><span class="p">:</span><span class="s2">"happypoint"</span><span class="p">,</span><span class="w">
         </span><span class="s2">"startDate"</span><span class="p">:</span><span class="s2">"2021-06-20T14:48:29.831"</span><span class="p">,</span><span class="w">
         </span><span class="s2">"membershipStatus"</span><span class="p">:</span><span class="s2">"Y"</span><span class="p">,</span><span class="w">
         </span><span class="s2">"point"</span><span class="p">:</span><span class="mi">120</span><span class="w">
      </span><span class="p">},</span><span class="w">
      </span><span class="p">{</span><span class="w">
         </span><span class="s2">"seq"</span><span class="p">:</span><span class="mi">2</span><span class="p">,</span><span class="w">
         </span><span class="s2">"membershipId"</span><span class="p">:</span><span class="s2">"shinsegae"</span><span class="p">,</span><span class="w">
         </span><span class="s2">"userId"</span><span class="p">:</span><span class="s2">"test1"</span><span class="p">,</span><span class="w">
         </span><span class="s2">"membershipName"</span><span class="p">:</span><span class="s2">"shinsegaepoint"</span><span class="p">,</span><span class="w">
         </span><span class="s2">"startDate"</span><span class="p">:</span><span class="s2">"2021-06-20T14:48:30.011"</span><span class="p">,</span><span class="w">
         </span><span class="s2">"membershipStatus"</span><span class="p">:</span><span class="s2">"Y"</span><span class="p">,</span><span class="w">
         </span><span class="s2">"point"</span><span class="p">:</span><span class="mi">3500</span><span class="w">
      </span><span class="p">},</span><span class="w">
      </span><span class="p">{</span><span class="w">
         </span><span class="s2">"seq"</span><span class="p">:</span><span class="mi">3</span><span class="p">,</span><span class="w">
         </span><span class="s2">"membershipId"</span><span class="p">:</span><span class="s2">"cj"</span><span class="p">,</span><span class="w">
         </span><span class="s2">"userId"</span><span class="p">:</span><span class="s2">"test1"</span><span class="p">,</span><span class="w">
         </span><span class="s2">"membershipName"</span><span class="p">:</span><span class="s2">"cjone"</span><span class="p">,</span><span class="w">
         </span><span class="s2">"startDate"</span><span class="p">:</span><span class="s2">"2021-06-20T14:48:30.043"</span><span class="p">,</span><span class="w">
         </span><span class="s2">"membershipStatus"</span><span class="p">:</span><span class="s2">"N"</span><span class="p">,</span><span class="w">
         </span><span class="s2">"point"</span><span class="p">:</span><span class="mi">1029</span><span class="w">
      </span><span class="p">}</span><span class="w">
   </span><span class="p">],</span><span class="w">
   </span><span class="s2">"error"</span><span class="p">:</span><span class="kc">null</span><span class="w">
</span><span class="p">}</span><span class="w">
</span></code></pre></div>
<h2><strong>2. 멤버십 등록하기 API</strong></h2>

<h3>요청</h3>
<table class="table">
        <thead><tr>
<th>항목</th>
<th>값</th>
</tr>
</thead>
        <tbody><tr>
<td>URL</td>
<td>POST /api/v1/membership</td>
</tr>
</tbody>
      </table>
<h3>요청 항목</h3>
<table class="table">
        <thead><tr>
<th>이름</th>
<th>타입</th>
<th>필수</th>
<th>설명</th>
</tr>
</thead>
        <tbody><tr>
<td>membershipId</td>
<td>string</td>
<td>O</td>
<td>멤버십 ID</td>
</tr>
<tr>
<td>membershipName</td>
<td>string</td>
<td>O</td>
<td>멤버십 이름</td>
</tr>
<tr>
<td>point</td>
<td>int</td>
<td>O</td>
<td>포인트</td>
</tr>
</tbody>
      </table>
<h3>요청 예시</h3>
<div class="highlight"><pre class="codehilite"><code><span class="p">{</span><span class="w">
   </span><span class="s2">"membershipId"</span><span class="p">:</span><span class="s2">"cj"</span><span class="p">,</span><span class="w">
   </span><span class="s2">"membershipName"</span><span class="p">:</span><span class="s2">"cjone"</span><span class="p">,</span><span class="w">
   </span><span class="s2">"point"</span><span class="p">:</span><span class="mi">5210</span><span class="w">
</span><span class="p">}</span><span class="w">
</span></code></pre></div>
<h3>응답</h3>

<h3>응답 내용</h3>
<table class="table">
        <thead><tr>
<th>이름</th>
<th>타입</th>
<th>필수</th>
<th>설명</th>
</tr>
</thead>
        <tbody><tr>
<td>response</td>
<td>object</td>
<td>O</td>
<td>멤버십 상세조회하기에 대한 값</td>
</tr>
</tbody>
      </table>
<h3>응답 예시</h3>
<div class="highlight"><pre class="codehilite"><code><span class="p">{</span><span class="w">
   </span><span class="s2">"success"</span><span class="p">:</span><span class="kc">true</span><span class="p">,</span><span class="w">
   </span><span class="s2">"response"</span><span class="p">:{</span><span class="w">
      </span><span class="s2">"seq"</span><span class="p">:</span><span class="mi">3</span><span class="p">,</span><span class="w">
      </span><span class="s2">"membershipId"</span><span class="p">:</span><span class="s2">"cj"</span><span class="p">,</span><span class="w">
      </span><span class="s2">"userId"</span><span class="p">:</span><span class="s2">"test1"</span><span class="p">,</span><span class="w">
      </span><span class="s2">"membershipName"</span><span class="p">:</span><span class="s2">"cjone"</span><span class="p">,</span><span class="w">
      </span><span class="s2">"startDate"</span><span class="p">:</span><span class="s2">"2021-07-01T16:33:21.291"</span><span class="p">,</span><span class="w">
      </span><span class="s2">"membershipStatus"</span><span class="p">:</span><span class="s2">"Y"</span><span class="p">,</span><span class="w">
      </span><span class="s2">"point"</span><span class="p">:</span><span class="mi">5210</span><span class="w">
   </span><span class="p">},</span><span class="w">
   </span><span class="s2">"error"</span><span class="p">:</span><span class="kc">null</span><span class="w">
</span><span class="p">}</span><span class="w">
</span></code></pre></div>
<h2><strong>3. 멤버십 삭제(비활성화)하기 API</strong></h2>

<h3>요청</h3>
<table class="table">
        <thead><tr>
<th>항목</th>
<th>값</th>
<th>설명</th>
</tr>
</thead>
        <tbody><tr>
<td>URL</td>
<td>DELETE /api/v1/membership/{membershipId}</td>
<td>{membershipId} = 멤버십 ID</td>
</tr>
</tbody>
      </table>
<h3>요청 항목</h3>
<table class="table">
        <thead><tr>
<th>이름</th>
<th>타입</th>
<th>필수</th>
<th>설명</th>
</tr>
</thead>
        <tbody><tr>
<td>membershipId</td>
<td>string</td>
<td>O</td>
<td>멤버십 ID</td>
</tr>
</tbody>
      </table>
<h3>응답</h3>

<h3>응답 내용</h3>
<table class="table">
        <thead><tr>
<th>이름</th>
<th>타입</th>
<th>필수</th>
<th>설명</th>
</tr>
</thead>
        <tbody><tr>
<td>response</td>
<td>boolean</td>
<td>O</td>
<td>성공여부</td>
</tr>
</tbody>
      </table>
<h3>응답 예시</h3>
<div class="highlight"><pre class="codehilite"><code><span class="p">{</span><span class="w">
   </span><span class="s2">"success"</span><span class="p">:</span><span class="kc">true</span><span class="p">,</span><span class="w">
   </span><span class="s2">"response"</span><span class="p">:</span><span class="kc">true</span><span class="p">,</span><span class="w">
   </span><span class="s2">"error"</span><span class="p">:</span><span class="kc">null</span><span class="w">
</span><span class="p">}</span><span class="w">
</span></code></pre></div>
<h2><strong>4. 멤버십 상세 조회하기 API</strong></h2>

<h3>요청</h3>
<table class="table">
        <thead><tr>
<th>항목</th>
<th>값</th>
<th>설명</th>
</tr>
</thead>
        <tbody><tr>
<td>URL</td>
<td>GET /api/v1/membership/{membershipId}</td>
<td>{membershipId} = 멤버십 ID</td>
</tr>
</tbody>
      </table>
<h3>응답</h3>

<h3>응답 내용</h3>
<table class="table">
        <thead><tr>
<th>이름</th>
<th>타입</th>
<th>필수</th>
<th>설명</th>
</tr>
</thead>
        <tbody><tr>
<td>response</td>
<td>object</td>
<td>O</td>
<td>멤버십 상세조회하기에 대한 값</td>
</tr>
<tr>
<td>membership</td>
<td>object</td>
<td>O</td>
<td>멤버십 정보</td>
</tr>
</tbody>
      </table>
<h3>응답 예시</h3>
<div class="highlight"><pre class="codehilite"><code><span class="p">{</span><span class="w">
   </span><span class="s2">"success"</span><span class="p">:</span><span class="kc">true</span><span class="p">,</span><span class="w">
   </span><span class="s2">"response"</span><span class="p">:{</span><span class="w">
         </span><span class="s2">"seq"</span><span class="p">:</span><span class="mi">1</span><span class="p">,</span><span class="w">
         </span><span class="s2">"membershipId"</span><span class="p">:</span><span class="s2">"spc"</span><span class="p">,</span><span class="w">
         </span><span class="s2">"membershipName"</span><span class="p">:</span><span class="s2">"happypoint"</span><span class="p">,</span><span class="w">
               </span><span class="s2">"userId"</span><span class="p">:</span><span class="s2">"test1"</span><span class="p">,</span><span class="w">
         </span><span class="s2">"point"</span><span class="p">:</span><span class="mi">120</span><span class="p">,</span><span class="w">
         </span><span class="s2">"startDate"</span><span class="p">:</span><span class="s2">"2021-07-01T16:33:21.291"</span><span class="p">,</span><span class="w">
         </span><span class="s2">"membershipStatus"</span><span class="p">:</span><span class="s2">"Y"</span><span class="w">
   </span><span class="p">},</span><span class="w">
   </span><span class="s2">"error"</span><span class="p">:</span><span class="kc">null</span><span class="w">
</span><span class="p">}</span><span class="w">
</span></code></pre></div>
<h2><strong>5. 포인트 적립하기 API</strong></h2>

<h3>요청</h3>
<table class="table">
        <thead><tr>
<th>항목</th>
<th>값</th>
</tr>
</thead>
        <tbody><tr>
<td>URL</td>
<td>PUT /api/v1/membership/point</td>
</tr>
</tbody>
      </table>
<h3>요청 항목</h3>
<table class="table">
        <thead><tr>
<th>이름</th>
<th>타입</th>
<th>필수</th>
<th>설명</th>
</tr>
</thead>
        <tbody><tr>
<td>membershipId</td>
<td>string</td>
<td>O</td>
<td>멤버십 ID</td>
</tr>
<tr>
<td>amount</td>
<td>int</td>
<td>O</td>
<td>사용금액</td>
</tr>
</tbody>
      </table>
<h3>요청 예시</h3>
<div class="highlight"><pre class="codehilite"><code><span class="p">{</span><span class="w">
   </span><span class="s2">"membershipId"</span><span class="p">:</span><span class="s2">"cj"</span><span class="p">,</span><span class="w">
   </span><span class="s2">"amount"</span><span class="p">:</span><span class="mi">100</span><span class="w">
</span><span class="p">}</span><span class="w">
</span></code></pre></div>
<h3>응답</h3>

<h3>응답 내용</h3>
<table class="table">
        <thead><tr>
<th>이름</th>
<th>타입</th>
<th>필수</th>
<th>설명</th>
</tr>
</thead>
        <tbody><tr>
<td>response</td>
<td>boolean</td>
<td>O</td>
<td>성공여부</td>
</tr>
</tbody>
      </table>
<h3>응답 예시</h3>
<div class="highlight"><pre class="codehilite"><code><span class="p">{</span><span class="w">
   </span><span class="s2">"success"</span><span class="p">:</span><span class="kc">true</span><span class="p">,</span><span class="w">
   </span><span class="s2">"response"</span><span class="p">:</span><span class="kc">true</span><span class="p">,</span><span class="w">
   </span><span class="s2">"error"</span><span class="p">:</span><span class="kc">null</span><span class="w">
</span><span class="p">}</span><span class="w">
</span></code></pre></div></div>
      </div>
      <div class="modal-footer">
        <a class="btn btn-primary" data-dismiss="modal" href="#">닫기</a>
      </div>
    </div>
  </div>
</div>
