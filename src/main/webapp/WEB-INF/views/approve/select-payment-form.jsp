<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<script>
const path2 = "${pageContext.request.contextPath}";
</script>

  <section>
	<div class="approve hidden-approve">
	  <div class="bg-approve"></div>
	  <div class="modalBox-approve">
	  		<span id="form-choice-name">������ ����</span>
	  		<div id="form-flex">
	  			<div id="form-choice">
	  				<div id="form-column">
		  				<a onclick="extendsApply();">����ٹ���û</a>
		  				<a onclick="attendanceApply();">���½�û</a>
		  				<a onclick="expenditureApply();">������Ǽ���û</a>
	  				</div>
	  			</div>
	  			<div id="form-choice-result">
	  				<img src="${path}/resources/images/approve/default.png" height="400px" width="250px"> 
	  			</div>
	  		</div>
	  		
			<button type="button" id="approval-close-button">�ݱ�</button>
			<button type="button" id="approval-write-button" onclick="approvalWrite();">�ۼ�</button>
	  </div>
	</div>
</section>  
<link rel="stylesheet" href="${path}/resources/css/approve/select-payment-form.css">
<script src="${path}/resources/js/approve/select-payment-form.js"></script>

  