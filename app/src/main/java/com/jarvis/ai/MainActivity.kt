package com.jarvis.ai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.jarvis.ai.data.AppDatabase
import com.jarvis.ai.data.Conversation
import com.jarvis.ai.ui.ConversationScreen
import com.jarvis.ai.viewmodel.JarvisViewModel
import com.jarvis.ai.viewmodel.JarvisViewModelFactory
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private lateinit var database: AppDatabase
    private val viewModel: JarvisViewModel by viewModels {
        JarvisViewModelFactory(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize Room database
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "jarvis-db"
        ).build()

        // Load dialog JSON into ViewModel
        lifecycleScope.launch {
            viewModel.loadDialogCatalogue(assets.open("dialog_catalogue.json"))
            val history = database.conversationDao().getAllConversations()
            viewModel.setHistory(history)
        }

        setContent {
            ConversationScreen(
                viewModel = viewModel,
                onSendMessage = { message ->
                    val reply = viewModel.generateReply(message)
                    lifecycleScope.launch {
                        val conversation = Conversation(
                            userInput = message,
                            jarvisReply = reply
                        )
                        database.conversationDao().insertConversation(conversation)
                        viewModel.appendConversation(conversation)
                    }
                }
            )
        }
    }
}
