package com.example.memorysator.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.memorysator.R
import com.example.memorysator.data.model.Photo




@Composable
fun DetailsScreen(onBackToMenuButtonClicked: () -> Unit, photo: Photo, modifier: Modifier = Modifier ) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.verticalScroll(rememberScrollState())
    ) {
        Text(
            text = photo.title,
            Modifier.padding(bottom = dimensionResource(id = R.dimen.medium_vertical_padding))
        )
        DetailsImageCard(photo.url)
        Text(
            text = photo.explanation,
            Modifier.padding(horizontal = dimensionResource(id = R.dimen.paragraph_horizontal_padding))
        )
        Spacer(modifier = Modifier.weight(1F))
        Button(
            onClick = onBackToMenuButtonClicked,
            Modifier
                .padding(vertical = dimensionResource(id = R.dimen.large_vertical_padding),)

                .width(dimensionResource(id = R.dimen.width_button))
        ) {
            Text(
                text = stringResource(id = R.string.return_game_button)
            )
        }
    }
}

@Composable
fun DetailsImageCard(photoUrl: String,modifier: Modifier = Modifier){
    Card (
        Modifier
            .padding(bottom = dimensionResource(id = R.dimen.medium_vertical_padding))
            .padding(horizontal = dimensionResource(id = R.dimen.small_padding)),
        elevation = CardDefaults.cardElevation(defaultElevation = dimensionResource(id = R.dimen.elevation))
    ){
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(photoUrl)
                .crossfade(true)
                .build(),
            contentDescription = "Space",
            error = painterResource(R.drawable.ic_broken_image),
            placeholder = painterResource(R.drawable.loading_img),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview(){
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
    DetailsScreen({},photo)
}