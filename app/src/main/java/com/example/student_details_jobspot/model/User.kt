package com.example.student_details_jobspot.model

data class User(
    var sapId : String = "",
    var mobile: String = "",
    var dob : String = "",
    var gender : String = "",
    var address : String = "",
    var city : String = "",
    var state : String = "",
    var zipCode : String = "",
    var sem1 : String = "",
    var sem2 : String = "",
    var sem3 : String = "",
    var sem4 : String = "",
    var avg : String = "",
)

data class Student(
    var studentDetail : StudentDetail? = null,
    var studentAddress : StudentAddress? = null,
    var studentScore : StudentScore?= null
)


data class StudentDetail(
    var sapId : String = "",
    var mobile: String = "",
    var dob : String = "",
    var gender : String = "",
)

data class StudentAddress(
    var address : String = "",
    var city : String = "",
    var state : String = "",
    var zipCode : String = "",
)

data class StudentScore(
    var sem1 : String = "",
    var sem2 : String = "",
    var sem3 : String = "",
    var sem4 : String = "",
    var avg : String = "",
)