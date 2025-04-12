import java.util.*;
class WordDictionary {

    private static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfWord = false;
    }

    private final TrieNode root = new TrieNode();

    public WordDictionary() {}
    
    public void addWord(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node = node.children.computeIfAbsent(ch, c -> new TrieNode());
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        return searchRecursive(word, 0, root);
    }

    private boolean searchRecursive(String word, int idx, TrieNode node) {
        // base case(기저 조건)
        if (idx == word.length()) return node.isEndOfWord;

        char ch = word.charAt(idx);

        if(ch == '.') {
            // 모든 자식 노드 탐색
            for (TrieNode child : node.children.values()) {
                if(searchRecursive(word, idx + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            TrieNode child = node.children.get(ch);
            if (child == null) return false;
            return searchRecursive(word, idx + 1, child);
        }
    }
    
    /**
    Time Limit Exceeded

    private final String DOT = ".";
    private final Map<String, Boolean> wd = new HashMap<>();

    public WordDictionary() {}

    public void addWord(String word) {
        wd.put(word, true);
    }

    public boolean search(String word) {
        return word.contains(DOT) ? searchByRegex(word) : wd.getOrDefault(word, false);
    }

    private boolean searchByRegex(String word) {
        return wd.keySet().stream().anyMatch(key -> isMatches(key, word));
    }

    private boolean isMatches(String key, String word) {
        Pattern pattern = Pattern.compile(word, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(key);
        return matcher.matches();
    }
    */

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */