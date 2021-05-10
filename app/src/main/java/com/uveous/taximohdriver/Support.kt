package com.uveous.taximohdriver

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.uveous.taximohdriver.TravelDashboard

class Support :  AppCompatActivity() {
    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.support)
        toolbar = findViewById(R.id.toolbar)
        toolbar.setNavigationOnClickListener(View.OnClickListener {
          finish()
        })


    }

}
