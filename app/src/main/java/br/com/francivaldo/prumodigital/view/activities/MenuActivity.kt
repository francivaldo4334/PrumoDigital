package br.com.francivaldo.prumodigital.view.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import br.com.francivaldo.prumodigital.view.pages.MenuPage
import br.com.francivaldo.prumodigital.view.ui.theme.PrumoDigitalTheme

class MenuActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrumoDigitalTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MenuPage()
                }
            }
        }
    }
    fun onBobActivity(){
        startActivity(Intent(this,BobActivity::class.java))
    }
    fun onAdmob(){

    }
    fun onShareApp(){

    }
    fun onDeveloperInform(){

    }
    fun onPrivecyPolicy(){

    }
}