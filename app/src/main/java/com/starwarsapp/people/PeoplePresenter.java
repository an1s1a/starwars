package com.starwarsapp.people;

import android.util.Log;

import com.starwarsapp.data.model.People;
import com.starwarsapp.data.source.Repository;
import com.starwarsapp.data.source.remote.RemoteDataSource;
import com.starwarsapp.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class PeoplePresenter implements PeopleContract.Presenter {

    private static final String LOG_TAG = PeoplePresenter.class.getSimpleName();

    private PeopleContract.View view;
    private Repository repository;

    private static final int PAGES = 9;
    private static final int PAGE_START = 1;
    private int currentPage = PAGE_START;
    private int loadedPages = PAGE_START;
    List<People> allPeople = new ArrayList<>();

    public PeoplePresenter(PeopleContract.View view, Repository repository) {
        this.view = view;
        this.repository = repository;
    }

    private void loadFromRepository() {
        repository.getPeoples(new RemoteDataSource.LoadDataListCallBack<People>() {
            @Override
            public void onDataLoaded(List<People> list) {
                allPeople.addAll(list);
                view.showPeople(allPeople);
                view.checkForLoading();
                loadedPages++;
                if (loadedPages > PAGES) {
                    view.setLastPage(true);
                    view.checkForLoading();
                    Utils.sortByName((ArrayList<People>) allPeople);
                    view.showPeople(allPeople);
                }
            }

            @Override
            public void onDataNotAvailable() {
                Log.e(LOG_TAG, "Data not available");
                view.showLoading(false);
            }
        }, currentPage);

        currentPage++;

        if (currentPage == PAGES) {

        }

        if (currentPage <= PAGES) {
            loadFromRepository();
        }
    }

    @Override
    public void loadPeople(boolean forceUpdate) {
        loadFromRepository();
    }
}
