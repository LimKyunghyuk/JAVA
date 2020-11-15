import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FileReporterTest {

    public static String sum(String ...numArr){
        String ret = "0";

        int sum = 0;
        for(int i = 0 ; i < numArr.length ; i++){
            sum += Integer.parseInt(numArr[i]);
        }

        try {
            ret = Integer.toString(sum);
        }catch (Exception e){ }

        return ret;
    }

    public static String getRandomNumber(){
        return Integer.toString((int)(Math.random() * 30));
    }

    @Test
    public void test(){

            System.out.println(">" + getRandomNumber());
            Map<String, String> map = new HashMap<String, String>();

            map.put("c11", getRandomNumber());
            map.put("c12", getRandomNumber());
            map.put("c13", getRandomNumber());
            map.put("c14", getRandomNumber());
            map.put("c15", getRandomNumber());
            map.put("c16", getRandomNumber());
            map.put("c21", getRandomNumber());
            map.put("c22", getRandomNumber());
            map.put("c23", getRandomNumber());
            map.put("c24", getRandomNumber());
            map.put("c25", getRandomNumber());
            map.put("c26", getRandomNumber());
            map.put("c31", getRandomNumber());
            map.put("c32", getRandomNumber());
            map.put("c33", getRandomNumber());
            map.put("c34", getRandomNumber());
            map.put("c35", getRandomNumber());
            map.put("c36", getRandomNumber());
            map.put("c41", getRandomNumber());
            map.put("c42", getRandomNumber());
            map.put("c43", getRandomNumber());
            map.put("c44", getRandomNumber());
            map.put("c45", getRandomNumber());
            map.put("c46", getRandomNumber());
            map.put("c51", getRandomNumber());
            map.put("c52", getRandomNumber());
            map.put("c53", getRandomNumber());
            map.put("c54", getRandomNumber());
            map.put("c55", getRandomNumber());
            map.put("c56", getRandomNumber());
            map.put("c61", getRandomNumber());
            map.put("c62", getRandomNumber());
            map.put("c63", getRandomNumber());
            map.put("c64", getRandomNumber());
            map.put("c65", getRandomNumber());
            map.put("c66", getRandomNumber());

            map.put("web1", sum(map.get("c11"), map.get("c12"), map.get("c13"), map.get("c14"), map.get("c15"), map.get("c16")));
            map.put("web2", sum(map.get("c21"), map.get("c22"), map.get("c23"), map.get("c24"), map.get("c25"), map.get("c26")));
            map.put("web3", sum(map.get("c31"), map.get("c32"), map.get("c33"), map.get("c34"), map.get("c35"), map.get("c36")));
            map.put("web4", sum(map.get("c41"), map.get("c42"), map.get("c43"), map.get("c44"), map.get("c45"), map.get("c46")));
            map.put("web5", sum(map.get("c51"), map.get("c52"), map.get("c53"), map.get("c54"), map.get("c55"), map.get("c56")));
            map.put("web6", sum(map.get("c61"), map.get("c62"), map.get("c63"), map.get("c64"), map.get("c65"), map.get("c66")));

            map.put("was1", sum(map.get("c11"), map.get("c21"), map.get("c31"), map.get("c41"), map.get("c51"), map.get("c61")));
            map.put("was2", sum(map.get("c12"), map.get("c22"), map.get("c32"), map.get("c42"), map.get("c52"), map.get("c62")));
            map.put("was3", sum(map.get("c13"), map.get("c23"), map.get("c33"), map.get("c43"), map.get("c53"), map.get("c63")));
            map.put("was4", sum(map.get("c14"), map.get("c24"), map.get("c34"), map.get("c44"), map.get("c54"), map.get("c64")));
            map.put("was5", sum(map.get("c15"), map.get("c25"), map.get("c35"), map.get("c45"), map.get("c55"), map.get("c65")));
            map.put("was6", sum(map.get("c16"), map.get("c26"), map.get("c36"), map.get("c46"), map.get("c56"), map.get("c66")));

            for(int i = 1 ; i <= 6 ; i++){
                if( 100 < Integer.parseInt(map.get("was" + i))){
                    map.put("was_rect" + i,"rect_r");
                }else{
                    map.put("was_rect" + i,"rect_b");
                }
            }

            for(int i = 1 ; i <= 6 ; i++){
                for(int j = 1 ; j <= 6 ; j++){
                    if( 20 < Integer.parseInt(map.get("c" + i + j))){
                        map.put("arrowhead_" + i + j, "#arrowhead_r");
                        map.put("arrowtail_" + i + j, "#arrowtail_r");
                        map.put("line_" + i + j, "line_r");
                        map.put("text_" + i + j, "text_r");
                    }else{
                        map.put("arrowhead_" + i + j, "#arrowhead_b");
                        map.put("arrowtail_" + i + j, "#arrowtail_b");
                        map.put("line_" + i + j, "line_b");
                        map.put("text_" + i + j, "text_b");
                    }
                }
            }

            FileReporter file = new FileReporter();
            // ./src/main/resources/mail.html
            String html = file.read("./src/test/resources/rect_before.html")
                    .replace(map)
                    .write("./src/test/resources/rect_after.html")
                    .getHtml();

    }


}