package edu.ourincheon.ch1_room

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db= Room.databaseBuilder(
                applicationContext,AppDatabase::class.java,"ToDoDB"
        ).allowMainThreadQueries().build()

        db.todoDao().getAll().observe(this, androidx.lifecycle.Observer {

            todo_text.text=it.toString()

        })
        todo_text.text=db.todoDao().getAll().toString()

        todo_add.setOnClickListener{
            db.todoDao().insert(ToDo(todo_edit.text.toString()))
            //todo_text.text=db.todoDao().getAll().toString()
        }
    }
}