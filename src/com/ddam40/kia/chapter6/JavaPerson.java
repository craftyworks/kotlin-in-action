package com.ddam40.kia.chapter6;

public class JavaPerson {
    private final String name;
    private String nickName;

    public JavaPerson(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNickName() {
        return this.nickName;
    }
}
