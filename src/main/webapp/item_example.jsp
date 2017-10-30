<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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

<div id="searchtool" style="padding:5px">


    <span>单位</span>
    <select id="company" class="easyui-combobox" name="dept" style="width: 80px;">
        <option value=""></option>
        <option value="1">二级单位</option>
        <option value="2">伊犁钢铁</option>
        <option value="3">通钢</option>
    </select>
    <span>年份</span>
    <select id="year" class="easyui-combobox" name="year" style="width: 80px;">
        <option value=""></option>
        <option value="2016">2016</option>
        <option value="2017">2017</option>
        <option value="2018">2018</option>
        <option value="2018">2019</option>

    </select>
    <span>月份</span>
    <select id="month"class="easyui-combobox" name="month" style="width: 80px;">
        <option value=""></option>
        <option value="01">01</option>
        <option value="02">02</option>
        <option value="03">03</option>
        <option value="04">04</option>
        <option value="05">05</option>
        <option value="06">06</option>
        <option value="07">07</option>
        <option value="08">08</option>
        <option value="09">09</option>
        <option value="10">10</option>
        <option value="11">11</option>
        <option value="12">12</option>
    </select>


<button class="btn" id="ExportData">导出</button>

<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="SearchData()">导出</a>
</div>
<script>
    $("#ExportData").click(function() {
        var params = {"year":$('#year').combobox('getValue'), "month":$('#month').combobox('getValue')}
        location.href = '/chaxun/list/export?year='+params.year +'&'+'month='+params.month
    })





</script>
