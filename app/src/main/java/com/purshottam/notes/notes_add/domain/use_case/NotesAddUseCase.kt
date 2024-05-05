package com.purshottam.notes.notes_add.domain.use_case

import android.util.Log
import com.purshottam.notes.core.mapper.toDataNoteEntity
import com.purshottam.notes.notes_add.domain.model.Note
import com.purshottam.notes.notes_add.domain.repository.INotesAddRepository
import java.io.IOException
import javax.inject.Inject

class NotesAddUseCase @Inject constructor(
    private val notesAddRepository: INotesAddRepository
) {

    suspend operator fun invoke(note: Note) {
        try {
            val note = note.toDataNoteEntity()
            notesAddRepository.insertNote(note)
        } catch (e: IOException) {
            Log.d("QWERTY", "invoke: IOException --> e.localizedMessage ${e.localizedMessage} e.message ${e.message}")

        } catch (e: Exception) {
            Log.d("QWERTY", "invoke: IOException --> e.localizedMessage ${e.localizedMessage} e.message ${e.message}")
        }
    }
}