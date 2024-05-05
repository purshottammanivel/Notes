package com.purshottam.notes.notes_home.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.purshottam.notes.notes_home.domain.use_case.NotesHomeUseCase
import com.purshottam.notes.utility.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesHomeViewModel @Inject constructor(
    private val notesHomeUseCase: NotesHomeUseCase
) : ViewModel() {

    private val _notesMutableStateFlow = MutableStateFlow<NotesHomeState>(NotesHomeState())
    val notesStateFlow: StateFlow<NotesHomeState> = _notesMutableStateFlow

    fun getNotes() {
        Log.d("QWERTY", "getNotes: ")
        viewModelScope.launch {

            notesHomeUseCase().onEach {

                when (it) {

                    is Resource.Loading -> {
                        Log.d("QWERTY", "getNotes: Resource.Loading --> ${it.data}")

                        _notesMutableStateFlow.value = NotesHomeState(isLoading = true)
                    }

                    is Resource.Error -> {
                        Log.d("QWERTY", "getNotes: Resource.Error --> ${it.data}")

                        _notesMutableStateFlow.value = NotesHomeState(error = it.message ?: "")
                    }

                    is Resource.Success -> {
                        Log.d("QWERTY", "getNotes: notes Data received --> ${it.data}")
                        _notesMutableStateFlow.value = NotesHomeState(data = it.data)
                    }
                }
            }
        }
    }
}