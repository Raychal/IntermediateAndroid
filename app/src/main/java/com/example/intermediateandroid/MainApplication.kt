package com.example.intermediateandroid

import android.app.Application
import com.example.intermediateandroid.database.StudentDatabase

class MyApplication : Application() {
    val database by lazy { StudentDatabase.getDatabase(this) }
    val repository by lazy { StudentRepository(database.studentDao())}
}