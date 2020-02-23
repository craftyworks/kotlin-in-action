package com.ddam40.kia.domain;

import com.ddam40.kia.Chapter3Kt;
import com.ddam40.kia.Chapter3_3Kt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaUtil {
    public static void test() {
        List<String> list = Arrays.asList("A", "B", "C");

        KotlinUtil a = new KotlinUtil();
        a.joinToString(list, ",", "[", "]");
        System.out.println( a.joinToString(list));
    }

    public static void main(String[] args) {
       test();

        Chapter3_3Kt.lastChar("ABCDE");

        System.out.println("12.345.6A".split("\\.").length);
    }
}
