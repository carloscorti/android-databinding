package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)

//        val view = binding.root
//        setContentView(view)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

//
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
        val nicknameText = binding.nicknameText
        val nicknameEdit = binding.nicknameEdit
        nicknameText.text = nicknameEdit.text.toString()
        nicknameEdit.visibility = View.GONE
        view.visibility = View.GONE
        nicknameText.visibility = View.VISIBLE

        // To hide keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}