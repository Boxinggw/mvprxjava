package dev.starlai.mvprx.topmovies;


import dev.starlai.mvprx.repo.ViewModel;
import rx.Observable;

/**
 * Created by izayoi on 11/17/2016.
 */

public interface TopMoviesMVP {

    interface View {
        void updateData(ViewModel viewModel);

        void showSnackbar(String s);
    }

    interface Presenter {
        void loadData();
        void rxUnsuscribe();
        void setView(TopMoviesMVP.View view);

    }

    interface Model {
        Observable<ViewModel> result();
    }

}
