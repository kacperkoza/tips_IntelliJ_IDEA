package com.example.tips_IntelliJ_IDEA

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class AppRunner {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(AppRunner::class.java, *args)
        }
    }
}

