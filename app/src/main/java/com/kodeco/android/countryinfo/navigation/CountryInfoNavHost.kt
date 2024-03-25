package com.kodeco.android.countryinfo.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kodeco.android.countryinfo.repositories.CountryRepository
import com.kodeco.android.countryinfo.ui.screens.about.AboutScreen
import com.kodeco.android.countryinfo.ui.screens.countrydetails.CountryDetailsScreen
import com.kodeco.android.countryinfo.ui.screens.countrydetails.CountryDetailsViewModel
import com.kodeco.android.countryinfo.ui.screens.countryinfo.CountryInfoScreen
import com.kodeco.android.countryinfo.ui.screens.countryinfo.CountryInfoViewModel

@Composable
fun CountryInfoNavHost(
    repository: CountryRepository,
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "list") {
        composable("list") {
            CountryInfoScreen(
                viewModel = viewModel(
                    factory = CountryInfoViewModel.CountryInfoViewModelFactory(
                        repository = repository,
                    ),
                ),
                onCountryRowTap = { countryIndex ->
                    navController.navigate("details/$countryIndex")
                },
                onTapAbout = { navController.navigate("about") }
            )
        }

        composable(
            "details/{countryIndex}",
            arguments = listOf(navArgument("countryIndex") {
                type = NavType.IntType
            })
        ) {
            CountryDetailsScreen(
                viewModel = viewModel(
                    factory = CountryDetailsViewModel.CountryDetailsViewModelFactory(
                        repository = repository,
                        countryId = it.arguments?.getInt("countryIndex") ?: 0
                    ),
                )
            ) {
                navController.navigateUp()
            }
        }

        composable("about") {
            AboutScreen() {
                navController.navigateUp()
            }
        }
    }
}