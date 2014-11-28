package project1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import static project1.DictionarManager.Dictionar3;
import static project1.DictionarManager.Dictionar3Sorted;

/**
 * Class implemented interface Runnable and can be read input data in everything
 * dictionares in the same time.
 */
public class LoadingDictionar1 implements Runnable {
    /**
     * Form, To .This variable defines the number of files which can be read in words.
     */
    private final int From, To;
    private int CounterIndex;
    private BufferedReader File;
    private Scanner In;
    private int i;

    /**
     * constructor initializes which files will be read in this thread
     */
    LoadingDictionar1(int from, int to) {
        From = from;
        To = to;
        CounterIndex = 0;
        File = null;
    }

    /**
     * Function return number file currently being read
     * @return i, is number file currently being read.
     */
    public int ReturnI() {
        return i;
    }

    /**
     * Function returns the index of words.
     * @return CounterIndex, the index of which have been granted.
     */
    public int FinalCount() {
        return CounterIndex;
    }

    /**
     * Function opens the file and gets the word out that filters by checking if
     * there is no repetitions and added to the TreeMap. If we find repetitions,
     * add this words and rise occurence. After that we add all records of
     * TreeMap to SortedMap, and using Comparator witch sorting by the
     * frequency.
     */
    @Override
    public void run() {

        for (i = From; i <= To; i++) {

            try {
                File = new BufferedReader(new InputStreamReader(new FileInputStream("data/" + i + ".txt"), "Windows-1250"));

            } catch (FileNotFoundException ex) {
              JOptionPane.showMessageDialog(null, ex.getMessage() +" File not found", "Error Message",JOptionPane.ERROR_MESSAGE);
            } catch (UnsupportedEncodingException ex) {
               JOptionPane.showMessageDialog(null, ex.getMessage() +" Unsuported Encoding", "Error Message",JOptionPane.ERROR_MESSAGE);
            }
            In = new Scanner(File);
            while (In.hasNext()) {

                String sentens = In.next();
                if (Dictionar3.get(sentens) != null) {
                    Dictionar3.tailMap(sentens).entrySet().iterator().next().setValue(new WordStruct(sentens, Dictionar3.tailMap(sentens).entrySet().iterator().next().getValue().getFileId(), Dictionar3.tailMap(sentens).entrySet().iterator().next().getValue().getOccurence() + 1));
                } else {
                    CounterIndex++;
                    Dictionar3.put(sentens, new WordStruct(sentens, CounterIndex, 1));
                }

            }
            try {
                File.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage() +"Error on close file", "Error Message",JOptionPane.ERROR_MESSAGE);
            }
        }
        //Sort with in SortedMap
        Dictionar3Sorted.addAll(Dictionar3.entrySet());
     
    }

}
