package br.com.francivaldo.prumodigital.view.pages

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.francivaldo.prumodigital.R
import br.com.francivaldo.prumodigital.view.activities.BobActivity

@SuppressLint("UnrememberedMutableState")
@Composable
fun BobPage(){
    val baseSize = LocalConfiguration.current.screenWidthDp/7;
    val context = LocalContext.current as BobActivity
    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column{
            //bob top
            Box(
                modifier = Modifier
                    .height(baseSize.dp)
                    .width((5 * baseSize).dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colors.primary),
                contentAlignment = Alignment.Center
            ){
                Icon(painter = painterResource(id = R.drawable.in_circle), contentDescription = "in_circle", modifier = Modifier
                    .size(baseSize.dp)
                    .padding(8.dp)
                    .offset(x = context.bobModel.x.dp,y= 0.dp)
                )
                Icon(painter = painterResource(id = R.drawable.out_circle_2), contentDescription = "out_circle", modifier = Modifier
                            .rotate(90f)
                            .scale(5f))
            }
            Spacer(modifier = Modifier.size(16.dp))
            //bob center and right
            Row {
                Box(
                    modifier = Modifier
                        .height((5 * baseSize).dp)
                        .width((5 * baseSize).dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colors.primary),
                    contentAlignment = Alignment.Center
                ){
                    Icon(painter = painterResource(id = R.drawable.in_circle), contentDescription = "in_circle", modifier = Modifier
                        .size(baseSize.dp)
                        .padding(8.dp)
                        .offset(x = context.bobModel.x.dp,y = context.bobModel.y.dp)
                    )
                    Icon(painter = painterResource(id = R.drawable.out_circle), contentDescription = "out_circle")
                }
                Spacer(modifier = Modifier.size(16.dp))
                Box(
                    modifier = Modifier
                        .height((5 * baseSize).dp)
                        .width(baseSize.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colors.primary),
                    contentAlignment = Alignment.Center
                ){
                    Icon(painter = painterResource(id = R.drawable.in_circle), contentDescription = "in_circle", modifier = Modifier
                        .size(baseSize.dp)
                        .padding(8.dp)
                        .offset(x = 0.dp,y = context.bobModel.y.dp)
                    )
                    Icon(painter = painterResource(id = R.drawable.out_circle_2), contentDescription = "out_circle")
                }
            }
        }
    }
    Text(context.text_x)
}