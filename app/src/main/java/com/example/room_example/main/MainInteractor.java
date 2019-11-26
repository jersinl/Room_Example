package com.example.room_example.main;

import android.os.AsyncTask;
import android.os.Handler;

import com.example.room_example.main.room.dao.Food;
import com.example.room_example.main.room.dao.FoodDao;

import java.util.ArrayList;

 class MainInteractor {

    public interface OnFinishedLoadingItems
    {
        void onFinished(ArrayList<Food> foods);
    }

    public interface OnAddFoodItems
    {
        void onFinishedAddItem(Food food);
    }

    public interface OnLoadingLocalStorageItems
    {
        void onFinishedLoadItems(ArrayList<Food> food);
    }


    void loadItems(OnFinishedLoadingItems listener, FoodDao foodDao)
    {
        new Handler().postDelayed( () ->
        {


            listener.onFinished((ArrayList<Food>) foodDao.getFood());


        }, 4000);


    }


    void addItem(OnAddFoodItems listener, Food food , FoodDao foodDao)
    {

        AsyncTask.execute(() -> foodDao.addFood(food) );
        listener.onFinishedAddItem(food);
    }

    void getItem(OnLoadingLocalStorageItems listener, FoodDao foodDao)
    {
        ArrayList<Food> foods = (ArrayList<Food>) foodDao.getFood();
        listener.onFinishedLoadItems(foods);
    }

}
