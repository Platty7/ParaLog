package ch.timonbissig.paralog.feature_paraloging.presentation.accountScreen.general_settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GeneralSettingsScreen() {
    val languages = listOf("Deutsch", "Englisch")
    var expanded by remember { mutableStateOf(false)}
        Column(modifier = Modifier.fillMaxSize()) {

        }
}

@Preview
@Composable
fun GeneralSettingsPreview() {
    GeneralSettingsScreen()
}