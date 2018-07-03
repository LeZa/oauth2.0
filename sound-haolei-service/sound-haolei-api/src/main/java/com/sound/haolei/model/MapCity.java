package com.sound.haolei.model;


import java.util.Date;
import java.util.List;

public class MapCity extends BaseModel{
    private Integer id;

    private String name;

    private String letter;

    private Integer pid;

    private Date ctime;

    private List<MapCountry> mapCountry;

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

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public List<MapCountry> getMapCountry() {
        return mapCountry;
    }

    public void setMapCountry(List<MapCountry> mapCountry) {
        this.mapCountry = mapCountry;
    }

}
