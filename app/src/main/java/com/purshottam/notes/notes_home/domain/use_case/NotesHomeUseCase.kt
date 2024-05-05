package com.purshottam.notes.notes_home.domain.use_case

import android.util.Log
import com.purshottam.notes.notes_home.domain.model.Note
import com.purshottam.notes.notes_home.domain.repository.INotesHomeRepository
import com.purshottam.notes.core.mapper.toDomainNote
import com.purshottam.notes.utility.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class NotesHomeUseCase @Inject constructor(
    private val notesHomeRepository: INotesHomeRepository
) {

    operator fun invoke(): Flow<Resource<List<Note>>> {
        return flow {
            try {

                emit(Resource.Loading())

                val response = notesHomeRepository.getNotes()
                val domainNotes =
                    if (response.isNullOrEmpty()) emptyList<Note>()
                    else response.map { it.toDomainNote() }

                emit(Resource.Success(data = domainNotes))

            } catch (e: IOException) {
                Log.d("QWERTY", "invoke: IOException --> e.localizedMessage ${e.localizedMessage} e.message ${e.message}")
                emit(Resource.Error(message = e.localizedMessage ?: "IOException"))

            } catch (e: Exception) {
                Log.d("QWERTY", "invoke: IOException --> e.localizedMessage ${e.localizedMessage} e.message ${e.message}")
                emit(Resource.Error(message = e.localizedMessage ?: "Exception"))

            }
        }
    }
}