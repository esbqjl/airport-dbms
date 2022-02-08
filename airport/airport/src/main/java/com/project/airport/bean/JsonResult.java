package com.project.airport.bean;

public class JsonResult {
    private String status = null;
    private Object result = null;
    public JsonResult status(String status){
        this .status = status;
        return this;
    }

    public void setResult(Object result) {
        this.result = result;
    }
    public void setStatus(String status){
        this.status = status;

    }

    public Object getResult() {
        return this.result;
    }

    public String getStatus() {
        return this.status;
    }
}
