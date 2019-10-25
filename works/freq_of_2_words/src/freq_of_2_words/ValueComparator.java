
package freq_of_2_words;

import java.util.Comparator;
import java.util.Map;

public class ValueComparator implements Comparator<String>{
     Map<String, Integer> base;
    public ValueComparator(Map<String, Integer> base) {
        this.base = base;
    }

    @Override
    public int compare(String a, String b) {
        if (base.get(a) >= base.get(b)) {
            return -1;
        } else {
            return 1;
        }
    }

}
