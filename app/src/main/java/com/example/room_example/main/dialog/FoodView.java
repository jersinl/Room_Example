package com.example.room_example.main.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.example.room_example.R;
import com.example.room_example.main.room.dao.Food;

public class FoodView extends DialogFragment {

    private EditText editTextName,editTextNickName,editTextType,editTextMaxPrice,editTextMinPrice;
    private Button buttonSave;
    private Listener listener;

    public interface Listener
    {
        void onSaveData(Food food);
    }

    public FoodView (Listener listener)
    {
        this.listener =  listener;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.dialog_item_view, container, false);
        loadComponents(v);
        // Do all the stuff to initialize your custom view

        return v;

    }

    private void loadComponents(View v)
    {


        editTextName = v.findViewById(R.id.editTextName);
        editTextNickName = v.findViewById(R.id.editTextNickName);
        editTextType = v.findViewById(R.id.editTextType);
        editTextMaxPrice = v.findViewById(R.id.editTextMaxPrice);
        editTextMinPrice = v.findViewById(R.id.editTextMinPrice);
        buttonSave = v.findViewById(R.id.buttonSave);

        events();
    }

    private void events()
    {
        buttonSave.setOnClickListener( v ->  save());
    }

    private void save()
    {
        Food food  = new Food();
        food.setName(editTextName.getText().toString());
        food.setNickName(editTextNickName.getText().toString());
        food.setType(editTextType.getText().toString());
        food.setMaxPrice(Double.valueOf(editTextMaxPrice.getText().toString()));
        food.setMinPrice(Double.valueOf(editTextMinPrice.getText().toString()));

        listener.onSaveData(food);
    }
}
