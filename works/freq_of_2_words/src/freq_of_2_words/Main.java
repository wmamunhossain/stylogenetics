package freq_of_2_words;

import java.io.File;
import java.io.IOException;

public class Main {

    
    public static void main(String[] args) throws IOException {

        // TODO code application logic here
        File root = new File("data");

        //Load Data From File
        CollectFiles collectFile = new CollectFiles();
        String data = collectFile.readDataFiles(root);


        //String Analysis
        StringAnalysis sa = new StringAnalysis(data);
        sa.countVocabulary();

    }

}
