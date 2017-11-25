package controller;
import com.github.pagehelper.PageInfo;
import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ChaxunService;
import service.CltCltService;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping(value = "cltname/list/")//后台最基本查询接口，datagrid查询接口
public class CltNoController {

        @Autowired
        private CltCltService cltCltService;

        @SuppressWarnings("unchecked")
        @RequestMapping(value = "cltname")//查询接口
        @ResponseBody
        public ResultInfoNew ChaXunCltname(@RequestParam(value = "cltname", required = true) String cltname,
                                           @RequestParam(value = "page", required = true) Integer page,
                                           @RequestParam(value = "rows", required = true) Integer rownum)
                throws Exception {
//        ResultInfoNew resultInfoNew = chaxunService.querydataservice(cltno,page,rownum);
//        return  resultInfoNew;

//        ResultInfoNew resultInfo=new ResulResultInfoNewtInfo();


            List<CltCltInfo> list = cltCltService.querycltservice(cltname, page, rownum);
            ResultInfoNew result = new ResultInfoNew();
            result.setRows(list);
            //取记录总条数
            PageInfo<CltCltInfo> pageInfo = new PageInfo<>(list);
            result.setTotal(pageInfo.getTotal());
            return result;
        }
    }
