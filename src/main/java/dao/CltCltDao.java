package dao;
import entity.CltCltInfo;
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
public interface CltCltDao {
    List<CltCltInfo> querycltdatabycltno(String  cltname,  int page, int rownum) throws Exception ;
}
