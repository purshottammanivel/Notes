package com.purshottam.notes.notes_home.di

import com.purshottam.notes.core.db.NoteDao
import com.purshottam.notes.notes_home.data.repository.NotesHomeRepositoryImpl
import com.purshottam.notes.notes_home.domain.repository.INotesHomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NotesHomeModule {

    @Provides
    fun provideINotesHomeRepository(noteDao: NoteDao): INotesHomeRepository {
        return NotesHomeRepositoryImpl(noteDao)
    }
}