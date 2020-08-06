package edu.ourincheon.ch1_room

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface ToDoDao {

    @Query("SELECT * FROM ToDo")
    fun getAll(): LiveData<List<ToDo>>

    @Insert
    fun insert(todo: ToDo)

    @Update
    fun upadate(todo: ToDo)

    @Delete
    fun delete(todo:ToDo)

}