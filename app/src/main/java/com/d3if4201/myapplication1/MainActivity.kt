package com.d3if4201.myapplication1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.d3if4201.myapplication1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
      private lateinit var NavController : NavController
    private  lateinit var   binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_main)
        NavController=this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this,NavController)
    }

    override fun onSupportNavigateUp(): Boolean {
         NavController = this.findNavController(R.id.myNavHostFragment)
        return NavController.navigateUp()
    }
}
