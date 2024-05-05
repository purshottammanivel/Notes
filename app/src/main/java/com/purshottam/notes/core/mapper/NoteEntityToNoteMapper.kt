package com.purshottam.notes.core.mapper

import com.purshottam.notes.core.db.NoteEntity
import com.purshottam.notes.notes_home.domain.model.Note

fun NoteEntity.toDomainNote(): Note {
    return Note(
        id          = this.id           ?: 0,
        noteTitle   = this.noteTitle    ?: "",
        noteDesc    = this.noteDesc     ?: ""
    )
}