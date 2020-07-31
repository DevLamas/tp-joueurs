import java.io.*;
import java.util.Properties;

public class WriteProperties {
    public static void main(final String[] args) {

        final Properties prop = new Properties();
        OutputStream output = null;

        try {

            output = new FileOutputStream("src/main/resources/config.properties");

            // set the properties value
            prop.setProperty("db.driver", "com.mysql.jdbc.Driver");
            prop.setProperty("db.url", "jdbc:mysql://localhost:3306/bdd_java");
            prop.setProperty("db.user", "root");
            prop.setProperty("db.password", "");

            // save properties to project root folder
            prop.store(output, null);


        } catch (final IOException ex) {
            ex.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (final IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
