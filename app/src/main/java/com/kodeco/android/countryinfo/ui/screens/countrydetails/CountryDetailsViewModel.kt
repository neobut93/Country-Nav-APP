package com.kodeco.android.countryinfo.ui.screens.countrydetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kodeco.android.countryinfo.repositories.CountryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CountryDetailsViewModel(
    private val countryId: Int,
    private val repository: CountryRepository
) : ViewModel() {

    private val _getCountry =
        MutableStateFlow(repository.getCountry(countryId))
    val getCountry get() = _getCountry.asStateFlow()

    init {
        getCountry
    }

    class CountryDetailsViewModelFactory(
        private val countryId: Int,
        private val repository: CountryRepository
    ) :
        ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            CountryDetailsViewModel(countryId, repository) as T
    }
}