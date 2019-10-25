package freq_of_2_words;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class StringAnalysis {

    private String data;

    public StringAnalysis(String data) {
        this.data = data;
    }

    public void countVocabulary() throws IOException {
        Scanner fileScan = new Scanner(data).useDelimiter("[ ,!?.:।৳০১২৩৪৯৮৭৬৫]+");
        ArrayList<String> words = new ArrayList<String>();
        ArrayList<String> words_2 = new ArrayList<String>();
        String wrd;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        while (fileScan.hasNext()) {
            wrd = fileScan.next();
            words.add(wrd);
        }
        int i;
        for (i = 0; i < words.size(); i++) {
            if (i < words.size() - 1) {
                wrd = words.get(i) + " " + words.get(i + 1);
                words_2.add(wrd);
                map.put(wrd, map.get(wrd) == null ? 1 : map.get(wrd) + 1);
            }

        }

        ValueComparator bvc = new ValueComparator(map);
        TreeMap<String, Integer> sorted_map = new TreeMap<String, Integer>(bvc);
        sorted_map.putAll(map);

        int count = 1;
        File file = new File("Frequency of Consecutive 2 Words.txt");

        // if file doesnt exists, then create it
        file.delete();
        
        file.createNewFile();
        FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.flush();
        
        
        

          for (Map.Entry<String, Integer> entry : sorted_map.entrySet()) {
            String key = entry.getKey();
            String value =Integer.toString(entry.getValue()) ;
            String result= key+" : "+value;
            bw.append(result);
            bw.newLine();

    }
          bw.close();
    return
;

}

}
