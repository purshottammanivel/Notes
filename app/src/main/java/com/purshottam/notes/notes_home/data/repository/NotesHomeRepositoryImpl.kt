package com.purshottam.notes.notes_home.data.repository

import com.purshottam.notes.core.db.NoteDao
import com.purshottam.notes.core.db.NoteEntity
import com.purshottam.notes.notes_home.domain.repository.INotesHomeRepository

class NotesHomeRepositoryImpl(
    private val noteDao: NoteDao
): INotesHomeRepository {

    override suspend fun getNotes(): List<NoteEntity> {
        return noteDao.getAllNotes()
    }
}