package com.netcracker.edu.ssu.dobrynin.artemiy.task004.part1;

import java.util.*;

/**
 * Created by User on 04.11.2016.
 */
public class Main {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("abd");
        words.add("bda");
        words.add("adb");
        words.add("abdc");
        words.add("acbd");
        words.add("abcd");
        words.add("zbd");
        words.add("fadbd");
        words.add("addbf");
        words.add("abacaba");
        words.add("baacbaa");
        words.add("abbacaa");

        Set<String> anagrams = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int len1 = o1.length();
                int len2 = o2.length();

                if (len1 != len2) {
                    return len1 - len2;
                } else {
                    int lim = Math.min(len1, len2);
                    char v1[] = o1.toCharArray();
                    char v2[] = o2.toCharArray();

                    int k = 0;
                    while (k < lim) {
                        char c1 = v1[k];
                        char c2 = v2[k];
                        if (c1 != c2) {
                            return c1 - c2;
                        }
                        k++;
                    }
                }
                return 0;
            }

        });

        for (String str1 : words) {
            for (String str2 : words) {
                if (!str1.equals(str2)) {
                    if (isAnagram(str1, str2)) {
                        anagrams.add(str1);
                        anagrams.add(str2);
                    }
                }
            }
        }

        for (String str : anagrams) {
            System.out.println(String.format("Anagram %s is of size %d", str, str.length()));
        }

    }

    public static boolean isAnagram(String first, String second) {
        if (first.length() == second.length()) {
            char[] firstArray = first.toCharArray();
            char[] secondArray = second.toCharArray();

            Arrays.sort(firstArray);
            Arrays.sort(secondArray);

            return Arrays.equals(firstArray, secondArray);
        }
        return false;
    }
}
