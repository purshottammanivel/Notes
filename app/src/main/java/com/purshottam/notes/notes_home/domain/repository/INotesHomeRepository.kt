package com.purshottam.notes.notes_home.domain.repository

import com.purshottam.notes.core.db.NoteEntity

interface INotesHomeRepository {

    suspend fun getNotes(): List<NoteEntity>
}