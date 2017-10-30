package dao.daoimpl;

/**
 * Created by Malu on 2017-05-09.
 */
import com.github.pagehelper.PageHelper;
import  dao.BaseDaoImpl;
import  dao.AcntdataDao;
import entity.WstCashExport;
import entity.WstCashsweep;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import  java.util.List;
import java.util.Map;

import entity.WstCashsweepAcntdata;


@Repository
public class AcntdataDaoImpl  extends BaseDaoImpl implements AcntdataDao {
    @Override

    public List<WstCashsweepAcntdata> queryAcntdatabycltno(String cltno, Date startdate, String acntno, Date enddate, int page, int rownum) throws Exception {
        PageHelper.startPage(page, rownum);
        Map map = new HashMap();
        map.put("cltno", cltno);
        map.put("acntno", acntno);
        map.put("startdate", startdate);
        map.put("enddate", enddate);


        return this.getSqlSession().selectList("mapper.WstCashsweepAcntdataMapper.selectByPrimaryKey", map);
    }

    public void DeleteInformationbyid(Integer id) throws Exception {

        this.getSqlSession().delete("mapper.WstCashsweepAcntdataMapper.deleteByPrimaryKey", id);

    }

    ;

    public void SaveInformationbyid(Integer id, BigDecimal inamount, BigDecimal outamount) throws Exception {
        BigDecimal balance = inamount.subtract(outamount);
        Map map = new HashMap();
        map.put("id", id);
        map.put("inamount", inamount);
        map.put("outamount", outamount);
        map.put("balance", balance);
        this.getSqlSession().update("mapper.WstCashsweepAcntdataMapper.saveByPrimaryKey", map);

        Map map1 = new HashMap();
        map1.put("idValF", id);

        map1.put("state", "4");
        this.getSqlSession().update("mapper.WstCashsweepAcntdataMapper.updatebalancebyid", map1);
    }

    public List<WstCashExport> queryCashweepbyclt(String s1, String s2, int page, int rownum) throws Exception {
        PageHelper.startPage(page, rownum);
        Map map = new HashMap();
        String s=s2+'-'+s1;

        map.put("year_month", s);


        return this.getSqlSession().selectList("mapper.WstCashsweepMapper.selectBytwolevel", map);

    }

    public List<WstCashExport> queryAcntCashsweepbyyili(String s1, String s2, int page, int rownum) throws Exception {
        PageHelper.startPage(page, rownum);
        Map map = new HashMap();
        String s=s2+'-'+s1;

        map.put("year_month", s);

        return this.getSqlSession().selectList("mapper.WstCashsweepMapper.selectByyili", map);
    }

    public List<WstCashExport> queryAcntCashsweepbytonghua(String s1, String s2, int page, int rownum) throws Exception {
        PageHelper.startPage(page, rownum);
        Map map = new HashMap();
        String s=s2+'-'+s1;

        map.put("year_month", s);


        return this.getSqlSession().selectList("mapper.WstCashsweepMapper.selectBytonghua", map);
    }
    public List<WstCashExport> queryAcntCashsweeptoexport(String s1, String s2) throws Exception {

        Map map = new HashMap();
        String s=s1+'-'+s2;
//        map.put("re_year", s2);
        map.put("year_month", s);
        return this.getSqlSession().selectList("mapper.WstCashsweepMapper.selectToExport", map);
//        map.put("re_year", s2);
//        map.put("re_month", s1);
//        return this.getSqlSession().selectList("mapper.WstCashsweepMapper.selectBytwolevel", map);
    }

}