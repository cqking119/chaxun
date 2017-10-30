package test;

/**
 * Created by Malu on 2017-05-16.
 */
import entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ChaxunService;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:spring/*.xml"} )
@Controller
public  class  TestChaxunController {


    @Autowired
    private ChaxunService chaxunService;

    @Test

    public void testchaxun() throws Exception {

        ResultInfo resultInfo = new ResultInfo();
        String cltno = "250200";
        String acntno="186";
        Integer page = 1;
        Integer rownum = 20;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String s = "2016-09-01";
        String s1 = "2017-10-01";
        Date startdate = sdf.parse(s);
        Date enddate = sdf.parse(s1);



        List<WstCashsweepAcntdata> list = chaxunService.querydataservice(cltno, startdate,acntno, enddate, page, rownum);
        resultInfo.addDatas("chaxun", list);
        System.out.println(resultInfo);
        for (WstCashsweepAcntdata tbItem : list) {
            System.out.println(tbItem.getId());

        }


    }
@Test
    public void testdetele() throws Exception {
        Integer ids[] = {209,210,211};
        for(int i=0;i<ids.length;i++){
            Integer id=ids[i];
            chaxunService.Deteteinformationservice(id);
        }

    }
    @Test
    public  void testsave()throws  Exception{
        BigDecimal inamount=new BigDecimal(0.1);
        BigDecimal outamoutnt=new BigDecimal(0.11);
        Integer id=553;
        chaxunService.Saveinformationservice(id,inamount,outamoutnt);



    }
    @Test
    public void testmouth() throws  Exception{

        String month="2016-01";
        String s1=month.substring(5);
        String s2=month.substring(0,4);
        System.out.println(s1);
        System.out.println(s2);
    }
    @Test
    public void testcashsweep() throws Exception {

        ResultInfo resultInfo = new ResultInfo();


        Integer page = 1;
        Integer rownum = 20;

        String month= "2017-01";
        String company="1";
        String s2=month.substring(5);
        String s1=month.substring(0,4);





        List<WstCashExport> list = chaxunService.queryCashsweepservice3(s2, s1,page,rownum);
        resultInfo.addDatas("chaxun", list);
        System.out.println(resultInfo);
        for (WstCashExport tbItem : list) {
            System.out.println(tbItem.getTotalcansweepbalance());

        }


    }
}


