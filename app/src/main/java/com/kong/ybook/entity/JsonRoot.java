package com.kong.ybook.entity;

/**
 * Created by konglingyu on 2017/2/22.
 */

public class JsonRoot {
    private int error_code;

    private String reason;

    private Result result;

    public void setError_code(int error_code){
        this.error_code = error_code;
    }
    public int getError_code(){
        return this.error_code;
    }

    public void setReason(String reason){
        this.reason = reason;
    }
    public String getReason(){
        return this.reason;
    }

    public void setResult(Result result){
        this.result = result;
    }
    public Result getResult(){
        return this.result;
    }
}
