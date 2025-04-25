package com.jarvis.ai.wear

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jarvis.ai.ui.theme.JarvisAITheme
import androidx.wear.compose.material.*
import androidx.compose.material3.Text
import com.google.android.gms.wearable.DataClient
import com.google.android.gms.wearable.DataMap
import com.google.android.gms.wearable.DataMapItem
import com.google.android.gms.wearable.Wearable
import kotlinx.coroutines.tasks.await

class JarvisWatchActivity : ComponentActivity() {

    private lateinit var dataClient: DataClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JarvisAITheme {
                // Setting up the UI for the Jarvis watch face/activity
                WatchFaceUI()
            }
        }

        // Initialize DataClient to interact with Wearable API for fetching data
        dataClient = Wearable.getDataClient(this)
    }

    @Composable
    fun WatchFaceUI() {
        // Main content for the watch UI layout
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentHeight(Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Jarvis AI Life Coach",
                    style = MaterialTheme.typography.h5,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Health Data: ${fetchHealthData()}",
                    style = MaterialTheme.typography.body1,
                    color = Color.Green
                )
            }
        }
    }

    // Function to simulate fetching health data or any necessary data for the watch activity
    private suspend fun fetchHealthData(): String {
        try {
            // Fetch health data from the wearable device
            val dataItem = dataClient.getDataItems(android.net.Uri.parse("wearable://path/to/data")).await()
            if (dataItem.isNotEmpty()) {
                val dataMapItem = DataMapItem.fromDataItem(dataItem[0])
                val dataMap: DataMap = dataMapItem.dataMap
                val heartRate = dataMap.getString("heart_rate") ?: "No data"
                return heartRate
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return "Fetching data failed"
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JarvisAITheme {
        WatchFaceUI()
    }
}
