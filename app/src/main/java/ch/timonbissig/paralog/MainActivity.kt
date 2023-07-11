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
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ch.timonbissig.paralog.feature_paraloging.presentation.accountScreen.SettingsScreen
import ch.timonbissig.paralog.feature_paraloging.presentation.mainScreen.component.JumpSector
import ch.timonbissig.paralog.feature_paraloging.presentation.mainScreen.component.MainScreen
import ch.timonbissig.paralog.feature_paraloging.presentation.mainScreen.component.WindTunnelSector
import ch.timonbissig.paralog.ui.theme.ParaLogTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            ParaLogTheme {
                val navController = rememberNavController()
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
                }, content = {
                        NavGraph(navController = navController)
                    })

            }
        }
    }
}

@Composable
fun NavGraph(navController: NavHostController) {
        NavHost(navController = navController, startDestination = Screens.Home.route) {
            composable(route = Screens.Home.route) {
                MainScreen(navController = navController)
            }
            composable(route = Screens.Account.route) {
                SettingsScreen(navController = navController)
            }
        }
}








