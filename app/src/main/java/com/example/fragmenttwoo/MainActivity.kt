package com.example.fragmenttwoo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val homeBtn: Button = findViewById(R.id.homebtn)
        val profileBtn: Button = findViewById(R.id.profilebtn)
        val settingBtn : Button = findViewById(R.id.setttingsbtn)

        val textInput: EditText = findViewById(R.id.enterName)
        val sendToProfileBtn : Button = findViewById(R.id.sendbtn)

        //instantiate the home profile and setting fragments

        val homeFragment = HomeFragment()
        val profileFragment = ProfileFragment()
        val settingsFragment = SettingsFragment()

        //when activity is created we want it to load the home fragment by default

        supportFragmentManager.beginTransaction().apply {
            //ask it to replace framelayout with home fragment
            replace(R.id.bodyFragment, homeFragment)
            commit()
        }

        //set onclicklistener for home, profile and setting button

        homeBtn.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.bodyFragment, homeFragment)
                commit()
            }
        }


        profileBtn.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.bodyFragment, profileFragment)
                commit()
            }
        }


        settingBtn.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.bodyFragment, settingsFragment)
                commit()
            }
        }

        sendToProfileBtn.setOnClickListener {
            val inputName : String = textInput.editableText.toString()
            //bundle the data that want to send to the fragment

            val args = Bundle()
            args.putString("name", inputName)
            profileFragment.arguments = args

            //call fragment manager and ask it to replace body fragment(frame layout) with profile fragment

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.bodyFragment, profileFragment)
                commit()
            }
        }
    }
}