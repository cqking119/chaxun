<%--录入信息修改--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/icon.css" />
    <link rel="stylesheet" type="text/css" href="css/taotao.css" />
    <script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="js/common.js"></script>
    <script type="text/javascript" src="js/jquery.datagrid.js"></script>
    <%--<style type="text/css">--%>
    <%--.content {--%>
    <%--padding: 10px 10px 10px 10px;--%>
    <%--}--%>
    <%--</style>--%>
</head>
<body>
<%--datagrid表单--%>
<table class="easyui-datagrid" id="itemList" title="成员单位编号查询"
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/cltname/list/cltname',method:'get',pageSize:30,toolbar:toolbar" toolbar="searchtool">
    <%--&lt;%&ndash;toolbar:toolbar&ndash;%&gt;toolbar="searchtool"--%>
    <thead>
    <tr>
        <th data-options="field:'ck',checkbox:true"></th>
        <th data-options="field:'cltno',width:200">单位编码</th>
        <th data-options="field:'chinesename',width:200">单位名称</th>
    </tr>
    </thead>
</table>
<div id="searchtool" style="padding:5px">
<span>单位名称:</span><input type="text" id="cltname"  size=10 />
<a href="javascript:void (0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="SearchCltname()">查询</a><br>
 <form action="item-list.jsp" method="post">
     <input type="text" name="accltno" id="accltno">
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit'"  onclick="AcquireCltno()" >获取</a>
 </form>
</div>

</body>
<script>
        function SearchCltname() {  //查询数据javascript,这里不用加url,load方法会自动加参数,注意databox取参数需要特定的databox方法
        $('#itemList').datagrid('load', {
                cltname: $('#cltname').val(),

//不用加url,load方法自动走datagrid的url


//                    url: "/chaxun/list/cltno?cltno=" + cltno

            }
        );
    }
        function getSelectionsIds(){
            var itemList = $("#itemList");
            var sels = itemList.datagrid("getSelections");
            var ids = [];
            for(var i in sels){
                ids.push(sels[i].cltno);//将选中的id用push方法放到sels数组中；
            }
            ids = ids.join(",");
            return ids;
        }
        function AcquireCltno() {
            var itemList = $("#itemList");
            var sels = itemList.datagrid("getSelections")[0];
            var ids = getSelectionsIds();
            if (ids.length == 0) {
                $.messager.alert('提示', '必须选择一个成员单位编号!');
                return;
            }
            if(ids.indexOf(',') > 0){
                $.messager.alert('提示','只能选择一个成员单位编号!');
                return ;
            }
           var text=sels.cltno;
         $("#accltno").val(sels.cltno);
            localStorage.setItem("text",text);//这种方式传递参数是最最简单的！！
        }

</script>