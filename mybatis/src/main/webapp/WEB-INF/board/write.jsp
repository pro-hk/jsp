<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/header.jsp" %>
    <main>
      <div class="inner">
      	<h2 class="subTitle">WRITE</h2>
      	<div id=contents>
      		<form method="post" action="WriteProcess.do" id="join" class="form">
      			<table>
      				<colgroup>
      					<col style="width:20%">
      					<col style="width:80%">
      				</colgroup>
      				<tbody>
      					<tr>
      						<th>이름 <span class="required">*</span></th>
      						<td>
      						<input type="text" name="user_name" id="user_name" placeholder="이름을 입력하세요." >
      						</td>
      					</tr>
      					<tr>
      						<th>제목 <span class="required">*</span></th>
      						<td>
      						<input type="text" name="user_subject" id="user_subject" placeholder="제목을 입력하세요." >
      						</td>
      					</tr>
      					<tr>
      						<th>이메일 <span class="required">*</span></th>
      						<td><input type="text" name="user_email" id="user_email" placeholder="메일을 입력하세요."></td>
      					</tr>
      					<tr>
      						<th>비밀번호 <span class="required">*</span></th>
      						<td><input type="password" name="user_pw" id="user_pw" placeholder="비밀번호를 입력하세요."></td>
      					</tr>
      					<tr>
      						<th>내용 <span class="required">*</span></th>
      						<td class="left"><textarea placeholder="내용을 입력하세요" name="user_contents" id="summernote"></textarea></td>
      					</tr>
      				</tbody>
      			</table>
      			<div class="btns">
      				<button type="submit" class="btn btnConfirm">글쓰기</button>
      				<button type="reset" class="btn btnCancel">취소</button>
      			</div>
      		</form>
     	</div>
      </div>
    </main>
    <script>
    	// summernote적용
  		$('#summernote').summernote({
  			height: 300,
  			callbacks: {
  				onImageUpload: function(files) { // files : 배열
  			    // 여러개 업로드를 원할 때
 			    	for(let i=0;i<files.length;i++){
  			    		uploadImage(files[i], this);
 			    	}
  			    }
  			}
  		});
    	
    	// 데이터 넘기는 방법 
    	// 1. QueryString -->  /xxx?id=aa (get)
    	// 2. Form Tag    -->  <form method="get/post" action="xxx"></form>
    	// 3. FormData
    	function uploadImage(file, editor) {
    		const sendData = new FormData();
    		sendData.append("uploadFile",file); // uploadFile : <input type="file" name="upLoadfile">
    		$.ajax({
    			url: "../board/SummerNoteFileUpload.do",
    			type: "post",
    			data: sendData,
    			contentType: false, // defalut : application/x-www-form-urlencode -- false로 해야지만 multipart/form-data로 넘어감
    			processData: false, // defalut : QueryString(xxx?id=xx)
    			dataType: "json",
    			success: function(data) {
    				console.log(data);
    				$(editor).summernote("editor.insertImage",data.url);
    			},
    			error: function(){
    				alert("파일 업로드 실패");
    			}
    		})
    	}
    </script>
<%@ include file="../include/footer.jsp" %>
    