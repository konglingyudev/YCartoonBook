package com.kong.ybook.entity;

/**
 * Created by konglingyu on 2017/2/23.
 */

public class Book {

        private String name;

        private String type;

        private String area;

        private String des;

        private boolean finish;

        private int lastUpdate;

        private String coverImg;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public int getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(int lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", area='" + area + '\'' +
                ", des='" + des + '\'' +
                ", finish=" + finish +
                ", lastUpdate=" + lastUpdate +
                ", coverImg='" + coverImg + '\'' +
                '}';
    }
}
