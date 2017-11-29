package com.starwarsapp.detail;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.starwarsapp.R;
import com.starwarsapp.data.model.Vehicle;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailVehiclesAdapter extends RecyclerView.Adapter<DetailVehiclesAdapter.DetailViewHolder>{

    DetailPresenter presenter;
    private List<Vehicle> vehicleList;

    public DetailVehiclesAdapter(DetailPresenter presenter, List<Vehicle> vehicleList) {
        this.presenter = presenter;
        this.vehicleList = vehicleList;
        notifyDataSetChanged();
    }

    @Override
    public DetailVehiclesAdapter.DetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vehicle_list_item,parent,false);
        return new DetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DetailVehiclesAdapter.DetailViewHolder holder, int position) {
        holder.vehicleName.setText(vehicleList.get(position).getName());
        holder.vehicleClass.setText(vehicleList.get(position).getVehicleClass());
    }

    @Override
    public int getItemCount() {
        return vehicleList.size();
    }

    public class DetailViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.name_vehicle)
        TextView vehicleName;

        @BindView(R.id.class_vehicle)
        TextView vehicleClass;

        public DetailViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setData(List<Vehicle> vehicles){
        this.vehicleList = vehicles;
        notifyDataSetChanged();
    }

}
