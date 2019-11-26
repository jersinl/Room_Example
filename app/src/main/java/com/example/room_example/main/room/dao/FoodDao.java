package com.example.room_example.main.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.ArrayList;
import java.util.List;

@Dao
public interface FoodDao {


    @Query("Select * from CMM_Food")
    List<Food> getFood();

    @Insert
    void addFood(Food food);

    @Update
    void updateFood(Food food);

    @Delete
    void deleteFood(Food food);
}
