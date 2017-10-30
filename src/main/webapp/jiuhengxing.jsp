<%--
  Created by IntelliJ IDEA.
  User: Malu
  Date: 2017-09-04
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.Date"%>
<%@page import="com.nstc.portal.key.Configure"%>
<%@page import="com.nstc.portal.util.PortalUtil"%>
<%@page import="com.nstc.uas.client.util.Base64"%>
<%@ page contentType="text/html; charset=GBK" %>
<%
    String certDn=com.nstc.cert.CertsUtil.getDn(request, null);
    com.nstc.security.SignProvider sp = com.nstc.security.SignProvider.getSigner(request.getSession().getServletContext());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8"/>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK" />
    <title>九恒星智能资金平台</title>
    <%String theme=PortalUtil.getTheme(request);%>
    <link href="themes/<%=theme%>/css/login.css" rel="stylesheet" type="text/css"/>
    <script language="javascript" src="js/jQuery/jquery-1.10.2.js"></script>
    <%=sp.isLoginSign()?sp.buildJsScript():""%>
    <script language="javascript" >
        jQuery.noConflict();
        top.onLoadMsg="<%=request.getAttribute("ERROR_MSG")%>";
        top.isLoginSign=<%=sp.isLoginSign()%>;
        <%=sp.buildSignFunction("doLoginSign" , null , certDn)%>
    </script>
    <!-- login.js 文件的引入顺序必须放到最后  -->
    <script language="javascript" src="themes/<%=theme %>/js/security.js"></script>
    <script language="javascript" src="themes/<%=theme %>/js/login.js"></script>
</head>
<body onload="onload();" bgcolor="#FFFFFF" style="margin-top:50px;" class="bodybg">
<form name="loginform" id="loginform" method="post" action="login.do">
    <input type="hidden" name="sign_uno" id="sign_uno"/>
    <input type="hidden" name="loginDn" id="loginDn" value="<%=certDn%>"/>
    <input type="hidden" name="plain_uno" id="plain_uno" value="LOGONDATA:<%=session.hashCode()%>"/>
    <input type="hidden" name="PE" id="PE" value="<%=request.getAttribute("PE")%>"/>
    <input type="hidden" name="MDS" id="MDS" value="<%=request.getAttribute("MDS")%>"/>
    <input type="hidden" name="scc" id="scc" value="<%=Configure.getInstance().isShowCheckCode()%>"/>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" style=" margin-top:3%">
        <tr>
            <td><table width="896" height="46" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                    <td><img src="themes/<%=theme%>/img/login/logo.jpg" alt="logo" width="374" height="46" /></td>
                    <td width="220" align="right" ><span style="cursor: pointer;" onclick="newTab('support/support.htm')">IE设置说明</span></td>
                </tr>
            </table>
                <table width="100%" height="283" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                        <td width="*" class="login_bgL">&nbsp;</td>
                        <td width="607" align="right"><img src="themes/<%=theme%>/img/login/login_2.png" width="607" height="283" /></td>
                        <td width="292" height="100%" class="login_dl<%=Configure.getInstance().isFrontSystem()?"":"1" %>" >
                            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                                <tr>
                                    <td valign="top">&nbsp;</td>
                                </tr>
                                <tr>
                                    <td  valign="top">
                                        <table width="260" border="0" align="center" class="login_margin">
                                            <tr>
                                                <td  height="35" valign="bottom">
                                                    <input name="userno" type="text" class="textfield2" id="userno" tabindex="1" maxlength="36" style="ime-mode:disabled"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td  height="28" valign="bottom">
                                                    <input type="password" class="textfield2"  id="password" onfocus="fadeOutErrMsg()" tabindex="2" maxlength="30" onpaste="return false" ondrop="return false" ondragenter="return false;" ondragstart="return false"/>
                                                    <input name="password" type="password" id="password_r" style="display:none" />
                                                </td>
                                            </tr>
                                            <tr height="29">
                                                <td valign="bottom" id=checkCode_td  >
                                                    <input name="checkCode" type="text" class="textfield3" id="checkCode" onblur="validateCheckCode()" tabindex="3" maxlength="4" style="ime-mode:disabled" />
                                                    <span style="padding-left:5px;">
	                  	<img id=checkCode_img alt="看不清？点击更换" src='checkCode.do?_t=<%=System.currentTimeMillis()%>' style="cursor: hand;" onclick="changeCheckCode()" />
                  	</span>

                                                </td>
                                            </tr>
                                            <tr>
                                                <td  height="25" align="left" style="color:#999999"><img src="themes/<%=theme %>/img/loading.gif" alt="loading" style="display: none;" id="loadImg"/><span id='msgSpan'></span></td>
                                            </tr>
                                        </table></td>
                                </tr>
                                <tr>
                                    <td valign="top" height="*"><a href="JavaScript:doSubmitLogin();" id="submitA"><img src="themes/<%=theme%>/img/login/dl_button.png" width="266" height="58" /></a></td>
                                </tr>
                            </table></td>
                        <td width="*"  class="login_bgR">&nbsp;</td>
                    </tr>
                </table>
                <table width="100%" height="40" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                        <td class="login_bottom">版权所有：北京九恒星科技股份有限公司（NSTC）◎2011 京ICP证 030353</td>
                    </tr>
                </table></td>
        </tr>
    </table>
</form>
<!-- 业务逻辑代码开始 -->
<!-- 用于输入证书密码的层-->
<div id="forlogin" style="display: none">
    <table width="100%" border="0" align="center" cellpadding="4" cellspacing="0" bordercolor="#666666">
        <tr><td height="10"></td></tr>
        <tr>
            <td align="right" valign="middle">
                <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" bordercolor="#666666">
                    <tr>
                        <td align="center" >密　码：<input type="password" id="userpwd"/></td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</div>
<!-- 业务逻辑代码结束 -->
<%=sp.isLoginSign()?sp.buildActiveObjectScript():""%>
</body>
</html>


