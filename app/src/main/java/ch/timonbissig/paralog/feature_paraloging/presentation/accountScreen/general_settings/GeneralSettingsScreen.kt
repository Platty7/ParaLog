package ch.timonbissig.paralog.feature_paraloging.presentation.accountScreen.general_settings

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import java.time.Instant
import java.time.ZoneOffset

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GeneralSettingsScreen(navController: NavController) {
    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = Instant.now().toEpochMilli()
    )
    val selectedDate = datePickerState.selectedDateMillis?.let { 
        Instant.ofEpochMilli(it).atOffset(ZoneOffset.UTC)
    }
    Column {
        DatePicker(state = datePickerState)
    }
}
