package com.example.examtraining.database;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ImageDao {

    @Insert
    void insertImage(ImageHolderModel... image);

    @Delete
    void deleteImgById(ImageHolderModel image);

    @Query("select * from ImageHolderModel")
    List<ImageHolderModel> getImgList ();

}
