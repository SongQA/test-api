package api

import io.restassured.RestAssured
import io.restassured.http.ContentType
import org.junit.jupiter.api.Test

class ExampleApiTest {

    private val baseUrl = "https://example.com/api"

    @Test
    fun testGetUsers() {
        RestAssured.given()
            .baseUri(baseUrl)
            .contentType(ContentType.JSON)
            .get("/users")
            .then()
            .statusCode(200)
    }

    @Test
    fun testCreateUser() {
        val requestBody = mapOf(
            "name" to "John Doe",
            "email" to "johndoe@example.com"
        )

        RestAssured.given()
            .baseUri(baseUrl)
            .contentType(ContentType.JSON)
            .body(requestBody)
            .post("/users")
            .then()
            .statusCode(201)
    }
}