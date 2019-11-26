package com.example.room_example.main;

import com.example.room_example.main.room.dao.Food;
import com.example.room_example.main.room.dao.FoodDao;

import java.util.ArrayList;

public class MainPresenter implements MainInteractor.OnFinishedLoadingItems ,
        MainInteractor.OnAddFoodItems , MainInteractor.OnLoadingLocalStorageItems {

    private MainView mainView;
    private MainInteractor mainInteractor;
    private FoodDao foodDao;

    MainPresenter(MainView mainView, MainInteractor mainInteractor, FoodDao foodDao)
    {
        this.mainView = mainView;
        this.mainInteractor = mainInteractor;
        this.foodDao = foodDao;
    }

    void onResume()
    {
        if(mainView!=null) mainView.showProgressBar();

        mainInteractor.loadItems(this,foodDao);
    }

    void onDestroy()
    {
        mainView = null;
    }

    void onAddItem()
    {
        mainView.showCreateItemView();
    }

    void onClickItem(Food food)
    {
         if (mainView != null) mainView.onShowMessage(food.getName());
    }

    void onSaveData(Food food)
    {
        mainInteractor.addItem(this,food,foodDao);

    }




    @Override
    public void onFinished(ArrayList<Food> foods) {

        if(mainView!=null)
        {
            mainView.hideProgressBar();
            mainView.setItems(foods);
        }

    }

    @Override
    public void onFinishedAddItem(Food food) {
        if(mainView!=null)
        {
            mainView.showProgressBar();
            mainView.onItemSuccessAdd(food);
            mainInteractor.getItem(this,foodDao);
        }


    }

    @Override
    public void onFinishedLoadItems(ArrayList<Food> food) {

        if(mainView!=null)
        {
            mainView.hideProgressBar();
            mainView.onAddedItem(food);
            onResume();
        }

    }
}
