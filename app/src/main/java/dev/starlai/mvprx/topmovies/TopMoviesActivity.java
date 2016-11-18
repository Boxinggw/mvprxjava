package dev.starlai.mvprx.topmovies;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.apkfuns.logutils.LogUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dev.starlai.mvprx.R;
import dev.starlai.mvprx.repo.ViewModel;
import dev.starlai.mvprx.util.DividerItemDecoration;

public class TopMoviesActivity extends AppCompatActivity implements TopMoviesMVP.View {

    @BindView(R.id.recycler_view) RecyclerView recyclerView;
    @BindView(R.id.listActivity_rootView) ViewGroup rootView;

    @Inject
    TopMoviesMVP.Presenter presenter;

    private TopMoviesAdapter adapter;
    private List<ViewModel> viewModels = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topmovies_activity);

        ButterKnife.bind(this);

        adapter = new TopMoviesAdapter(viewModels);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this));

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.loadData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.rxUnsuscribe();
    }

    @Override
    public void updateData(ViewModel viewModel) {
        viewModels.add(viewModel);
        if(viewModels.isEmpty()) adapter.notifyItemInserted(0);
        else adapter.notifyItemInserted(viewModels.size() - 1);

        LogUtils.d("updateData: " + viewModels.size());
    }

    @Override
    public void showSnackbar(String s) {
        Snackbar.make(rootView, s, Snackbar.LENGTH_SHORT).show();

    }
}
