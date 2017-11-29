package com.starwarsapp.people;

import android.content.Context;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.starwarsapp.R;
import com.starwarsapp.data.model.People;
import com.starwarsapp.detail.DetailActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PeopleListAdapter extends RecyclerView.Adapter<PeopleListAdapter.PeopleViewHolder> {

    PeoplePresenter presenter;
    private ItemClickListener listener;
    private List<People> peopleList;
    private Context context;

    public PeopleListAdapter(ItemClickListener listener, List<People> peopleList, PeoplePresenter presenter, Context context) {
        this.presenter = presenter;
        this.listener = listener;
        this.peopleList = peopleList;
        this.context = context;
        notifyDataSetChanged();
    }

    @Override
    public PeopleListAdapter.PeopleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.people_list_item, parent, false);

        return new PeopleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PeopleListAdapter.PeopleViewHolder holder, int position) {

        holder.name.setOnClickListener((view) -> {
            if (listener != null) {
                listener.onItemClicked(peopleList.get(holder.getAdapterPosition()));
                People people = peopleList.get(holder.getAdapterPosition());
                view.getId();
                people.getBirthYear();
                holder.onPeopleClicked(people, view);
            }
        });

        String name = peopleList.get(position).getName();

        holder.name.setText(name);
        if (!peopleList.get(position).isFavourite) {
            holder.notFavourite.setVisibility(View.VISIBLE);
            holder.favourite.setVisibility(View.GONE);
        } else {
            holder.notFavourite.setVisibility(View.GONE);
            holder.favourite.setVisibility(View.VISIBLE);
        }

        holder.notFavourite.setOnClickListener((view) -> {
            if (listener != null) {
                listener.onItemClicked(peopleList.get(holder.getAdapterPosition()));
                People people = peopleList.get(holder.getAdapterPosition());
                view.getId();
                people.getBirthYear();
                holder.onFavouriteClicked(people, holder.notFavourite);
            }
        });

        holder.favourite.setOnClickListener((view) -> {
            if (listener != null) {
                listener.onItemClicked(peopleList.get(holder.getAdapterPosition()));
                People people = peopleList.get(holder.getAdapterPosition());
                view.getId();
                people.getBirthYear();
                holder.onFavouriteClicked(people, holder.favourite);
            }
        });

        holder.delete.setOnClickListener((view) -> {
            if (listener != null) {
                listener.onItemClicked(peopleList.get(holder.getAdapterPosition()));
                People people = peopleList.get(holder.getAdapterPosition());
                view.getId();
                people.getBirthYear();
                holder.onDeleteClicked(people, holder.delete, peopleList);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return peopleList.size();
    }

    public void setData(List<People> list) {
        this.peopleList = list;
        notifyDataSetChanged();
    }

    public interface ItemClickListener {
        void onItemClicked(People people);
    }

    public class PeopleViewHolder extends RecyclerView.ViewHolder implements PeopleListCallback {
        @BindView(R.id.peopleText)
        TextView name;
        @BindView(R.id.not_favourite)
        ImageView notFavourite;
        @BindView(R.id.favourite)
        ImageView favourite;
        @BindView(R.id.delete)
        ImageView delete;

        public PeopleViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void onPeopleClicked(People people, View view) {
            context.startActivity(DetailActivity.newIntent(context, people));
        }

        @Override
        public void onFavouriteClicked(People people, View view) {
            ImageView view1 = (ImageView) view;
            AnimatedVectorDrawable drawable = (AnimatedVectorDrawable) view1.getDrawable();

            if (!people.isFavourite) {
                people.isFavourite = true;
                //drawable.start();
                favourite.setVisibility(View.VISIBLE);
                notFavourite.setVisibility(View.GONE);
            } else {
                people.isFavourite = false;
                favourite.setVisibility(View.GONE);
                notFavourite.setVisibility(View.VISIBLE);
            }

/* FAVOURITE ANIMATION

            if(!people.isFavourite){
                people.setFavourite(true);
                drawable.start();

                android.os.Handler handler = new android.os.Handler();
                final Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        //favourite.setVisibility(View.VISIBLE);
                        //view1.setVisibility(View.GONE);
                        people.isFavourite = true;
                        favourite.setVisibility(View.VISIBLE);
                        notFavourite.setVisibility(View.GONE);
                    }
                };
                handler.postDelayed(r, 300);

            } else {
                people.setFavourite(false);
                drawable.start();

                android.os.Handler handler = new android.os.Handler();
                final Runnable r = new Runnable() {
                    @Override
                    public void run() {
                       // view1.setVisibility(View.GONE);
                        people.isFavourite = false;
                        favourite.setVisibility(View.GONE);
                        notFavourite.setVisibility(View.VISIBLE);
                    }
                };
                handler.postDelayed(r, 300);

            }
*/
        }

        @Override
        public void onDeleteClicked(People people, ImageView imageView, List<People> peopleList) {
            peopleList.remove(people);
        }
    }
}
