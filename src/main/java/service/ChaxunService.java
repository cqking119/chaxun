package service;
import entity.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
/**
 * Created by Malu on 2017-04-10.
 */

public interface ChaxunService {
/**
 * Created by chenqi on 2017/2/17.
 */
  List<WstCashsweepAcntdata> querydataservice(String cltno, Date startdate,String acntno,Date enddate ,int page, int rownum) throws Exception;
        void Deteteinformationservice (Integer id) throws Exception;
        void Saveinformationservice(Integer id, BigDecimal inamount,BigDecimal outamount) throws  Exception;
    List<WstCashExport> queryCashsweepservice1(String s1,String s2,int page, int rownum) throws Exception;
    List<WstCashExport> queryCashsweepservice2(String s1,String s2,int page, int rownum) throws Exception;
    List<WstCashExport> queryCashsweepservice3(String s1,String s2,int page, int rownum) throws Exception;
    List<WstCashExport> queryCashsweepservice4(String s1,String s2) throws Exception;
}

