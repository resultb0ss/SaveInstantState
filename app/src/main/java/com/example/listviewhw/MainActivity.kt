package com.example.listviewhw

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.listviewhw.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    lateinit var userViewModel: UserViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setSupportActionBar(binding.toolbarMain)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]



        var notes: MutableList<User> = mutableListOf()

        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,notes)
        binding.mainListViewLV.adapter = adapter

        userViewModel.getListUsers().observe(this, Observer {
            binding.mainListViewLV.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,it)
        })



        binding.addButtonBTN.setOnClickListener{
            if (binding.mainFirstnameET.text.isNotEmpty() && binding.mainAgeET.text.isNotEmpty() &&
                binding.mainLastnameET.text.isNotEmpty() && binding.mainAdressET.text.isNotEmpty())

            {
                val userFirstName = binding.mainFirstnameET.text.toString()
                val userLastName = binding.mainLastnameET.text.toString()
                val userAge = binding.mainAgeET.text.toString().toInt()
                val userAdress = binding.mainAdressET.text.toString()
                val user = User(userFirstName,userLastName,userAdress,userAge)

                notes.add(user)
                userViewModel.userList.value = notes
                adapter.notifyDataSetChanged()

                binding.mainFirstnameET.text.clear()
                binding.mainLastnameET.text.clear()
                binding.mainAdressET.text.clear()
                binding.mainAgeET.text.clear()

            } else {
                Toast.makeText(this,
                    "Неверный ввод",
                    Toast.LENGTH_LONG).show()
            }

        }


        binding.mainListViewLV.onItemClickListener =
            AdapterView.OnItemClickListener{ parent, v,position, id ->
                val intent = Intent(this,InfoActivity::class.java)
                val user = adapter.getItem(position)
                intent.putExtra(User::class.java.simpleName,user)
                startActivity(intent)
            }



    }


}