<%--
  Created by IntelliJ IDEA.
  User: Malu
  Date: 2017-05-31
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- 页面加载时运行js方法 --%>
<bodyonload bodyonload="reloadgrid()">

  <%-- 表格的加载 --%>

         <%-- 要传的参数变量--%>
   <div id="NodeChild"style="padding: 2px; font-size: 13px">市直单位定量指标1</div>

    <div style="margin: 10px0;"></div>
    <div id="tt"class="easyui-tabs" style="width: 1100px; height: 530px;margin-top: 15px">
        <div title="已录入单位"style="padding: 10px" >
            <table id="HaveInput"title="原始数据录入情况" class="easyui-datagrid" style="width:1050px; height: 480px; padding-left: 200px;"data-options="rownumbers:true,url:'ScoresDetailsCity.ashx/ProcessRequest',pageSize:5,pageList:[5,10,15,20],method:'get',toolbar:'#tb',"
                                    toolbar="#bar"pagination="true" rownumbers="true"fitcolumns="true" striped="true"singleselect="true">

                 <thead>
                   <tr>
                       <thdata-optionsthdata-options="field:'DepartmentName',width:100">单位名称</th>
                        <thdata-optionsthdata-options="field:'Data', width:75">原始数据</th>
                      <thdata-optionsthdata-options="field:'Remarks', width:175,align:'right'">备注</th>
                      <%--                        <thdata-optionsthdata-options="field:'CountScores', width:75,align:'right'">得分</th>--%>
                      <thdata-optionsthdata-options="field:'YearTime', width:85,align:'right'">年份</th>
                    </tr>
              </thead>
               </table>
             <div id="bar">
                   <ahrefahref="javascript:void(0)" class="easyui-linkbutton"iconcls="icon-edit" plain="true"onclick="editUser()">修改数据</a>
              </div>

         </div>


</body>
</html>
