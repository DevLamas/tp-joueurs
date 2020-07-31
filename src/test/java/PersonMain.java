import com.mysql.cj.xdevapi.Type;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class PersonMain {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        /*
        java.util.Date date = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

         */
        System.out.println("test1");

        Calendar newDob = Calendar.getInstance();
        newDob.set(2020, 7, 29);
        System.out.println("test2");

        Person p1 = new Person(3,"TEST","Bidon");
        System.out.println(p1.toString());
        PersonDAO persDao = new PersonDAO();


        //-----------INSERT---------------------------
        persDao.insertData(p1);

        p1.setFirstname("Test");
        persDao.updateData(p1);

        persDao.deleteData(p1);
    }
}
