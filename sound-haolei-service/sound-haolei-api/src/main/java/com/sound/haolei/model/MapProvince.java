package com.sound.haolei.model;


import java.util.Date;
import java.util.List;

public class MapProvince extends BaseModel{
    private Integer id;

    private String name;

    private String letter;

    private Date ctime;

    // 城市
    private List<MapCity> mapCity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter == null ? null : letter.trim();
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public List<MapCity> getMapCity() {
        return mapCity;
    }

    public void setMapCity(List<MapCity> mapCity) {
        this.mapCity = mapCity;
    }


}
