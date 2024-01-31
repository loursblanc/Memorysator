package com.example.memorysator.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.ui.res.stringResource

import androidx.compose.ui.tooling.preview.Preview
import com.example.memorysator.R

@Composable
fun RulesScreen(modifier: Modifier = Modifier ) {
    Column {
        Text(text = stringResource(id = R.string.rules_title))
        Text(text = stringResource(id = R.string.rules))
        Row {
            Button(onClick ={ /*Todo*/ }){
                Text(text = stringResource(id = R.string.return_main_menu_button))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RulesScreenPreview(){
    RulesScreen()
}