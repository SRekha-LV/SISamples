package com.rules.mvc.model.mongo;

import org.springframework.data.annotation.Id;

public class SequenceCounterInfo {

    @Id
    private String name;

    private long seq;

    public SequenceCounterInfo(String name, long seq) {
        this.name = name;
        this.seq = seq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

}
