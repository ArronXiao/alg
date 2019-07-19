package com.xx.utils;

import com.xx.struct.LinkNode;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class PrintUtils {

    public static void print(String msg) {
        System.out.println(msg);
    }

    public static  <T>  void print(T msg) {
        System.out.println(msg);
    }

    public static void print(Map msg) {
        for(Object key : msg.keySet()) {
            System.out.println("key: " + key + " value: " + msg.get(key));
        }
    }

    public static <T> void print(List<T> list) {
        if (list == null) {
            System.out.println("list == null");
            return;
        }
        int index = 0;
        for(T o : list) {
            System.out.println("index: " + index + "  "+ o);
            index++;
        }
    }

    public static void print(LinkNode linkNode) {
        if (linkNode == null) {
            System.out.println("linkNode == null");
        }
        while(linkNode != null) {
            System.out.println("linkNode.value : " + linkNode.value);
            linkNode = linkNode.nextNode;
        }
    }
}
