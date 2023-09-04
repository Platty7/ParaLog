package ch.timonbissig.paralog.feature_paraloging.presentation.accountScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ch.timonbissig.paralog.Screens

@Composable
fun SettingsScreen(navController: NavController) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.padding(top = 60.dp))
        Box(modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.secondary)
            .size(100.dp)) {
            Icon(imageVector = Icons.Rounded.Person, contentDescription = "ProfilePicture", modifier = Modifier.align(
                Alignment.Center)
                .size(80.dp))
        }
        Spacer(modifier = Modifier
            .padding(top = 24.dp))
        Text(text = "Max Mustermann", fontSize = MaterialTheme.typography.headlineMedium.fontSize ,color = MaterialTheme.colorScheme.onTertiary, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.padding(top = 42.dp))
        Box(modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.secondary)
            .height(50.dp)
            .fillMaxWidth(0.5f),
            contentAlignment = Alignment.Center){
            Row (){
                Icon(imageVector = Icons.Rounded.Person, contentDescription = "Person")
                Spacer(modifier = Modifier.padding(start = 12.dp))
                Text(text = "Account")
            }
        }
        Spacer(modifier = Modifier.padding(top = 24.dp))
        Box(modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.secondary)
            .height(50.dp)
            .fillMaxWidth(0.5f)
            .clickable {
                navController.navigate(Screens.GeneralSettings.route)
            },
        contentAlignment = Center){
            Row (){
                Icon(imageVector = Icons.Rounded.Settings, contentDescription = "Person")
                Spacer(modifier = Modifier.padding(start = 12.dp))
                Text(text = "Einstellungen")
            }
        }
        Spacer(modifier = Modifier.padding(top = 24.dp))
        Box(modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .height(50.dp)
            .background(MaterialTheme.colorScheme.secondary)
            .fillMaxWidth(0.5f)
            .clickable {
                navController.navigate(Screens.Information.route)
            },
            contentAlignment = Center
        ){
            Row (
            ){
                Icon(imageVector = Icons.Rounded.Info, contentDescription = "Person")
                Spacer(modifier = Modifier.padding(start = 12.dp))
                Text(text = "Informationen")
            }
        }
    }
}

@Preview
@Composable
fun SettingsScreenPreview() {
    val navController = rememberNavController()
    SettingsScreen(navController)
}