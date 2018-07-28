package com.example.jkpark.bucketlist_unit.model;

public class VoteResultPic {
    int stage_num;
    String pic;

    public VoteResultPic(int stage_num, String pic) {
        this.stage_num = stage_num;
        this.pic = pic;
    }

    public int getStage_num() {
        return stage_num;
    }

    public String getPic() {
        return pic;
    }

    public void setStage_num(int stage_num) {
        this.stage_num = stage_num;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
