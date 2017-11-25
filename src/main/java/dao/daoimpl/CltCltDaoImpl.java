package dao.daoimpl;
import com.github.pagehelper.PageHelper;
import  dao.BaseDaoImpl;
import  dao.AcntdataDao;
import dao.CltCltDao;
import entity.WstCashExport;
import entity.WstCashsweep;
import entity.WstCashsweepAcntdata;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import  java.util.List;
import java.util.Map;
import  entity.CltCltInfo;
import entity.CltCltInfo;
@Repository
public class CltCltDaoImpl extends BaseDaoImpl implements CltCltDao{
    public  List<CltCltInfo> querycltdatabycltno(String  cltname, int page, int rownum) throws Exception{

        PageHelper.startPage(page, rownum);
        Map map = new HashMap();
        map.put("cltname", cltname);


        return this.getSqlSession().selectList("mapper.CltCltInfoMapper.selectBycltno", map);
    } ;
}
