/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author Karol
 */
public class DictionarManager {
     /**
     * Dictionar1 is a TreeMap has a word to which we can appeal with the key.
     * Static field is that you might dismiss him from another class
    */
    protected static TreeMap<String, WordStruct> Dictionar1 = new TreeMap<String, WordStruct>();
    /**
     *Dictionar1Sorted. It is a variable that can be easily sort the following values ​​using the Comparator.
    *Static field is that you might dismiss him from another class.
    */
    protected static SortedSet<Map.Entry<String, WordStruct>> Dictionar1Sorted = new TreeSet<Map.Entry<String, WordStruct>>(
            new Comparator<Map.Entry<String, WordStruct>>() {
                @Override
                public int compare(Map.Entry<String, WordStruct> o1, Map.Entry<String, WordStruct> o2) {
                    if (o1.getValue().getOccurence() < o2.getValue().getOccurence()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            });
    /**
     * Dictionar2 is a TreeMap has a word to which we can appeal with the key.
     * Static field is that you might dismiss him from another class
    */
    protected static TreeMap<String, WordStruct> Dictionar2 = new TreeMap<String, WordStruct>();
    
     /**
     *Dictionar2Sorted. It is a variable that can be easily sort the following values ​​using the Comparator.
    *Static field is that you might dismiss him from another class.
    */
    protected static SortedSet<Map.Entry<String, WordStruct>> Dictionar2Sorted = new TreeSet<Map.Entry<String, WordStruct>>(
            new Comparator<Map.Entry<String, WordStruct>>() {
                @Override
                public int compare(Map.Entry<String, WordStruct> o1, Map.Entry<String, WordStruct> o2) {
                    if (o1.getValue().getOccurence() < o2.getValue().getOccurence()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            });
    /**
     * Dictionar3 is a TreeMap has a word to which we can appeal with the key.
     * Static field is that you might dismiss him from another class
    */
    protected static TreeMap<String, WordStruct> Dictionar3 = new TreeMap<String, WordStruct>();
     /**
     *Dictionar3Sorted. It is a variable that can be easily sort the following values ​​using the Comparator.
    *Static field is that you might dismiss him from another class.
    */
    
    protected static SortedSet<Map.Entry<String, WordStruct>> Dictionar3Sorted = new TreeSet<Map.Entry<String, WordStruct>>(
            new Comparator<Map.Entry<String, WordStruct>>() {
                @Override
                public int compare(Map.Entry<String, WordStruct> o1, Map.Entry<String,WordStruct> o2) {
                    if (o1.getValue().getOccurence() < o2.getValue().getOccurence()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            });

    public DictionarManager() {
    }

    public SortedSet<Map.Entry<String, WordStruct>> DictionarSortedSet1()
    {
        return Dictionar1Sorted;
    }
     public SortedSet<Map.Entry<String, WordStruct>> DictionarSortedSet2()
    {
        return Dictionar2Sorted;
    }
      public SortedSet<Map.Entry<String, WordStruct>> DictionarSortedSet3()
    {
        return Dictionar3Sorted;
    }
    
      public TreeMap<String, WordStruct> DictionarTreeMap1()
      {
          return Dictionar1;
      }
      public TreeMap<String, WordStruct> DictionarTreeMap2()
      {
          return Dictionar2;
      }
      public TreeMap<String, WordStruct> DictionarTreeMap3()
      {
          return Dictionar3;
      }
      
      
}
