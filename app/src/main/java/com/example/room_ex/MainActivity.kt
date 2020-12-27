package com.example.room_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.room_ex.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        //라이브 데이터 활용하기 위해 설정
        binding.lifecycleOwner = this


        val mainViewModel = ViewModelProvider(this,MainViewModel.Factory(application)).get(MainViewModel::class.java)


        binding.viewModel = mainViewModel


//        mainViewModel.getAll().observe(this, Observer {
//            text_view.text = it.toString()
//        })


//        btn_add.setOnClickListener {
//            lifecycleScope.launch(Dispatchers.IO) {
//                mainViewModel.insert(edit_todo.text.toString())
//            }
//        }

    }
}