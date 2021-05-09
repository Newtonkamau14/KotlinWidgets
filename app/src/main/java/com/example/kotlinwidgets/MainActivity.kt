package com.example.kotlinwidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener {
     lateinit var dynSpinner: Spinner
     lateinit var ideAdapter:ArrayAdapter<String>
     var ideList = arrayOf("Visual Studio","Intellij","Codeblocks","Eclipse","Xcode")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var languages = arrayOf("Kotlin","Java","Swift","Javascript","Go","Elixir","C","C++","C#","Cobol","Web Assembly","Ruby")

        var languagesAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,languages)

        autoComplete.threshold = 0
        autoComplete.setAdapter(languagesAdapter)

        dynSpinner = findViewById(R.id.dynamicSpinner)
        ideAdapter = ArrayAdapter(applicationContext,android.R.layout.simple_spinner_item,ideList)
        dynSpinner?.adapter = ideAdapter
        dynSpinner?.onItemSelectedListener = this

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var ides:String = parent?.getItemAtPosition(position) as String
        Toast.makeText(applicationContext,"$ides",Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

}