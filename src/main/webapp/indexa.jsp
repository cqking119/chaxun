<%@page contentType="text/html;charset=utf-8" %>
<html>

<head>
    <meta http-equiv="CONTENT-TYPE" content="text/html"; charset="utf-8"/>
    <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#bs").click(function () {
                $.getJSON("chaxun/api/demo/chaxun", function (result) {
                    $.each(result, function (i, field) {

                        if (i % 2 != 1) {
                            $("p").append("银行  " + field.bank);
                        }
                        else {
                            $("p").append("金额  " + field.amount + "<br>");
                        }
                    })
                })
            })
            $("#cs").click(function () {
                $.getJSON("chaxun/api/demo/chaxun2", function (result) {
                    $.each(result, function (i, field) {

                        if (i % 2 != 1) {
                            $("p").append("核算账号" + field.no);
                        }
                        else {
                            $("p").append("金额  " + field.balance + "<br>");
                        }
                    })
                })
            })


            $("#yue").click(function () {
            $.getJSON("chaxun/api/demo/chaxun3", function (result) {
                $.each(result, function (i, field) {


                    $("p").append("差额 " + field.amount + "<br>");


                })
            })
        })
        })



//     $(function(){
//         $.ajax({
//             url:'api/demo/chaxun',
//             type:'GET',
//             dataType:'json',
//             timout:1000,
//             cache:false,
//             beforeSend:LoadFunction,
//             error:erryfunction,
//             success:succFunction
//             })
//        function  LoadFunction() {
//            $("#list".html('加载中')；
//        }
//    function  erryfunction() {
//        alert("error");
//    }
//    function  succFunction(tt) {
//             var json=eval(tt);
//             var tt="";
//             $.each(json,function (index) {
//                 var Bank=json[index];
//               tt+=Bank+"<br>"
//
//             });
//             $("#list").html('');
//              $("#list").html(tt);
//
//    }
//     })




    </script>
</head>
<body>
<ul id="list"></ul>
<button id="cs" >cs</button>
<button id="bs">bs</button>
<button id="yue">差额</button>

<%--<ul id="list2"></ul>--%>
<%--<button id="button2" value="button2">结算</button>--%>
<p></p>
</body>
</html>
