package com.isczaragoza.dogsapp.listOfDogs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.isczaragoza.dogsapp.R
import com.isczaragoza.dogsapp.designSystem.CardDogItem
import com.isczaragoza.dogsapp.domain.entities.DogEntity
import com.isczaragoza.dogsapp.framework.models.DogUiModel
import com.isczaragoza.dogsapp.ui.theme.DogsAppTheme
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListOfDogsScreen(
    onClickBack: () -> Unit = {},
) {
    val viewModel: ListOfDogsViewModel = koinViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val isLoading = uiState is ListOfDogsUiState.Loading
    Column(modifier = Modifier.fillMaxSize()) {
        CenterAlignedTopAppBar(
            title = { Text(text = stringResource(R.string.list_of_dogs_screen_top_app_bar)) },
            navigationIcon = {
                IconButton(onClick = onClickBack) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowLeft,
                        contentDescription = null,
                    )
                }
            })
        if (isLoading) {
            LinearProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
            )
        } else {
            HorizontalDivider(
                thickness = 2.dp, color = Color.Transparent
            )
        }

        when (uiState) {
            is ListOfDogsUiState.Success -> {
                val items = (uiState as ListOfDogsUiState.Success).listOfDogs
                if (items.isEmpty()) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = stringResource(R.string.list_of_dogs_screen_no_items))
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 10.dp, end = 10.dp)
                ) {
                    LazyColumn {
                        items(items) { item: DogUiModel ->
                            CardDogItem(item)
                        }
                    }
                }
            }

            is ListOfDogsUiState.LoadFailed -> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    /*Esta sección puede mostrar los errores en UI dependiendo del error arrojado por el use case*/
                    Text(text = stringResource(R.string.error))
                }
            }

            else -> {}
        }


    }
}

@Preview(showBackground = true)
@Composable
private fun ListOfDogsScreenPreview() {
    DogsAppTheme {
        ListOfDogsScreen()
    }
}