package com.example.testactivitynavigation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.annotation.IdRes
import androidx.core.net.toUri
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.testactivitynavigation.databinding.ActivityMainBinding
import com.example.testactivitynavigation.databinding.ActivityMainBinding.inflate
import com.example.testactivitynavigation.databinding.ActivitySecondBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class SecondActivity : AppCompatActivity() {

    lateinit var binding: ActivitySecondBinding

    companion object {
        fun start(context: Context, @IdRes menuId:Int) {
            val intent = Intent(context, SecondActivity::class.java)
            intent.putExtra("KEY", menuId)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.navView.setOnItemSelectedListener {
            MainActivity.start(this, it.itemId)
            true
        }
    }

    override fun onStart() {
        super.onStart()
        val menuItemFrom = intent.getIntExtra("KEY", -1)
        val item: MenuItem = binding.navView.menu.findItem(menuItemFrom)
        item.isChecked = true
        invalidateOptionsMenu()
    }
}