<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>          
<c:set var="path" value="${pageContext.request.contextPath }"/> 


<jsp:include page="/WEB-INF/views/common/header.jsp"/>
<link rel="stylesheet" href="${path}/resources/css/approve/drafting_app.css">	
<section class="max1920px">
<jsp:include page="/WEB-INF/views/common/side-nav.jsp"/>
	<div class="approve-section section-shadow">
		
  <div id="approve_name">
  	���缭�̸� + ��û
  </div>		
		
  <div>
    <div id="one-width">
      <div id="kind" class="answer"></div>
      <div id="app-line" class="answer"></div>
    </div>

    <div id="one-width">
      <div id="title" class="question">����</div>
      <div id="title-answer" class="answer">
        <input type="text" id="title-input">
      </div>
    </div>

    <div id="one-width">
      <div id="department" class="question">�μ�</div>
      <div id="department-answer" class="answer"></div>
      <div id="writer" class="question">�����</div>
      <div id="writer-answer" class="answer"></div>
      <div id="position" class="question">��å</div>
      <div id="position-answer" class="answer"></div>
    </div>

    <div id="one-width">
      <div id="effectDate" class="question">��������</div>
      <div id="effectDate-answer" class="answer">
          <input type="date" id="effectDate-input">
      </div>
      <div id="writeDate" class="question">�ۼ���</div>
      <div id="writeDate-answer" class="answer"></div>
    </div>

    <div id="one-width">
      <div id="content" class="question">����</div>
      <div id="content-answer" class="answer">
        <textarea id="content-textarea">

        </textarea> 
      </div>
    </div>

    <div id="one-width">
      <div id="appAttachment" class="question">÷������</div>
      <div id="appAttachment-answer" class="answer">
        <input type="file" id="appAttachment-input">
      </div>
    </div>


    <div id="one-width">
      <button type="button" id="back">���ư���</button>
      <button type="button" id="save">�ӽ�����</button>
      <button type="button" id="sign">������</button>
    </div>

  </div>

</div>
<!-- <div class="approve-section1 section-shadow">
	<button type="button" id="regist-appline">���缱 ����</button>
</div>  -->
<button type="button" id="regist-appline">���缱 ����</button>
</section>
</html>
