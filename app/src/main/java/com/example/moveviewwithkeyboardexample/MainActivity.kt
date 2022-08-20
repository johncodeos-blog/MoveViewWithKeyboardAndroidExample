package com.example.moveviewwithkeyboardexample

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val root = findViewById<ConstraintLayout>(R.id.content_id)

        val insetsWithKeyboardCallback = InsetsWithKeyboardCallback(window)
        ViewCompat.setOnApplyWindowInsetsListener(root, insetsWithKeyboardCallback)
        ViewCompat.setWindowInsetsAnimationCallback(root, insetsWithKeyboardCallback)


        val loginButton = findViewById<Button>(R.id.login_button)

        val insetsWithKeyboardAnimationCallback = InsetsWithKeyboardAnimationCallback(loginButton)
        ViewCompat.setWindowInsetsAnimationCallback(loginButton, insetsWithKeyboardAnimationCallback)

    }
}