package com.smic.practice.strings;

public class TestStrings {

    public static void testMaxChars() {
        System.out.println(MaxChars.maxChars("aaaaaaaaaaaaaaaaabbbbcddddeeeeee"));
        System.out.println(MaxChars.maxChars("California is a great place"));
    }

    public static void testRemoveChars () {
        System.out.println(RemoveChars.removeChars("java", 'a'));
        System.out.println(RemoveChars.removeRecChars("java", 'a'));
    }
}
