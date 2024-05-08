package com.example

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.routing.*


fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)




fun Application.module() {

install(CallLogging)
    routing {
        static {
            resources("static")
//            resource("static/facebook.html")
//            resource("static/text.txt")
        }

        get("/") {
            call.respondText("Hello World Embedded Server...")
        }

    }
}

//@Serializable
//data class Person(
//    val id: Int,
//    val name: String,
//    val age: String
//)


/*two different ways of creating server app
   1-Embedded Server
   2- EngineMain
    */
//used to specify how your server should respond to different HTTP requests.