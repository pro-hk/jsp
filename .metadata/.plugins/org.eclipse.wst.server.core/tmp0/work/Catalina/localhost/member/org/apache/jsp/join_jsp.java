/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.58
 * Generated at: 2022-01-26 03:15:02 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class join_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/./include/footer.jsp", Long.valueOf(1642990499599L));
    _jspx_dependants.put("/./include/header.jsp", Long.valueOf(1643009192755L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("  <head>\r\n");
      out.write("    <meta charset=\"UTF-8\" />\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n");
      out.write("    <title>INCLUDE</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/reset.css\" />\r\n");
      out.write("    <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/layout.css\" />\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/form.css\" />\r\n");
      out.write("    <script src=\"//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js\"></script>\r\n");
      out.write("    <script src=\"js/jquery-3.6.0.min.js\"></script>  \r\n");
      out.write("    <script src=\"js/main.js\" defer></script>\r\n");
      out.write("  </head>\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("    <header id=\"header\">\r\n");
      out.write("      <div class=\"container\">\r\n");
      out.write("        <h1>prohk</h1>\r\n");
      out.write("        <nav id=\"gnb\">\r\n");
      out.write("          <h2 class=\"hidden\">global navigation bar</h2>\r\n");
      out.write("          <ul>\r\n");
      out.write("            <li><a href=\"./login.jsp\">로그인</a></li>\r\n");
      out.write("            <li><a href=\"./join.jsp\">회원가입</a></li>\r\n");
      out.write("            <li><a href=\"./board.jsp\">게시판</a></li>\r\n");
      out.write("          </ul>\r\n");
      out.write("        </nav>\r\n");
      out.write("      </div>\r\n");
      out.write("    </header>");
      out.write("\r\n");
      out.write("    <main>\r\n");
      out.write("      <div class=\"container\">\r\n");
      out.write("      	<h2 class=\"subTitle\">JOIN</h2>\r\n");
      out.write("      	<div id=contents>\r\n");
      out.write("      		<form method=\"post\" action=\"join_process.jsp\" id=\"join\" class=\"form\">\r\n");
      out.write("      			<table>\r\n");
      out.write("      				<colgroup>\r\n");
      out.write("      					<col sytle=\"width:20%\">\r\n");
      out.write("      					<col sytle=\"width:80%\">\r\n");
      out.write("      				</colgroup>\r\n");
      out.write("      				<tbody>\r\n");
      out.write("      					<tr>\r\n");
      out.write("      						<th>아이디 <span class=\"required\">*</span></th>\r\n");
      out.write("      						<td><input type=\"text\" name=\"user_id\" id=\"user_id\" placeholder=\"아이디를 입력하세요.\"></td>\r\n");
      out.write("      					</tr>\r\n");
      out.write("      					<tr>\r\n");
      out.write("      						<th>비밀번호 <span class=\"required\">*</span></th>\r\n");
      out.write("      						<td><input type=\"password\" name=\"user_pw\" id=\"user_pw\" placeholder=\"비밀번호를 입력하세요.\"></td>\r\n");
      out.write("      					</tr>\r\n");
      out.write("      					<tr>\r\n");
      out.write("      						<th>비밀번호 확인 <span class=\"required\">*</span></th>\r\n");
      out.write("      						<td><input type=\"password\" name=\"user_pw_confirm\" id=\"user_pw_confirm\" placeholder=\"비밀번호를 다시 입력하세요.\"></td>\r\n");
      out.write("      					</tr>\r\n");
      out.write("      					<tr>\r\n");
      out.write("      						<th>이름 <span class=\"required\">*</span></th>\r\n");
      out.write("      						<td><input type=\"text\" name=\"user_name\" id=\"user_name\" placeholder=\"이름을 입력하세요.\"></td>\r\n");
      out.write("      					</tr>\r\n");
      out.write("      					<tr>\r\n");
      out.write("      						<th>이메일 <span class=\"required\">*</span></th>\r\n");
      out.write("      						<td><input type=\"text\" name=\"user_email\" id=\"user_email\" placeholder=\"메일을 입력하세요.\"></td>\r\n");
      out.write("      					</tr>\r\n");
      out.write("      					<tr>\r\n");
      out.write("      						<th>전화번호 <span class=\"required\">*</span></th>\r\n");
      out.write("      						<td>\r\n");
      out.write("      							<select name=\"user_phone_first\" class=\"short\">\r\n");
      out.write("      								<option value=\"010\" selected>010</option>\r\n");
      out.write("      								<option value=\"011\">011</option>\r\n");
      out.write("      								<option value=\"017\">017</option>\r\n");
      out.write("      							</select>\r\n");
      out.write("      							<input type=\"text\" name=\"user_phone_middle\" class=\"short\" id=\"user_phone_middle\" placeholder=\"전화번호를 입력하세요.\">\r\n");
      out.write("      							<input type=\"text\" name=\"user_phone_last\" class=\"short\" id=\"user_phone_last\" placeholder=\"전화번호를 입력하세요.\">\r\n");
      out.write("      						</td>\r\n");
      out.write("      					</tr>\r\n");
      out.write("      					<tr>\r\n");
      out.write("      						<th>주소 <span class=\"required\">*</span></th>\r\n");
      out.write("      						<td>\r\n");
      out.write("      							<div>\r\n");
      out.write("	      							<input type=\"number\" name=\"zipcode\" placeholder=\"우편번호\" id=\"zipcode\" class=\"short\">\r\n");
      out.write("    	  							<button class=\"btn btnZipcode\">우편번호</button>\r\n");
      out.write("      							</div>\r\n");
      out.write("      							<div class=\"addrBox\">\r\n");
      out.write("	      							<input type=\"text\" name=\"address01\" id=\"address01\" placeholder=\"기본주소\">\r\n");
      out.write("    	  							<span class=\"sticker\">기본 주소</span>\r\n");
      out.write("      							</div>\r\n");
      out.write("      							<div class=\"addrBox\">\r\n");
      out.write("	      							<input type=\"text\" name=\"address02\" id=\"address02\" placeholder=\"나머지주소\">\r\n");
      out.write("    	  							<span class=\"sticker\">나머지 주소</span>\r\n");
      out.write("      							</div>\r\n");
      out.write("      						</td>\r\n");
      out.write("      					</tr>\r\n");
      out.write("      				</tbody>\r\n");
      out.write("      			</table>\r\n");
      out.write("      			<div class=\"btns\">\r\n");
      out.write("      				<button type=\"submit\" class=\"btn btnConfirm\">회원가입</button>\r\n");
      out.write("      				<button type=\"reset\" class=\"btn btnCancel\">취소</button>\r\n");
      out.write("      			</div>\r\n");
      out.write("      		</form>\r\n");
      out.write("     	</div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </main>\r\n");
      out.write("    <script>\r\n");
      out.write("    $(\".btnZipcode\").on(\"click\",function(){\r\n");
      out.write("    	postCode();\r\n");
      out.write("    	return false;\r\n");
      out.write("    });\r\n");
      out.write("    \r\n");
      out.write("    $(\".btnConfirm\").on(\"click\",function(){\r\n");
      out.write("    	if($(\"#user_id\").val()===\"\"){\r\n");
      out.write("    		alert(\"아이디를 입력하세요.\");\r\n");
      out.write("    		$(\"#user_id\").focus;\r\n");
      out.write("    		return false;\r\n");
      out.write("    	} else if($(\"#user_pw\").val()===\"\"){\r\n");
      out.write("    		alert(\"비밀번호를 입력하세요.\");\r\n");
      out.write("    		$(\"#user_pw\").focus;\r\n");
      out.write("    		return false;\r\n");
      out.write("    	} else if($(\"#user_pw_confirm\").val()===\"\"){\r\n");
      out.write("    		alert(\"비밀번호확인을 입력하세요.\");\r\n");
      out.write("    		$(\"#user_pw_confirm\").focus;\r\n");
      out.write("    		return false;\r\n");
      out.write("    	} else if($(\"#user_pw\").val()!==\"\" && $(\"#user_pw_confirm\").val()!==\"\") {\r\n");
      out.write("	    	if($(\"#user_pw\").val()!==$(\"#user_pw_confirm\").val()) {\r\n");
      out.write("	    		alert(\"비밀번호가 맞지 않습니다.\");\r\n");
      out.write("	    		$(\"#user_pw_confirm\").focus;\r\n");
      out.write("	    		return false;\r\n");
      out.write("	    	}	\r\n");
      out.write("    	} else if($(\"#user_name\").val()===\"\") {\r\n");
      out.write("    		alert(\"이름을 입력하세요.\");\r\n");
      out.write("    		$(\"#user_name\").focus;\r\n");
      out.write("    		return false;\r\n");
      out.write("    	} else if($(\"#user_email\").val()===\"\"){\r\n");
      out.write("    		alert(\"메일을 입력하세요.\");\r\n");
      out.write("    		$(\"#user_email\").focus;\r\n");
      out.write("    		return false;\r\n");
      out.write("    	} else if($(\"#user_phone_middle\").val()===\"\"){\r\n");
      out.write("    		alert(\"전화번호를 입력하세요.\");\r\n");
      out.write("    		$(\"#user_phone_middle\").focus;\r\n");
      out.write("    		return false;\r\n");
      out.write("    	} else if($(\"#user_phone_last\").val()===\"\"){\r\n");
      out.write("    		alert(\"전화번호를 입력하세요.\");\r\n");
      out.write("    		$(\"#user_phone_last\").focus;\r\n");
      out.write("    		return false;\r\n");
      out.write("    	} else if($(\"#zipcode\").val()===\"\"){\r\n");
      out.write("    		alert(\"우편번호를 입력하세요.\");\r\n");
      out.write("    		$(\"#zipcode\").focus;\r\n");
      out.write("    		return false;\r\n");
      out.write("    	} else if($(\"#address01\").val()===\"\"){\r\n");
      out.write("    		alert(\"주소를 입력하세요.\");\r\n");
      out.write("    		$(\"#address01\").focus;\r\n");
      out.write("    		return false;\r\n");
      out.write("    	}\r\n");
      out.write("    });\r\n");
      out.write("    \r\n");
      out.write("    function postCode() {\r\n");
      out.write("        new daum.Postcode({\r\n");
      out.write("            oncomplete: function(data) {\r\n");
      out.write("                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.\r\n");
      out.write("\r\n");
      out.write("                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.\r\n");
      out.write("                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.\r\n");
      out.write("                let roadAddr = data.roadAddress; // 도로명 주소 변수\r\n");
      out.write("                let extraRoadAddr = ''; // 참고 항목 변수\r\n");
      out.write("\r\n");
      out.write("                // 법정동명이 있을 경우 추가한다. (법정리는 제외)\r\n");
      out.write("                // 법정동의 경우 마지막 문자가 \"동/로/가\"로 끝난다.\r\n");
      out.write("                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){\r\n");
      out.write("                    extraRoadAddr += data.bname;\r\n");
      out.write("                }\r\n");
      out.write("                // 건물명이 있고, 공동주택일 경우 추가한다.\r\n");
      out.write("                if(data.buildingName !== '' && data.apartment === 'Y'){\r\n");
      out.write("                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);\r\n");
      out.write("                }\r\n");
      out.write("                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.\r\n");
      out.write("                if(extraRoadAddr !== ''){\r\n");
      out.write("                    extraRoadAddr = ' (' + extraRoadAddr + ')';\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("                // 우편번호와 주소 정보를 해당 필드에 넣는다.\r\n");
      out.write("                document.getElementById(\"zipcode\").value = data.zonecode;\r\n");
      out.write("                document.getElementById(\"address01\").value = roadAddr;\r\n");
      out.write("                //document.getElementById(\"sample4_jibunAddress\").value = data.jibunAddress;\r\n");
      out.write("            }\r\n");
      out.write("        }).open();\r\n");
      out.write("    }\r\n");
      out.write("    </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<footer id=\"footer\">\r\n");
      out.write("      <p>ALL COPYRIGHTS RESERVED BY PROHK</p>\r\n");
      out.write("    </footer>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("    ");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
