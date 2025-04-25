package com.jarvis.ai

import android.util.Log

class DialogManager {

    private val dialogResponses = mapOf(
        "greetings" to listOf("Hello! How can I assist you today?", "Hi there! What can I help you with?"),
        "fallback" to listOf("Sorry, I didn’t quite catch that.", "Could you please repeat that?")
    )

    fun getResponse(type: String): String {
        return dialogResponses[type]?.random() ?: dialogResponses["fallback"]!!.random()
    }

    fun logConversation(input: String, output: String) {
        Log.d("DialogManager", "User: $input\nAI: $output")
    }
}
