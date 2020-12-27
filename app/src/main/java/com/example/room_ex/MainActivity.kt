package com.example.room_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.room.Room
import com.example.room_ex.model.Todo
import com.example.room_ex.model.TodoDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val db = Room.databaseBuilder(
            applicationContext,
            TodoDatabase::class.java, "database-name"
        ).allowMainThreadQueries()
            .build()

        db.todoDao().getAll().observe(this, Observer {
            text_view.text = it.toString()
        })




        btn_add.setOnClickListener {
            db.todoDao().insert(Todo(0, edit_todo.text.toString()))

        }

    }
}