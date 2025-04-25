package com.jarvis.ai.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ConversationDao {

    @Insert
    suspend fun insert(conversation: ConversationEntity)

    @Query("SELECT * FROM conversation_table")
    suspend fun getAllConversations(): List<ConversationEntity>
}
