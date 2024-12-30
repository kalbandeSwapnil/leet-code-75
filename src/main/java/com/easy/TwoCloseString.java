package com.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
1657. Determine if Two Strings Are Close

Two strings are considered close if you can attain one from the other using the following operations:

Operation 1: Swap any two existing characters.
For example, abcde -> aecdb
Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
You can use the operations on either string as many times as necessary.

Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.


Example 1:

Input: word1 = "abc", word2 = "bca"
Output: true
Explanation: You can attain word2 from word1 in 2 operations.
Apply Operation 1: "abc" -> "acb"
Apply Operation 1: "acb" -> "bca"
Example 2:

Input: word1 = "a", word2 = "aa"
Output: false
Explanation: It is impossible to attain word2 from word1, or vice versa, in any number of operations.
Example 3:

Input: word1 = "cabbba", word2 = "abbccc"
Output: true
Explanation: You can attain word2 from word1 in 3 operations.
Apply Operation 1: "cabbba" -> "caabbb"
Apply Operation 2: "caabbb" -> "baaccc"
Apply Operation 2: "baaccc" -> "abbccc"


Constraints:

1 <= word1.length, word2.length <= 105
word1 and word2 contain only lowercase English letters.
 */
public class TwoCloseString {
        public boolean closeStrings(String word1, String word2) {

            if (word1.length() != word2.length()) {
                return false;
            }

            // Step 2: Count frequencies of characters in both words
            int[] freq1 = new int[26];
            int[] freq2 = new int[26];
            Set<Character> set1 = new HashSet<>();
            Set<Character> set2 = new HashSet<>();

            for (char c : word1.toCharArray()) {
                freq1[c - 'a']++;
                set1.add(c);
            }

            for (char c : word2.toCharArray()) {
                freq2[c - 'a']++;
                set2.add(c);
            }

            // Step 3: Check if both words have the same set of characters
            if (!set1.equals(set2)) {
                return false;
            }

            // Step 4: Check if the frequency distributions can be rearranged
            Arrays.sort(freq1);
            Arrays.sort(freq2);
            return Arrays.equals(freq1, freq2);
        }

        public static void main(String[] args) {
            TwoCloseString solution = new TwoCloseString();

            // Example 1
            System.out.println(solution.closeStrings("abc", "bca")); // Output: true

            // Example 2
            System.out.println(solution.closeStrings("a", "aa")); // Output: false

            // Example 3
            System.out.println(solution.closeStrings("cabbba", "abbccc")); // Output: true
        }



}
