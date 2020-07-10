import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.util.Collection;

public class ApacheCommons {

    public static void main(String[] args) {

        // https://commons.apache.org/proper/commons-configuration/userguide/howto_hierarchical.html
        Parameters params = new Parameters();
        FileBasedConfigurationBuilder<XMLConfiguration> builder =
                new FileBasedConfigurationBuilder<XMLConfiguration>(XMLConfiguration.class)
                        .configure(params.xml()
                                .setFileName("propsCommons.xml"));
        try {
            XMLConfiguration config = builder.getConfiguration();

            System.out.println(config.getString("item.name"));
            Collection<String> prop = (Collection<String>) config.getProperty("item.name");

            System.out.println(prop.size());

            for(String p : prop){
                System.out.println(p);
            }

        }catch(ConfigurationException cex){
            // loading of the configuration file failed
        }

        System.out.println("end");
    }

}
