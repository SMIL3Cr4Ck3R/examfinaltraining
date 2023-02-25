package com.example.examtraining.database;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ImageHolderModel {

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = false)
    private int imgID;

    @ColumnInfo (name = "title")
    private String title;

    @ColumnInfo (name = "url")
    private String url;

    public ImageHolderModel(int imgID, String title, String url) {
        this.imgID = imgID;
        this.title = title;
        this.url = url;
    }

    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ImageHolderModel{" +
                "imgID=" + imgID +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

}
