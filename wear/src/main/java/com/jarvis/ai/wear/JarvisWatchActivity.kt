package com.jarvis.ai.wear

import android.os.Bundle
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.speech.tts.TextToSpeech
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import java.util.*

class JarvisWatchActivity : ComponentActivity() {
    private lateinit var speechRecognizer: SpeechRecognizer
    private lateinit var textToSpeech: TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize SpeechRecognizer and TextToSpeech
        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this)
        textToSpeech = TextToSpeech(this) { status ->
            if (status == TextToSpeech.SUCCESS) {
                textToSpeech.language = Locale.US
            }
        }

        setContent {
            WearUI()
        }
    }

    // Start listening to voice commands
    private fun startListening() {
        val intent = RecognizerIntent().apply {
            action = RecognizerIntent.ACTION_RECOGNIZE_SPEECH
            putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        }
        speechRecognizer.startListening(intent)
    }

    // Speak a response to the user
    private fun speak(text: String) {
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
    }

    @Composable
    fun WearUI() {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Jarvis AI Life Coach", modifier = Modifier.padding(bottom = 16.dp))
            Button(onClick = { startListening() }) {
                Text(text = "Speak to Jarvis")
            }
            Button(onClick = { speak("Hello! How can I assist you today?") }) {
                Text(text = "Test Speak")
            }
        }
    }
}

@Preview
@Composable
fun WearUIPreview() {
    WearUI()
}
