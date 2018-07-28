package com.example.jkpark.bucketlist_unit.model;

public class VoteResult {
    String name;
    int num_pics;

    public VoteResult(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNum_pics() {
        return num_pics;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNum_pics(int num_pics) {
        this.num_pics = num_pics;
    }
}
