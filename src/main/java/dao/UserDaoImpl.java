package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import dao.UserDao;


import entity.ResultInfo;
import entity.Userinformation;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import sqlSessionFactory.BaseDaoImpl;

import entity.Helloworld;
import entity.Userinformation;



import jdbc.JDBC;

///**
// * Created by chenqi on 2017/2/17.
// */
//@Repository
//public class UserDaoImpl extends  BaseDaoImpl implements UserDao{
//
//    @Override
//    public  Map<String, String> bigCustomersQueryDao() throws Exception{
//    Map<String, String> map = new HashMap<String, String>();
//    Connection conn = null;
//    conn = JDBC.getConnection();
//
//        String sql="select name from helloworld where id=1" ;
//        PreparedStatement pstmt = conn.prepareStatement(sql);
//
//            ResultSet rs = pstmt.executeQuery();
//        while(rs.next()) {
//            map.put("1", rs.getString("name"));
//        }

//    @Override
//    public  Helloworld bigCustomersQueryDao() throws Exception{
//
//            return this.getSqlSession().selectOne("mapper.HelloworldMapper.selectByPrimaryKey",2); mapper.WstCashsweepAcntdataMapper.selectByPrimaryKey
//
//}
//      @Override
//    public  Helloworld querybyidDao(Integer id) throws Exception{
//
//          return this.getSqlSession().selectOne("mapper.HelloworldMapper.selectByPrimaryKey",id);
//      }
//      public int insertuser(Userinformation userinformation ) throws  Exception {
//
//          return  this.getSqlSession().insert("mapper.UserinformationMapper.insert",userinformation);
//      }
//}
