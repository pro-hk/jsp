<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="./include/header.jsp" %>

<main id="notice01">
      <div class="container">
        <h1>공지사항</h1>
        <div class="contents">
          <form action="VisualUpload.do" method="post" enctype="multipart/form-data" id="join">
            <table>
              <colgroup>
                <col style="width: 150px" />
                <col />
              </colgroup>
              <tbody>
                <tr>
                  <th>slogan</th>
                  <td><input type="text" name="user_slogan" id="user_slogan" placeholder="슬로건을 입력하세요." /></td>
                </tr>
                <tr>
                  <th>visual</th>
                  <td><input type="file" name="user_visual" id="user_visual" /></td>
                </tr>
              </tbody>
            </table>
            <div class="btns">
              <button class="btn btnSave">저장</button>
              <button class="btn btnCancel">취소</button>
            </div>
          </form>
        </div>
      </div>
    </main>
    
    <script>
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

<%@ include file="./include/footer.jsp" %>