package algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Trie
 */
public class Trie<Value> {

    private static int  R = 256;

    private Node root = new Node();

    private static class Node {

        private Object value;

        private Node[] next = new Node[R];
    }

    public  int size() {

        return size(root);
    }

    private int size(Node n) {

        int size = 0;

        if (n == null) return  0;

        if (n.value!=null) size++;

        for(Node a: n.next) {
            size = size + size(a);
        }

        return size;
    }

    public Value get(String key){

        Node n = get(root,key,0);

        return n!=null ?  (Value)n.value : null;
    }

    private Node get(Node n , String key, int d){

        if (n==null) return null;
        if (d == key.length()) return n;

        char c = key.charAt(d);
        Node next = n.next[c];

        return get(next,key,d+1);
    }

    /*
    Insert value into a trie.
     */
    public void put(String key, Value val){

        Node n = get(root,key,0);

        if (n!=null)
            n.value = val;
        else
            put(root,key,0,val);

    }

    private void put(Node n ,String key, int d, Value val) {

        if (d == key.length()) {
            n.value = val;
            return;
        }

        char c = key.charAt(d);
        Node next = n.next[c];
        if (next==null) {
            n.next[c]= new Node();
        }

        put(n.next[c],key,d+1,val);

    }

    /*
    Get all keys
     */
    public Iterable<String> keys() {

        List<String> items = new ArrayList<String>();

        collect(get(root,"",0),"",items);

        return items;
    }

    private void collect(Node n , String pre, List<String> items) {

        if (n == null) return;
        if (n.value!=null ) items.add(pre);

        for (char c=0;c<R;c++ ) {
            collect(n.next[c], pre + c, items);
        }
    }

    private void collectMatch(Node n , String pre, int d, String pat, List<String> items) {

        if (n == null) return;
        if (d==pat.length() && n.value!=null ) {
            items.add(pre);
            return;
        }

        char next = pat.charAt(d);

        for (char c = 0; c < R; c++) {
            if (next==c || next=='.') {
                collectMatch(n.next[c], pre + c, d + 1, pat, items);
            }
        }
    }

    /*
    Return all keys with prefix s
     */
    public Iterable<String> keysWithPrefix(String s) {

        List<String> items = new ArrayList<String>();
        collect(get(root,s,0),s,items);
        return items;
    }

    /*
    Return keys that match a pattern
     */
    public Iterable<String> keysThatMatch(String pat) {

        List<String> items = new ArrayList<String>();
        collectMatch(root,"",0,pat,items);
        return items;
    }

    public String longestPrefixOf(String s ){

        return prefixOf(root,s,0,"","");
    }

    private String prefixOf(Node n,String pre, int d, String prefix, String longest) {

        if (n==null) return longest;

        if (d==pre.length()) return longest;

        if (n.value!=null) longest=prefix;

        char c = pre.charAt(d);

        return prefixOf(n.next[c],pre,d+1, prefix+c, longest);

    }

    /*
    Delete a key
     */
    public void delete(String key) {

    }

    // Test a trie
    public static void main(String[] args) {

        Trie<Integer> trie = new Trie();

        // test insert
        trie.put("by",4);
        trie.put("sea",2);
        trie.put("sells",1);
        trie.put("she",0);
        trie.put("shells",3);
        trie.put("the",5);

        // size
        System.out.println("Size : " + trie.size() );

        // test get
        System.out.println( "she:" +  trie.get("she"));
        System.out.println( "shells:" + trie.get("shells"));

        // keys
        System.out.println("Keys:" + trie.keys());
        System.out.println("Keys with prefix se:" + trie.keysWithPrefix("se"));
        System.out.println("Longest prefix of shellsort:" + trie.longestPrefixOf("shellsort"));
        System.out.println("Keys that match .he:" + trie.keysThatMatch(".he"));



        // test update
        trie.put("by",11);
        System.out.println( "by:" + trie.get("by"));

    }

}
