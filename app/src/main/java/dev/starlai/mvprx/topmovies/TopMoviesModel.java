package dev.starlai.mvprx.topmovies;

import dev.starlai.mvprx.repo.Repository;
import dev.starlai.mvprx.repo.ViewModel;
import rx.Observable;

/**
 * Created by izayoi on 11/17/2016.
 */

public class TopMoviesModel implements TopMoviesMVP.Model {

    private Repository repository;

    public TopMoviesModel(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<ViewModel> result() {
        return null;
    }
}
