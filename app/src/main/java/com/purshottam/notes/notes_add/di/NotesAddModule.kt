package com.purshottam.notes.notes_add.di

import com.purshottam.notes.core.db.NoteDao
import com.purshottam.notes.notes_add.data.repository.NotesAddRepositoryImpl
import com.purshottam.notes.notes_add.domain.repository.INotesAddRepository
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NotesAddModule {

    fun provideINotesAddRepository(noteDao: NoteDao): INotesAddRepository {
        return NotesAddRepositoryImpl(noteDao)
    }
}