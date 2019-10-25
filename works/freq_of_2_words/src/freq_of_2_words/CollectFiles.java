
package freq_of_2_words;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class CollectFiles {

    public ArrayList<File> getListFiles(File parentDir) {
        try {
            ArrayList<File> inFiles = new ArrayList<File>();
            File[] files = parentDir.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    inFiles.addAll(getListFiles(file));
                } else {
                    inFiles.add(file);
                }
            }
            return inFiles;
        } catch (Exception e) {
            return new ArrayList<File>();
        }
    }

    private String readDataFile(File cf) {
        String data = "";
        Scanner in = openFile(cf);
        try {
            while (in.hasNext()) {
                data += in.nextLine();
            }
            closeFile(in);
        } catch (NoSuchElementException ne) {
            ne.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return data;
    }

    public String readDataFiles(File parentDir) {
        String data = "";
        ArrayList<File> files = getListFiles(parentDir);
        for (File file : files) {
            if (file.isFile()) {
                data += readDataFile(file);
            }
        }
        return data;
    }

    private void closeFile(Scanner input) {
        if (input != null) {
            input.close();
        }
    }

    private Scanner openFile(File file) {
        Scanner input = null;
        try {
            input = new Scanner(file, "UTF-8");
        } catch (FileNotFoundException fn) {
            fn.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return input;
    }

}
