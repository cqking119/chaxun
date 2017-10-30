package dao;

import entity.Helloworld;
import entity.Userinformation;

import java.util.Map;

/**
 * Created by chenqi on 2017/2/17.
 */

public interface UserDao {
   Helloworld bigCustomersQueryDao() throws Exception;
   Helloworld querybyidDao(Integer id) throws Exception;
    int insertuser(Userinformation userinformation ) throws  Exception;

}
