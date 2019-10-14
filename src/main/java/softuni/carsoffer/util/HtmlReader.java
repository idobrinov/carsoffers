package softuni.carsoffer.util;

import java.io.*;

public class HtmlReader {

    public String htmlReared(String htmlPath) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(new File(htmlPath))));

        StringBuilder stringBuilder = new StringBuilder();
        String line;

        while ((line = bufferedReader.readLine()) != null ) {

            stringBuilder.append(line).append(System.lineSeparator());
        }

        return stringBuilder.toString().trim() ;
    }
}
