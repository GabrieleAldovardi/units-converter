package com.example.generalconverter;

public class Pairs<K, V> {
    Pair<K, V>[] keys;
    V[] values;

    public Pairs(Pair<K, V>[] keys, V[] values) {
        this.keys = keys;
        this.values = values;
    }

}
