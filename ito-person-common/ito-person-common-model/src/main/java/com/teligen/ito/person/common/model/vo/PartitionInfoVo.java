package com.teligen.ito.person.common.model.vo;

import java.util.List;

public class PartitionInfoVo<T> {
    private List<T> add;
    private List<T> update;
    private List<T> delete;

    public List<T> getAdd() {
        return add;
    }

    public void setAdd(List<T> add) {
        this.add = add;
    }

    public List<T> getUpdate() {
        return update;
    }

    public void setUpdate(List<T> update) {
        this.update = update;
    }

    public List<T> getDelete() {
        return delete;
    }

    public void setDelete(List<T> delete) {
        this.delete = delete;
    }

    public List<T> getRepeat() {
        return repeat;
    }

    public void setRepeat(List<T> repeat) {
        this.repeat = repeat;
    }

    private List<T> repeat;

}
