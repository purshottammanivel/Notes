package com.purshottam.notes.core.mapper

import com.purshottam.notes.core.db.NoteEntity
import com.purshottam.notes.notes_add.domain.model.Note

fun Note.toDataNoteEntity(): NoteEntity {
    return NoteEntity(
        id          = this.id           ?: 0,
        noteTitle   = this.noteTitle    ?:  "",
        noteDesc    = this.noteDesc     ?:  ""
    )
}