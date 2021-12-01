package com.example.assignment7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CarListAdapter extends RecyclerView.Adapter<CarListAdapter.ViewHolder> {

    private final List<Car> cars;
    private final OnClickListener listener;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvCarName;

        public ViewHolder(View view) {
            super(view);
            tvCarName = (TextView) view.findViewById(R.id.tv_car_name);
        }
    }

    public CarListAdapter(List<Car> cars, OnClickListener listener) {
        this.cars = cars;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_car_list, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.tvCarName.setText(cars.get(position).getName());
        viewHolder.tvCarName.setOnClickListener(view -> listener.onItemClick(cars.get(position)));
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    interface OnClickListener {
        void onItemClick(Car car);
    }
}
