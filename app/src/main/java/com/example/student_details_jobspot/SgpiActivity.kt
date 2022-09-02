package com.example.student_details_jobspot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.student_details_jobspot.databinding.ActivityAddressBinding
import com.example.student_details_jobspot.databinding.ActivityMainBinding
import com.example.student_details_jobspot.databinding.ActivitySgpiBinding

class SgpiActivity : AppCompatActivity() {
    private lateinit var binding1: ActivityAddressBinding
    private lateinit var binding2: ActivitySgpiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address)
        setContentView(R.layout.activity_main)
        setContentView(R.layout.activity_sgpi)
        binding1 = ActivityAddressBinding.inflate(layoutInflater)
        binding2 = ActivitySgpiBinding.inflate(layoutInflater)
        setContentView(binding1.root)
        setContentView(binding2.root)

        val sapId = intent.getLongExtra("EXTRA_SapID", 0)
        val mobile = intent.getLongExtra("EXTRA_Mobile", 0)
        val dob = intent.getStringExtra("EXTRA_DOB")
        val gender = intent.getStringExtra("EXTRA_Gender")
        val address1 = intent.getStringExtra("EXTRA_Address1")
        val address2 = intent.getStringExtra("EXTRA_Address2")
        val city = intent.getStringExtra("EXTRA_City")
        val state = intent.getStringExtra("EXTRA_State")
        val zipcode = intent.getLongExtra("EXTRA_ZipCode",0)
        val details = "$sapId $mobile $dob $gender $address1 $address2 $city $state $zipcode"
        binding2.tv2.text = details
    }
}