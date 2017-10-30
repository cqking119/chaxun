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


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Malu on 2017-05-17.
 */
@Controller
@RequestMapping(value = "chaxun/list/")//后台最基本查询接口，datagrid查询接口
public class ChaXunController {
    @Autowired
    private ChaxunService chaxunService;

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "cltno")//查询接口
    @ResponseBody
    public ResultInfoNew ChaXuncltno(@RequestParam(value = "cltno", required = true) String cltno, @RequestParam(value = "startdate", required = true) String startonedate,
                                     @RequestParam(value = "acntno", required = true) String acntno,
                                     @RequestParam(value = "enddate", required = true) String endonedate,
                                     @RequestParam(value = "page", required = true) Integer page,
                                     @RequestParam(value = "rows", required = true) Integer rownum)
            throws Exception {
//        ResultInfoNew resultInfoNew = chaxunService.querydataservice(cltno,page,rownum);
//        return  resultInfoNew;

//        ResultInfoNew resultInfo=new ResulResultInfoNewtInfo();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Date startdate = sdf.parse(startonedate);
        Date enddate = sdf.parse(endonedate);

        List<WstCashsweepAcntdata> list = chaxunService.querydataservice(cltno, startdate, acntno, enddate, page, rownum);
        ResultInfoNew result = new ResultInfoNew();
        result.setRows(list);
        //取记录总条数
        PageInfo<WstCashsweepAcntdata> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
//        ResultInfoNew resultInfoNew = chaxunService.querydataservice(cltno,page,rownum );
//             resultInfo.addDatas("chaxun",list);
//             return  resultInfo ;


    }

    //    @Autowired
//    private  ChaxunService chaxunService;
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody

    public TaotaoResult DeleteInformation(@RequestParam(value = "ids") Integer[] ids) throws Exception {

        for (int i = 0; i < ids.length; i++) {
            Integer id = ids[i];
            chaxunService.Deteteinformationservice(id);
        }
        TaotaoResult result = TaotaoResult.ok();
        return result;

    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody

    public TaotaoResult SaveInformation(@RequestParam(value = "id") Integer id, @RequestParam(value = "inamount") BigDecimal inamount, @RequestParam(value = "outamount") BigDecimal outamount) throws Exception {
        chaxunService.Saveinformationservice(id, inamount, outamount);
        TaotaoResult result = TaotaoResult.ok();
        return result;
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "cashsweep")
    @ResponseBody
    public ResultInfoNew ChaxunCashsweep(@RequestParam(value = "company") String company, @RequestParam(value = "month") String month, @RequestParam(value = "year") String year, @RequestParam(value = "page", required = true) Integer page,
                                         @RequestParam(value = "rows", required = true) Integer rownum) throws Exception {

        String s1 = month;
        String s2 = year;
        ResultInfoNew result = new ResultInfoNew();
        if (company.equals("1")) {

            List<WstCashExport> list = chaxunService.queryCashsweepservice1(s1, s2, page, rownum);
            result.setRows(list);
            //取记录总条数
            PageInfo<WstCashExport> pageInfo = new PageInfo<>(list);
            result.setTotal(pageInfo.getTotal());
            return result;

        }
        if (company.equals("2")) {

            List<WstCashExport> list = chaxunService.queryCashsweepservice2(s1, s2, page, rownum);
            result.setRows(list);

            //取记录总条数
            PageInfo<WstCashExport> pageInfo = new PageInfo<>(list);
            result.setTotal(pageInfo.getTotal());

            return result;
        }


        if (company.equals("3")) {


            List<WstCashExport> list = chaxunService.queryCashsweepservice3(s1, s2, page, rownum);
            result.setRows(list);

            //取记录总条数
            PageInfo<WstCashExport> pageInfo = new PageInfo<>(list);
            result.setTotal(pageInfo.getTotal());
            return result;

        }

        return result;

    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "export")
    @ResponseBody
    public TaotaoResult export(HttpServletRequest request, HttpServletResponse response,
                        @RequestParam(value = "month") String month, @RequestParam(value = "year") String year) throws Exception {
        String s1= year;//为什么会出现导出excel出现空字段的问题，猜测是由于并非查询出所有字段，和实体类中的字段没有一一对应，这种导出必须要求mapper.xml需要全查询才行，要不就修改字段。
        String s2 = month;
        String s=year+'-'+month ;
        List<WstCashExport> list = chaxunService.queryCashsweepservice4(s1,s2);
        ExportExcel<WstCashExport> ee= new ExportExcel<WstCashExport>();
        String[] headers = { "单位名称","日存放财务公司余额","日均可归集资金","可归集口径资金（月日均)","日均资金总额","全口径资金归集率（月日均）","期末存放财务公司余额","期末可归集资金","可归集口径资金归集率（期末)","期末资金总额","全口径资金归集率（期末)" };
//           String[] headers = { "期末存放财务公司余额","期末可归集资金","可归集口径资金归集率期末","期末资金总额","全口径资金归集率期末" };

        String fileName = s+"二级单位资金归集率汇总";
        ee.exportExcel(headers,list,fileName,response);
        TaotaoResult result = TaotaoResult.ok();
        return result;
    }

}
