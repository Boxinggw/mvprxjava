package dev.starlai.mvprx.repo;

import dev.starlai.mvprx.service.model.Result;
import rx.Observable;

/**
 * Created by izayoi on 11/17/2016.
 */

public interface Repository {

    Observable<Result> getResultsFromMemory();

    Observable<Result> getResultsFromNetwork();

    Observable<String> getCountriesFromMemory();

    Observable<String> getCountriesFromNetwork();

    Observable<String> getCountryData();

    Observable<String> getResultData();
}
