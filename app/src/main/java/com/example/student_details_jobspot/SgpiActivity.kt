package com.example.student_details_jobspot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.student_details_jobspot.databinding.ActivitySgpiBinding
import com.example.student_details_jobspot.model.*
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject

private const val TAG = "SGPI ACTIVITY"
class SgpiActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySgpiBinding
    private val mFirebaseStore : FirebaseFirestore by lazy { FirebaseFirestore.getInstance() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySgpiBinding.inflate(layoutInflater)
        setContentView(binding.root)

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


        binding.tv2.text = details

        binding.btnSgpiNext.setOnClickListener{
            val sem1 = binding.etSem1.text.toString()
            val sem2 = binding.etSem2.text.toString()
            val sem3 = binding.etSem3.text.toString()
            val sem4 = binding.etSem4.text.toString()
            val avg = binding.etAvg.text.toString()

            val detail = User(
                sapId = sapId,
                mobile = mobile,
                dob = dob,
                gender = gender,
                address = "$address1 $address2",
                city = city,
                state = state,
                zipCode = zipcode,
                sem1 = sem1,
                sem2 = sem2,
                sem3 = sem3,
                sem4 = sem4,
                avg = avg
            )

            val studentDetail = StudentDetail(
                sapId = sapId,
                mobile = mobile,
                dob = dob,
                gender = gender
            )
            val studentAddress = StudentAddress(
                address = "$address1 $address2",
                city = city,
                state = state,
                zipCode = zipcode
            )

            val studentScore = StudentScore(
                sem1 = sem1,
                sem2 = sem2,
                sem3 = sem3,
                sem4 = sem4,
                avg = avg
            )

            val student = Student(
                studentDetail = studentDetail,
                studentAddress = studentAddress,
                studentScore = studentScore
            )

            mFirebaseStore.collection("user").document().set(detail)
                .addOnSuccessListener {
                    Log.d(TAG, "We are goood")
                    mFirebaseStore.collection("user").addSnapshotListener { document, error ->
                        document?.let{ querySnapshot ->  
                            try{
                                for(snap in querySnapshot){
                                    val user = snap.toObject<User>()
                                    Log.d(TAG, "User : ${user}")
                                }
                            }catch (e: Exception){
                                Log.d(TAG, "User : ${e.message}")
                            }
                        }
                    }
                }
                .addOnFailureListener {
                    Log.d(TAG, "We are bad ${it.message}")
                }
            
            mFirebaseStore.collection("student").document().set(student)
                .addOnSuccessListener { 
                    mFirebaseStore.collection("student").addSnapshotListener { document, error ->
                        document?.let { querySnapshot ->
                            try {
                                for(snap in querySnapshot){
                                    val student = snap.toObject<Student>()
                                    Log.d(TAG, "Student : ${student}")
                                }
                            }catch (e : Exception){
                                Log.d(TAG, "User : ${e.message}")
                            }
                        }
                    }
                }



            Toast.makeText(this,"$sem1 $sem2 $sem3 $sem4 $avg" , Toast.LENGTH_SHORT).show()
        }
    }
}