package com.easy;


import java.util.HashSet;

/*
1456. Maximum Number of Vowels in a Substring of Given Length

Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

Example 1:

Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.
Example 2:

Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.
Example 3:

Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.


Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
1 <= k <= s.length
 */
public class MaximumNumberOfVowels {
    public int maxVowels(String s, int k) {

        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('o');
        vowels.add('i');
        vowels.add('u');

        int vowelCount = 0;
        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) {
                vowelCount++;
            }
        }
        int maxVowelCount = vowelCount;

        for (int i = k; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                vowelCount++;
            }
            if (vowels.contains(s.charAt(i - k))) {
                vowelCount--;
            }
            maxVowelCount = Math.max(vowelCount, maxVowelCount);
        }


        return maxVowelCount;
    }

    public static void main(String[] args) {
        String str = "leetcode"; //s = "aeiou", k = 2
        int k = 3;
        MaximumNumberOfVowels maximumNumberOfVowels = new MaximumNumberOfVowels();
        System.out.println(maximumNumberOfVowels.maxVowels(str, k));
    }
}
