package ch.timonbissig.paralog

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.BarChart
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.List
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screens(var title:String, var icon:ImageVector, var route:String) {

    object Home : Screens("Home", Icons.Rounded.Home, "main_screen")
    object Cockpit : Screens("Cockpit", Icons.Rounded.BarChart, "cockpit_screen")
    object AddEntry : Screens("Entries", Icons.Rounded.List, "entry_screen")
    object Account : Screens("Account", Icons.Rounded.AccountCircle, "account_screen")
}
