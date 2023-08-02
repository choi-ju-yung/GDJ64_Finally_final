<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<section class="max1920px">
	<jsp:include page="/WEB-INF/views/common/side-nav.jsp"/>
	<div class="main-section section-shadow card">
      <div class="right-container">
         <h2>사원 정보 수정</h2>
         <form action="${path }/employee/memberId" id="update-emp-form" method="post" enctype="multipart/form-data">
         	<input type="hidden" name="member-id" value="${member.memberId }">
         	<div>
         		<span>이름</span>
         		<input type="text" name="member-name" value="${member.memberName }">
         	</div>
         	<div>
         		<span>전화번호</span>
         		<input type="text" name="phone" value="${member.phone }">
         	</div>
         	<div>
         		<span>주소 검색</span>
         		<input type="text" name="main-address" id="main-addr" value="${member.address }">
         		<input type="button" onclick="fn_searchAddr();" value="검색">
         	</div>
         	<div>
         		<span>상세 주소</span>
         		<input type="text" name="detail-address" id="detail-addr" value="${member.subAddress }">
         	</div>
         	<div>
         		<span>부서</span>
	         	<select>
	         		<option selected disabled value="${member.dept.deptCode }">${member.dept.deptName }</option>
	         		<c:if test="${depts!=null }">
	         			<c:forEach var="d" items="${depts }">
		         			<option value="${d.deptCode }">${d.deptName }</option>
		         		</c:forEach>
	         		</c:if>
	         	</select>
         	</div>
         	<div>
         		<span>직책</span>
	         	<select>
	         		<option selected disabled value="${member.job.jobCode }">${member.job.jobName }</option>
	         		<c:if test="${jobs!=null }">
	         			<c:forEach var="j" items="${jobs }">
	         				<option value="${j.jobCode }">${j.jobName }</option>
	         			</c:forEach>
	         		</c:if>
	         	</select>
         	</div>
         	<div>
         		<span>급여</span>
         		<input type="number" name="salary" value="${member.salary }">
         	</div>
         	<div>
         		<span>프로필</span>
         		<input type="file" name="upFile" value="${member.profileImg }" id="input-file">
         	</div>
         	<img src="${path }/resources/upload/profile/${member.profileImg}" id="mypage-profile">
         	<p>* 프로필 사진이 존재하는 경우 파일 첨부해주세요. 용량 제한 100MB</p>
         	<div>
         		<span>연차</span>
         		<input type="number" name="leave" value="${member.leave }">
         	</div>
         	<div>
         		<span>입사일</span>
         		<input type="date" name="enroll-date" value="${member.hireDate }">
         	</div>
         	<div>
         		<span>퇴사일</span>
         		<input type="date" name="ent-date" value="${member.entDate!=''?member.entDate:''}" id="ent-date-id">
         	</div>
         	<p>* 퇴사일 이후로는 해당 사원 번호로 로그인 불가능합니다.</p>
         </form>
      </div>
	<div><input type="reset" value="취소"><button onclick="fn_empDataCk();">수정</button></div>
   </div>
</section>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
//데이터 입력 확인 후 넘기는 메소드
function fn_empDataCk(){
	const inputArr=$("input");
	if($("#ent-date-id").val()==''){
		$("#ent-date-id").val(null);
		console.log($("#ent-date-id").val());
	}
	$("#update-emp-form").submit();
}
console.log($("#ent-date-id").val());
	//주소 검색 메소드
	function fn_searchAddr(){
		//주소 API 사용
		 new daum.Postcode({
		        oncomplete: function(data) {
		        	$("#main-addr").val(data.address);
		        	$("#detail-addr").focus();
		        }
		    }).open();
	}
	$(document).on("change","#input-file",function(){
		let maxSize = 1024 * 1024 * 100;  // 파일 최대 크기 100MB
		const file = this.file; // 첨부된 파일 목록
		if(file.size > maxSize){ // 크기 체크
			alert('100MB 이하의 파일만 첨부할 수 있습니다.');
			$(this).val('');  // 첨부된 파일을 모두 없애줌
			return;
		}
	});
</script>
</body>
</html>