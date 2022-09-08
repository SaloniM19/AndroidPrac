package com.example.student_details_jobspot

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.student_details_jobspot.databinding.ActivityAddressBinding
import com.example.student_details_jobspot.databinding.ActivityMainBinding


class AddressActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddressBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddressBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sapId = intent.getLongExtra("EXTRA_SapID",0)
        val mobile = intent.getLongExtra("EXTRA_Mobile",0)
        val dob = intent.getStringExtra("EXTRA_DOB")
        val gender = intent.getStringExtra("EXTRA_Gender")
        val details = "$sapId $mobile $dob $gender"
        binding.tv1.text = details

        binding.btnAddressNext.setOnClickListener{
            val address1 = binding.etAddress1.text.toString()
            val address2 = binding.etAddress2.text.toString()
            val city = binding.etCity.text.toString()
            val state = binding.etState.text.toString()
            val zipcode = binding.etZipCode.text.toString().toLong()

            Intent(this, SgpiActivity::class.java).also {

                it.putExtra("EXTRA_SapID", sapId)
                it.putExtra("EXTRA_Mobile", mobile)
                it.putExtra("EXTRA_DOB", dob)
                it.putExtra("EXTRA_Gender",gender)
                it.putExtra("EXTRA_Address1", address1)
                it.putExtra("EXTRA_Address2", address2)
                it.putExtra("EXTRA_City", city)
                it.putExtra("EXTRA_State", state)
                it.putExtra("EXTRA_ZipCode", zipcode)

                startActivity(it)
            }
        }

    }
}


