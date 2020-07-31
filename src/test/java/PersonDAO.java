import com.sun.tools.javac.util.Log;

import java.sql.*;
import java.util.Calendar;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.logging.*;

public class PersonDAO {
    public ResultSet findAll() throws SQLException, ClassNotFoundException {
        Connect dzoconn = new Connect();
        Connection con = dzoconn.connexion();

        ResultSet result = null;

        String requete = "Select * from person";
        try{
            Statement state = con.createStatement();
            result = state.executeQuery(requete);
            return result;

        }catch (Exception e ){
            System.out.println("Une erreure dans la recherche all persons : ");
            e.printStackTrace();
            con.close();
            return result;
        }
    }

    public static void insertData(Person p) throws SQLException, ClassNotFoundException {

        Connect dzoconn = new Connect();
        Connection con = dzoconn.connexion();

        String query = "insert into person (first_name, last_name) values ('"+ p.getFirstname() +"', '"+ p.getLastname() +"')";
        try{
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.execute();
        } catch (Exception e ){
            System.out.println("Une erreure dans l'insertion d'une nouvelle personne : ");
            con.close();
            e.printStackTrace();
        }
    }

    public static void deleteData(Person p) throws SQLException, ClassNotFoundException {

        Connect dzoconn = new Connect();
        Connection con = dzoconn.connexion();

        String query = "delete from person where id = '"+ p.getId() +"'";
        try {
            PreparedStatement preparedStmt = con.prepareStatement(query);
            // execute the preparedstatement
            preparedStmt.execute();

        } catch (Exception e ){
            System.out.println("Une erreure dans la suppression de la personne "+ p.getId() +" "+ p.getFirstname() +" "+ p.getLastname() +" : ");
            con.close();
            e.printStackTrace();
        }
    }

    public static void updateData(Person p) throws SQLException, ClassNotFoundException {
        Connect dzoconn = new Connect();
        Connection con = dzoconn.connexion();

        String query = "update person set first_name = '"+ p.getFirstname() +"', last_name = '"+ p.getLastname() +"' where id = '"+ p.getId() +"'";
        try {
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.execute();
        }catch (Exception e ){
            System.out.println("Une erreure dans la modification de la personne "+ p.getId() +" "+ p.getFirstname() +" "+ p.getLastname() +" : ");
            con.close();
            e.printStackTrace();
        }
    }

    public void updatableResultSet() {
        LOG.debug("Debut Update Scrollable Result Set");
        try {
            String sql = "SELECT * FROM person";

            st = conn.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            rs = st.executeQuery(sql);

            Calendar newDob = Calendar.getInstance();
            newDob.set(2020, 0, 1);

            while (rs.next()) {
                rs.updateObject( "dob", newDob.getTime());
                rs.updateRow();
            }

        } catch (SQLException e ) {
            LOG.error(e.getMessage());
        } finally {
            try {
                DbUtils.close(st);
            } catch (Exception e) {
                LOG.warn(e.getMessage());
            }
            try {
                DbUtils.close(rs);
            } catch (Exception e) {
                LOG.warn(e.getMessage());
            }
        }
        LOG.debug("Fin Update Scrollable Result Set");
    }
}
