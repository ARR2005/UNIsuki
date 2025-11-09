package com.example.unisuki.auth

class auth {
    var name: String = ""
    var idNumber: String = ""
    var password: String = ""
    var repassword: String = ""



    public constructor(name: String, idNumber: String, password: String, repassword: String) {
        this.name = name
        this.idNumber = idNumber
        this.password = password
        this.repassword = repassword
    }

    public constructor(){

    }
}