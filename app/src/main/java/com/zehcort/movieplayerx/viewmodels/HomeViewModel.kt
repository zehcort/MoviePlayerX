package com.zehcort.movieplayerx.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zehcort.domain.companions.Resource
import com.zehcort.domain.usecases.GetMovieCategories
import com.zehcort.movieplayerx.states.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMovieCategories: GetMovieCategories
) : ViewModel() {
    private val _state = mutableStateOf(HomeState())
    val state: State<HomeState> = _state

    fun fetchMovieCategories() {
        viewModelScope.launch {
            getMovieCategories().collect() { result ->
                when (result) {
                    is Resource.Error -> TODO()
                    is Resource.Loading -> _state.value = state.value.copy(
                        isLoading = true
                    )

                    is Resource.Success -> _state.value = state.value.copy(
                        isLoading = false,
                        movieCategories = result.data!!
                    )
                }
            }
        }
    }

    fun resetMovieCategoriesState() {
        _state.value = state.value.copy(
            movieCategories = listOf()
        )
    }
}