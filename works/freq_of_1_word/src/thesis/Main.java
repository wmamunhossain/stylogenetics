package thesis;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        File root = new File("data");

        //Load Data From File
        EasyFile easyFile = new EasyFile();
        String data = easyFile.readDataFiles(root);

        //testing purpose
        String subdata = data.substring(0, 245);

        //String Analysis
        StringAnalysis sa = new StringAnalysis(data);
        sa.printFrequency();
    }
}
