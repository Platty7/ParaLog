import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Air
import androidx.compose.material.icons.rounded.CalendarMonth
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun LastWindTunnelingSection(modifier: Modifier = Modifier) {
Box(modifier = Modifier
    .size(120.dp, 80.dp)
    .clip(RoundedCornerShape(12.dp))
    .background(MaterialTheme.colorScheme.secondary)) {
    Column {
        Text(text = "Letzer Windtunnel",
        fontSize = MaterialTheme.typography.labelSmall.fontSize,
        color = MaterialTheme.colorScheme.onTertiary,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(start = 12.dp))
        Spacer(modifier = Modifier.padding(top = 6.dp))
        Row {
            Spacer(modifier = Modifier.padding(start = 6.dp))
            Icon(imageVector = Icons.Rounded.CalendarMonth, contentDescription = "air")
            Text(text = "30.06.2023", fontSize = MaterialTheme.typography.labelSmall.fontSize,
            color = MaterialTheme.colorScheme.onTertiary)
        }
        Row {
            Spacer(modifier = Modifier.padding(start = 6.dp))
            Icon(imageVector = Icons.Rounded.LocationOn, contentDescription = "location")
            Text(text = "Winterthur", fontSize = MaterialTheme.typography.labelSmall.fontSize,
                color = MaterialTheme.colorScheme.onTertiary)
        }
    }
}
}


@Preview
@Composable
fun LastWindTunnelingSectionPreview() {
    LastWindTunnelingSection()
}