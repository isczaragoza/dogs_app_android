package com.isczaragoza.dogsapp.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.isczaragoza.dogsapp.home.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
object HomeDestination


fun NavGraphBuilder.homeScreen(onClickRequestPuppyList: () -> Unit = {}) {
    composable<HomeDestination> {
        HomeScreen(onClickRequestPuppyList = onClickRequestPuppyList)
    }
}