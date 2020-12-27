package com.example.room_ex.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
    @PrimaryKey(autoGenerate = true) var id: Int,
    @ColumnInfo(name = "title") val title: String

)