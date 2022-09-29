package com.evo.ib.sixninesit;

import java.io.*;
import java.util.* ;

/*
Thomas Schwalen to Everyone (10:32 AM)
write a program that takes an English-language text file and a number N, and prints the top N words with their frequencies (aka counts, occurrences) in descending order.

e.g.

Example run
$ ./frequencies example.txt 10
5 : the
3 : and
2 : from
2 : his
2 : he
2 : it
2 : i
1 : man
1 : sprang
1 : chair

example text used:

The man sprang from his chair and paced up and down the room in
uncontrollable agitation. Then, with a gesture of desperation, he
tore the mask from his face and hurled it upon the ground. "You
are right," he cried; "I am the King. Why should I attempt to
conceal it?"
 */
public class Challenge {

    public static String removePunctuations(String source) {
        return source.replaceAll("\\p{Punct}", "");
    }

    public static void topNFrequencies(String filename, int n) {
        File file = new File(
                "/Users/pranavkhariharane/java/algorithms/java/leetcode/" + filename);

        // Note:  Double backquote is to avoid compiler
        // interpret words
        // like \test as \t (ie. as a escape sequence)
        try {
            // Creating an object of BufferedReader class
            BufferedReader br
                    = new BufferedReader(new FileReader(file));

            // Declaring a string variable
            String st;
            String[] splitStr;
            Map <String, Integer> freqCounts = new HashMap<>() ;
            // Condition holds true till
            // there is character in a string

            while ((st = br.readLine()) != null) {

                // Print the string
                splitStr = removePunctuations(st).split(" ");
                for (int i = 0 ; i < splitStr.length ; i++) {
                    String sub = splitStr[i].trim().toLowerCase();
                    if (freqCounts.containsKey(sub)){
                        freqCounts.put(sub, freqCounts.get(sub) +1) ;
                    }
                    else {
                        freqCounts.put(sub,1) ;
                    }
                   // System.out.println (splitStr[i].trim()) ;

                }
            }

            PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                    (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue()
            );

            for (Map.Entry<String, Integer> kv : freqCounts.entrySet()){
                pq.add(kv) ;
                if (pq.size() > n) {
                    pq.poll() ;
                }
            }
            PriorityQueue<Map.Entry<String, Integer>> pq1= new PriorityQueue<>(
                    (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : b.getValue()-a.getValue()
            );
            while (pq.size() > 0) {
                Map.Entry<String, Integer> kv = pq.poll() ;
                pq1.add(kv) ;
            }
            while (pq1.size() > 0) {
                Map.Entry<String, Integer> kv = pq1.poll() ;
                System.out.println(kv.getKey() + " : " + kv.getValue() );
            }


        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } catch (Exception e) {

        }




    }

    public static void main(String[] args) {

        topNFrequencies("example.txt", 10);
    }

}
