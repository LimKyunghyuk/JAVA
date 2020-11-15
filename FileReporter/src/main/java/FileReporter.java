import java.io.*;
import java.util.Map;

public class FileReporter {

    private StringBuilder html;

    public String getHtml(){
        return html.toString();
    }

    public FileReporter read(String fileName){
        html = new StringBuilder();
        File file = new File(fileName);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                html.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return this;
    }

    public FileReporter write(String fileName){
        File file = new File(fileName);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(html.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return this;
    }

    public FileReporter replace(String target, String replacement){
        html = new StringBuilder(html.toString().replace("#{" + target + "}", replacement));
        return this;
    }

    public FileReporter replace(Map<String, String> map){

        for( String key : map.keySet() ){
            html = new StringBuilder(html.toString().replace("#{" + key + "}", map.get(key)));
        }
        return this;
    }
}