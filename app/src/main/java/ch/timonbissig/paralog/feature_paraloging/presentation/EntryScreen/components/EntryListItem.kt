package ch.timonbissig.paralog.feature_paraloging.presentation.EntryScreen.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun EntryListItem(icon: ImageVector, date:Int, title:String, level:String) {
    Card(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()
        .wrapContentHeight(),
    shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondary
        )


    ){
        Row() {
            androidx.compose.material3.Icon(imageVector = icon, contentDescription = "Icons", modifier = Modifier
                .padding(start = 6.dp)
                .size(50.dp)
                .align(CenterVertically))
            Column(Modifier.padding(8.dp)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.onTertiary,
                )
                Text(
                    text = level,
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }

    }
}

@Preview
@Composable
fun EntryListItemPreview() {
    EntryListItem(Icons.Default.Home, 234, "25.066.2023", "Level 1")
}