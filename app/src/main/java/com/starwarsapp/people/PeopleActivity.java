package com.starwarsapp.people;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.starwarsapp.R;
import com.starwarsapp.data.model.People;
import com.starwarsapp.data.source.Repository;
import com.starwarsapp.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

public class PeopleActivity extends AppCompatActivity implements PeopleContract.View {

    @BindView(R.id.progress)
    ProgressBar progress;

    @BindView(R.id.swipeRefreshLayout)
    ConstraintLayout constraintLayout;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private static final String LOG_TAG = PeopleActivity.class.getSimpleName();
    @Inject
    PeoplePresenter presenter;

    @Inject
    Repository repository;

    private PeopleListAdapter adapter;
    private boolean isLoading = false;
    private boolean isLastPage = false;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initRecycler();
        presenter.loadPeople(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.order_by_birth:
                Utils.sortByBirth((ArrayList<People>) presenter.allPeople);
                showPeople(presenter.allPeople);
                return true;
            case R.id.order_by_favourite:
                Utils.sortByFavourite((ArrayList<People>) presenter.allPeople);
                showPeople(presenter.allPeople);
                return true;
            case R.id.order_by_name:
                Utils.sortByName((ArrayList<People>) presenter.allPeople);
                showPeople(presenter.allPeople);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initRecycler() {
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PeopleListAdapter(people -> {

        }, new ArrayList<People>(), presenter, this);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                checkForLoading();

            }
        });
    }

    @Override
    public void checkForLoading() {
        int visibleItemCount = layoutManager.getChildCount();
        int totalItemCount = layoutManager.getItemCount();
        int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
        if (!isLoading) {
            if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount && firstVisibleItemPosition >= 0) {
                showLoading(true);
            }
        }

        if ((visibleItemCount + firstVisibleItemPosition) < totalItemCount) {
            showLoading(false);
        }

        if ((visibleItemCount + firstVisibleItemPosition) == totalItemCount && isLastPage) {
            showLoading(false);
        }
    }

    @Override
    public void setLastPage(boolean isLastPage) {
        this.isLastPage = isLastPage;
    }

    @Override
    public void showPeople(List<People> people) {
        adapter.setData(people);
    }

    @Override
    public void showLoading(boolean isLoading) {
        if (isLoading) {
            progress.setVisibility(View.VISIBLE);
            this.isLoading = true;
        } else {
            progress.setVisibility(View.GONE);
            this.isLoading = false;
        }
    }
}
