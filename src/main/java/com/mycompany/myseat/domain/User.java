package com.mycompany.myseat.domain;

import java.util.Date;
import java.util.Objects;

public class User {
    private String email;
    private String pw;
    private String name;
    private String nickname;
    private Date register_date;
    private int grade;
    private int point;
    private int status;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getRegister_date() {
        return register_date;
    }

    public void setRegister_date(Date register_date) {
        this.register_date = register_date;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User(){}

    public User(String email, String pw, String name, String nickname) {
        this.email = email;
        this.pw = pw;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return grade == user.grade && point == user.point && status == user.status && Objects.equals(email, user.email) && Objects.equals(pw, user.pw) && Objects.equals(name, user.name) && Objects.equals(nickname, user.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, pw, name, nickname, grade, point, status);
    }

    @Override
    public String toString() {
        return "User{" +
                ", email='" + email + '\'' +
                ", pw='" + pw + '\'' +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", register_date=" + register_date +
                ", grade=" + grade +
                ", point=" + point +
                ", status=" + status +
                '}';
    }
}
