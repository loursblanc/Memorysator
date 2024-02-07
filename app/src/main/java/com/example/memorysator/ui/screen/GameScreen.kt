package com.example.memorysator.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.memorysator.R
import com.example.memorysator.network.Photo


@Composable
fun GameScreen(onBackToMenuButtonClicked: () -> Unit,
               onDetailsButtonClicked: (Photo) -> Unit,
               uiState: MemorysatorUiState,
               modifier: Modifier = Modifier ) {

    when(uiState.apiState){
        ConnectionState.LOADING -> LoadingScreen()
        ConnectionState.ERROR -> ErrorScreen({})
        ConnectionState.SUCESS -> SucessScreen(
            onBackToMenuButtonClicked,
            onDetailsButtonClicked,
            uiState.photos
        )

    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.loading_img),
        contentDescription = stringResource(R.string.loading)
    )
}

@Composable
fun ErrorScreen(retryAction: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_connection_error), contentDescription = ""
        )
        Text(text = "Loading Fail", modifier = Modifier.padding(16.dp))
        Button(onClick = retryAction) {
            Text("Retry")
        }
    }
}

@Composable
fun SucessScreen(onBackToMenuButtonClicked: () -> Unit,
                 onDetailsButtonClicked: (Photo) -> Unit,
                 photos: List<Photo>,
                 modifier: Modifier = Modifier
) {
    Box(Modifier.fillMaxSize()){
        GameCardGrid(onDetailsButtonClicked,photos)
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
fun GameCardGrid(onDetailsButtonClicked: (Photo) -> Unit, photos: List<Photo>, modifier: Modifier = Modifier){
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
    ){
        items(photos){ Photo ->
            GameCardCard(Photo,onDetailsButtonClicked, modifier.padding(dimensionResource(id = R.dimen.small_padding)))
        }
    }
}

@Composable
fun GameCardCard(photo: Photo, onDetailsButtonClicked: (Photo) -> Unit, modifier: Modifier = Modifier){
    Card(
        modifier
            .clickable {  /*Todo*/ }
            .height(dimensionResource(id = R.dimen.height_card)),
            elevation = CardDefaults.cardElevation(defaultElevation = dimensionResource(id = R.dimen.elevation)),
            shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_card)),
    ){
        Box(){
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(photo.url)
                    .crossfade(true)
                    .build(),
                contentDescription = "Space",
                error = painterResource(R.drawable.ic_broken_image),
                placeholder = painterResource(R.drawable.loading_img),
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            IconButton(onClick = { onDetailsButtonClicked(photo) },
                Modifier
                    .align(Alignment.BottomEnd)
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
    val photo = Photo(
        title = "M2-9: Wings of a Butterfly Nebula",
        url = "https://apod.nasa.gov/apod/image/0206/eclipsebird_staiger.jpg",
        explanation = "Are stars better appreciated for their art after t" +
                " gas frequently forms an impressive display called a planetary nebula that fades gradually over thousand of years. " +
                "M2-9, a butterfly planetary nebula 2100 light-years away shown in representative colors, has wings that tell a strange but incomplete tale. " +
                "In the center, two stars orbit inside a gaseous disk 10 times the orbit of Pluto. The expelled envelope of the dying star breaks out from the disk " +
                "creating the bipolar appearance. Much remains unknown about the physical processes that cause planetary nebulae.",
        mediaType = "image",
        copyright = null
    )
    GameCardCard(photo,{})
}

@Preview(showBackground = true)
@Composable
fun GameScreenPreview(){
    GameScreen({},{},uiState = MemorysatorUiState())
}
