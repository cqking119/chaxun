package dao;
import entity.WstCashExport;
import entity.WstCashsweep;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import sqlSessionFactory.BaseDaoImpl;
/**
 * Created by Malu on 2017-05-09.
 */

import  dao.AcntdataDao;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import  java.util.List;
import entity.WstCashsweepAcntdata;

public interface AcntdataDao {
     List<WstCashsweepAcntdata> queryAcntdatabycltno(String  cltno, Date startdate,String acntno,Date enddate, int page, int rownum) throws Exception ;
     void  DeleteInformationbyid(Integer id) throws Exception;
     void  SaveInformationbyid(Integer id, BigDecimal inamount,BigDecimal outamount)throws  Exception;

    List<WstCashExport> queryCashweepbyclt(String s1, String s2, int page, int rownum) throws Exception;
     List<WstCashExport> queryAcntCashsweepbyyili(String s1, String s2, int page, int rownum) throws Exception;
     List<WstCashExport> queryAcntCashsweepbytonghua(String s1, String s2, int page, int rownum) throws Exception;
   List<WstCashExport> queryAcntCashsweeptoexport(String s1, String s2) throws Exception;//nothing
}
