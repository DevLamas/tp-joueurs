import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Connect {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/bdd_java";
            String user = "root";
            String passwd = "";

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,passwd);
            Statement state = con.createStatement();
            ResultSet result = state.executeQuery("SELECT * FROM person");
            //result.close();

        } catch (SQLException | ClassNotFoundException ex){
            System.out.println("Une erreure est survenue lors de la connexion de la base de données : ");
            ex.printStackTrace();

        }
    }

    //test

    public static Connection connexion() throws ClassNotFoundException, SQLException {
        final Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("src/main/resources/config.properties");
            prop.load(input);

            //Class.forName(prop.getProperty("db.driver"));
            String url = prop.getProperty("db.url");
            String user = prop.getProperty("db.user");
            String passwd = prop.getProperty("db.password");

            Connection con = DriverManager.getConnection(url,user,passwd);
            return con;
        }catch(Exception e){
            System.out.println("Une erreure est survenue lors de la connexion de la base de données : ");
            e.printStackTrace();
            return null;
        }
    }

    public void deconnexion(Connection con){
        try{
            con.close();
        } catch (Exception e){
            System.out.println("Erreur dans la déconnexion : ");
            e.printStackTrace();
        }
    }



}
