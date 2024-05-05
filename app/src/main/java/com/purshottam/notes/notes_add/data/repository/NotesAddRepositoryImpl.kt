package com.purshottam.notes.notes_add.data.repository

import com.purshottam.notes.notes_add.domain.repository.INotesAddRepository
import com.purshottam.notes.core.db.NoteDao
import com.purshottam.notes.core.db.NoteEntity

class NotesAddRepositoryImpl(
    private val noteDao: NoteDao
) : INotesAddRepository {

    override suspend fun insertNote(note: NoteEntity) {
        noteDao.insertNote(note)
    }
}