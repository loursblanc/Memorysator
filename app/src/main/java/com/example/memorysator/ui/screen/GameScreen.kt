package com.example.memorysator.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.memorysator.R


val mockupIdPhotosList = listOf<Int>(R.drawable.nasa01, R.drawable.nasa02, R.drawable.nasa03,
    R.drawable.nasa04, R.drawable.nasa05, R.drawable.nasa02,R.drawable.nasa01, R.drawable.nasa02, R.drawable.nasa03,
    R.drawable.nasa04, R.drawable.nasa05, R.drawable.nasa02,R.drawable.nasa01, R.drawable.nasa02,R.drawable.nasa01, R.drawable.nasa02, R.drawable.nasa03,
    R.drawable.nasa04, R.drawable.nasa05, R.drawable.nasa02,R.drawable.nasa01, R.drawable.nasa02, R.drawable.nasa03,
    R.drawable.nasa04, R.drawable.nasa05, R.drawable.nasa02,R.drawable.nasa01, R.drawable.nasa02,)

@Composable
fun GameScreen(onBackToMenuButtonClicked: () -> Unit,
               onDetailsButtonClicked: () -> Unit,
               modifier: Modifier = Modifier ) {
    Box(Modifier.fillMaxSize()){
        GameCardGrid(onDetailsButtonClicked)
        Button(
            onClick = onBackToMenuButtonClicked ,
            Modifier
                .align(Alignment.BottomCenter)
        ) {
            Text(
                text = stringResource(id = R.string.return_main_menu_button),
            )
        }
    }
}

@Composable
fun GameCardGrid(onDetailsButtonClicked: () -> Unit,modifier: Modifier = Modifier){
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        //contentPadding = PaddingValues(4.dp)
        //Modifier.padding(dimensionResource(id = R.dimen.medium_vertical_padding))
    ){
        items(mockupIdPhotosList){ idPhoto ->
            GameCardCard(idPhoto,onDetailsButtonClicked, modifier.padding(dimensionResource(id = R.dimen.small_padding)))
        }
    }
}

@Composable
fun GameCardCard(photoId: Int,onDetailsButtonClicked: () -> Unit, modifier: Modifier = Modifier){
    Card(
        modifier
            .clickable {  /*Todo*/ }
            .height(dimensionResource(id = R.dimen.height_card)),
            elevation = CardDefaults.cardElevation(defaultElevation = dimensionResource(id = R.dimen.elevation)),
            shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_card)),
    ){
        Box(){
            Image(
                painter = painterResource(id = photoId),
                contentDescription = "Space",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            IconButton(onClick = onDetailsButtonClicked,
                Modifier.align(Alignment.BottomEnd)
                    .testTag(stringResource(id = R.string.details_title))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.info_icon), 
                    contentDescription = "Details",
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GameCardCardPreview(){
    GameCardCard(mockupIdPhotosList[0],{})
}

@Preview(showBackground = true)
@Composable
fun GameScreenPreview(){
    GameScreen({},{})
}
