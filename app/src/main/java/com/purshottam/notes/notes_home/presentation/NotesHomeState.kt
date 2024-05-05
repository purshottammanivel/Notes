package com.purshottam.notes.notes_home.presentation

import com.purshottam.notes.notes_home.domain.model.Note

data class NotesHomeState(
    val data: List<Note>? = null,
    val error: String? = "",
    val isLoading: Boolean = false
)