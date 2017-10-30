package test;

import org.junit.Test;

/**
 * Created by Malu on 2017-09-18.
 */

public class Singletontest {
    @Test
    public  void  test() {
        instance s1 = instance.getInstance();
        instance s2 = instance.getInstance();
        Singeltonins s3 = Singeltonins.getInstance();
    System.out.println(s3.i);
   Singeltonins s4=Singeltonins.getInstance();
        System.out.println(s4.i);

    }
    @Test
    public void test2(){
        String s1 =new String("a") ;
        String  s2=new String("a") ;
     if (s1==s2) {
         System.out.println("=="+"相等");

     }
     else
         {
             System.out.println("=="+"不相等");

         }






    }
    @Test
    public void test3() {
        String s1 = new String("a");
        String s2 = new String("a");
        if (s1.equals(s2)) {
            System.out.println("equals" + "相等");

        } else {
            System.out.println("equals" + "不相等");

        }
    }
    @Test
    public static void main(String[] args) {
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program" + "ming";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s1.intern());
    }

}
