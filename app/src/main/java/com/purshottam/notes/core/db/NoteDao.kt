package com.purshottam.notes.core.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.purshottam.notes.notes_home.domain.model.Note

@Dao
interface NoteDao {

    @Insert
    suspend fun insertNote(note: NoteEntity)

    @Query("SELECT * FROM NoteEntity")
    suspend fun getAllNotes(): List<NoteEntity>
}