package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        //напишите тут ваш код
        return map.values().stream().mapToInt(List::size).sum();
    }

    @Override
    public V put(K key, V value) {
        //напишите тут ваш код
        V returnElement = null;

        if (map.containsKey(key)) {
            List<V> values = map.get(key);
            returnElement = values.get(values.size() - 1);
            if (values.size() >= repeatCount) {
                values.remove(0);
            }
            values.add(value);

        } else {
            List<V> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }
        return returnElement;
    }

    @Override
    public V remove(Object key) {
        //напишите тут ваш код
        V returnElement = null;
        List<V> values = map.get(key);
        if (values != null) {
            returnElement = values.remove(0);
            if (values.size() == 0) {
                map.remove(key);
            }
        }
        return returnElement;
    }

    @Override
    public Set<K> keySet() {
        //напишите тут ваш код
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        //напишите тут ваш код
        ArrayList<V> list = new ArrayList<>();
        map.forEach((key, value) -> list.addAll(value));
        return list;
    }

    @Override
    public boolean containsKey(Object key) {
        //напишите тут ваш код
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        //напишите тут ваш код
        return map.entrySet().stream().anyMatch(entry -> entry.getValue().contains(value));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}