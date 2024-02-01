package com.example.memorysator.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button

import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.memorysator.R


val mockupIdPhotosList = listOf<Int>(R.drawable.nasa01, R.drawable.nasa02, R.drawable.nasa03,
    R.drawable.nasa04, R.drawable.nasa05, R.drawable.nasa02)

@Composable
fun GameScreen(modifier: Modifier = Modifier ) {
    Column (
        verticalArrangement =  Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GameCardGrid()
        Spacer(modifier = Modifier.weight(1F))
        Button(
            onClick = { /*TODO*/ },
            Modifier
               .padding(vertical = dimensionResource(id = R.dimen.large_vertical_padding))
                .width(dimensionResource(id = R.dimen.width_button))
        ) {
            Text(
                text = stringResource(id = R.string.return_main_menu_button),
            )
        }
    }
}

@Composable
fun GameCardGrid(){
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        Modifier.padding(dimensionResource(id = R.dimen.medium_vertical_padding))
    ){
        items(mockupIdPhotosList){ idPhoto ->
            GameCardCard(idPhoto, Modifier.padding(4.dp))
        }
    }
}

@Composable
fun GameCardCard(photoId: Int, modifier: Modifier = Modifier){
    Card(modifier.clickable{  /*Todo*/ }){
        Image(painter = painterResource(id = photoId), contentDescription = "Space")
    }
}

@Preview(showBackground = true)
@Composable
fun GameCardCardPreview(){
    GameCardCard(mockupIdPhotosList[0])
}

@Preview(showBackground = true)
@Composable
fun GameScreenPreview(){
    GameScreen()
}
