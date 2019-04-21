package com.coding.datastructures.examples;

import java.util.*;

public class MatchingTags {
    public static void matchTags(String input) {
        // input is like "(ABC){DEF}";
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> matchingTagsMap = new HashMap<>();
        matchingTagsMap.put('}', '{');
        matchingTagsMap.put(')', '(');
        matchingTagsMap.put(']', '[');

        Set<Character> openingTagSet = new HashSet<>();
        openingTagSet.addAll(matchingTagsMap.values());

        for (int i = 0; i < input.length(); i++) {

            char ch = input.charAt(i);

            if (openingTagSet.contains(ch)) {
                stack.push(ch);
            }

            if (matchingTagsMap.containsKey(ch)) {
                Character lastTag = stack.pop();
                if (lastTag != matchingTagsMap.get(ch)) {
                    System.out.println("FALSE");
                }
            }
        }
    }

    // Driver code
    public static void main(String[] args) {
        MatchingTags.matchTags("(ABC){DEF}");
    }
}
