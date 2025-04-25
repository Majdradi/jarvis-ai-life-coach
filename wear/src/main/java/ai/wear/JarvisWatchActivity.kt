package com.jarvis.ai.wear

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.jarvis.ai.theme.JarvisAITheme
import com.jarvis.ai.wear.ui.JarvisWatchUI

class JarvisWatchActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JarvisAITheme {
                JarvisWatchUI()
            }
        }
    }
}
