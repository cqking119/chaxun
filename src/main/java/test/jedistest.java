package test;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Created by Malu on 2017-06-26.
 */
public class jedistest {
    @Test
    public void  testJedis(){
    Jedis jedis = new Jedis("192.168.128.129",6379);
    jedis.set("name","chenqi");
    String name=jedis.get("name");
    System.out.println(name);
    jedis.close();
    }


}
