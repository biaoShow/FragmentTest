package com.example.biao.fragmenttest;


import java.io.Serializable;

public class Mes implements Serializable{

    private String title;
    private String content;

    public Mes(String title,String content){
        this.title = title;
        this.content = content;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
