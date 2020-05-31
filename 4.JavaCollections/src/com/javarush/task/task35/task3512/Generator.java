package com.javarush.task.task35.task3512;

public class Generator<T> {
    Class<T> tClass;

    T newInstance() throws InstantiationException, IllegalAccessException {
        T t = tClass.newInstance();
        return t;
    }

    public Generator(Class<T> tClass) {
        this.tClass = tClass;
    }
}
