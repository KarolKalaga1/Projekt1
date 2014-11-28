package project1;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 * Includes a user interface to control program easy. Stores dictionaries sorted
 * structures and TreeMap for easy access to the database of words. Include
 * class that supports ProgressBar.
 * @author Karol Kalaga
 */
public class Dictionar extends javax.swing.JFrame {
    private DictionarManager ODictionarManager=new DictionarManager();
    private Timer CountTime = new Timer();
    /**
     * Find. It is a variable that creates a new object of class FindText,
     * Used to search for words in dictionaries.
     */
    private FindText Find = new FindText();
    /**
     * First. It is a variable that creates a new object of class MyThread
     */
    private final LoadingDictionar1 First = new LoadingDictionar1(1, 7600);
    /**
     * Second. It is a variable that creates a new object of class MyThread1
     */
    private final LoadingDictionar2 Second = new LoadingDictionar2(1, 1000);
   /**
     * Third. It is a variable that creates a new object of class MyThread2
     */
    private final LoadingDictionar3 Third = new LoadingDictionar3(1, 100);

    /**
     * Thread1. It is a variable that creates a new Thread;
     */
    private final Thread Thread1 = new Thread(First);
    /**
     * Thread2. It is a variable that creates a new Thread;
     */
    private final Thread Thread2 = new Thread(Second);
    /**
     * Thread3. It is a variable that creates a new Thread;
     */
    private final Thread Thread3 = new Thread(Third);
    private final Thread Thread4 = new Thread(CountTime);

    /**
     * This constructor init Thread to input words and prepares action listener
     * to search for words.
     *
     * @throws java.io.UnsupportedEncodingException The Character Encoding is
     * not supported.
     * @throws java.io.FileNotFoundException Signals that an attempt to open the
     * file denoted by a specified pathname has failed.
     * @throws java.lang.InterruptedException A part of the method signature and
     * a possible outcome of calling the method you're calling
     */
    @SuppressWarnings("CallToThreadStartDuringObjectConstruction")
    public Dictionar() throws UnsupportedEncodingException, FileNotFoundException, InterruptedException {
        setTitle("Serching Words");
        initComponents();
   
        
        BGenerate.setEnabled(false);
        Thread1.start();
        Thread2.start();
        Thread3.start();
        Thread4.start();
        PBProgress.setStringPainted(true);
        PBProgress.setForeground(Color.BLACK);
        PBProgress.setVisible(true);
        
        new Thread(new MyThreadProgressBar()).start();

        TFEntryWords.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                Find.Check(BGenerate, TFEntryWords, TTable, CountTime, RBDictionary1, RBDictionary2, RBDictionary3, ODictionarManager.DictionarSortedSet1(), ODictionarManager.DictionarSortedSet2(), ODictionarManager.DictionarSortedSet3());

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                Find.Check(BGenerate, TFEntryWords, TTable, CountTime, RBDictionary1, RBDictionary2, RBDictionary3,ODictionarManager.DictionarSortedSet1(), ODictionarManager.DictionarSortedSet2(), ODictionarManager.DictionarSortedSet3());

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                Find.Check(BGenerate, TFEntryWords, TTable, CountTime, RBDictionary1, RBDictionary2, RBDictionary3,ODictionarManager.DictionarSortedSet1(), ODictionarManager.DictionarSortedSet2(), ODictionarManager.DictionarSortedSet3());

            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        TFEntryWords = new javax.swing.JTextField();
        BGenerate = new javax.swing.JButton();
        PBProgress = new javax.swing.JProgressBar();
        RBDictionary1 = new javax.swing.JRadioButton();
        RBDictionary2 = new javax.swing.JRadioButton();
        RBDictionary3 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TTable = new javax.swing.JTable();
        jClear = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(390, 470));

        TFEntryWords.setToolTipText("Enter the word.");
        TFEntryWords.setMaximumSize(new java.awt.Dimension(2147483647, 6000));

        BGenerate.setText("Generate Output");
        BGenerate.setToolTipText("");
        BGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BGenerateActionPerformed(evt);
            }
        });

        PBProgress.setMaximum(7500);

        buttonGroup1.add(RBDictionary1);
        RBDictionary1.setText("Dictionary 1");
        RBDictionary1.setToolTipText("Select a dictionary for viewing.");
        RBDictionary1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RBDictionary1MouseClicked(evt);
            }
        });

        buttonGroup1.add(RBDictionary2);
        RBDictionary2.setText("Dictionary 2");
        RBDictionary2.setToolTipText("Select a dictionary for viewing.");
        RBDictionary2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RBDictionary2MouseClicked(evt);
            }
        });

        buttonGroup1.add(RBDictionary3);
        RBDictionary3.setText("Dictionary 3");
        RBDictionary3.setToolTipText("Select a dictionary for viewing.");
        RBDictionary3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RBDictionary3MouseClicked(evt);
            }
        });

        TTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id.", "Words", "Occurence"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TTable.setToolTipText("Found words.");
        TTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TTable);

        jClear.setText("Clear");
        jClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jClearActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Print dictionar");
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Exit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Instruction");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("About");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(PBProgress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(111, 111, 111))
            .addGroup(layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(jClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(187, 187, 187))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(41, 41, 41))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TFEntryWords, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(RBDictionary1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(22, 22, 22)
                        .addComponent(RBDictionary2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(RBDictionary3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(BGenerate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PBProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TFEntryWords, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jClear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BGenerate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RBDictionary1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(RBDictionary2)
                        .addComponent(RBDictionary3)))
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Function creates a new object that generates output.
     */
    private void BGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BGenerateActionPerformed
        HtmlOutput output = new HtmlOutput(TFEntryWords.getText(), ODictionarManager.DictionarTreeMap1(), ODictionarManager.DictionarTreeMap2(),ODictionarManager.DictionarTreeMap3());
    }//GEN-LAST:event_BGenerateActionPerformed

   /**
     * Searching words in SortedMap and the result is placed in a JTable.
     */
    private void RBDictionary1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RBDictionary1MouseClicked
        Find.Check(BGenerate, TFEntryWords, TTable, CountTime, RBDictionary1, RBDictionary2, RBDictionary3, ODictionarManager.DictionarSortedSet1(), ODictionarManager.DictionarSortedSet2(), ODictionarManager.DictionarSortedSet3());
    }//GEN-LAST:event_RBDictionary1MouseClicked
    /**
     * Searching words in SortedMap and the result is placed in a JTable.
     */
    private void RBDictionary2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RBDictionary2MouseClicked
        Find.Check(BGenerate, TFEntryWords, TTable, CountTime, RBDictionary1, RBDictionary2, RBDictionary3, ODictionarManager.DictionarSortedSet1(), ODictionarManager.DictionarSortedSet2(), ODictionarManager.DictionarSortedSet3());
    }//GEN-LAST:event_RBDictionary2MouseClicked
    /**
     * Searching words in SortedMap and the result is placed in a JTable.
     */
    private void RBDictionary3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RBDictionary3MouseClicked
        Find.Check(BGenerate, TFEntryWords, TTable, CountTime, RBDictionary1, RBDictionary2, RBDictionary3, ODictionarManager.DictionarSortedSet1(), ODictionarManager.DictionarSortedSet2(), ODictionarManager.DictionarSortedSet3());
    }//GEN-LAST:event_RBDictionary3MouseClicked
    /**
     * Selects the clicked word and searches for it by functions, The result is
     * placed in a JTable.
     */
    private void TTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TTableMouseClicked
        if (TTable.getSelectedRowCount() >= 0) {
            DefaultTableModel model = (DefaultTableModel) TTable.getModel();
            TFEntryWords.setText((String) model.getValueAt(TTable.getSelectedRow(), 1));
        }
    }//GEN-LAST:event_TTableMouseClicked
    /**
     * Close program.
     */
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed
    /**
     * Function show MessageDialog about program.
     */
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        ImageIcon icon = new ImageIcon("dataAdd/information (2).png");
        JOptionPane.showMessageDialog(null, "Project was commissioned by the object PT.\n\n"
                + "The program is ready for operation immediately after start-up,\n"
                + "but does not have available the full database of words.\n"
                + "A progress bar indicates the progress of load dictionares.\n"
                + "After that we can write in text field and find word in all dictionaries.\n"
                + "Controls allow you to select a dictionary from which you want to use.\n"
                + "Table visible button of the main panel allows us to check \nthe incidence of the word and its individual id.\n"
                + "When you select a word, click on the button,\n"
                + "and we have shown the absolute incidence of words\nin all the dictionaries and relative to each of them.\n", "Instruction", JOptionPane.INFORMATION_MESSAGE, icon);
    }//GEN-LAST:event_jMenuItem3ActionPerformed
    /**
     * Function show MessageDialog about autors.
     */
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        ImageIcon icon = new ImageIcon("dataAdd/copyright-icon.png");
        JOptionPane.showMessageDialog(null, "Project was commissioned by the object PT.\n"
                + "Created by Karol Kalaga and Mateusz Łysień.", "About", JOptionPane.INFORMATION_MESSAGE, icon);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jClearActionPerformed
        TFEntryWords.setText("");
    }//GEN-LAST:event_jClearActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dictionar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dictionar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dictionar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dictionar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Dictionar().setVisible(true);
                } catch (UnsupportedEncodingException ex) {
                   JOptionPane.showMessageDialog(null, ex.getMessage() +" Unsuported Encoding", "Error Message",JOptionPane.ERROR_MESSAGE);
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage() +" File not found", "Error Message",JOptionPane.ERROR_MESSAGE);
                } catch (InterruptedException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage() +" Interrupted Exception", "Error Message",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    /**
     * Class implements interface Runnable with use to control ProgressBar.
     * Used to analyze how much remains to be loaded.
     */
    private class MyThreadProgressBar implements Runnable {

        @Override
        public void run() {
            do {

                PBProgress.repaint();
                PBProgress.setValue(First.ReturnI());
                if (PBProgress.getValue() == 7500) {
                    JOptionPane.showMessageDialog(null, "Loaded all the data.", "Information", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            } while (true);
            PBProgress.setVisible(false);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BGenerate;
    private javax.swing.JProgressBar PBProgress;
    private javax.swing.JRadioButton RBDictionary1;
    private javax.swing.JRadioButton RBDictionary2;
    private javax.swing.JRadioButton RBDictionary3;
    public javax.swing.JTextField TFEntryWords;
    private javax.swing.JTable TTable;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jClear;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables

}
