package service.serviceimpl;
import dao.AcntdataDao;
import entity.*;
import dao.daoimpl.AcntdataDaoImpl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import service.HelloworldService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import dao.UserDao;
import javax.jws.soap.SOAPBinding;
import  service.ChaxunService;

/**
 * Created by Malu on 2017-05-09.
 */
@Service
public class Chaxunimpl implements ChaxunService{
 @Autowired
 private AcntdataDao acntdataDao;
    @Override
public List<WstCashsweepAcntdata> querydataservice(String cltno, Date startdate,String acntno,Date enddate ,int page, int rownum) throws Exception {
    List<WstCashsweepAcntdata> list =acntdataDao.queryAcntdatabycltno(cltno,startdate,acntno,enddate ,page, rownum);
    return list;

  };
    public void Deteteinformationservice (Integer id) throws Exception{
          acntdataDao.DeleteInformationbyid( id);

    };
    public  void Saveinformationservice(Integer id, BigDecimal inamount, BigDecimal outamount) throws  Exception {
            acntdataDao.SaveInformationbyid(id,inamount,outamount);
    }
    @Override
    public  List<WstCashExport> queryCashsweepservice1(String s1,String s2,int page, int rownum) throws Exception{
        List<WstCashExport> list = acntdataDao.queryCashweepbyclt(s1,s2,page,rownum);
        return  list;
    }
    @Override
    public  List<WstCashExport> queryCashsweepservice2(String s1,String s2,int page, int rownum) throws Exception {
        List<WstCashExport> list = acntdataDao.queryAcntCashsweepbyyili(s1, s2, page, rownum);
        return list;
    }
    @Override
    public  List<WstCashExport> queryCashsweepservice3(String s1,String s2,int page, int rownum) throws Exception {
        List<WstCashExport> list = acntdataDao.queryAcntCashsweepbytonghua(s1, s2, page, rownum);
        return list;
    }
    public  List<WstCashExport> queryCashsweepservice4(String s1,String s2) throws Exception{
        List<WstCashExport> list = acntdataDao.queryAcntCashsweeptoexport(s1, s2);
        return list;

    };
}
