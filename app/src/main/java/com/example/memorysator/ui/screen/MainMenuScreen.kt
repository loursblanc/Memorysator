package com.example.memorysator.ui.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.memorysator.R
import com.example.memorysator.data.Difficulty

@Composable
fun MainMenuScreen (modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = stringResource(id = R.string.app_title),
            modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.large_vertical_padding))
        )
        Text(text = stringResource(id = R.string.Difficulty_Title))
        Row ( Modifier
            .border(width = 1.dp, color = Color.Gray.copy(0.3F), shape = RoundedCornerShape(12.dp))
            .padding(horizontal = 16.dp, vertical = 8.dp)
        ){

            enumValues<Difficulty>().forEach { difficulty ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.selectableGroup()
                ){
                    RadioButton(selected = true, onClick = { /*TODO*/ })
                    Text(
                        text = stringResource(id = difficulty.id),
                       //modifier = Modifier.padding(top = 2.dp) // Espacement avec le RadioButton
                    )
                }
            }
        }
        Column (Modifier.padding(top = 50.dp)){
            Button(onClick = { /*TODO*/ },Modifier.width(dimensionResource(id = R.dimen.width_button))) {
                Text(text = stringResource(id = R.string.rules_title))
            }
            Button(onClick = { /*TODO*/ }, Modifier.width(dimensionResource(id = R.dimen.width_button))) {
                Text(text = stringResource(id = R.string.start_button))
            }
        }

    }
}



@Preview(showBackground = true)
@Composable
fun MainMenuScreenPreview(){
    MainMenuScreen()
}