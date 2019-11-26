package com.example.room_example.main.room.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.room_example.main.room.dao.Food;
import com.example.room_example.main.room.dao.FoodDao;

@Database( entities = Food.class, exportSchema = false,version = 1)
public abstract class FoodDatabase extends RoomDatabase {

    private static final String db_name = "example_db";
    private static FoodDatabase instance;

    public static synchronized FoodDatabase getInstance(Context context)
    {
        if(instance == null)
        {
            instance = Room.databaseBuilder(context.getApplicationContext(),FoodDatabase.class,db_name)
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build();
        }

        return instance;
    }

    public abstract FoodDao foodDao();

}
