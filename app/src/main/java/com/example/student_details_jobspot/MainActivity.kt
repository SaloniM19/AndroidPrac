package com.example.student_details_jobspot

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.student_details_jobspot.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var radioGroup: RadioGroup? = null
    private var selectedRadioButton: RadioButton? = null
    private lateinit var radioButton : RadioButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        radioGroup = findViewById (R.id.radioGroup);

        binding.btnDetailNext.setOnClickListener {
            selectedRadioButton = findViewById (radioGroup!!.checkedRadioButtonId);
            val gender = selectedRadioButton!!.text.toString();
            val sapId = binding.etSapId.text.toString().toLong()
            val mobile = binding.etMobile.text.toString().toLong()
            val dob = binding.etDOB.text.toString()
            Intent(this, AddressActivity::class.java).also {
                it.putExtra("EXTRA_SapID", sapId)
                it.putExtra("EXTRA_Mobile", mobile)
                it.putExtra("EXTRA_DOB", dob)
                it.putExtra("EXTRA_Gender", gender)
                startActivity(it)
            }
        }

    }
}


