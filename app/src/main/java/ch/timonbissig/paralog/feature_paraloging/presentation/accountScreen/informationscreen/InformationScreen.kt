package ch.timonbissig.paralog.feature_paraloging.presentation.accountScreen.informationscreen

import android.app.LocaleConfig
import android.content.pm.PackageManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ch.timonbissig.paralog.R

@Composable
fun InformationScreen(navController: NavController) {
    val manager = LocalContext.current.packageManager
    val info = manager.getPackageInfo(LocalContext.current.packageName, 0)
    val versionName = info.versionName
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.mipmap.ic_launcher_foreground),
            contentDescription = "ParaLog Logo"
        )
        Spacer(modifier = Modifier.padding(top = 8.dp))
        Text(text = versionName, color = Color.White, fontWeight = FontWeight.Bold)
    }
}