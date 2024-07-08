package com.oguz.hiltinjectionwithkotlin

import com.google.gson.Gson
import javax.inject.Inject

class ClassExample
@Inject
constructor(@FirstImplementor private val myInterface: MyInterface,
            private val gson: Gson,
            @SecondImplementor private val mySedondInterfaceImplementor: MyInterface)
{

    fun myFunction() : String{
        return "Working : ${myInterface.myPrintFunc()}"
    }

    fun SecondFunction() : String {

        return "Working : ${mySedondInterfaceImplementor.myPrintFunc()}"
    }
}