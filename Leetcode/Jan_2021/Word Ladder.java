/*

https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/580/week-2-january-8th-january-14th/3598/


Given two words beginWord and endWord, and a dictionary wordList, return the length of the shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list.
Return 0 if there is no such transformation sequence.



Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", return its length 5.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.


Constraints:

1 <= beginWord.length <= 100
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the strings in wordList are unique.

*/

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> dictionary = new HashSet<>();
        for (String s : wordList) {
            dictionary.add(s);
        }
        if (!dictionary.contains(endWord))
            return 0;

        Set<String> s1 = new HashSet<>();
        Set<String> s2 = new HashSet<>();
        s1.add(beginWord);
        s2.add(endWord);
        int step = 0;

        while (s1.size() != 0 && s2.size() != 0) {
            step++;
            if (s1.size() > s2.size()) {
                Set<String> tempSet = new HashSet<>(s1);
                s1 = s2;
                s2 = tempSet;
            }
            Set<String> temp = new HashSet<>();
            for (String s : s1) {
                char[] stoc = s.toCharArray();
                //i < beginWord.length()
                for (int i = 0; i < beginWord.length(); i++) {
                    char t = stoc[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == t)
                            continue;
                        stoc[i] = c;
                        String str = new String(stoc);
                        if (s2.contains(str)) {
                            return step += 1;
                        }
                        if (!dictionary.contains(str))
                            continue;

                        dictionary.remove(str);
                        temp.add(str);
                    }
                    stoc[i] = t;
                }
            }
            s1 = temp;
        }
        return 0;
    }
}