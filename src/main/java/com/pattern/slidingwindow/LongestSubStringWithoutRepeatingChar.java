package com.pattern.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
3. Longest Substring Without Repeating Characters
Given a string s, find the length of the longest
substring
 without repeating characters.
Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

 */
public class LongestSubStringWithoutRepeatingChar {

    /*
    Time complexity : O(n)O(n). Index jj will iterate nn times.
    Space complexity (HashMap) : O(min(m, n))O(min(m,n)). Same as the previous approach.
    Space complexity (Table): O(m)O(m). mm is the size of the charset.

     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charIndex = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            if (charIndex.containsKey(currentChar)) {
                left = Math.max(left, charIndex.get(currentChar) + 1);
            }
            charIndex.put(currentChar, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubStringWithoutRepeatingChar sol = new LongestSubStringWithoutRepeatingChar();
        System.out.println(sol.lengthOfLongestSubstring("abcabcbb")); // Output: 3
        System.out.println(sol.lengthOfLongestSubstring("bbbbb")); // Output: 1
        System.out.println(sol.lengthOfLongestSubstring("pwwkew")); // Output: 3
    }

}
