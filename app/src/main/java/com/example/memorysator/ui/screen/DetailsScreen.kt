package com.example.memorysator.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.memorysator.R

//Todo delete when data is connected
val placeHolderTitle = "Image Title"
val placeHolderDescriptions = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do " +
        "eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, " +
        "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis " +
        "aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla " +
        "pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt " +
        "mollit anim id est laborum."
val placeholderDescriptionImage = "Description"


@Composable
fun DetailsScreen(modifier: Modifier = Modifier ) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = placeHolderTitle,
            Modifier.padding(bottom = dimensionResource(id = R.dimen.medium_vertical_padding))
        )
        DetailsImageCard()
        Text(
            text = placeHolderDescriptions,
            Modifier.padding(horizontal = dimensionResource(id = R.dimen.paragraph_horizontal_padding))
        )
        Spacer(modifier = Modifier.weight(1F))
        Button(
            onClick = { /*TODO*/ },
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
fun DetailsImageCard(modifier: Modifier = Modifier){
    Card (
        Modifier
            .padding(bottom = dimensionResource(id = R.dimen.medium_vertical_padding))
            .padding(horizontal = dimensionResource(id = R.dimen.small_padding)),
        elevation = CardDefaults.cardElevation(defaultElevation = dimensionResource(id = R.dimen.elevation))
    ){
        Image(painter = painterResource(
            id = R.drawable.nasa02),
            contentDescription = placeholderDescriptionImage
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview(){
    DetailsScreen()
}