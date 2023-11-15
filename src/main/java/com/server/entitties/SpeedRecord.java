package com.server.entitties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity(name = "speed")
public class SpeedRecord {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="time")
    private LocalDateTime time;
    @Column(name="ping")
    private Float ping;
    @Column(name="download")
    private Float download;
    @Column(name= "upload")
    private Float upload;

    public SpeedRecord() {
    }


    public SpeedRecord(LocalDateTime time, Float ping, Float download, Float upload) {
        this.time = time;
        this.ping = ping;
        this.download = download;
        this.upload = upload;
    }
    public SpeedRecord(Integer id, LocalDateTime time, Float ping, Float download, Float upload) {
        this.id = id;
        this.time = time;
        this.ping = ping;
        this.download = download;
        this.upload = upload;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Float getPing() {
        return ping;
    }

    public void setPing(Float ping) {
        this.ping = ping;
    }

    public Float getDownload() {
        return download;
    }

    public void setDownload(Float download) {
        this.download = download;
    }

    public Float getUpload() {
        return upload;
    }

    public void setUpload(Float upload) {
        this.upload = upload;
    }

    @Override
    public String toString() {
        return "SpeedRecord{" +
                "id=" + id +
                ", time=" + time +
                ", ping=" + ping +
                ", download=" + download +
                ", upload=" + upload +
                '}';
    }
}
