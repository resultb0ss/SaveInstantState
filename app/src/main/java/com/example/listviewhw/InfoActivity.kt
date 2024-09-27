package com.example.listviewhw

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.listviewhw.databinding.ActivityInfoBinding
import com.example.listviewhw.databinding.ActivityMainBinding
import com.example.listviewhw.User

class InfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInfoBinding
    private var user: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        user = intent.extras?.getParcelable(User::class.java.simpleName) as User?

        binding.infoActivityFirstNameResultTV.text = user?.getName()
        binding.infoActivityLastNameResultTextViewTV.text = user?.getLastName()
        binding.infoActivityPhoneNumberResutTextViewTV.text = user?.getPhone().toString()
        binding.infoActivityAdressResultTextViewTV.text = user?.getAdress()






    }
}