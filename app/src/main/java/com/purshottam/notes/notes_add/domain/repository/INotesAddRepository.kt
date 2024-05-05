package com.purshottam.notes.notes_add.domain.repository

import com.purshottam.notes.core.db.NoteEntity

interface INotesAddRepository {

    suspend fun insertNote(note: NoteEntity)
}