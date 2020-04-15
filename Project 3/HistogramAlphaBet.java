package sample;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.LinkedHashMap;
import java.util.Comparator;
import java.util.Map;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;


public class HistogramAlphaBet {
    private File file =  new File("D:\\Mahmud\\Spring 2020\\Software design labratory\\Homework\\Alice in Wonderland.txt");

    private ArrayList<String> line = new ArrayList<>();     // puts every word from the text file
    private HashMap<Character, Integer> hmap = new HashMap<>();    // maps the character to its occurrence
    private String readWord;
    private String wordToLowerCase;
    private int totalChar = 0;
    Scanner in;
    {
        try {
            in = new Scanner(file);
            while (in.hasNext()){
                readWord =in.next().replaceAll ("[^a-zA-Z]", "");
                wordToLowerCase = readWord.toLowerCase();
                line.add(wordToLowerCase);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        in.close();

        for (int i = 0; i < line.size(); i++){
            for (char c: line.get(i).toCharArray()){
                totalChar++;
                if (!hmap.containsKey(c)) hmap.put(c, 1);
                else hmap.put (c, hmap.get(c) + 1);
            }
        }
    }

    public int getTotalCharCount(){
        return totalChar;
    }

    // Sort the frequencies in decreasing order
    public HashMap<Character, Integer> sortedMap = hmap
            .entrySet()
            .stream()
            .sorted(comparingByValue(Comparator.reverseOrder()))
            .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2) -> e2, LinkedHashMap::new));
}