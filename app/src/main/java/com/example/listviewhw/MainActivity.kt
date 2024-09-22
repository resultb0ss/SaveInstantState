package com.example.listviewhw

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.example.listviewhw.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setSupportActionBar(binding.toolbarMain)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        var notes: MutableList<User> = mutableListOf()

        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,notes)
        binding.mainListViewLV.adapter = adapter

        binding.addButtonBTN.setOnClickListener{
            if (binding.mainNameET.text.isNotEmpty() && binding.mainAgeET.text.isNotEmpty()){
                val user = User(binding.mainNameET.text.toString(),binding.mainAgeET.text.toString().toInt())
                notes.add(user)
                adapter.notifyDataSetChanged()
                binding.mainNameET.text.clear()
                binding.mainAgeET.text.clear()
            } else {
                Toast.makeText(this,
                    "Неверный ввод",
                    Toast.LENGTH_LONG).show()
            }

        }

        binding.mainListViewLV.onItemClickListener =
            AdapterView.OnItemClickListener{ parent, v,position, id ->
                val note = adapter.getItem(position)
                adapter.remove(note)
                Toast.makeText(this,"Пользователь удален  $note", Toast.LENGTH_LONG ).show()
            }



    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.exitMenuMain -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}