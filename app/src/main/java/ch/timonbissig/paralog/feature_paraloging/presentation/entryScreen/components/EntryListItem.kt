package ch.timonbissig.paralog.feature_paraloging.presentation.entryScreen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun EntryListItem(icon: ImageVector, date:String, comment: String, function: String, location:String) {
    Card(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()
        .wrapContentHeight(),
    shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondary
        )


    ){
        Row {
            androidx.compose.material3.Icon(imageVector = icon, contentDescription = "Icons", modifier = Modifier
                .padding(start = 6.dp)
                .size(50.dp)
                .align(CenterVertically),
            tint = MaterialTheme.colorScheme.onTertiary)
            Column(Modifier.padding(8.dp)) {
                Row {
                    Text(
                        text = date,
                        style = MaterialTheme.typography.headlineLarge,
                        color = MaterialTheme.colorScheme.onTertiary,
                    )
                    Text(
                        text = function,
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier
                            .align(CenterVertically)
                            .padding(start = 40.dp),
                        color = MaterialTheme.colorScheme.onTertiary
                    )
                }
                Row (verticalAlignment = Alignment.Top){
                    Text(text = location, style = MaterialTheme.typography.bodyMedium,color = MaterialTheme.colorScheme.onTertiary)
                    Spacer(modifier = Modifier.padding(start = 24.dp))
                    Text(text = comment, style = MaterialTheme.typography.bodyMedium,color = MaterialTheme.colorScheme.onTertiary)
                }
            }
        }

    }
}