package test;
import java.sql.*;


import oracle.jdbc.driver.OracleDriver;

/**
 * Created by Malu on 2017-02-03.
 */
public class jdbctest {
    public static  void  main(String arg[])
    {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("success");




        }
        catch (Exception e)
        {
            System.out.println("failure");
            e.printStackTrace();
        }
        try {
            Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@192.168.208.106:1521:sgcwgs1","nstcsa","a1111111");
            System.out.println("success");
           Statement statement=connection.createStatement();
           ResultSet resultSet=statement.executeQuery("select * from bp_account where acnttype='R' order by case when bankno='11' then 1 when bankno='05'then 2when bankno='02'then 3  when bankno='01'then 4 when bankno='04'then 5\n" +
                   " when bankno='03'then 6\n" +
                   "                when bankno='08'then 7 \n" +
                   "                  when bankno='41'then 8\n" +
                   "                    when bankno='06'then 9\n" +
                   "                      end " );
           while (resultSet.next()){
             String a= resultSet.getString(7);
              String b= String.valueOf(resultSet.getBigDecimal(8));
              System.out.println(a+","+b);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("error");
        }

    }
}
