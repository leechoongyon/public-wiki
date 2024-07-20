package com.example

class Cup<in T>
open class Dog      // 상속 가능
class Puppy: Dog() // Puppy 가 Dog 를 상속

fun main(array: Array<String>) {
    val b : Cup<Dog> = Cup<Puppy>() // 오류
    val a : Cup<Puppy> = Cup<Dog>() // OK
}