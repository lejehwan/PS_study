public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];

        char[] ch1 = magazine.toCharArray();
        for (char c : ch1) {
            count[c - 'a']++;
        }
        char[] ch2 = ransomNote.toCharArray();
        for (char c : ch2) {
            if (count[c - 'a'] == 0) return false;
            count[c - 'a']--;
        }

        return true;
    }
}
