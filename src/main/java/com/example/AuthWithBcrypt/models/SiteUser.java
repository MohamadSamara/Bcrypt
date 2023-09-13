package com.example.AuthWithBcrypt.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class SiteUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @OneToMany(mappedBy = "siteUser" , cascade = CascadeType.ALL)
    List<SitePost> sitePostList;
    public SiteUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public SiteUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<SitePost> getSitePostList() {
        return sitePostList;
    }

    public void setSitePostList(List<SitePost> sitePostList) {
        this.sitePostList = sitePostList;
    }
}
