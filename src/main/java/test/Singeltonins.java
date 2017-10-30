package test;

import org.springframework.expression.spel.ast.Elvis;

/**
 * Created by Malu on 2017-09-18.
 */
public class Singeltonins {
    private  static  final  Singeltonins instance =new Singeltonins();
   public  static final  int i =1;
    private Singeltonins(){}
    public static Singeltonins getInstance(){
//        int a=1;
//        return  instance;
     

        }

    }

}
