package com.example.realtimedb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_cities.*

class Cities : AppCompatActivity() {
    val cities : ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cities)

        FirebaseDatabase.getInstance().reference.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                TODO("Not implemented!") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot) {
                for (city in p0.children)
                {
                    cities.add(city.key.toString())
                }

                val adapter = ArrayAdapter<String>(applicationContext, android.R.layout.simple_list_item_1, cities)
                list.adapter = adapter
            }

        })
    }
}
