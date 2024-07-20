package com.example



class Cup<out T>
open class Dog      // open 클래스를 선언하면 다른 클래스에서 상속 가능
class Puppy: Dog()  // Dog 를 상속받고 있음

fun main(array: Array<String>) {
    val b : Cup<Dog> = Cup<Puppy>() // OK
//    val a : Cup<Puppy> = Cup<Dog>() // 오류

}