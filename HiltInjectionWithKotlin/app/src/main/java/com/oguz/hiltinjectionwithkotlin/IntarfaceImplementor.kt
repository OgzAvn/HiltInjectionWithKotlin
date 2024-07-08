package com.oguz.hiltinjectionwithkotlin

import javax.inject.Inject

class IntarfaceImplementor
    @Inject
    constructor()
    : MyInterface{
    override fun myPrintFunc(): String {
        return "My Interface Implementor"
    }
}