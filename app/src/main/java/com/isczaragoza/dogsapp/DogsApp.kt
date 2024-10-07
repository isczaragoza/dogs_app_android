package com.isczaragoza.dogsapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.isczaragoza.dogsapp.home.navigation.HomeDestination
import com.isczaragoza.dogsapp.home.navigation.homeScreen
import com.isczaragoza.dogsapp.listOfDogs.navigation.listOfDogsScreen
import com.isczaragoza.dogsapp.listOfDogs.navigation.navigateToListOfDogsScreen
import com.isczaragoza.dogsapp.ui.theme.DogsAppTheme
import com.isczaragoza.dogsapp.ui.theme.Grey200

@Composable
fun DogsApp() {
    val navController: NavHostController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Grey200,
        //contentWindowInsets = WindowInsets(0, 0, 0, 0),
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .consumeWindowInsets(innerPadding)
                .windowInsetsPadding(
                    WindowInsets.safeDrawing.only(
                        WindowInsetsSides.Horizontal,
                    ),
                )
        ) {
            NavHost(
                navController = navController,
                startDestination = HomeDestination
            ) {
                homeScreen(onClickRequestPuppyList = {
                    navController.navigateToListOfDogsScreen()
                })
                listOfDogsScreen(onClickBack = {
                    navController.navigateUp()
                })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DogsAppPreview() {
    DogsAppTheme {
        DogsApp()
    }
}