
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

public class Property {

    public static void main(String[] args) throws IOException {

        Properties propXml = new Properties();
        propXml.loadFromXML(new FileInputStream("props.xml"));
        System.out.println(propXml.getProperty("propA"));
        System.out.println(propXml.getProperty("propB"));

        Properties prop = new Properties();
        FileInputStream input = new FileInputStream(new File("props.properties"));
        prop.load(new InputStreamReader(input, Charset.forName("UTF-8")));
        System.out.println(propXml.getProperty("propA"));
        System.out.println(propXml.getProperty("propB"));
    }
}
