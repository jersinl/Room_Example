package com.example.room_example.main.room.dao;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "CMM_Food")
public class Food {

    @PrimaryKey(autoGenerate = true)
    private int foodId;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "nickName")
    private String nickName;
    @ColumnInfo(name = "type")
    private String type;
    @ColumnInfo(name = "maxPrice")
    private double maxPrice;
    @ColumnInfo(name = "minPrice")
    private double minPrice;

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }
}
