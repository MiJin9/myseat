package com.mycompany.myseat.domain;

import java.util.Date;
import java.util.Objects;

public class ReviewDto {
    private Integer bno;
    private String title;
    private String content;
    private String nickname;
    private int view_cnt;
    private int comment_cnt;
    private Date reg_date;
    private Date up_date;
    private int sort;

    public Integer getBno() {
        return bno;
    }

    public void setBno(Integer bno) {
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

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public ReviewDto(){ this("", "", "", 0);}

    public ReviewDto(String title, String content, String nickname, int sort) {
        this.title = title;
        this.content = content;
        this.nickname = nickname;
        this.sort = sort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewDto reviewDto = (ReviewDto) o;
        return bno == reviewDto.bno && sort == reviewDto.sort && Objects.equals(title, reviewDto.title) && Objects.equals(content, reviewDto.content) && Objects.equals(nickname, reviewDto.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bno, title, content, nickname, sort);
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
                ", sort=" + sort +
                '}';
    }


}
