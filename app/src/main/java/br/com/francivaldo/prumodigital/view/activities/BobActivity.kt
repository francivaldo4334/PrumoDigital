package br.com.francivaldo.prumodigital.view.activities

import android.annotation.SuppressLint
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import br.com.francivaldo.prumodigital.domain.model.BobModel
import br.com.francivaldo.prumodigital.view.pages.BobPage
import br.com.francivaldo.prumodigital.view.ui.theme.PrumoDigitalTheme

class BobActivity : ComponentActivity(){
    var bobModel = BobModel()
    var text_x by mutableStateOf("")

    private lateinit var sensorManager:SensorManager
    private lateinit var sensor:Sensor

    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            val baseSize = LocalConfiguration.current.screenWidthDp/7;
            bobModel.setBaseSize(baseSize)
            PrumoDigitalTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ){
                    BobPage()
                }
            }
        }

        //giroscopio
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY)
    }
    val gyroListener = object : SensorEventListener {
        override fun onSensorChanged(event: SensorEvent?) {
            event?.let {
                if(it.sensor.type == Sensor.TYPE_GRAVITY) {
                    var x = it.values[0]/it.sensor.maximumRange
                    var y = (it.values[1]/it.sensor.maximumRange)*-1
                    bobModel.updateX(x)
                    bobModel.updateY(y)
                    text_x = "x = ${x}\ny = ${y}"//\n : ${it.sensor.maximumRange} :"
                }
            }
        }

        override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
            return
        }
    }

    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(gyroListener,sensor,SensorManager.SENSOR_DELAY_UI)
    }

    override fun onStop() {
        super.onStop()
        sensorManager.unregisterListener(gyroListener)
    }
}