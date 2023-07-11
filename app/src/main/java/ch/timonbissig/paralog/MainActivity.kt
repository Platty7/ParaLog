package ch.timonbissig.paralog

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ch.timonbissig.paralog.feature_paraloging.presentation.mainScreen.component.JumpSector
import ch.timonbissig.paralog.feature_paraloging.presentation.mainScreen.component.WindTunnelSector
import ch.timonbissig.paralog.ui.theme.ParaLogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            ParaLogTheme {
                val navController = rememberNavController()
                MainScreen(navController = navController)
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController) {
    val navItems = listOf(Screens.Cockpit, Screens.Home, Screens.AddEntry, Screens.Account)
    val backStackEntry = navController.currentBackStackEntryAsState()
    Scaffold(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background),
    bottomBar = {
        NavigationBar(containerColor = MaterialTheme.colorScheme.primary) {
            navItems.forEach { item ->
                val selected = item.route == backStackEntry.value?.destination?.route

                NavigationBarItem(
                    selected = selected,
                    onClick = { navController.navigate(item.route) },
                    label = {
                        Text(text = item.title, fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.onTertiary)
                    },
                    icon = {
                        Icon(imageVector = item.icon, contentDescription = "${item.title} Icon", tint = MaterialTheme.colorScheme.onTertiary)
                    }
                )
            }
        }
    })
        {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Column {
                Spacer(modifier = Modifier.padding(top = 6.dp))
                Text(
                    text = "Hallo",
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                    modifier = Modifier.padding(start = 6.dp)
                )
                Text(
                    text = "Max Mustermann",
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                    modifier = Modifier.padding(start = 6.dp)
                )
                Spacer(Modifier.padding(top = 24.dp))
                JumpSector()
                Spacer(modifier = Modifier.padding(top = 24.dp))
                WindTunnelSector()
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    val navController = rememberNavController()
    MainScreen(navController = navController)
}





