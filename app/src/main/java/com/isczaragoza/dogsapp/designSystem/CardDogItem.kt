package com.isczaragoza.dogsapp.designSystem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import coil.compose.AsyncImage
import com.isczaragoza.dogsapp.R
import com.isczaragoza.dogsapp.framework.models.DogUiModel
import com.isczaragoza.dogsapp.ui.theme.DogsAppTheme
import com.isczaragoza.dogsapp.ui.theme.Grey600
import com.isczaragoza.dogsapp.ui.theme.Grey800

@Composable
fun CardDogItem(dogUiModel: DogUiModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, bottom = 5.dp)
            .background(Color.Transparent, shape = RoundedCornerShape(10.dp))
    ) {
        Box {
            Column(
                modifier = Modifier
                    .width(140.dp)
                    .height(220.dp)
                    .clip(shape = RoundedCornerShape(10.dp))
                    .background(color = Grey600, shape = RoundedCornerShape(10.dp))
                    .zIndex(1f)
            ) {
                dogUiModel.image?.run {
                    AsyncImage(
                        model = this,
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .padding(top = 40.dp)
                    .background(Color.White, shape = RoundedCornerShape(10.dp))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .height(180.dp)
                        .padding(start = 155.dp, top = 14.dp, end = 16.dp, bottom = 14.dp)
                        .background(color = Color.Transparent, shape = RoundedCornerShape(10.dp))
                ) {
                    Text(text = dogUiModel.dogName, fontSize = 26.sp, color = Grey800, maxLines = 1)
                    Text(
                        modifier = Modifier
                            .height(90.dp)
                            .padding(top = 10.dp)
                            .background(Color.White),
                        text = dogUiModel.description ?: "",
                        fontSize = 14.sp,
                        color = Grey600,
                        maxLines = 3,
                        softWrap = true,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        modifier = Modifier.padding(top = 10.dp),
                        text = if (dogUiModel.age != null) {
                            stringResource(R.string.card_dog_item_age, dogUiModel.age)
                        } else {
                            ""
                        },
                        fontSize = 16.sp,
                        color = Grey800,
                        maxLines = 1
                    )
                }
            }
        }
    }
    /*Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Gray, shape = RoundedCornerShape(12.dp))
        //.clip(shape = RoundedCornerShape(12.dp))
    ) {
        Box(modifier = Modifier.background(Color.Black), contentAlignment = Alignment.BottomStart) {
            Box(
                modifier = Modifier
                    .width(140.dp)
                    .height(215.dp)
                    .background(Color.Blue)
            ) {

            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(top = 32.dp)
                    .background(Color.White)
            ) {

            }
        }
    }*/
}

@Preview(showBackground = true)
@Composable
private fun CardDogItemPreview() {
    DogsAppTheme {
        CardDogItem(DogUiModel("Title", "Description", 2, "Footer Image URL"))
    }
}