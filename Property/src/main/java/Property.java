import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Property {

    public static void main(String[] args) throws IOException {

        Properties prop = new Properties();
        prop.loadFromXML(new FileInputStream("props.xml"));

        System.out.println(prop.getProperty("propE"));

    }
}
