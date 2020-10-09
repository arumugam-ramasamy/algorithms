package com.smic.practice.strings;

import java.util.*;

public class KNonRepeated {

    static class CharPair implements Comparable<CharPair> {
        Character ch;
        int pos;

        public CharPair(Character ch, int pos) {
            this.ch = ch;
            this.pos = pos;
        }

        public Character getCh() {
            return ch;
        }

        public void setCh(Character ch) {
            this.ch = ch;
        }

        public int getPos() {
            return pos;
        }

        public void setPos(int pos) {
            this.pos = pos;
        }

        @Override
        public int compareTo(CharPair s2) {
            if (this.pos < s2.pos)
                return 1;
            else if (this.pos > s2.pos)
                return -1;
            return 0;
        }
    }

    public static Character kNonRepeated(String str, int pos) {

        if (str == null || str.length() == 0) return null;

        Map<Character, Integer> oneTime = new HashMap<>();
        Map<Character, Integer> moreTime = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if (oneTime.containsKey(ch)) {
                moreTime.put(ch, oneTime.get(ch));
                oneTime.remove(ch);
            } else {
                if (moreTime.containsKey(ch) == false) {
                    oneTime.put(ch, i);
                }
            }
        }

        PriorityQueue<CharPair> charPairs = new PriorityQueue<CharPair>();

        for (Map.Entry<Character, Integer> keyval : oneTime.entrySet()) {
            charPairs.add(new CharPair(keyval.getKey(), keyval.getValue()));
        }

        if (charPairs.size() < pos)
            return null;
        Character k = null;
        for (int i = 0; i < pos; i++) {
            k = charPairs.poll().getCh();
        }

        return k;
    }

    public static Character kNewNonRepeated(String str, int pos) {
        if (str == null || str.length() == 0) return null;
        Map<Character,Integer> counts = new LinkedHashMap<>(str.length());
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            counts.put(ch, counts.containsKey(ch) ? counts.get(ch) + 1 : 1) ;
        }
        int count = 0 ;
        for (Map.Entry<Character,Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 1) {
                if ((count+1) == pos) return entry.getKey();
                count++ ;
            }
        }
        return null ;
    }
}
