package com.example.room_example.main;

import com.example.room_example.main.room.dao.Food;

import java.util.ArrayList;

public interface MainView {

    void showProgressBar();
    void hideProgressBar();
    void setItems(ArrayList<Food> foods);
    void showCreateItemView();
    void onItemSuccessAdd(Food food);
    void onItemErrorAdd();
    void onShowMessage(String message);
    void onAddedItem(ArrayList<Food> foods);


}
