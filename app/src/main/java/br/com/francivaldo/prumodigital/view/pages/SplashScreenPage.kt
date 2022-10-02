package br.com.francivaldo.prumodigital.view.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import br.com.francivaldo.prumodigital.R

@Composable
fun SplashScreenPage(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ){
        Icon(painter = painterResource(id = R.drawable.ic_logo_fcr), contentDescription = "logo",modifier = Modifier.align(Alignment.Center))
    }
}