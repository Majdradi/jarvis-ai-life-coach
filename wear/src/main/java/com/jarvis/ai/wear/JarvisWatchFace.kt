package com.example.jarviswatchface

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.wear.widget.BoxInsetLayout
import com.google.android.material.composethemeadapter.MdcTheme
import androidx.wear.tiles.material.Text

class JarvisWatchFace : ComponentActivity() {

    private lateinit var watchFacePaint: Paint

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize watch face paint
        watchFacePaint = Paint().apply {
            color = Color.WHITE
            textSize = 50f
            isAntiAlias = true
        }

        setContent {
            MdcTheme {
                BoxInsetLayout {
                    // You can add your UI components like time, notifications, etc., here
                    Text("Jarvis AI Life Coach Watchface")
                }
            }
        }
    }

    // Method to draw the watch face
    fun drawWatchFace(canvas: Canvas) {
        // Draw the watch face elements (e.g., time, health metrics)
        canvas.drawText("Jarvis AI", 100f, 100f, watchFacePaint)
        // You can add more elements like health data, weather, etc., here.
    }
}
