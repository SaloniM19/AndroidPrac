package com.example.student_details_jobspot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.student_details_jobspot.databinding.ActivityAddressBinding
import com.example.student_details_jobspot.databinding.ActivityMainBinding
import com.example.student_details_jobspot.databinding.ActivitySgpiBinding
import com.example.student_details_jobspot.model.User
import com.google.firebase.firestore.FirebaseFirestore

private const val TAG = "SGPI ACTIVITY"
class SgpiActivity : AppCompatActivity() {
    private lateinit var binding1: ActivityAddressBinding
    private lateinit var binding2: ActivitySgpiBinding
    private val mFirebaseStore : FirebaseFirestore by lazy { FirebaseFirestore.getInstance() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address)
        setContentView(R.layout.activity_main)
        setContentView(R.layout.activity_sgpi)
        binding1 = ActivityAddressBinding.inflate(layoutInflater)
        binding2 = ActivitySgpiBinding.inflate(layoutInflater)
        setContentView(binding1.root)
        setContentView(binding2.root)

        val sapId = intent.getLongExtra("EXTRA_SapID", 0).toString()
        val mobile = intent.getLongExtra("EXTRA_Mobile", 0).toString()
        val dob = intent.getStringExtra("EXTRA_DOB").toString()
        val gender = intent.getStringExtra("EXTRA_Gender").toString()
        val address1 = intent.getStringExtra("EXTRA_Address1").toString()
        val address2 = intent.getStringExtra("EXTRA_Address2").toString()
        val city = intent.getStringExtra("EXTRA_City").toString()
        val state = intent.getStringExtra("EXTRA_State").toString()
        val zipcode = intent.getLongExtra("EXTRA_ZipCode",0).toString()
        val details = "$sapId $mobile $dob $gender $address1 $address2 $city $state $zipcode"

        val detail = User(
            sapId = sapId,
            mobile = mobile,
            dob = dob,
            gender = gender,
            address = "$address1 $address2",
            city = city,
            state = state,
            zipCode = zipcode
        )

        mFirebaseStore.collection("user").document().set(detail)
            .addOnSuccessListener {
                Log.d(TAG, "We are goood")
            }
            .addOnFailureListener {
                Log.d(TAG, "We are bad ${it.message}")
            }

        binding2.tv2.text = details

        binding2.btnSgpiNext.setOnClickListener{
            val sem1 = binding2.etSem1.text.toString()
            val sem2 = binding2.etSem2.text.toString()
            val sem3 = binding2.etSem3.text.toString()
            val sem4 = binding2.etSem4.text.toString()
            val avg = binding2.etAvg.text.toString()

            Toast.makeText(this,"$sem1 $sem2 $sem3 $sem4 $avg" , Toast.LENGTH_SHORT).show()
        }
    }
}