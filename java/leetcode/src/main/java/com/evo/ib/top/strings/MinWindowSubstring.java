package com.evo.ib.top.strings;

public class MinWindowSubstring {
    // Function
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) return "" ;
        return minWindowSubString(s.toCharArray(), t.toCharArray()) ;
    }

    public String minWindowSubString (char [] str, char[] pattern) {

        int [] charT = new int[256] ;
        int ans = Integer.MAX_VALUE ;
        int start = 0 ;
        int count = 0 ;
        for (int i = 0 ; i < pattern.length ; i++) {
            if (charT[pattern[i]] == 0)
                count++ ;
            ++charT[pattern[i]] ;
        }
        int i = 0 ;
        int j = 0 ;
        while (j < str.length) {

            charT[str[j]]-- ;
            if (charT[str[j]] == 0)
                --count ;
            if (count == 0) {
                while (count == 0) {
                    if (ans > (j - i +1)) {
                        ans = j - i + 1;
                        start = i ;
                    }
                    charT[str[i]]++ ;
                    if (charT[str[i]] > 0)
                        count++ ;
                    i++ ;
                }
            }
            j++ ;
        }
        if (ans != Integer.MAX_VALUE)
            return String.valueOf(str).substring(start, ans+start);
        else
            return "";
    }

    public String Minimum_Window(char []s, char []t)
    {

        int m[] = new int[256];

        // Answer
        int ans = Integer.MAX_VALUE; // length of ans
        int start = 0; // starting index of ans
        int count = 0;
        // creating map
        for (int i = 0; i < t.length; i++) {
            if (m[t[i]] == 0)
                count++;
            m[t[i]]++;
        }

        // References of Window
        int i = 0;
        int j = 0;

        // Traversing the window
        while (j < s.length)
        {

            // Calculations
            m[s[j]]--;
            if (m[s[j]] == 0)
                count--;

            // Condition matching
            if (count == 0)
            {
                while (count == 0)
                {

                    // Sorting ans
                    if (ans > j - i + 1)
                    {
                        ans = Math.min(ans, j - i + 1);
                        start = i;
                    }

                    // Sliding I
                    // Calculation for removing I
                    m[s[i]]++;
                    if (m[s[i]] > 0)
                        count++;

                    i++;
                }
            }
            j++;
        }

        if (ans != Integer.MAX_VALUE)
            return String.valueOf(s).substring(start, ans+start);
        else
            return "-1";
    }

    public static void main(String[] args)
    {
        String s = "ADOBECODEBAANC";
        String t = "AABC";

        System.out.print("-->Smallest window that contain all character : ");
        MinWindowSubstring minWindowSubstring = new MinWindowSubstring();
        System.out.println(minWindowSubstring.minWindow(s, t) );
        //System.out.print(Minimum_Window(s.toCharArray(), t.toCharArray()));

    }
}

