package com.leandro1995.datastore

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.leandro1995.datastore.datastore.DataStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameEditText = findViewById<EditText>(R.id.nameEditText)
        val ageEditText = findViewById<EditText>(R.id.ageEditText)
        val saveButton = findViewById<Button>(R.id.saveButton)
        val messageText = findViewById<TextView>(R.id.messageText)

        saveButton.setOnClickListener {
            GlobalScope.launch(Dispatchers.Main) {
                DataStore.setMessage(value = nameEditText.text.toString())
                DataStore.setAge(value = ageEditText.text.toString().toInt())

                messageText.text = "${nameEditText.text} ${ageEditText.text}"
            }
        }

        if (DataStore.getMessage().isNotEmpty()) {
            messageText.text = "${DataStore.getMessage()} ${DataStore.getAge()}"
        }
    }
}