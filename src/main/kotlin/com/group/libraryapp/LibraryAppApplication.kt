package com.group.libraryapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LibraryAppApplication

// 코틀린에서 main 함수를 만들면 해당 함수가 static 함수로 실행
fun main(args: Array<String>) {
    runApplication<LibraryAppApplication>(*args)
}