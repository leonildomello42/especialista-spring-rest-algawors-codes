package com.algaworks.algafoodapi.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.stream.IntStream;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Problem implements Serializable{

    private static final long serialVersionUID = 1L;

    private Integer status;
    private String type;
    private String title;
    private String detail;


    public Problem(){
    }

    public Problem(Integer status, String title) {
        this.status = status;
        this.title = title;
    }

    public Problem(Integer status, String type, String title, String detail) {
        this.status = status;
        this.type = type;
        this.title = title;
        this.detail = detail;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
