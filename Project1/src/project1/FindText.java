package project1;

import java.util.Iterator;
import java.util.Map;
import java.util.SortedSet;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * Class have a two function to searching words.
 */
public class FindText {

    public FindText() {
    }

    /**
     * This function usful to full text searching, search the word after the
     * first liter, return words if find or null if didn't find.
     *
     * @param word, words which will be compared.
     * @param pattern, is a word with a textbox which the user is looking at
     * other dictionaries.
     * @return word,null. Return words if find or null if didn't find.
     */
    private String FindText(String word, String pattern) {
        int LenghtPattern = pattern.length();

        if (word.length() < LenghtPattern) {
            return null;
        }
        //search if first letter is the same
        String tmp = word.substring(0, LenghtPattern);

        if (tmp.compareTo(pattern) == 0) {
            return word;
        }
        return null;
    }

    public String StrStr(String haystack, String needle) {

        int needleLen = needle.length();
        int haystackLen = haystack.length();

        if (needleLen == haystackLen && needleLen == 0) {
            return "";
        }

        if (needleLen == 0) {
            return haystack;
        }

        for (int i = 0; i < haystackLen; i++) {
            if (haystackLen - i + 1 < needleLen) {
                return null;
            }

            int k = i;
            int j = 0;

            while (j < needleLen && k < haystackLen && needle.charAt(j) == haystack.charAt(k)) {
                j++;
                k++;
                if (j == needleLen) {
                    return haystack;
                }
            }

        }

        return null;
    }

    /**
     * This function removes elements from JTable and allows searches for words
     * after the first letter and enter into JTable.
     *
     * @param BGenerate this is button witch can be enable or disable
     * @param Text1 this is a texbox to put text on in
     * @param jTable1 contains the word loaded with structure
     * @param CountTime parameters adds class answered for the measurement of
     * time
     * @param jRadioButton1 parameter specifies from which all this data
     * accurately dictionary
     * @param jRadioButton3 parameter specifies from which all this data
     * accurately dictionary
     * @param Dictionar3Sorted contains a sorted structure SortedMap
     * @param Dictionar1Sorted contains a sorted structure SortedMap
     * @param jRadioButton2 parameter specifies from which all this data
     * accurately dictionary
     * @param Dictionar2Sorted contains a sorted structure SortedMap
     */
    public void Check(JButton BGenerate, JTextField Text1, JTable jTable1, Timer CountTime, JRadioButton jRadioButton1, JRadioButton jRadioButton2, JRadioButton jRadioButton3, SortedSet<Map.Entry<String, WordStruct>> Dictionar1Sorted, SortedSet<Map.Entry<String, WordStruct>> Dictionar2Sorted, SortedSet<Map.Entry<String, WordStruct>> Dictionar3Sorted) {

        if (Text1.getText().length() > 0) {
            BGenerate.setEnabled(true);
            if (jRadioButton1.isSelected()) {

                String tekst = Text1.getText();
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                if (model.getRowCount() > 0) {
                    for (int i = model.getRowCount() - 1; i > -1; i--) {
                        model.removeRow(i);
                    }
                }

                CountTime.BeginTimer(0);
                for (Iterator<Map.Entry<String, WordStruct>> it = Dictionar1Sorted.iterator(); it.hasNext();) {
                    Map.Entry<String, WordStruct> obiect = it.next();
                    if (FindText(obiect.getValue().getWord(), tekst) != null) {
                        model.addRow(new Object[]{obiect.getValue().getFileId(), obiect.getValue().getWord(), obiect.getValue().getOccurence()});
                    }
                }

                CountTime.Stopped(false);

                System.out.println("Zakończono szukanie trwało : ");
                System.out.println(CountTime.ReturnTime());

            } else if (jRadioButton2.isSelected()) {

                String tekst = Text1.getText();
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                if (model.getRowCount() > 0) {
                    for (int i = model.getRowCount() - 1; i > -1; i--) {
                        model.removeRow(i);
                    }
                }

                CountTime.BeginTimer(0);
                CountTime.Stopped(false);
                for (Iterator<Map.Entry<String, WordStruct>> it = Dictionar2Sorted.iterator(); it.hasNext();) {
                    Map.Entry<String, WordStruct> obiect = it.next();
                    if (FindText(obiect.getValue().getWord(), tekst) != null) {
                        model.addRow(new Object[]{obiect.getValue().getFileId(), obiect.getValue().getWord(), obiect.getValue().getOccurence()});
                    }
                }

                System.out.println("Zakończono szukanie trwało : ");
                System.out.println(CountTime.ReturnTime());

            } else if (jRadioButton3.isSelected()) {

                String tekst = Text1.getText();
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                if (model.getRowCount() > 0) {
                    for (int i = model.getRowCount() - 1; i > -1; i--) {
                        model.removeRow(i);
                    }
                }

                CountTime.BeginTimer(0);
                CountTime.Stopped(false);
                for (Iterator<Map.Entry<String, WordStruct>> it = Dictionar3Sorted.iterator(); it.hasNext();) {
                    Map.Entry<String, WordStruct> obiect = it.next();
                    if (FindText(obiect.getValue().getWord(), tekst) != null) {
                        model.addRow(new Object[]{obiect.getValue().getFileId(), obiect.getValue().getWord(), obiect.getValue().getOccurence()});
                    }
                }

                System.out.println("Zakończono szukanie trwało : ");
                System.out.println(CountTime.ReturnTime());
            }

        } else if (Text1.getText().length() == 0) {
            BGenerate.setEnabled(false);
            if (jRadioButton1.isSelected()) {
                String tekst = Text1.getText();
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                if (model.getRowCount() > 0) {
                    for (int i = model.getRowCount() - 1; i > -1; i--) {
                        model.removeRow(i);
                    }
                }

                CountTime.BeginTimer(0);
                for (Iterator<Map.Entry<String, WordStruct>> it = Dictionar1Sorted.iterator(); it.hasNext();) {
                    Map.Entry<String, WordStruct> obiect = it.next();
                    if (FindText(obiect.getValue().getWord(), tekst) != null) {
                        model.addRow(new Object[]{obiect.getValue().getFileId(), obiect.getValue().getWord(), obiect.getValue().getOccurence()});
                    }
                }

                CountTime.Stopped(false);

                System.out.println("Zakończono szukanie trwało : ");
                System.out.println(CountTime.ReturnTime());
            } else if (jRadioButton2.isSelected()) {
                String tekst = Text1.getText();
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                if (model.getRowCount() > 0) {
                    for (int i = model.getRowCount() - 1; i > -1; i--) {
                        model.removeRow(i);
                    }
                }

                CountTime.BeginTimer(0);
                CountTime.Stopped(false);
                for (Iterator<Map.Entry<String, WordStruct>> it = Dictionar2Sorted.iterator(); it.hasNext();) {
                    Map.Entry<String, WordStruct> obiect = it.next();
                    if (FindText(obiect.getValue().getWord(), tekst) != null) {
                        model.addRow(new Object[]{obiect.getValue().getFileId(), obiect.getValue().getWord(), obiect.getValue().getOccurence()});
                    }
                }

                System.out.println("Zakończono szukanie trwało : ");
                System.out.println(CountTime.ReturnTime());

            } else if (jRadioButton3.isSelected()) {
                String tekst = Text1.getText();
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                if (model.getRowCount() > 0) {
                    for (int i = model.getRowCount() - 1; i > -1; i--) {
                        model.removeRow(i);
                    }
                }

                CountTime.BeginTimer(0);
                CountTime.Stopped(false);
                for (Iterator<Map.Entry<String, WordStruct>> it = Dictionar3Sorted.iterator(); it.hasNext();) {
                    Map.Entry<String, WordStruct> obiect = it.next();
                    if (FindText(obiect.getValue().getWord(), tekst) != null) {
                        model.addRow(new Object[]{obiect.getValue().getFileId(), obiect.getValue().getWord(), obiect.getValue().getOccurence()});
                    }
                }

                System.out.println("Zakończono szukanie trwało : ");
                System.out.println(CountTime.ReturnTime());
            }
        }

    }
}
