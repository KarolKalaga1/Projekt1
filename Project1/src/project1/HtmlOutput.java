package project1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.TreeMap;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;

/**
 * This class use to create Output using html.
 *
 */
public class HtmlOutput {

    /**
     * Constructor thread running through the Swing class. Created the
     * JEditorPane and add an html editor kit, after that create html as a
     * string and create a document, set it on the jeditorpane, then add the
     * html, and display in the JFrame.
     *
     * @param words Found word to generate
     * @param Dictionar1. TreeMap for viewing how many times the word occurred
     * in dictionaries1
     * @param Dictionar2. TreeMap for viewing how many times the word occurred
     * in dictionaries2
     * @param Dictionar3. TreeMap for viewing how many times the word occurred
     * in dictionaries3
     */
    public HtmlOutput(String words, TreeMap<String, WordStruct> Dictionar1, TreeMap<String, WordStruct> Dictionar2, TreeMap<String, WordStruct> Dictionar3) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // create jeditorpane
                JEditorPane jEditorPane = new JEditorPane();          

                // make it read-only
                jEditorPane.setEditable(false);

                // create a scrollpane; modify its attributes as desired
                JScrollPane scrollPane = new JScrollPane(jEditorPane);
                         
                // add an html editor kit
                HTMLEditorKit kit = new HTMLEditorKit();
                jEditorPane.setEditorKit(kit);

                int OccurenceDictionar1 = (Dictionar1.get(words) == null) ? 0 : Dictionar1.get(words).getOccurence();
                int OccurenceDictionar2 = (Dictionar2.get(words) == null) ? 0 : Dictionar2.get(words).getOccurence();
                int OccurenceDictionar3 = (Dictionar3.get(words) == null) ? 0 : Dictionar3.get(words).getOccurence();
                // create html as a string
                String htmlString = "<html>\n"
                        + "<body bgcolor=\"#33CCCC\" text=\"#000000\">"
                        + "<h1>"
                        + "<center>" + words + "</center>\n"
                        + "</h1>\n"
                        + "<h2><center>Absolute occurrence</center></h2>"
                        + "<h2><center>" + (OccurenceDictionar1 + OccurenceDictionar2 + OccurenceDictionar3) + "</center></h2>\n"
                        + "<h2><center>Relative occurrence</center></h2>\n"
                        + "<h2>" + "Dictionary 1 : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + ((Dictionar1.get(words) == null) ? 0 : (Dictionar1.get(words).getOccurence())) + "</h2>\n"
                        + "<h2>" + "Dictionary 2 : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + ((Dictionar2.get(words) == null) ? 0 : (Dictionar2.get(words).getOccurence())) + "</h2>\n"
                        + "<h2>" + "Dictionary 3 : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + ((Dictionar3.get(words) == null) ? 0 : (Dictionar3.get(words).getOccurence())) + "</h2>\n"
                        + "</body>\n";

                // create a document, set it on the jeditorpane, then add the html
                Document doc = kit.createDefaultDocument();
                jEditorPane.setDocument(doc);
                jEditorPane.setText(htmlString);

                // now add it all to a frame
                JFrame j = new JFrame("Words Output");  
                j.getContentPane().add(scrollPane, BorderLayout.CENTER);

                // display the frame
                j.setSize(new Dimension(280, 350));

                j.setLocationRelativeTo(null);
                j.setResizable(false);
                j.setVisible(true);

            }
        });
    }

}
