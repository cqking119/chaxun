package service;
import entity.Helloworld;
import entity.ResultInfo;
import entity.Userinformation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by chenqi on 2017/2/17.
 */

public interface HelloworldService  {
    public Helloworld queryHelloWorldservice () throws Exception;
    public  Helloworld querybyidservice(Integer id) throws Exception;
    public int  insertuserservice(Userinformation userinformation)throws Exception;
}
