package ch.timonbissig.paralog.feature_paraloging.presentation.entryScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ch.timonbissig.paralog.feature_paraloging.presentation.entryScreen.components.EntryListItem

@Composable
fun EntryScreen(navController: NavController, entryList: List<FakeData>) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
        Column(modifier = Modifier.padding(start = 14.dp)) {
            Spacer(modifier = Modifier.padding(top = 12.dp))
            Text(text = "Deine", fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.headlineLarge.fontSize)
            Text(
                text = "Einträge",
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.headlineLarge.fontSize,
            )
            Spacer(modifier = Modifier.padding(top = 24.dp))
            LazyColumn(modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
            ) {
                items(entryList) {entry ->
                    EntryListItem(
                        icon = entry.icon,
                        date = entry.date,
                        comment = entry.comment,
                        function = entry.function,
                        location = entry.location
                    )
                }
            }
        }
    }
}
data class FakeData(
    val icon : ImageVector,
    val date : String,
    val comment : String,
    val function : String,
    val location : String

)