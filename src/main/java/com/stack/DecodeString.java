package com.stack;

import java.util.Stack;
/*
394. Decode String

Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.



Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"


Constraints:

1 <= s.length <= 30
s consists of lowercase English letters, digits, and square brackets '[]'.
s is guaranteed to be a valid input.
All the integers in s are in the range [1, 300].
 */
public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> counts = new Stack<>(); // Stack to store repeat counts
        Stack<StringBuilder> resultStack = new Stack<>(); // Stack to store intermediate results
        StringBuilder current = new StringBuilder(); // Current result string
        int k = 0; // Current repeat count

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0'); // Build the number for k
            } else if (ch == '[') {
                counts.push(k); // Push repeat count to stack
                resultStack.push(current); // Push current string to stack
                current = new StringBuilder(); // Start a new current string
                k = 0; // Reset k
            } else if (ch == ']') {
                int repeat = counts.pop(); // Get repeat count
                StringBuilder temp = current;
                current = resultStack.pop(); // Retrieve previous result
                for (int i = 0; i < repeat; i++) {
                    current.append(temp); // Append the repeated string
                }
            } else {
                current.append(ch); // Append regular characters to current result
            }
        }

        return current.toString(); // Final result
    }

    public static void main(String[] args) {
        DecodeString solution = new DecodeString();

        // Example 1
        String s1 = "3[a]2[bc]";
        System.out.println(solution.decodeString(s1)); // Output: "aaabcbc"

        // Example 2
        String s2 = "3[a2[c]]";
        System.out.println(solution.decodeString(s2)); // Output: "accaccacc"

        // Example 3
        String s3 = "2[abc]3[cd]ef";
        System.out.println(solution.decodeString(s3)); // Output: "abcabccdcdcdef"
    }
}

