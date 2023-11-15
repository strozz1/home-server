package com.server.entitties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "service")
public class ServiceRecord {
    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String icon;
    private String url;

    private boolean status;

    public ServiceRecord() {
    }

    public ServiceRecord(int id, String name, String icon,String url, boolean status) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
