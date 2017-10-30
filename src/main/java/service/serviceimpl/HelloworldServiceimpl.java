package service.serviceimpl;

import entity.Helloworld;
import entity.ResultInfo;
import entity.Userinformation;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import service.HelloworldService;
import java.util.Map;
import dao.UserDao;

import javax.jws.soap.SOAPBinding;

/**
 * Created by chenqi on 2017/2/17.
 */
//@Service
//public class HelloworldServiceimpl implements HelloworldService {
//
//     @Autowired
//     private UserDao userDao;
//    @Override
//      public  Helloworld queryHelloWorldservice() throws Exception {
//
//
//        Helloworld helloworld = userDao.bigCustomersQueryDao();
//         return  helloworld;
//
//
//
//        };
//
//    @Override
//    public  Helloworld querybyidservice(Integer id) throws Exception {
//
//
//        Helloworld helloworld = userDao.querybyidDao(id);
//        return  helloworld;
//
//
//
//    };
//    public int insertuserservice(Userinformation userinformation)throws Exception {
//        ResultInfo resultInfo = new ResultInfo();
//        int res = userDao.insertuser(userinformation);
//        return  res ;
//    }
//
//}
