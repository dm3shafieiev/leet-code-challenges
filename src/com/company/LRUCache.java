package com.company;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
  private Entry head = new Entry();
  private Entry tail = new Entry();
  private Map<Integer, Entry> cache;
  private int capacity;
  private int size;


  public LRUCache(int capacity) {
    cache = new HashMap<>(capacity);
    this.capacity = capacity;
    this.size = 0;
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    Entry entry = cache.get(key);

    if(entry == null) {
      return -1;
    }

    moveToHead(entry);

    return entry.value;
  }

  public void put(int key, int value) {

    Entry entry = cache.get(key);

    if(entry != null) {

      entry.value = value;
      moveToHead(entry);

    } else {

      Entry newNode = addNode(new Entry(key, value, null, null));
      cache.put(key, newNode);

      size++;

      if(size > capacity) {
        cache.remove(tail.prev.key);
        removeNode(tail.prev);
        size--;
      }
    }

  }

  private Entry addNode(Entry node) {

    Entry headNext = head.next;

    head.next.prev = node;
    head.next = node;

    node.next = headNext;
    node.prev = head;

    return node;
  }

  private void removeNode(Entry node) {

    Entry nodePrev = node.prev;
    Entry nodeNext = node.next;

    nodePrev.next = nodeNext;
    nodeNext.prev = nodePrev;

  }

  private void moveToHead(Entry node) {

    removeNode(node);
    addNode(node);

  }

  static class Entry {

    public int key, value;
    public Entry prev, next;

    public Entry() {

    }

    public Entry (int key, int value, Entry prev, Entry next) {
      this.key = key;
      this.value = value;
      this.prev = prev;
      this.next = next;
    }

  }
}
