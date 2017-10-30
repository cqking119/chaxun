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
<table class="easyui-datagrid" id="itemList" title="资金归集率信息查询"
                   data-options="singleSelect:false,collapsible:true,pagination:true,url:'/chaxun/list/cltno',method:'get',pageSize:30,toolbar:toolbar" toolbar="searchtool">
        <%--&lt;%&ndash;toolbar:toolbar&ndash;%&gt;toolbar="searchtool"--%>
        <thead>
        <tr>
            <th data-options="field:'ck',checkbox:true"></th>
            <th data-options="field:'id',width:60">序号</th>
            <th data-options="field:'cltno',width:60">单位编码</th>
            <th data-options="field:'cltname',width:200">单位名称</th>
            <th data-options="field:'acntno',width:100">银行账号</th>
            <th data-options="field:'actdate',width:100,formatter:TAOTAO.formatDateTime">发生日期</th>
            <th data-options="field:'inamount',width:70,align:'right'" >收入</th>
            <th data-options="field:'outamount',width:70,align:'right'">支出</th>
            <th data-options="field:'balance',width:100" >发生额</th>
            <th data-options="field:'state',width:60,align:'center'">状态</th>
            <th data-options="field:'totalbalance',width:130,align:'center'">当日余额</th>
        </tr>
        </thead>
</table>



<%--查询块表单--%>
<div id="searchtool" style="padding:5px">
    <span>单位编号:</span><input type="text" id="cltno" value="" size=10 />
    <span>银行账号:</span><input type="text" id="acntno" value="" size=10 />
    <span>初始日期:</span><input type="text" id ="startdate"  class="easyui-datebox" value="" size=10 />
    <span>截至日期:</span><input type="text" id ="enddate" class="easyui-datebox"value="" size=10 />

    <a href="javascript:void (0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="ProcessData()">查询</a><br>
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="DeleteData()">删除</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit'"  onclick="EditData()" >编辑</a>
</div>
<%--dlg为编辑页面弹出框，点击编辑页面出发--%>
<div id="dlg" class="easyui-dialog" style="width: 400px; height: 280px; padding: 10px 20px;"
     closed="true" buttons="#dlg-buttons">
    <div class="ftitle">
        录入信息编辑
    </div>
    <form id="fm" method="post">
        <div class="fitem">
            <label>
                序号
            </label>
            <%--设定为不可编辑--%>
            <input name="id" id="fid"  class="easyui-validatebox" required="false" disabled="true" />
        </div>
        <div class="fitem">
            <label>
                单位编号</label>
            <input name="cltno" id="fcltno" class="easyui-validatebox" required="false"disabled="true" />
        </div>
        <div class="fitem">
            <label>
                单位名称</label>
            <input name="cltname" id="fcltname" class="easyui-validatebox" required="false" disabled="true"/>
        </div>
        <div class="fitem">
            <label>
                收入</label>
            <input name="inamount" id="finamount" class="easyui-validatebox" required="true" />
        </div>
        <div class="fitem">
            <label>
                支出</label>
            <input name="outamount" id="foutamount" class="easyui-validatebox" required="true" />
        </div>
        <%--给后台传值为了让前台不可见的，生产时用到很多--%>
        <input type="hidden" name="action" id="hidtype" />
        <input type="hidden" name="ID" id="Nameid" />
    </form>
</div>

<div id="dlg-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="SaveData()" >保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="javascript:$('#dlg').dialog('close')" >取消</a>
</div>
<style type="text/css">
    #fm
    {
        margin: 0;
        padding: 10px 30px;
    }
    .ftitle
    {
        font-size: 14px;
        font-weight: bold;
        padding: 5px 0;
        margin-bottom: 10px;
        border-bottom: 1px solid #ccc;
    }
    .fitem
    {
        margin-bottom: 5px;
    }
    .fitem label
    {
        display: inline-block;
        width: 120px;//弹出表单的文本框的宽度
    }
</style>










<script>
//    var test = document.getElementById("ff").innerHTML
//    var param={key:3};
//    alert(test);
//    $('#itemlist').datagrid({
//        queryParams:{
//            cltno:'250200'
//        }
//
//    });
//

        function ProcessData() {  //查询数据javascript,这里不用加url,load方法会自动加参数,注意databox取参数需要特定的databox方法
      alert("陈奇")
            $('#itemList').datagrid('load', {
                    cltno: $('#cltno').val(),
                    acntno: $('#acntno').val(),
                    startdate: $('#startdate').datebox('getValue'),//这里需要特定的datebox取参数
                    enddate: $('#enddate').datebox('getValue')
//不用加url,load方法自动走datagrid的url


//                    url: "/chaxun/list/cltno?cltno=" + cltno

                }
            );
        }


//        var test = document.getElementById("ff").innerHTML;
//        var param={key:3};

        //查询参数直接添加在queryParams中
//        $("#itemList").datagrid({
//            url: "/chaxun/list/cltno?cltno=" + test,
//            queryParams:param
//        })
//        var queryParams = $('#itemList').datagrid('options').queryParams;
//        getQueryParams(queryParams);
//        $("#itemList").datagrid('options').queryParams = queryParams;
//
//        $("#itemList").datagrid('reload');


//getSelectionsIds()方法是取出选中的id的
    function getSelectionsIds(){
    	var itemList = $("#itemList");
    	var sels = itemList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].id);//将选中的id用push方法放到sels数组中；
    	}
    	ids = ids.join(",");
    	return ids;
    }
   function DeleteData(){//删除数据的javascript，是将需要删除的前台的数据id取出，传入后台调用mybatis删除

       var data = $("#itemList").datagrid("getSelections")[0];
       var ids = getSelectionsIds();//通过getSelectionsIds获取ids
       if(ids.length == 0){//数组中数据为0，说明并未点选需要删除信息，此时提示未选中信息
           $.messager.alert('提示','未选中需要删除信息');
           return ;
       }
       $.messager.confirm('确认','确定删除所选录入信息吗？',function(r){
           if (r){

               var params = {"ids":ids};//将前台需要删除的数据id放到ids数组中去，传给后台参数ids

               $.post("/chaxun/list/delete",params, function(data){//post方法调用后台删除接口
                   if(data.status == 200) {//data后台传给前台的数,后台result传200，说明删除成功
                       $.messager.alert('提示', '删除资金信息成功!', undefined, function () {
                           $("#itemList").datagrid("reload");//删除完后回显数据
                       });
                   }
               });
           }
       });

   }
   function EditData() {
       var itemList = $("#itemList");
       var sels = itemList.datagrid("getSelections")[0];
       var ids = getSelectionsIds();
       if (ids.length == 0) {
           $.messager.alert('提示', '必须选择一条录入信息才能编辑!');
           return;
       }
       if(ids.indexOf(',') > 0){
           $.messager.alert('提示','只能选择一条录入信息!');
           return ;
       }

       if (sels) {
           $("#dlg").dialog("open").dialog('setTitle', '编辑信息');
           $("#fm").form("load",sels);
//          url = "/chaxun/list/save?id=" + sels.id+""
       }


   }
function SaveData() {
    var params = {"id":$('#fid').val(),"inamount":$('#finamount').val(),"outamount":$('#foutamount').val()};
    $("#fm").form("submit", {

    url:  '/chaxun/list/save?id='+params.id +'&'+'inamount='+params.inamount+'&'+'outamount='+params.outamount,
//        url: url,
        onsubmit: function () {
////
//            var params = {"id":$('#fid').val(),"inamount":$('#finamount').val(),"outamount":$('#foutamount').val()};
//
//            $.post("/chaxun/list/save",params, function(data){
//                if(data.status == 200) {
//                    $.messager.alert('提示', '修改资金信息成功!', undefined, function () {
//                        $("#itemList").datagrid("reload");
//                    });
//                }
//            });
        },

        success: function (data) {
        var data=eval('('+data+')');
            if (data.status == 200) {
                $.messager.alert("提示信息", "操作成功");
                $("#dlg").dialog("close");
                $("#itemList").datagrid("load");
            }
            else {
                $.messager.alert("提示信息", "操作失败");
            }
        }
    });
}
    var toolbar = [{
        text:'新增',
        iconCls:'icon-add',
        handler:function(){
        	$(".tree-title:contains('新增商品')").parent().click();
        }
    },{
        text:'编辑',
        iconCls:'icon-edit',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','必须选择一个商品才能编辑!');
        		return ;
        	}
        	if(ids.indexOf(',') > 0){
        		$.messager.alert('提示','只能选择一个商品!');
        		return ;
        	}
        	
        	$("#itemEditWindow").window({
        		onLoad :function(){
        			//回显数据
        			var data = $("#itemList").datagrid("getSelections")[0];
        			data.priceView = TAOTAO.formatPrice(data.price);
        			$("#itemeEditForm").form("load",data);
        			
        			// 加载商品描述
        			$.getJSON('/rest/item/query/item/desc/'+data.id,function(_data){
        				if(_data.status == 200){
        					//UM.getEditor('itemeEditDescEditor').setContent(_data.data.itemDesc, false);
        					itemEditEditor.html(_data.data.itemDesc);
        				}
        			});
        			
        			//加载商品规格
        			$.getJSON('/rest/item/param/item/query/'+data.id,function(_data){
        				if(_data && _data.status == 200 && _data.data && _data.data.paramData){
        					$("#itemeEditForm .params").show();
        					$("#itemeEditForm [name=itemParams]").val(_data.data.paramData);
        					$("#itemeEditForm [name=itemParamId]").val(_data.data.id);

        					//回显商品规格
        					 var paramData = JSON.parse(_data.data.paramData);
        					
        					 var html = "<ul>";
        					 for(var i in paramData){
        						 var pd = paramData[i];
        						 html+="<li><table>";
        						 html+="<tr><td colspan=\"2\" class=\"group\">"+pd.group+"</td></tr>";
        						 
        						 for(var j in pd.params){
        							 var ps = pd.params[j];
        							 html+="<tr><td class=\"param\"><span>"+ps.k+"</span>: </td><td><input autocomplete=\"off\" type=\"text\" value='"+ps.v+"'/></td></tr>";
        						 }
        						 
        						 html+="</li></table>";
        					 }
        					 html+= "</ul>";
        					 $("#itemeEditForm .params td").eq(1).html(html);
        				}
        			});
        			
        			TAOTAO.init({
        				"pics" : data.image,
        				"cid" : data.cid,
        				fun:function(node){
        					TAOTAO.changeItemParam(node, "itemeEditForm");
        				}
        			});
        		}
        	}).window("open");
        }
    },{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中商品!');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除ID为 '+ids+' 的商品吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/rest/item/delete",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','删除商品成功!',undefined,function(){
            					$("#itemList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    },'-',{
        text:'下架',
        iconCls:'icon-remove',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中商品!');
        		return ;
        	}
        	$.messager.confirm('确认','确定下架ID为 '+ids+' 的商品吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/rest/item/instock",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','下架商品成功!',undefined,function(){
            					$("#itemList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    },{
        text:'上架',
        iconCls:'icon-remove',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中商品!');
        		return ;
        	}
        	$.messager.confirm('确认','确定上架ID为 '+ids+' 的商品吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/rest/item/reshelf",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','上架商品成功!',undefined,function(){
            					$("#itemList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    }];


</script>
</body>