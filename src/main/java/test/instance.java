package test;

/**
 * Created by Malu on 2017-09-18.
 */
public class instance {
private static instance instance = new instance();
private instance(){}
static  int i=1;
public static instance getInstance() {
        return instance;

        }
        }
