package thesis;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class StringAnalysis {

    private String data;

    public StringAnalysis(String data) {
        this.data = data;
    }

    public int countWord() {
        int count = 0;
        Scanner fileScan = new Scanner(data).useDelimiter("[ ,!?.:।৳০১২৩৪৯৮৭৬৫]+");
        while (fileScan.hasNext()) {
            fileScan.next();
            count++;
        }
        return count;
    }

    public int countVocabulary() {
        Scanner fileScan = new Scanner(data).useDelimiter("[ ,!?.:।৳০১২৩৪৯৮৭৬৫]+");
        String word;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        while (fileScan.hasNext()) {
            word = fileScan.next();
            map.put(word, map.get(word) == null ? 1 : map.get(word) + 1);
        }
        return map.size();
    }

    public void printFrequency() throws IOException {
        Scanner fileScan = new Scanner(data).useDelimiter("[ ,!?.:।৳০১২৩৪৯৮৭৬৫]+");
        String word;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        while (fileScan.hasNext()) {
            word = fileScan.next();
            map.put(word, map.get(word) == null ? 1 : map.get(word) + 1);
        }

        ValueComparator bvc = new ValueComparator(map);
        TreeMap<String, Integer> sorted_map = new TreeMap<String, Integer>(bvc);
        sorted_map.putAll(map);
        
        int count = 1;
          File file = new File("Frequency of 1 Word.txt");

        // if file doesnt exists, then create it
        file.createNewFile();
        FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
        BufferedWriter bw = new BufferedWriter(fw);


        for (Map.Entry<String, Integer> entry : sorted_map.entrySet()) {
            String key = entry.getKey();
            String value =Integer.toString(entry.getValue()) ;
            String result= key+" : "+value;
            bw.append(result);
            bw.newLine();
           // System.out.println(count+". " +key + " : " + value);
        }
    }
}
