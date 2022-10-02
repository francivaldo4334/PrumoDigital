package br.com.francivaldo.prumodigital.view.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import br.com.francivaldo.prumodigital.view.pages.SplashScreenPage
import br.com.francivaldo.prumodigital.view.ui.theme.PrumoDigitalTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            PrumoDigitalTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SplashScreenPage()
                }
            }
        }
        lifecycleScope.launch {
            delay(2000)
            startActivity(Intent(this@SplashScreenActivity,MenuActivity::class.java))
            finish()
        }
    }
}