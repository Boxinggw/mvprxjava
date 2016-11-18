package dev.starlai.mvprx.repo;

import java.util.ArrayList;
import java.util.List;

import dev.starlai.mvprx.service.MoreInfoApiService;
import dev.starlai.mvprx.service.MovieApiService;
import dev.starlai.mvprx.service.model.Result;
import rx.Observable;

/**
 * Created by izayoi on 11/17/2016.
 */

public class TopMoviesRepository implements Repository {

    private MovieApiService movieApiService;
    private MoreInfoApiService moreInfoApiService;
    private List<String> countries;
    private List<String> results;
    private long timestamp;

    private static final long STALE_MS = 20 * 1000; // Data is stale after 20 seconds

    public TopMoviesRepository(MovieApiService movieApiService, MoreInfoApiService moreInfoApiService) {
        this.movieApiService = movieApiService;
        this.moreInfoApiService = moreInfoApiService;
        this.timestamp = System.currentTimeMillis();
        countries = new ArrayList<>();
        results = new ArrayList<>();
    }

    public boolean isUpToDate() {
        return System.currentTimeMillis() - timestamp < STALE_MS;
    }

    @Override
    public Observable<Result> getResultsFromMemory() {
        return null;
    }

    @Override
    public Observable<Result> getResultsFromNetwork() {
        return null;
    }

    @Override
    public Observable<String> getCountriesFromMemory() {
        return null;
    }

    @Override
    public Observable<String> getCountriesFromNetwork() {
        return null;
    }

    @Override
    public Observable<String> getCountryData() {
        return null;
    }

    @Override
    public Observable<String> getResultData() {
        return null;
    }
}
