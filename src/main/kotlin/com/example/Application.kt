package com.example

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.serialization.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import kotlinx.serialization.Serializable


//fun main(args: Array<String>): Unit =
//    io.ktor.server.netty.EngineMain.main(args)

fun main(){
    embeddedServer(Netty , port = 8080){
install(ContentNegotiation){
    json()

}
        module()
    }.start(true)
}


fun Application.module() {
//    install(Routing){
//    route(path = "/",method = HttpMethod.Get){
//        handle {
//            call.respondText("Routing")
//        }
//    }
//    }
    routing {
        get("/") {
            call.respondText("Hello World Embedded Server...")
        }
        get("/user/{username}") {
            val name = call.parameters["username"]
            val header = call.request.headers["Connection"]
            call.respondText("Hello $name with Header: $header")
        }
        get("/user/{username}") {
            val name = call.parameters["username"]
            val header = call.request.headers["Connection"]
            if (name == "Admin") {
                call.response.header("Custom Header", "Admin")
                call.respond(message = "Hello Admin", status = HttpStatusCode.OK)
            }
            call.respondText("Hello $name with Header: $header")
        }
        get("/user") {
            val name = call.request.queryParameters["name"]
            val age = call.request.queryParameters["age"]

            call.respondText("Name: $name and Age: $age")
        }
        get("/person") {

            try {
                val person = Person(1, "Ayesha", " 24")
                call.respond(message = person, status = HttpStatusCode.OK)

            }catch (e:Exception){
                call.respond(message = "${e.message}", status = HttpStatusCode.BadRequest)
            }
        }
        get("/redirect") {
            call.respondRedirect(url = "/moved", permanent = false)
        }
        get("/moved") {
            call.respondText("You successfully redirected!")
        }
    }

}

@Serializable
data class Person(
    val id: Int,
    val name: String,
    val age: String
)


/*two different ways of creating server app
   1-Embedded Server
   2- EngineMain
    */
//used to specify how your server should respond to different HTTP requests.