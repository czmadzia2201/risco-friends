package com.risco.friendApp.model;

public class Greeting {

    private final long id;
    private final String content;
    private int age;

    public Greeting(long id, String content, int age) {
        this.id = id;
        this.content = content;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public int getAge() {
        return age;
    }

}