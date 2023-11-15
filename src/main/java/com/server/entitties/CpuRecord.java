package com.server.entitties;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity(name = "cpu")
public class CpuRecord {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "time")
    private LocalDateTime time;

    @Column(name = "temp")
    private Float temp;

    public CpuRecord() {
    }

    public CpuRecord(Integer id, LocalDateTime time, float temp) {
        this.id = id;
        this.time = time;
        this.temp = temp;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "Cpu_Record{" +
                "id=" + id +
                ", time=" + time +
                ", temp=" + temp +
                '}';
    }

}
