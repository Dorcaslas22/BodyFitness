package com.chidinma.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.chidinma.myapplication.component.BottomNavigation
import com.chidinma.myapplication.component.HomeScreen
import com.chidinma.myapplication.ui.theme.BodyFitnessTheme
import com.chidinma.myapplication.ui.theme.DrawableStringPair

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BodyFitnessTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.secondaryContainer
                ) {
                    BodyFitnessApplicationPortrait()
                }
            }
        }
    }
}

val alignYourBodyData = listOf(
    R.drawable.ab1_inversions to R.string.ab1_inversions,
    R.drawable.ab2_quick_yoga to R.string.ab2_quick_yoga,
    R.drawable.ab3_stretching to R.string.ab3_stretching,
    R.drawable.ab4_tabata to R.string.ab4_tabata,
    R.drawable.ab5_hiit to R.string.ab5_hiit,
    R.drawable.ab6_pre_natal_yoga to R.string.ab6_pre_natal_yoga
).map { DrawableStringPair(it.first, it.second) }

val favoriteCollectionsData = listOf(
    R.drawable.nature_meditations to R.string.fc1_short_mantras,
    R.drawable.fc3_stress_and_anxiety to R.string.fc2_nature_meditations,
    R.drawable.nighty_wind to R.string.fc3_stress_and_anxiety,
    R.drawable.fc4_self_message to R.string.fc4_self_massage,
    R.drawable.short_mantras to R.string.fc5_overwhelmed,
    R.drawable.overwhelmed_1 to R.string.fc6_nightly_wind_down
).map { DrawableStringPair(it.first, it.second) }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BodyFitnessApplicationPortrait() {
    BodyFitnessTheme {
        Scaffold(
            bottomBar =  { BottomNavigation() }
        ) { padding ->
            HomeScreen(Modifier.padding(padding))
        }
    }
}
