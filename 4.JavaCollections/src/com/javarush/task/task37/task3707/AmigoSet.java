package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet implements Serializable, Cloneable, Set {

    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        int capacity = Math.max(16, (int) Math.floor(collection.size() / .75f) + 1);
        map = new HashMap<>(capacity);

        collection.forEach(this::add);
    }

    @Override
    public boolean add(Object o) {
        return map.put((E) o, PRESENT) == null;
    }

    @Override
    public Iterator iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        return super.remove(o);
    }

    @Override
    public Object clone() throws InternalError {
        try {
            AmigoSet<E> cloneAmigiSet = (AmigoSet) super.clone();
            cloneAmigiSet.map = (HashMap) map.clone();
            return cloneAmigiSet;
        } catch (Exception e) {
            throw new InternalError();
        }

    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    private void writeObject(ObjectOutputStream outputStream) throws IOException {
        outputStream.defaultWriteObject();
        outputStream.writeObject(map.size());
        for (E key : map.keySet()) {
            outputStream.writeObject(key);
        }
        outputStream.writeObject(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
        outputStream.writeObject(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
    }

    private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        inputStream.defaultReadObject();

        int size = (int) inputStream.readObject();
        Set<E> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            set.add((E) inputStream.readObject());
        }
        int capacity = (int) inputStream.readObject();
        float loadFactor = (float) inputStream.readObject();

        map = new HashMap<>(capacity, loadFactor);
        for (E e : set) {
            map.put(e, PRESENT);
        }

    }

}
