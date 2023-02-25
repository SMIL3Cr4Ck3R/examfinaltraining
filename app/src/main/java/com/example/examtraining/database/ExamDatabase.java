package com.example.examtraining.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {ImageHolderModel.class},version = 1)
public abstract class ExamDatabase extends RoomDatabase {

    private static ExamDatabase instance;
    public static synchronized ExamDatabase getInstance(Context context) {

        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),ExamDatabase.class,"ExamDB").build();
        }
        return instance;
    }

    public abstract ImageDao ImageDao();

}
