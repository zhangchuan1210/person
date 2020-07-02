package com.teligen.ito.person.common.model.vo;

public class MatchInfoVo<T> {
    boolean isMathch;
    T source;
    T target;

    public boolean isMathch() {
        return isMathch;
    }

    public void setMathch(boolean mathch) {
        isMathch = mathch;
    }

    public T getSource() {
        return source;
    }

    public void setSource(T source) {
        this.source = source;
    }

    public T getTarget() {
        return target;
    }

    public void setTarget(T target) {
        this.target = target;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    String id;

}
