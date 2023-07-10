package ch.timonbissig.paralog.feature_paraloging.presentation.mainScreen.component

import LastWindTunnelingSection
import androidx.compose.foundation.Image
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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ch.timonbissig.paralog.R

@Composable
fun WindTunnelSector() {
    Box(modifier = Modifier
        .size(LocalConfiguration.current.screenWidthDp.dp - 6.dp, 200.dp)
        .clip(RoundedCornerShape(12.dp))
        .background(MaterialTheme.colorScheme.tertiary)
    ) {
        Row {
            Column {
                Text(
                    text = "Wind Tunnel",
                    modifier = Modifier.padding(start = 12.dp),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onTertiary
                )
                Row(modifier = Modifier.padding(top = 6.dp)){
                    Icon(
                        imageVector = Icons.Rounded.Air,
                        contentDescription = "Wind",
                        modifier = Modifier.padding(start = 12.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Text(text = "10 Stunden", color = MaterialTheme.colorScheme.onTertiary ,modifier = Modifier.padding(start = 1.dp))

                }
                Spacer(modifier = Modifier.padding(top = 25.dp))
                Row (modifier = Modifier.padding(start = 12.dp)){
                    LastWindTunnelingSection()
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Image(painter = painterResource(id = R.drawable.chart_preview), contentDescription = "Chart", modifier = Modifier
                .padding(end = 12.dp))
        }
    }
}

@Preview
@Composable
fun WindTunnelSectorPreview() {
    WindTunnelSector()
}