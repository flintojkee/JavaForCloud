import java.io.File;
import java.util.*;

class TrieNode
{
    char c;
    TrieNode parent;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    boolean isLeaf;

    public TrieNode() {}
    public TrieNode(char c){this.c = c;}
}

public class TrieTest {
    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(new File("test.txt"));
        Trie dc = new Trie();
        while (in.hasNext()){
            dc.insert(in.next());
        }
        System.out.println(dc.search("Zulu"));
        if(dc.startsWith("Zulu")==true)
        {
            TrieNode tn = dc.searchNode("Zulu");
            dc.wordsFinderTraversal(tn,0);
            dc.displayFoundWords();

        }


    }
}


