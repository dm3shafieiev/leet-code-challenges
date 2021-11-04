package com.company;

import java.util.HashMap;
import java.util.Map;

public class ImplementTrie {

  public TrieNode root;

  public ImplementTrie() {

    root = new TrieNode();

  }

  public void insert(String word) {

    TrieNode tempRoot = root;

    for(Character ch: word.toCharArray()) {

      if(tempRoot.children.get(ch) == null) {
        tempRoot.children.put(ch, new TrieNode(ch));
      }

      tempRoot = tempRoot.children.get(ch);

    }

    tempRoot.isWord = true;

  }

  public boolean search(String word) {

    TrieNode tempRoot = basicSearchOperation(word);

    return tempRoot != null && tempRoot.isWord;

  }

  public boolean startsWith(String prefix) {

    return basicSearchOperation(prefix) != null;
  }

  private TrieNode basicSearchOperation(String word) {

    TrieNode tempRoot = root;

    for(Character ch: word.toCharArray()) {

      if(tempRoot.children.get(ch) != null) {
        tempRoot = tempRoot.children.get(ch);
      }else {
        return null;
      }

    }
    return tempRoot;
  }


  class TrieNode {

    private Character value;

    private Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();

    private boolean isWord;

    public TrieNode() {


    }

    public TrieNode(Character value) {

      this.value = value;

    }
  }
}
