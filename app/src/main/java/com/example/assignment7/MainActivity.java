package com.example.assignment7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,
        CarListAdapter.OnClickListener {

    private final List<String> companyList = new ArrayList<>();
    private final HashMap<String, List<Car>> cars = new HashMap<>();
    private List<Car> selectedCarList = new ArrayList<>();
    private Spinner spCompanies;
    private RecyclerView rvCarsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateList();
        initViews();
        configViews();
    }

    private void initViews() {
        spCompanies = findViewById(R.id.sp_categories);
        rvCarsList = findViewById(R.id.rv_cars_list);
    }

    private void configViews() {
        spCompanies.setOnItemSelectedListener(this);

        ArrayAdapter<String> aa = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, companyList);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCompanies.setAdapter(aa);

        rvCarsList.setLayoutManager(new LinearLayoutManager(this));
        selectedCarList = cars.get(cars.keySet().toArray()[0]);
        rvCarsList.setAdapter(new CarListAdapter(selectedCarList, this));
    }

    private void populateList() {
        List<Car> hyundai = new ArrayList<>();
        ArrayList<Integer> venueImageList = new ArrayList<>();
        venueImageList.add(R.drawable.venue1);
        venueImageList.add(R.drawable.venue2);
        venueImageList.add(R.drawable.venue3);
        venueImageList.add(R.drawable.venue4);
        hyundai.add(new Car("Venue", venueImageList));

        ArrayList<Integer> konaImageList = new ArrayList<>();
        konaImageList.add(R.drawable.kona1);
        konaImageList.add(R.drawable.kona2);
        konaImageList.add(R.drawable.kona3);
        konaImageList.add(R.drawable.kona4);
        hyundai.add(new Car("Kona", konaImageList));

        ArrayList<Integer> tusconImageList = new ArrayList<>();
        konaImageList.add(R.drawable.tuscon1);
        konaImageList.add(R.drawable.tuscon2);
        konaImageList.add(R.drawable.tuscon3);
        konaImageList.add(R.drawable.tuscon4);
        hyundai.add(new Car("Tuscon", tusconImageList));

        cars.put("Hyundai", hyundai);

        List<Car> toyota = new ArrayList<>();
        ArrayList<Integer> miraiImageList = new ArrayList<>();
        miraiImageList.add(R.drawable.mirai1);
        miraiImageList.add(R.drawable.mirai2);
        miraiImageList.add(R.drawable.mirai3);
        miraiImageList.add(R.drawable.mirai4);
        toyota.add(new Car("Mirai", miraiImageList));

        ArrayList<Integer> supraImageList = new ArrayList<>();
        supraImageList.add(R.drawable.supra1);
        supraImageList.add(R.drawable.supra2);
        supraImageList.add(R.drawable.supra3);
        supraImageList.add(R.drawable.supra4);
        toyota.add(new Car("Supra", supraImageList));

        ArrayList<Integer> priusImageList = new ArrayList<>();
        priusImageList.add(R.drawable.prius1);
        priusImageList.add(R.drawable.prius2);
        priusImageList.add(R.drawable.prius3);
        priusImageList.add(R.drawable.prius4);
        toyota.add(new Car("Prius", priusImageList));

        cars.put("Toyota", toyota);

        List<Car> honda = new ArrayList<>();

        ArrayList<Integer> civicImageList = new ArrayList<>();
        civicImageList.add(R.drawable.civic1);
        civicImageList.add(R.drawable.civic2);
        civicImageList.add(R.drawable.civic3);
        civicImageList.add(R.drawable.civic4);
        honda.add(new Car("Civic", civicImageList));

        ArrayList<Integer> accordImageList = new ArrayList<>();
        accordImageList.add(R.drawable.accord1);
        accordImageList.add(R.drawable.accord2);
        accordImageList.add(R.drawable.accord3);
        accordImageList.add(R.drawable.accord4);
        honda.add(new Car("Accord", accordImageList));

        cars.put("Honda", honda);

        List<Car> nissan = new ArrayList<>();

        ArrayList<Integer> versaImageList = new ArrayList<>();
        versaImageList.add(R.drawable.versa1);
        versaImageList.add(R.drawable.versa2);
        versaImageList.add(R.drawable.versa3);
        versaImageList.add(R.drawable.versa4);
        nissan.add(new Car("Versa", versaImageList));

        ArrayList<Integer> sentraImageList = new ArrayList<>();
        sentraImageList.add(R.drawable.sentra1);
        sentraImageList.add(R.drawable.sentra2);
        sentraImageList.add(R.drawable.sentra3);
        sentraImageList.add(R.drawable.sentra4);
        nissan.add(new Car("Sentra", sentraImageList));

        cars.put("Nissan", nissan);

        List<Car> ford = new ArrayList<>();

        ArrayList<Integer> ecoImageList = new ArrayList<>();
        ecoImageList.add(R.drawable.eco1);
        ecoImageList.add(R.drawable.eco2);
        ecoImageList.add(R.drawable.eco3);
        ecoImageList.add(R.drawable.eco4);
        ford.add(new Car("Eco Sport", ecoImageList));

        ArrayList<Integer> escapeImageList = new ArrayList<>();
        escapeImageList.add(R.drawable.escape1);
        escapeImageList.add(R.drawable.escape2);
        escapeImageList.add(R.drawable.escape3);
        escapeImageList.add(R.drawable.escape4);
        ford.add(new Car("Escape", escapeImageList));

        ArrayList<Integer> edgeImageList = new ArrayList<>();
        edgeImageList.add(R.drawable.edge1);
        edgeImageList.add(R.drawable.edge2);
        edgeImageList.add(R.drawable.edge3);
        edgeImageList.add(R.drawable.edge4);
        ford.add(new Car("Edge", edgeImageList));

        ArrayList<Integer> broncoImageList = new ArrayList<>();
        broncoImageList.add(R.drawable.bronco1);
        broncoImageList.add(R.drawable.bronco2);
        broncoImageList.add(R.drawable.bronco3);
        broncoImageList.add(R.drawable.bronco4);
        ford.add(new Car("Bronco", broncoImageList));

        cars.put("Ford", ford);

        companyList.addAll(cars.keySet());
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        selectedCarList = cars.get(cars.keySet().toArray()[i]);
        rvCarsList.setAdapter(new CarListAdapter(selectedCarList, this));
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        //no op
    }

    @Override
    public void onItemClick(Car car) {
        Intent carDetailActivity = new Intent(this, CarDetailActivity.class);
        carDetailActivity.putExtra("CAR_NAME", car.getName());
        carDetailActivity.putIntegerArrayListExtra("CAR_IMAGES", car.getImageIds());
        startActivity(carDetailActivity);
    }
}