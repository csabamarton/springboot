package com.example.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "deviceid")
    private long deviceId;

    @Column(name = "token")
    private String token;

    @Column(name = "devicetype")
    private String deviceType;

    @Column(name = "devicelang")
    private String deviceLang;

    @Column(name = "regdate")
    private Date regDate;

    @Column(name = "userid")
    private Long userId;

    @Column(name = "devicetypedescription", columnDefinition = "TEXT")
    private String deviceTypeDescription;

    @Column(name = "lastview")
    private Date lastView;

    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceLang() {
        return deviceLang;
    }

    public void setDeviceLang(String deviceLang) {
        this.deviceLang = deviceLang;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getDeviceTypeDescription() {
        return deviceTypeDescription;
    }

    public void setDeviceTypeDescription(String deviceTypeDescription) {
        this.deviceTypeDescription = deviceTypeDescription;
    }

    public Date getLastView() {
        return lastView;
    }

    public void setLastView(Date lastView) {
        this.lastView = lastView;
    }
}
