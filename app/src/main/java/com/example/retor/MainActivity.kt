package com.example.retor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.retor.database.User
import com.example.retor.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val instancia : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var cont=0
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnUs.setOnClickListener {

            instancia.saveUser(
                User(
                0,
                user_name = binding.etUser.text.toString()+"",
            )
            )
            // cont++
            Log.d("prueba", "datos del edit")
            updateList()
        }

    }
    fun updateList(){
        instancia.getUsers()
        instancia.savedUsers.observe(this){usersList ->
            if(!usersList.isNullOrEmpty()){
                for(user in usersList){
                    Log.d("thesearetheusers", user.user_name)

                    binding.rvUserEntrada.adapter = MainAdapter(usersList)
                }


            }else {
                Log.d("users", "null or empty")
            }
        }
    }
}