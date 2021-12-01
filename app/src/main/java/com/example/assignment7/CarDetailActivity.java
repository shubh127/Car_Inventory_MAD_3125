package com.example.assignment7;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class CarDetailActivity extends AppCompatActivity {
    private String carName;
    private ArrayList<Integer> carImageIds;
    private ImageView ivCenter;
    private ImageView ivFirst;
    private ImageView ivSecond;
    private ImageView ivThird;
    private ImageView ivFourth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_detail);

        getDataFromIntent();
        initViews();
        configViews();
    }

    private void initViews() {
        ivCenter = findViewById(R.id.iv_center);
        ivFirst = findViewById(R.id.iv_first);
        ivSecond = findViewById(R.id.iv_second);
        ivThird = findViewById(R.id.iv_third);
        ivFourth = findViewById(R.id.iv_fourth);
    }

    private void configViews() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(carName);
        }

        ivCenter.setImageDrawable(ContextCompat.getDrawable(this,
                carImageIds.get(0)));
        ivFirst.setImageDrawable(ContextCompat.getDrawable(this,
                carImageIds.get(0)));
        ivSecond.setImageDrawable(ContextCompat.getDrawable(this,
                carImageIds.get(1)));
        ivThird.setImageDrawable(ContextCompat.getDrawable(this,
                carImageIds.get(2)));
        ivFourth.setImageDrawable(ContextCompat.getDrawable(this,
                carImageIds.get(3)));

        ivFirst.setOnClickListener(view -> ivCenter.setImageDrawable(ContextCompat.
                getDrawable(CarDetailActivity.this,
                        carImageIds.get(0))));

        ivSecond.setOnClickListener(view -> ivCenter.setImageDrawable(ContextCompat.
                getDrawable(CarDetailActivity.this,
                        carImageIds.get(1))));

        ivThird.setOnClickListener(view -> ivCenter.setImageDrawable(ContextCompat.
                getDrawable(CarDetailActivity.this,
                        carImageIds.get(2))));

        ivFourth.setOnClickListener(view -> ivCenter.setImageDrawable(ContextCompat.
                getDrawable(CarDetailActivity.this,
                        carImageIds.get(3))));
    }

    private void getDataFromIntent() {
        carName = getIntent().getExtras().getString("CAR_NAME");
        carImageIds = getIntent().getExtras().getIntegerArrayList("CAR_IMAGES");
    }
}