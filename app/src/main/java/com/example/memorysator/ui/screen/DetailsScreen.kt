package com.example.memorysator.ui.screen

import android.telecom.Call.Details
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    Column () {
        Text(text = placeHolderTitle)
        DetailsImageCard()
        Text(text = placeHolderDescriptions)
        Button(onClick = { /*TODO*/ }) {
            Text(text = stringResource(id = R.string.return_game_button))
        }
    }
}

@Composable
fun DetailsImageCard(modifier: Modifier = Modifier){
    Card {
        Image(painter = painterResource(id = R.drawable.nasa03), contentDescription = placeholderDescriptionImage )
    }

}

@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview(){
    DetailsScreen()
}