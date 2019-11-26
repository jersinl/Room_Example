package com.example.room_example.main;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.room_example.main.room.dao.Food;
import com.example.room_example.R;
import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MainViewHolder>   {

    private ArrayList<Food> foods;
    private Listener listener;

    FoodAdapter (ArrayList<Food> foods, Listener listener)
    {
        this.foods = foods;
        this.listener = listener;

    }


    interface  Listener
    {
        void onClickItem(Food food);
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item_food, parent, false);
        return new MainViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, final int position) {
        final TextView txtFoodId = holder.itemView.findViewById(R.id.txtFoodId);
        final TextView txtName = holder.itemView.findViewById(R.id.txtName);
        final TextView txtNickName = holder.itemView.findViewById(R.id.txtNickName);
        final TextView txtType = holder.itemView.findViewById(R.id.txtType);
        final TextView txtMaxPrice = holder.itemView.findViewById(R.id.txtMaxPrice);
        final TextView txtMinPrice = holder.itemView.findViewById(R.id.txtMinPrice);

        txtFoodId.setText(Integer.toString(foods.get(position).getFoodId()));
        txtName.setText(foods.get(position).getName());
        txtNickName.setText(foods.get(position).getNickName());
        txtType.setText(foods.get(position).getType());
        txtMaxPrice.setText(Double.toString(foods.get(position).getMaxPrice()));
        txtMinPrice.setText(Double.toString(foods.get(position).getMinPrice()));

        txtFoodId.setOnClickListener( v -> listener.onClickItem(foods.get(position)));



    }


    @Override
    public int getItemCount() {
        return  foods!=null ?  foods.size() : 0;
    }

    static class MainViewHolder extends RecyclerView.ViewHolder {

        MainViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
