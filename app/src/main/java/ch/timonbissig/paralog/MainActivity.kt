package ch.timonbissig.paralog

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Air
import androidx.compose.material.icons.rounded.Paragliding
import androidx.compose.material.icons.rounded.Save
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ch.timonbissig.paralog.Screens.Account.icon
import ch.timonbissig.paralog.feature_paraloging.presentation.accountScreen.SettingsScreen
import ch.timonbissig.paralog.feature_paraloging.presentation.accountScreen.general_settings.GeneralSettingsScreen
import ch.timonbissig.paralog.feature_paraloging.presentation.accountScreen.informationscreen.InformationScreen
import ch.timonbissig.paralog.feature_paraloging.presentation.addEntryScreen.AddSkyDiveEntryScreen
import ch.timonbissig.paralog.feature_paraloging.presentation.cockpitScreen.CockpitScreen
import ch.timonbissig.paralog.feature_paraloging.presentation.entryScreen.EntryScreen
import ch.timonbissig.paralog.feature_paraloging.presentation.entryScreen.FakeData
import ch.timonbissig.paralog.feature_paraloging.presentation.mainScreen.MainScreen
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
                val navItems = listOf(Screens.Cockpit, Screens.Home, Screens.Entries, Screens.Account)
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
                },
                    floatingActionButton = {
                        val currentPage = backStackEntry.value?.destination?.route
                        if (currentPage == Screens.AddSkyDiveEntry.route){
                            ExtendedFloatingActionButton(onClick = { "navController.navigate(Screens.AddSkyDiveEntry.route)" }, icon = { Icon(
                                imageVector = Icons.Rounded.Save,
                                contentDescription = "Save"
                            )}, text = { Text(text = "Speichern")},
                                containerColor = MaterialTheme.colorScheme.primary)
                        }
                        else{
                               FloatingActionButton(onClick = { navController.navigate(Screens.AddSkyDiveEntry.route) }, containerColor = MaterialTheme.colorScheme.primary) {
                              Icon(imageVector = Icons.Rounded.Add, contentDescription = "Add Entry")
                          }
                        }


                    },
                    floatingActionButtonPosition = FabPosition.End,
                    content = {
                        NavGraph(navController = navController)
                    })

            }
        }
    }
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun NavGraph(navController: NavHostController) {
    val items = listOf(
        FakeData(Icons.Rounded.Paragliding, "26.06.2023", "Lvel 1", "AFF", "Beromünster"),
        FakeData(Icons.Rounded.Air, "26.05.2023", "", "AFF", "Zürich"),
        FakeData(Icons.Rounded.Paragliding, "26.06.2023", "Lvel 1", "AFF", "Beromünster"),
        FakeData(Icons.Rounded.Paragliding, "26.06.2023", "Lvel 1", "AFF", "Beromünster"),
        FakeData(Icons.Rounded.Paragliding, "26.06.2023", "Lvel 1", "AFF", "Beromünster"),
        FakeData(Icons.Rounded.Paragliding, "26.06.2023", "Lvel 1", "AFF", "Beromünster"),
        FakeData(Icons.Rounded.Paragliding, "26.06.2023", "Lvel 1", "AFF", "Beromünster"),
        FakeData(Icons.Rounded.Paragliding, "26.06.2023", "Lvel 1", "AFF", "Beromünster"),
        FakeData(Icons.Rounded.Paragliding, "26.06.2023", "Lvel 1", "AFF", "Beromünster"),
    )
        NavHost(navController = navController, startDestination = Screens.Home.route) {
            composable(route = Screens.Home.route) {
                MainScreen(navController = navController)
            }
            composable(route = Screens.Account.route) {
                SettingsScreen(navController = navController)
            }
            composable(route = Screens.Cockpit.route) {
                CockpitScreen(navController = navController)
            }
            composable(route = Screens.Entries.route) {
                EntryScreen(navController = navController, entryList = items)
            }
            composable(route = Screens.Information.route) {
                InformationScreen(navController = navController)
            }
            composable(route = Screens.AddSkyDiveEntry.route) {
                AddSkyDiveEntryScreen(navController = navController)
            }
            composable(route = Screens.GeneralSettings.route) {
                GeneralSettingsScreen(navController = navController)
            }
        }
}










