<%--二级单位资金归集率查询--%>
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
<table class="easyui-datagrid" id="cashsweepList" title="二级单位资金归集率查询"
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/chaxun/list/cashsweep',method:'get',pageSize:30 " toolbar="output">
    <%--&lt;%&ndash;toolbar:toolbar&ndash;%&gt;toolbar="searchtool"--%>
    <%--mybatis自动产生实体类的时候数据库字段有‘_’无法解析出来--%>
    <thead>
    <tr>
        <th data-options="field:'ck',checkbox:true"></th>
        <th data-options="field:'cltname',width:200">单位名称</th>
        <th data-options="field:'totalbeforemonthamount',width:120">日存放财务公司余额</th>
        <th data-options="field:'totalcansweepbalance',width:120">日均可归集资金</th>
        <th data-options="field:'cancashsweepratemean',width:140">可归集口径资金（月日均)</th>
        <th data-options="field:'totalcurrencymoneybalance',width:100">日均资金总额</th>
        <th data-options="field:'cashsweepratemean',width:150">全口径资金归集率（月日均）</th>
        <th data-options="field:'beforemonthamount',width:150" >期末存放财务公司余额</th>
        <th data-options="field:'cansweepbalance',width:150">期末可归集资金</th>
        <th data-options="field:'cancashsweeprate',width:150" >可归集口径资金归集率（期末)</th>
        <th data-options="field:'currencymoneybalance',width:150">期末资金总额</th>
        <th data-options="field:'cashsweeprate',width:150">全口径资金归集率（期末)</th>
    </tr>
    </thead>
</table>

<div id="output" style="padding:5px">

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

    <%--<span>单位: </span>--%>
        <%--<select id="company" style="height: 24px;width: 163px;">--%>
       <%--<option value="">选择单位</option>--%>
       <%--<option value="1">二级单位</option>--%>
       <%--<option value="2">伊犁钢铁</option>--%>
       <%--<option value="3">通钢</option>--%>
       <%--</select>--%>

    <%--<span>月份:</span><input type="month" id="month"  value=""  size=10 />--%>
    <%--<span>月份:</span><input type="text" id ="startdate"  class="easyui-datetime" value="" size=10 />--%>

    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="SearchData()">查询</a>


    <%--<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="ExportData()">导出</a>--%>
    <%--<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit'"  onclick="EditData()" >编辑</a>--%>
</div>
<button id="deviceExport">导出</button>
<script>
  function SearchData(){
      alert("陈奇最帅")
      $('#cashsweepList').datagrid('load', {
          company: $('#company').combobox('getValue'),
          month: $('#month').combobox('getValue'),
          year:$('#year').combobox('getValue')
//          startdate: $('#startdate').datebox('getValue'),
//          enddate: $('#enddate').datebox('getValue')


          }
      );
  }


      $("#deviceExport").click(function () {
          var params = {"year": $('#year').combobox('getValue'), "month": $('#month').combobox('getValue')};
          location.href = '/chaxun/list/export?year=' + params.year + '&' + 'month=' + params.month


      })


      function  ExportData() {

//      $("#fm").form("submit", {
//
//          url:  '/chaxun/list/export?year='+params.year +'&'+'month='+params.month+'&',
//          onsubmit: function () {
//  },
//          success: function (data) {
//              var data=eval('('+data+')');
//              if (data.status == 200) {
//                  $.messager.alert("提示信息", "导出成功");
//
//              }
//              else {
//                  $.messager.alert("提示信息", "操作失败");
//              }
//          }
      $.messager.confirm('确认', '确定导出该月数据吗', function (r) {
          var params = {"year":$('#year').combobox('getValue'), "month":$('#month').combobox('getValue')};
          if (r) {

              $.get("/chaxun/list/export", params, function (data) {
                  if (data.status == 200) {
                      $.messager.alert('提示', '导出成功!', undefined, function () {
                      });
                  }
              });
          }
      });
  }


</script>
</body>
</html>
