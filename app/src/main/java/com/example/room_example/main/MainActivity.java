package com.example.room_example.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.room_example.R;
import com.example.room_example.main.dialog.FoodView;
import com.example.room_example.main.room.dao.Food;
import com.example.room_example.main.room.database.FoodDatabase;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements MainView, View.OnClickListener {

    RecyclerView recyclerView;
    FloatingActionButton floatingActionButton;
    ProgressBar progressBar;
    DialogFragment dialogFragment;
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadComponents();

    }

    void loadComponents()
    {
        FoodDatabase appDb  = FoodDatabase.getInstance(this);
        mainPresenter = new MainPresenter(this,new MainInteractor(),appDb.foodDao());
        recyclerView = findViewById(R.id.rcvMain);
        floatingActionButton = findViewById(R.id.floatingActionButton);
        progressBar = findViewById(R.id.progressBar);

        events();

    }

    void events()
    {
        floatingActionButton.setOnClickListener(this);
    }


    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void hideProgressBar() {

        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setItems(ArrayList<Food> foods) {
        recyclerView.setAdapter(new FoodAdapter(foods,mainPresenter::onClickItem) );
    }

    @Override
    public void showCreateItemView() {

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment prev = getSupportFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);
        dialogFragment = new FoodView(mainPresenter::onSaveData);
        dialogFragment.show(ft, "dialog");
    }

    @Override
    public void onItemSuccessAdd(Food food) {
        dialogFragment.dismiss();
        Toast.makeText(MainActivity.this,"Se agrego correctamente : " + food.getName(),Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onItemErrorAdd() {

    }

    @Override
    public void onShowMessage(String message) {
        Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAddedItem(ArrayList<Food> foods) {

        Toast.makeText(MainActivity.this,"Se agrego"+ foods.get(0).getName(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        mainPresenter.onAddItem();
    }

//    Lyfecicle of Activity


    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.onDestroy();
    }
}
