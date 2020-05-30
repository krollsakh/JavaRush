package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/*
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    Entry<String> root;
    int sizeTree;
    private Queue<Entry> queueAddReady = new LinkedList<>(); // очередь элементов, готовых к добавлению к ним листьев

    public CustomTree() {
        root = new Entry<>("0");
        queueAddReady.add(root);
        sizeTree = 0;
    }

    public String getParent(String s) {

        Queue<Entry> queue = new LinkedList<>();

        Entry top = root;
        queue.add(top);

        do {
            if (top.elementName.equals(s)) return (top.parent == null) ? null : top.parent.elementName;
            if (top.leftChild != null) queue.add(top.leftChild);
            if (top.rightChild != null) queue.add(top.rightChild);
            if (!queue.isEmpty()) top = queue.poll();
        } while (!queue.isEmpty());

        return null;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(String s) {
        Entry newEntry = new Entry(s);
        Entry top = queueAddReady.peek();

        newEntry.parent = top;

        if (top.availableToAddLeftChildren) {
            top.leftChild = newEntry;
            top.availableToAddLeftChildren = false;
        } else {
            top.rightChild = newEntry;
            top.availableToAddRightChildren = false;
            queueAddReady.poll();
        }

        sizeTree++;

        return queueAddReady.add(newEntry);
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    //Действия при удалении элемента (обход, очистка ветви родителя, удаление из очереди "готовых к добавлению"
    private int removeEntry(Entry e) {
        int countDeleted = 0;
        Queue<Entry> queue = new LinkedList<>();
        Entry top = e;

        do {
            if (top.leftChild != null) {
                queue.add(top.leftChild);
            }
            if (top.rightChild != null) {
                queue.add(top.rightChild);
            }
            if (!queue.isEmpty()) {
                countDeleted++;
                queueAddReady.remove(top);
                top = queue.poll();
            }
        } while (!queue.isEmpty());

        countDeleted++;
        queueAddReady.remove(top);

        return countDeleted;
    }

    // восстановление очереди "готовых к добавлению"
    private void restoreQueueAddReady() {
        Queue<Entry> queue = new LinkedList<>();
        Entry top = root;

        queue.add(root);

        while (!queue.isEmpty()) {
            top = queue.poll();

            if (top.leftChild != null) {
                queue.add(top.leftChild);
            } else {
                top.availableToAddLeftChildren = true;
            }

            if (top.rightChild != null) {
                queue.add(top.rightChild);
            } else {
                top.availableToAddRightChildren = true;
            }

            if (top.isAvailableToAddChildren()) {
                queueAddReady.add(top);
            }
        };
    }

    @Override
    public boolean remove(Object o) {

        if (!(o instanceof String)) throw new UnsupportedOperationException();

        String s = (String) o;

        Queue<Entry> queue = new LinkedList<>();
        Entry top = root;

        queue.add(top);
        do {
            if (top.elementName.equals(s)) {
                sizeTree -= removeEntry(top);
                if (top.parent != null) {
                    if (top.parent.leftChild == top) {
                        top.parent.leftChild = null;
                    } else {
                        top.parent.rightChild = null;
                    }
                }
                if (queueAddReady.size() == 0) restoreQueueAddReady();

                return true;
            }

            if (top.leftChild != null) queue.add(top.leftChild);
            if (top.rightChild != null) queue.add(top.rightChild);
            if (!queue.isEmpty()) top = queue.poll();

        } while (!queue.isEmpty());

        return true;
    }

    @Override
    public int size() {
        return sizeTree;
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry parent;
        Entry leftChild;
        Entry rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }
    }
}
