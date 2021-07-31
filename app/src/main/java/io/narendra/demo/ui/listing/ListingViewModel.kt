package io.narendra.demo.ui.listing

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.narendra.demo.data.MovieRepository
import io.narendra.demo.model.Result
import io.narendra.demo.model.TrendingMovieResponse
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect

/**
 * ViewModel for ListingActivity
 */
class ListingViewModel @ViewModelInject constructor(private val movieRepository: MovieRepository) :
        ViewModel() {

    private val _movieList = MutableLiveData<Result<TrendingMovieResponse>>()
    val movieList = _movieList

    init {
        fetchMovies()
    }

    private fun fetchMovies() {
        viewModelScope.launch {
            movieRepository.fetchTrendingMovies().collect {
                _movieList.value = it
            }
        }
    }
}