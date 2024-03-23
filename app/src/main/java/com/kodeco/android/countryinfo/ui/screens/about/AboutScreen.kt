package com.kodeco.android.countryinfo.ui.screens.about

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AboutScreen(
    onNavigateUp: () -> Unit,
    ) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "About")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        onNavigateUp()
                    }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                        )
                    }
                }
            )
        },
    ){ paddingValues ->
        Text(
            modifier = Modifier.padding(paddingValues),
            text = "About this screen"
        )
    }
}