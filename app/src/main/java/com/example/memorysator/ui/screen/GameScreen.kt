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
import com.example.memorysator.R
import com.example.memorysator.network.Photo


@Composable
fun GameScreen(onBackToMenuButtonClicked: () -> Unit,
               onDetailsButtonClicked: () -> Unit,
               uiState: MemorysatorUiState,
               modifier: Modifier = Modifier ) {
    Box(Modifier.fillMaxSize()){
        GameCardGrid(onDetailsButtonClicked,uiState.Photos)
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
fun GameCardGrid(onDetailsButtonClicked: () -> Unit, photos: List<Photo>, modifier: Modifier = Modifier){
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
    ){
        items(photos){ Photo ->
            GameCardCard(Photo.url,onDetailsButtonClicked, modifier.padding(dimensionResource(id = R.dimen.small_padding)))
        }
    }
}

@Composable
fun GameCardCard(url: Int, onDetailsButtonClicked: () -> Unit, modifier: Modifier = Modifier){
    Card(
        modifier
            .clickable {  /*Todo*/ }
            .height(dimensionResource(id = R.dimen.height_card)),
            elevation = CardDefaults.cardElevation(defaultElevation = dimensionResource(id = R.dimen.elevation)),
            shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_card)),
    ){
        Box(){
            Image(
                painter = painterResource(id = url),
                contentDescription = "Space",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            IconButton(onClick = onDetailsButtonClicked,
                Modifier.align(Alignment.BottomEnd)
                    .testTag(stringResource(id = R.string.details_button))
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
    GameCardCard(R.drawable.nasa01,{})
}

@Preview(showBackground = true)
@Composable
fun GameScreenPreview(){
    GameScreen({},{},uiState = MemorysatorUiState())
}
