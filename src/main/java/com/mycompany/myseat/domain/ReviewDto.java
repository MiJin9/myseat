package com.mycompany.myseat.domain;

import java.util.Date;
import java.util.Objects;

public class ReviewDto {
    private int bno;
    private String title;
    private String content;
    private String nickname;
    private int view_cnt;
    private int comment_cnt;
    private Date reg_date;
    private Date up_date;
    private int type;

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getView_cnt() {
        return view_cnt;
    }

    public void setView_cnt(int view_cnt) {
        this.view_cnt = view_cnt;
    }

    public int getComment_cnt() {
        return comment_cnt;
    }

    public void setComment_cnt(int comment_cnt) {
        this.comment_cnt = comment_cnt;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    public Date getUp_date() {
        return up_date;
    }

    public void setUp_date(Date up_date) {
        this.up_date = up_date;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ReviewDto(){ this("", "", "", 0);}

    public ReviewDto(String title, String content, String nickname, int type) {
        this.title = title;
        this.content = content;
        this.nickname = nickname;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewDto reviewDto = (ReviewDto) o;
        return bno == reviewDto.bno && type == reviewDto.type && Objects.equals(title, reviewDto.title) && Objects.equals(content, reviewDto.content) && Objects.equals(nickname, reviewDto.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bno, title, content, nickname, type);
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "bno=" + bno +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", nickname='" + nickname + '\'' +
                ", view_cnt=" + view_cnt +
                ", comment_cnt=" + comment_cnt +
                ", reg_date=" + reg_date +
                ", up_date=" + up_date +
                ", type=" + type +
                '}';
    }


}
