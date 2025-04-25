package com.jarvis.ai.wear

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color as ComposeColor
import androidx.compose.ui.tooling.preview.Preview
import com.jarvis.ai.ui.theme.JarvisAITheme
import androidx.wear.widget.WearableLinearLayoutManager
import androidx.wear.widget.WearableRecyclerView
import androidx.wear.widget.WearableRecyclerViewAdapter
import androidx.wear.widget.WearableRecyclerView.LayoutManager

class JarvisWatchFace : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JarvisAITheme {
                Box(modifier = Modifier.fillMaxSize()) {
                    Text(
                        text = "Jarvis AI",
                        color = ComposeColor.White,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
    }

    // This method renders the watch face
    private fun drawWatchFace(canvas: Canvas, width: Int, height: Int) {
        val paint = Paint().apply {
            color = Color.WHITE
            textSize = 60f
            textAlign = Paint.Align.CENTER
        }

        // Get the center of the canvas
        val centerX = width / 2
        val centerY = height / 2

        // Draw the time or any text in the center of the watch face
        val time = "12:30" // For now, we are hardcoding time. You can replace this with dynamic time.
        canvas.drawText(time, centerX.toFloat(), centerY.toFloat(), paint)
    }
    
    @Preview
    @Composable
    fun JarvisWatchFacePreview() {
        JarvisAITheme {
            Box(modifier = Modifier.fillMaxSize()) {
                Text(
                    text = "Jarvis AI Watchface",
                    color = ComposeColor.White,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}
