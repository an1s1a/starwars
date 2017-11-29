package com.starwarsapp.people;

import com.starwarsapp.BasePresenter;
import com.starwarsapp.BaseView;
import com.starwarsapp.data.model.People;

import java.util.List;

public interface PeopleContract {

    interface View extends BaseView<Presenter> {

        void showPeople(List<People> people);

        void showLoading(boolean isLoading);

        void checkForLoading();

        void setLastPage(boolean isLastPage);
    }

    interface Presenter extends BasePresenter {

        void loadPeople(boolean forceUpdate);
    }
}
