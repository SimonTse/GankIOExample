package com.simontse.gankio.gankioexample.entity;

/**
 * Created by simon_pc on 2016/10/9.
 * Email: xiejx_op@foxmail.com
 * Description: 干货实体类
 */

public class GanHuo<T> {

    private  boolean error;
    private T results;

    public GanHuo(boolean error, T results) {
        this.error = error;
        this.results = results;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }
}
