<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="./include/header.jsp"%>

<!--  파일 2개 이상 올리기 -->
<main id="notice01">
	<div class="container">
		<h1>공지사항</h1>
		<div class="contents">
			<form action="VisualUpload02.do" method="post" id="join"
				enctype="multipart/form-data">
				<table>
					<colgroup>
						<col style="width: 150px" />
						<col />
					</colgroup>
					<tbody>
						<tr>
							<th>slogan</th>
							<td><input type="text" name="user_slogan1" id="user_slogan1"
								placeholder="슬로건을 입력하세요." /></td>
						</tr>
						<tr>
							<th>visual</th>
							<td><input type="file" name="user_visual1" id="user_visual1" /></td>
						</tr>
					</tbody>
				</table>
				<div class="btns end">
					<button class="btn btnSmall" id="btnPlus">+</button>
					<button class="btn btnSmall" id="btnMinus">-</button>
				</div>
				<div class="btns">
					<button class="btn btnSave">저장</button>
					<button class="btn btnCancel">취소</button>
				</div>
			</form>
		</div>
	</div>
</main>

<script>
	let count = 1;
	$("#btnPlus").on("click",function(){
		count++;
		$("#join tbody").append(`
			<tr>
         	   <th>slogan</th>
        	   <td><input type="text" name="user_slogan\${count}" id="user_slogan\${count}" placeholder="슬로건을 입력하세요." /></td>
        	</tr>
        	<tr>
            	<th>visual</th>
            	<td><input type="file" name="user_visual\${count}" id="user_visual\${count}" /></td>
        	</tr>
    	`)
   	 	return false;
   	});
	
 	$("#btnMinus").on("click",function(){
		if(count > 1){
			count--;
			$("#join tbody tr:last-child").remove();
			$("#join tbody tr:last-child").remove();
		}
		return false;
	}); 
    
   	$(".btnCancel").on("click",function(){
   		$("#user_slogan").val("");
   		$("#user_visual").val("");
   		return false;
   	});
   	$(".btnSave").on("click",function(){
   		if($("#user_slogan").val()==="") {
   			alert("슬로건을 입력하세요");
   			$("#user_slogan").focus();
   			return false;
   		} else if($("#user_visual").val()===""){
   			alert("내용을 입력하세요");
   			return false;
   		} else {
   			const save = confirm("저장하시겠습니까");
   			if(!save) {
   				return false;
   			}
   		}
   	});
</script>

<%@ include file="./include/footer.jsp"%>