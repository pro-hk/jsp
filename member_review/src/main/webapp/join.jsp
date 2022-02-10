<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./include/header.jsp" %>
    <main>
      <div class="container">
      	<h2 class="subTitle">회원가입</h2>
      	<div id=contents>
      		<form method="post" action="join_process.jsp" id="join" class="form">
      			<table>
      				<colgroup>
      					<col style="width:20%">
      					<col style="width:80%">
      				</colgroup>
      				<tbody>
      					<tr>
      						<th>아이디 <span class="required">*</span></th>
      						<td>
      						<input type="text" name="user_id" id="user_id" style="width:calc(100% - 100px)" placeholder="아이디를 입력하세요." >
      						<button class="btn btnIdCheck" id="btnIdCheck">ID중복체크</button>
      						</td>
      					</tr>
      					<tr>
      						<th>비밀번호 <span class="required">*</span></th>
      						<td><input type="password" name="user_pw" id="user_pw" placeholder="비밀번호를 입력하세요."></td>
      					</tr>
      					<tr>
      						<th>비밀번호 확인 <span class="required">*</span></th>
      						<td><input type="password" name="user_pw_confirm" id="user_pw_confirm" placeholder="비밀번호를 다시 입력하세요."></td>
      					</tr>
      					<tr>
      						<th>이름 <span class="required">*</span></th>
      						<td><input type="text" name="user_name" id="user_name" placeholder="이름을 입력하세요."></td>
      					</tr>
      					<tr>
      						<th>이메일 <span class="required">*</span></th>
      						<td><input type="text" name="user_email" id="user_email" placeholder="메일을 입력하세요."></td>
      					</tr>
      					<tr>
      						<th>전화번호 <span class="required">*</span></th>
      						<td>
      							<select name="user_phone_first" class="short">
      								<option value="010" selected>010</option>
      								<option value="011">011</option>
      								<option value="017">017</option>
      							</select>
      							<input type="text" name="user_phone_middle" class="short" id="user_phone_middle" placeholder="전화번호를 입력하세요.">
      							<input type="text" name="user_phone_last" class="short" id="user_phone_last" placeholder="전화번호를 입력하세요.">
      						</td>
      					</tr>
      					<tr>
      						<th>주소 <span class="required">*</span></th>
      						<td>
      							<div>
	      							<input type="number" name="zipcode" placeholder="우편번호" id="zipcode" class="short">
    	  							<button class="btn btnZipcode">우편번호</button>
      							</div>
      							<div class="addrBox">
	      							<input type="text" name="address01" id="address01" placeholder="기본주소">
    	  							<span class="sticker">기본 주소</span>
      							</div>
      							<div class="addrBox">
	      							<input type="text" name="address02" id="address02" placeholder="나머지주소">
    	  							<span class="sticker">나머지 주소</span>
      							</div>
      						</td>
      					</tr>
      				</tbody>
      			</table>
      			<div class="btns">
      				<button type="submit" class="btn btnConfirm">회원가입</button>
      				<button type="reset" class="btn btnCancel">취소</button>
      			</div>
      		</form>
     	</div>
      </div>
    </main>
    <script>
    	let idCheck = false;
    	const korean = /[ㄱ-ㅎㅏ-ㅣ가-힣]/g;
    	const email = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
		//데이터 보내기
		//1. form을 통해서 보내기
		//2. a태그(href)로 보내기
		//3. ajax로 보내기      		
		$("#btnIdCheck").on("click",function(){
			// e.preventDefault();
			const user_id = $("#user_id").val();
			if(user_id===""){
				alert("아이디를 입력하세요.")
				$("#user_id").focus();
			} else if(korean.test($("#user_id").val())){
				alert("ID에 한글을 쓸 수 없습니다.");
				$("#user_id").val("");
				$("#user_id").focus();
			} else { 
			$.ajax({
				url:"id_check.jsp",
				type:"post",
				data:{"user_id":user_id},
				success:function(res) {
					//console.log(res);
					if(res.count > 0) {
						alert("사용할 수 없는 아이디입니다.");
						$("#user_id").val("");
						$("#user_id").focus();
					} else {
						const yes = confirm("사용가능한 아이디입니다. 사용하시겠습니까?");
						if(yes) {
							$("#user_id").attr("readonly",true);
							$("#user_id").addClass("readonly");
							idCheck = true;
							$("#user_pw").focus();
						} else {
							$("#user_id").val("");
							$("#user_id").focus();
						}
					}
				}
			});
			}
			return false;
		});
    
    	$(".btnConfirm").on("click",function(){
    		if($("#user_id").val()=="") {
    			alert("아이디를 입력하세요.");
    			$("#user_id").focus();
    			return false;
    		} else if(korean.test($("#user_id").val())) {
    			alert("ID에 한글을 쓸 수 없습니다.");
    			$("#user_id").val("");
    			$("#user_id").focus();
    			return false;
    		} else if($("#user_pw").val()=="") {
    			alert("비밀번호를 입력하세요.");
    			$("#user_pw").focus();
    			return false;
    		} else if($("#user_pw_confirm").val()=="") {
    			alert("비밀번호를 한번 더 입력하세요.");
    			$("#user_pw_confirm").focus();
    			return false;
    		} else if($("#user_pw_confirm").val()!=$("#user_pw").val()) {
    			alert("비밀번호가 맞지 않습니다.");
    			$("#user_pw").val("");
    			$("#user_pw_confirm").val("");
    			$("#user_pw").focus();
    			return false;
    		} else if($("#user_name").val()=="") {
    			alert("이름을 입력하세요.");
    			$("#user_name").focus();
    			return false;
    		} else if($("#user_email").val()=="") {
    			alert("이메일을 입력하세요.");
    			$("#user_email").focus();
    			return false;
    		} else if(!email.test($("#user_email").val())) {
    			alert("이메일 형식에 맞게 입력해주세요.");
    			$("#user_email").focus();
    			return false;
    		} else if($("#user_phone_middle").val()=="") {
    			alert("전화번호를 입력하세요.");
    			$("#user_phone_middle").focus();
    			return false;
    		} else if($("#user_phone_last").val()=="") {
    			alert("전화번호를 입력하세요.");
    			$("#user_phone_last").focus();
    			return false;
    		} else if($("#zipcode").val()=="") {
    			alert("우편번호를 입력하세요.");
    			$("#zipcode").focus();
    			return false;
    		} else if($("#address01").val()=="") {
    			alert("주소를 입력하세요.");
    			$("#address01").focus();
    			return false;
    		} else if($("#address02").val()=="") {
    			alert("주소를 입력하세요.");
    			$("#address02").focus();
    			return false;
    		} else if(!idCheck){
    			alert("아이디를 체크해주세요");
    			return false;
    		}
    	});
    </script>
<%@ include file="./include/footer.jsp" %>
    