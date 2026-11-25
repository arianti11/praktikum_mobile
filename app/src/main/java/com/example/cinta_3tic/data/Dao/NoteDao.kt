package com.example.cinta_3tic.data.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.cinta_3tic.data.Entity.NoteEntity


@Dao
interface NoteDao {
    @Query("SELECT * FROM notes ORDER BY createdAt DESC")
    suspend fun getAll(): List<NoteEntity>


    @Insert
    suspend fun insert(note: NoteEntity)


    @Delete
    suspend fun delete(note: NoteEntity)
}