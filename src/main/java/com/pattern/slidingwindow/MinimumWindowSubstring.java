package com.pattern.slidingwindow;



/*
76. Minimum Window Substring
Given two strings s and t of lengths m and n respectively, return the minimum window
substring
 of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.



Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.

 */

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public String minWindow(String source, String target) {
        if (source == null || target == null || source.length() < target.length()) {
            return "";
        }

        Map<Character, Integer> tCharCount = new HashMap<>();

        for (char c : target.toCharArray()) {
            tCharCount.put(c, tCharCount.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, count = target.length(), minLen = Integer.MAX_VALUE, minLeft = 0;

        while (right < source.length()) {
            // Moving right pointer and updating the window size and characters count
            char rightChar = source.charAt(right++);

            if (tCharCount.containsKey(rightChar)) {

                tCharCount.put(rightChar, tCharCount.get(rightChar) - 1);

                if (tCharCount.get(rightChar) >= 0) {
                    count--;
                }
            }


            // Moving left pointer and updating the window size and characters count
            while (count == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    minLeft = left;
                }

                char leftChar = source.charAt(left++);
                if (tCharCount.containsKey(leftChar)) {
                    tCharCount.put(leftChar, tCharCount.get(leftChar) + 1);
                    if (tCharCount.get(leftChar) > 0) {
                        count++;
                    }
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : source.substring(minLeft, minLeft + minLen);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring sol = new MinimumWindowSubstring();
        System.out.println(sol.minWindow("ADOBECODEBANC", "ABC")); // Output: "BANC"
        System.out.println(sol.minWindow("a", "a")); // Output: "a"
        System.out.println(sol.minWindow("a", "aa")); // Output: ""
    }
}