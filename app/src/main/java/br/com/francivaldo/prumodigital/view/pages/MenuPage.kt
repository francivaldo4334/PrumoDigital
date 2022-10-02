package br.com.francivaldo.prumodigital.view.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import br.com.francivaldo.prumodigital.R
import br.com.francivaldo.prumodigital.view.activities.MenuActivity

@Composable
fun MenuPage() {
    val context = LocalContext.current as MenuActivity
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //inform social
        Column {
            Row(verticalAlignment = Alignment.CenterVertically){
                Icon(painter = painterResource(id = R.drawable.ic_instagram), contentDescription = "admob", tint = MaterialTheme.colors.onBackground, modifier = Modifier.padding(8.dp))
                Text(text = stringResource(R.string.instagram_inform))
            }
            Row(verticalAlignment = Alignment.CenterVertically){
                Icon(painter = painterResource(id = R.drawable.ic_email), contentDescription = "admob", tint = MaterialTheme.colors.onBackground, modifier = Modifier.padding(8.dp))
                Text(text = stringResource(R.string.email_inform))
            }
        }
        //buttons
        Column(
            modifier = Modifier.padding(32.dp)
        ) {
            Button(
                onClick = { context.onBobActivity() },
                modifier = Modifier.fillMaxWidth().height(52.dp)
            ) {
                Text(text = stringResource(R.string.start))
            }
            Spacer(modifier = Modifier.size(16.dp))
            Row(
              modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { context.onAdmob() },
                    modifier = Modifier.weight(1f).height(52.dp)
                ) {
                    Icon(painter = painterResource(id = R.drawable.ic_admob), contentDescription = "admob", tint = MaterialTheme.colors.onBackground)
                }
                Spacer(modifier = Modifier.size(16.dp))
                Button(
                    onClick = { context.onShareApp() },
                    modifier = Modifier.weight(1f).height(52.dp)
                ) {
                    Icon(painter = painterResource(id = R.drawable.ic_share), contentDescription = "share app", tint = MaterialTheme.colors.onBackground)
                }
            }
            Spacer(modifier = Modifier.size(16.dp))
            Button(
                onClick = { context.onDeveloperInform() },
                modifier = Modifier.fillMaxWidth().height(52.dp)
            ) {
                Text(text = stringResource(R.string.developer))
            }
        }
        //Private policy
        Text(text = stringResource(R.string.private_policy),modifier = Modifier.clickable { context.onPrivecyPolicy() })

    }
}