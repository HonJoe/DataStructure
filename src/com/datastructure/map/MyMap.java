package com.datastructure.map;


public interface MyMap<K,V> {
    public V get(K key);
    public V put(K key,V value);
    interface IEntry<K,V>{
        public K getKey();
        public V getValue();
    }

}