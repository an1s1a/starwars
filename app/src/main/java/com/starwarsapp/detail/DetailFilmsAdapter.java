package com.starwarsapp.detail;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.starwarsapp.R;
import com.starwarsapp.data.model.Film;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailFilmsAdapter extends RecyclerView.Adapter<DetailFilmsAdapter.DetailViewHolder>{

    DetailPresenter presenter;
    private List<Film> filmList;

    public DetailFilmsAdapter(DetailPresenter presenter, List<Film> filmList) {
        this.presenter = presenter;
        this.filmList = filmList;
        notifyDataSetChanged();
    }

    @Override
    public DetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.film_list_item, parent, false);
        return new DetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DetailViewHolder holder, int position) {
        holder.filmTitle.setText(filmList.get(position).getTitle());
        holder.filmDirector.setText(filmList.get(position).getDirector());
        holder.filmProducer.setText(filmList.get(position).getProducer());
    }

    @Override
    public int getItemCount() {
        return filmList.size();
    }

    public class DetailViewHolder extends RecyclerView.ViewHolder {

       @BindView(R.id.title_film)
       TextView filmTitle;

        @BindView(R.id.producer_film)
        TextView filmProducer;

        @BindView(R.id.director_film)
        TextView filmDirector;

        public DetailViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setData(List<Film> films){
        this.filmList = films;
        notifyDataSetChanged();
    }
}
