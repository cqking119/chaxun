package controller;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.*;

import dao.UserDao;
import entity.Helloworld;
import entity.Userinformation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import entity.ResultInfo;
import service.HelloworldService;
import entity.ResultInfo;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by chenqi on 2017/2/17.
 */
@Controller
@RequestMapping(value = "api/demo/")
public class helloworldcontroller {

//    @Autowired
//    private HelloworldService helloworldService;
//
//    @SuppressWarnings("unchecked")
//    @RequestMapping(value = "Helloworld")
//    @ResponseBody
//    public ResultInfo bigCustomersQuery() throws Exception {
//        ResultInfo resultInfo = new ResultInfo();
//
//
//        Helloworld helloworld = helloworldService.queryHelloWorldservice();
//        resultInfo.addDatas("helloworld", helloworld);
//
//        return resultInfo;
//    }
//
//    @SuppressWarnings("unchecked")
//    @RequestMapping(value = "querybyid")
//    @ResponseBody
//
//    public ResultInfo querybyid(@RequestParam("id") Integer id) throws Exception {
//        ResultInfo resultInfo = new ResultInfo();
//
//
//        Helloworld helloworld = helloworldService.querybyidservice(id);
//        resultInfo.addDatas("helloworld", helloworld);
//
//        return resultInfo;
//    }
//
//    @SuppressWarnings("unchecked")
//    @RequestMapping(value = "insertuser", method = RequestMethod.POST)
//    @ResponseBody
//    public ResultInfo insertuser(@RequestParam(value = "id", required = false) Integer id,
//                                 @RequestParam(value = "province", required = false) String province,
//                                 @RequestParam(value = "city", required = false) String city,
//                                 @RequestParam(value = "time", required = false) Date time,
//                                 @RequestParam(value = "telephone", required = false) String telephone) throws Exception {
//
//
//        ResultInfo resultInfo = new ResultInfo();
//        Userinformation userinformation = new Userinformation();
//        userinformation.setCity(city);
//        userinformation.setId(id);
//        userinformation.setProvince(province);
//        userinformation.setTelephone(telephone);
//        userinformation.setTime(time);
//        int res = helloworldService.insertuserservice(userinformation);
//
//        resultInfo.addDatas("insertuser", res);
//        return resultInfo;
//
//    }



    @SuppressWarnings("unchecked")
    @RequestMapping(value = "chaxun")
@ResponseBody
    public List chaxun() throws Exception {
        ResultInfo resultInfo = new ResultInfo();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //  System.out.println("success");


        } catch (Exception e) {
            System.out.println("failure");
            e.printStackTrace();
        }
        List<Map<String, String>> list = null;
        try {
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.208.106:1521:sgcwgs1", "nstcsa", "a1111111");
            System.out.println("success");
            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("select * from bp_account where acnttype='R' order by case when bankno='11' then 1 when bankno='05'then 2when bankno='02'then 3  when bankno='01'then 4 when bankno='04'then 5\n" +
//                    " when bankno='03'then 6\n" +
//                    "                when bankno='08'then 7 \n" +
//                    "                  when bankno='41'then 8\n" +
//                    "                    when bankno='06'then 9\n" +
//                    "when bankno='07' THEN 10\n "+
//                    "                      end ");
                        ResultSet resultSet = statement.executeQuery("select * from vw_chaxun");
//            ResultSet resultSet2 = statement.executeQuery("select * from vw_chaxun2 ");
            list = new ArrayList<Map<String, String>>();
           // Map<String, String> map = new HashMap<String, String>();

            while (resultSet.next()) {
                Map<String, String> map1 = new HashMap<String, String>();
                Map<String, String> map2 = new HashMap<String, String>();
                NumberFormat nf=new DecimalFormat("$,###.##") ;
                String a = resultSet.getString(7);
                String c="bank";
//               b=resultSet.getBigDecimal(8);
//                BigDecimal b2=resultSet2.getBigDecimal(3);
//                BigDecimal b3=b1.subtract(b2);
//                String b=String.valueOf(b3);

                String b = nf.format((resultSet.getBigDecimal(8)));
                String d="amount";
                //String c = a + "," + b;

                map1.put(c, a);
                map2.put(d,b);
                list.add(map1);
                list.add(map2);
                resultInfo.addDatas("i", list);
                System.out.println(resultInfo);

            }

              connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error");
        }

        return list;
    }
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "chaxun2")
    @ResponseBody
    public List chaxun2() throws Exception {
        ResultInfo resultInfo = new ResultInfo();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //  System.out.println("success");


        } catch (Exception e) {
            System.out.println("failure");
            e.printStackTrace();
        }
        List<Map<String, String>> list = null;
        try {
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.208.106:1521:sgcwgs1", "nstcsa", "a1111111");
            System.out.println("success");
            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("select * from cntlist t where t.no in ('101101010100101','101101010200101','101101010300101','101101010400101','101101010500101','101101010600101','101101011800101','101101010700101','101101010800101','101101010900101','101101011600101','101101011800101') and t.rdate in (select to_date(to_char(sysdate,'yyyy-mm-dd'),'yyyy-mm-dd')from dual )\n");
//            ResultSet resultSet2 = statement.executeQuery("select * from vw_chaxun2 ");
                        ResultSet resultSet= statement.executeQuery("select * from vw_chaxun2 ");

            list = new ArrayList<Map<String, String>>();
            // Map<String, String> map = new HashMap<String, String>();

            while (resultSet.next()) {
                Map<String, String> map1 = new HashMap<String, String>();
                Map<String, String> map2 = new HashMap<String, String>();
                NumberFormat nf=new DecimalFormat("$,###.##") ;
                String a = resultSet.getString(1);
                String c="no";
//               b=resultSet.getBigDecimal(8);
//                BigDecimal b2=resultSet2.getBigDecimal(3);
//                BigDecimal b3=b1.subtract(b2);
//                String b=String.valueOf(b3);
                String b = nf.format((resultSet.getBigDecimal(3)));
                String d="balance";
                //String c = a + "," + b;

                map1.put(c, a);
                map2.put(d,b);
                list.add(map1);
                list.add(map2);
                resultInfo.addDatas("i", list);
                System.out.println(resultInfo);

            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error");
        }

        return list;
    }
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "chaxun3")
    @ResponseBody
    public List chaxun3() throws Exception {
        ResultInfo resultInfo = new ResultInfo();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //  System.out.println("success");


        } catch (Exception e) {
            System.out.println("failure");
            e.printStackTrace();
        }
        List<Map<String, String>> list = null;
        try {
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.208.106:1521:sgcwgs1", "nstcsa", "a1111111");
            System.out.println("success");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from vw_chaxun_amout  ");
//            ResultSet resultSet2 = statement.executeQuery("select * from vw_chaxun2 ");
            list = new ArrayList<Map<String, String>>();
            // Map<String, String> map = new HashMap<String, String>();
            BigDecimal A[]=new BigDecimal[24];
            BigDecimal B[]=new BigDecimal[12];
            int i=0 ;
            while (resultSet.next()) {




                A[i] =resultSet.getBigDecimal(1);
                String b=String.valueOf(A[i]);


                resultInfo.addDatas("i", b);
                System.out.println(resultInfo);
                System.out.println(i);
                i++;
            }
            String C[]={"华夏","交通" ,"建设","工商","农业","中国银行","兴业银行","北京银行"," 招商银行"," 中国光大银行","民生银行","兴业银行新开户"};
           for (int j=0;j<12;j++){
               Map<String, String> map= new HashMap<String, String>();
               NumberFormat nf=new DecimalFormat("$,###.##") ;
                B[j]=A[j].subtract(A[j+12]);
                String a="amount";
                String b=nf.format((B[j]))+C[j];
                map.put(a,b);
                 list.add(map);
           }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error");
        }

        return list;
    }
//    @SuppressWarnings("unchecked")
//    @RequestMapping(value = "chaxun5")
//    @ResponseBody
//    public List chaxun5() throws Exception {
//        ResultInfo resultInfo = new ResultInfo();
//
//    }
}








