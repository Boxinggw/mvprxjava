package dev.starlai.mvprx.topmovies;

import dev.starlai.mvprx.repo.ViewModel;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by izayoi on 11/17/2016.
 */

public class TopMoviesPresenter implements TopMoviesMVP.Presenter {

    private TopMoviesMVP.View view;
    private Subscription subscription = null;
    private TopMoviesMVP.Model model;

    public void loadData() {
        subscription = model.result().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ViewModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        if(view != null) view.showSnackbar("Error getting movies");
                    }

                    @Override
                    public void onNext(ViewModel viewModel) {
                        if(view != null) view.updateData(viewModel);
                    }
                });

    }

    @Override
    public void rxUnsuscribe() {
        if(subscription != null) {
            if(!subscription.isUnsubscribed()) subscription.unsubscribe();
        }

    }

    @Override
    public void setView(TopMoviesMVP.View view) {
        this.view = view;

    }
}
