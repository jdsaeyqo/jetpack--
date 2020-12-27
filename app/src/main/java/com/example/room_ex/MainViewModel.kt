package com.example.room_ex

import android.app.Application
import androidx.lifecycle.*
import androidx.room.Room
import com.example.room_ex.model.Todo
import com.example.room_ex.model.TodoDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    class Factory(val application: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainViewModel(application) as T
        }
    }

    private val db = Room.databaseBuilder(
        application,
        TodoDatabase::class.java, "database-name"
    ).allowMainThreadQueries()
        .build()

    var todos: LiveData<List<Todo>>

    var newTodo : String? = null

    init {
        todos = getAll()
    }


    fun getAll(): LiveData<List<Todo>> {
        return db.todoDao().getAll()
    }

    fun insert(todo: String) {
        viewModelScope.launch(Dispatchers.IO) {
            db.todoDao().insert(Todo(0,todo))
        }

    }
}