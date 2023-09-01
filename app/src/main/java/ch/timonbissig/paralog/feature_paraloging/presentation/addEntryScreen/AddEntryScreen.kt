package ch.timonbissig.paralog.feature_paraloging.presentation.addEntryScreen

import android.widget.DatePicker
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccessTime
import androidx.compose.material.icons.rounded.Adjust
import androidx.compose.material.icons.rounded.AirplanemodeActive
import androidx.compose.material.icons.rounded.CalendarMonth
import androidx.compose.material.icons.rounded.Height
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.OpenInFull
import androidx.compose.material.icons.rounded.Paragliding
import androidx.compose.material.icons.rounded.Timer
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ch.timonbissig.paralog.Screens
import java.time.Instant

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddSkyDiveEntryScreen(navController: NavController) {
    var filledLocationText by remember{
        mutableStateOf("")
    }
    var filledAirplaneText by remember{
        mutableStateOf("")
    }
    var filledJumpHeight by remember{
        mutableStateOf("")
    }
    var filledOpeningHeighttText by remember{
        mutableStateOf("")
    }
    var filledFreeFlyTimetText by remember{
        mutableStateOf("")
    }
    var filledParachuteTimeText by remember{
        mutableStateOf("")
    }
    var filledTargetDistanceText by remember {
        mutableStateOf("")
    }



    Column (
        Modifier
            .fillMaxSize()
            .padding(24.dp)){
        Row(){
            Row (){
                Icon(imageVector = Icons.Rounded.CalendarMonth, contentDescription = "Date", tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(50.dp))
                Text(text = "23.06.2023", fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onTertiary, fontSize = MaterialTheme.typography.headlineLarge.fontSize, textAlign = TextAlign.Center)
            }
            Spacer(modifier = Modifier.padding(start = 48.dp))
            Icon(imageVector = Icons.Rounded.Paragliding, contentDescription = "Parachute", tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(70.dp))
        }
        Row (){
            Icon(imageVector = Icons.Rounded.AccessTime, contentDescription = "Date", tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(50.dp))
            Text(text = "10:45", fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onTertiary, fontSize = MaterialTheme.typography.headlineLarge.fontSize, textAlign = TextAlign.Center)
        }
        Spacer(modifier = Modifier.padding(top = 24.dp))
            TextField(modifier = Modifier.fillMaxWidth(),value = filledLocationText, onValueChange = {filledLocationText = it}, leadingIcon = {
                Icon(imageVector = Icons.Rounded.LocationOn, contentDescription = "Locaion")
            }, label = {
                Text(text = "Standort")
            })
        Spacer(modifier = Modifier.padding(bottom = 12.dp))
        TextField(modifier = Modifier.fillMaxWidth(),value = filledAirplaneText, onValueChange = {filledAirplaneText = it}, leadingIcon = {
            Icon(imageVector = Icons.Rounded.AirplanemodeActive, contentDescription = "Locaion")
        }, label = {
            Text(text = "Flugzeug")
        })
        Spacer(modifier = Modifier.padding(top = 12.dp))
        Divider(color = MaterialTheme.colorScheme.primary)
        Spacer(modifier = Modifier.padding(bottom = 12.dp))
        TextField(modifier = Modifier.fillMaxWidth(), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),value = filledJumpHeight, onValueChange = {filledJumpHeight = it}, leadingIcon = {
            Icon(imageVector = Icons.Rounded.Height, contentDescription = "Locaion")
        }, label = {
            Text(text = "Absprung Höhe (m)")
        })
        Spacer(modifier = Modifier.padding(bottom = 12.dp))
        TextField(modifier = Modifier.fillMaxWidth(),value = filledOpeningHeighttText,keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), onValueChange = {filledOpeningHeighttText = it}, leadingIcon = {
            Icon(imageVector = Icons.Rounded.OpenInFull, contentDescription = "Locaion")
        }, label = {
            Text(text = "Öffnungs Höhe (m)")
        })
        Spacer(modifier = Modifier.padding(bottom = 12.dp))
        TextField(modifier = Modifier.fillMaxWidth(),value = filledFreeFlyTimetText,keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), onValueChange = {filledFreeFlyTimetText = it}, leadingIcon = {
            Icon(imageVector = Icons.Rounded.Timer, contentDescription = "Locaion")
        }, label = {
            Text(text = "Freifallzeit (s)")
        })
        Spacer(modifier = Modifier.padding(bottom = 12.dp))
        TextField(modifier = Modifier.fillMaxWidth(),value = filledParachuteTimeText,keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), onValueChange = {filledParachuteTimeText = it}, leadingIcon = {
            Icon(imageVector = Icons.Rounded.Timer, contentDescription = "Locaion")
        }, label = {
            Text(text = "Schirmzeit (s)")
        })
        Spacer(modifier = Modifier.padding(bottom = 12.dp))
        TextField(modifier = Modifier.fillMaxWidth(),value = filledTargetDistanceText,keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), onValueChange = {filledTargetDistanceText = it}, leadingIcon = {
            Icon(imageVector = Icons.Rounded.Adjust, contentDescription = "Locaion")
        }, label = {
            Text(text = "Entfernung zum Ziel (m)")
        })

    }
}