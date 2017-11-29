package com.starwarsapp.people;

import android.view.View;
import android.widget.ImageView;

import com.starwarsapp.data.model.People;

import java.util.ArrayList;
import java.util.List;

public interface PeopleListCallback {
    void onPeopleClicked(People people, View view);
    void onFavouriteClicked(People people, View view);
    void onDeleteClicked(People people, ImageView imageView, List<People> peopleList);
}
