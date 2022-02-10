<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="./include/header.jsp" %>

<main id="notice01">
      <div class="container">
        <h1>공지사항</h1>
        <div class="contents">
          <form action="notice_process.jsp" method="post">
            <table>
              <colgroup>
                <col style="width: 150px" />
                <col />
              </colgroup>
              <tbody>
                <tr>
                  <th>제목</th>
                  <td><input type="text" name="notice_title" id="notice_title" /></td>
                </tr>
                <tr>
                  <th>내용</th>
                  <td><textarea type="textarea" name="notice_content" id="notice_content"></textarea></td>
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
    		$("#notice_title").val("");
    		$("#notice_content").val("");
    		return false;
    	});
    	$(".btnSave").on("click",function(){
    		if($("#notice_title").val()==="") {
    			alert("제목을 입력하세요");
    			$("#notice_title").focus();
    			return false;
    		} else if($("#notice_content").val()===""){
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