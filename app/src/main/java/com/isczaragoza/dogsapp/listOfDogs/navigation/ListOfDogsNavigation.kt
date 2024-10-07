package com.isczaragoza.dogsapp.listOfDogs.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.isczaragoza.dogsapp.listOfDogs.ListOfDogsScreen
import kotlinx.serialization.Serializable

@Serializable
object ListOfDogsDestination

fun NavController.navigateToListOfDogsScreen() {
    this.navigate(route = ListOfDogsDestination) {
        graph.findStartDestination().route?.let {
            popUpTo(it)
        }
    }
}

fun NavGraphBuilder.listOfDogsScreen(onClickBack: () -> Unit = {}) {
    composable<ListOfDogsDestination> {
        ListOfDogsScreen(onClickBack= onClickBack)
    }
}