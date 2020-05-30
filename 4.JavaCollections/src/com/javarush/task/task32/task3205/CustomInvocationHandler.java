package com.javarush.task.task32.task3205;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomInvocationHandler implements InvocationHandler {
    private SomeInterfaceWithMethods original;

    public CustomInvocationHandler(SomeInterfaceWithMethods original) {
        this.original = original;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        System.out.println(methodName + " in");
        Object result = method.invoke(original, args);
        System.out.println(methodName + " out");

        return result;
    }
}
