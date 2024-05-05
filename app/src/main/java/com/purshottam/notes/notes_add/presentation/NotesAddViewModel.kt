package com.purshottam.notes.notes_add.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.purshottam.notes.notes_add.domain.model.Note
import com.purshottam.notes.notes_add.domain.use_case.NotesAddUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class NotesAddViewModel @Inject constructor(
    private val notesAddUseCase: NotesAddUseCase
) : ViewModel() {

    private val _notesAddMutableStateFlow = MutableStateFlow<NotesAddState>(NotesAddState())
    val notesAddStateFlow: StateFlow<NotesAddState> = _notesAddMutableStateFlow

    fun insertNote(note: Note) {
        viewModelScope.launch {
            notesAddUseCase(note)
        }
    }
}