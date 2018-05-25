package com.jsystems.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsystems.api.models.FakeBook;
import com.jsystems.api.models.Person;
import com.jsystems.api.models.TestUserGeneric;
import com.jsystems.api.models.UserDevice;
import com.jsystems.api.models.errorModels.ErrorResponse;
import com.jsystems.api.response.TestResponse;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasValue;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ApiTest {

    @Test
    @DisplayName("First Api rest Test")
    public void ApiFirstTest() {

        RestAssured.given()
                .when()
                .get("http://www.mocky.io/v2/5a6b69ec3100009d211b8aeb")
                .then()
                .statusCode(200)
                .body("name", equalTo("Piotr"))
                .body("surname", equalTo("Kowalski"));
    }

    @Test
    @DisplayName("Secend Api rest Test")
    public void SecondTest() {
        RestAssured.given()
                .when()
                .get("http://www.mocky.io/v2/5a6a58222e0000d0377a7789")
                .then()
                .assertThat()
                .statusCode(200)
//            .contentType(ContentType.JSON)
                .contentType("application/json")
                .body("[0].imie", is("Piotr"))
                .body("[0].nazwisko", is("Kowalski"))
                .body("[0].device[0].type", equalTo("computer"))
                .body("[0].device[0].device.model[0].produce", equalTo("dell"));
        //     .body("[0].device[0].device.model[0].screen.size", equalTo("17"))

    }

    @Test
    @DisplayName("Next Api Test Mapped Object")
    public void TestMappedObject() {

        JsonPath jsonPath = RestAssured.given()
                .spec(Specificator.requestSpecification)
                .when()
                .get("/5a6b69ec3100009d211b8aeb")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();
//        jsonPath.prettyPrint();

        Person person = jsonPath.getObject("", Person.class);
        System.out.println(person);
        assertTrue(person.name.equals("Piotr"));
        assertTrue(person.surname.equals("Kowalski"));
    }

    @Test
    @DisplayName("Second Api Test Mapped Object")
    public void secondTestMappedObject() {

        JsonPath jsonPath = RestAssured.given()
                .spec(Specificator.requestSpecification)
                .when()
                .get("/5a6a58222e0000d0377a7789")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();
//                .extract().body().jsonPath();

        jsonPath.prettyPrint();

        List<UserDevice> userDeviceList = jsonPath.getList("", UserDevice.class);

        assertTrue(userDeviceList.get(0).imie.equals("Piotr"));
        assertTrue(userDeviceList.get(0).nazwisko.equals("Kowalski"));
        assertTrue(userDeviceList.get(0).device.get(0).type.equals("computer"));
        assertTrue(userDeviceList.get(0).device.get(0).deviceModels.get(0).produce.equals("dell"));
        assertTrue(userDeviceList.get(0).device.get(0).deviceModels.get(0).screenSize == 17);

    }


    @Test
    @DisplayName("Mapped to Response")
    public void responseTest() {

        Response response = RestAssured
                .given()
                .spec(Specificator.requestSpecification)
                .when()
                .get("/5a6b69ec3100009d211b8aeb")
                .andReturn();

        Person person = response
                .then()
                .extract()
                .as(Person.class);

        assertTrue(person.name.equals("Piotr"));
        assertTrue(person.surname.equals("Kowalski"));
        assertTrue(response.contentType().equals("application/json"));

//        List<UserDevice> userDeviceList = jsonPath.getList("", UserDevice.class);
//        assertThat(userDeviceList.get(0).device.get(0).deviceModels.get(0).produce).isEqualTo("dell");
//        System.out.println(userDeviceList.toString());
    }

    @Test
    @DisplayName("Mapped List to Response")
    public void responseToList() {

        Response response = RestAssured
                .given()
                .spec(Specificator.requestSpecification)
                .when()
                .get("/5a6a58222e0000d0377a7789")
                .andReturn();

        UserDevice[] userDevice = response
                .then()
                .extract()
                .as(UserDevice[].class);

        List<UserDevice> userDeviceList = Arrays.asList(userDevice);

        assertTrue(userDeviceList.get(0).imie.equals("Piotr"));
        assertTrue(userDeviceList.get(0).nazwisko.equals("Kowalski"));
        assertTrue(userDeviceList.get(0).device.get(0).type.equals("computer"));
        assertTrue(userDeviceList.get(0).device.get(0).deviceModels.get(0).produce.equals("dell"));
        assertTrue(userDeviceList.get(0).device.get(0).deviceModels.get(0).screenSize == 17);

        assertTrue(response.contentType().equals("application/json"));
        assertTrue(response.statusCode() == 200);
        assertTrue((response.getHeader("Content-Type").equals("application/json")));
        assertTrue((response.getHeader("Server").equals("Cowboy")));
        assertTrue((response.getHeader("Content-Length").equals("1457")));

    }

    @Test
    @DisplayName("Mapped List to Response version2")
    public void responseWithListVersoin2() {

        Response response = TestResponse.responseWithList();

        UserDevice[] userDevice = response
                .then()
                .extract()
                .as(UserDevice[].class);

        List<UserDevice> userDeviceList = Arrays.asList(userDevice);

        assertTrue(userDeviceList.get(0).imie.equals("Piotr"));
        assertTrue(userDeviceList.get(0).nazwisko.equals("Kowalski"));
        assertTrue(userDeviceList.get(0).device.get(0).type.equals("computer"));
        assertTrue(userDeviceList.get(0).device.get(0).deviceModels.get(0).produce.equals("dell"));
        assertTrue(userDeviceList.get(0).device.get(0).deviceModels.get(0).screenSize == 17);

        assertTrue(response.contentType().equals("application/json"));
        assertTrue(response.statusCode() == 200);
        assertTrue((response.getHeader("Content-Type").equals("application/json")));
        assertTrue((response.getHeader("Server").equals("Cowboy")));
        assertTrue((response.getHeader("Content-Length").equals("1457")));
        //               .extract().body().jsonPath();
    }


    @Test
    @DisplayName("Test Error Response")
    public void errorResponse() {
        Response response = TestResponse.responseWithList2("5a690b452e000054007a73cd");
        //url -- 5a690b452e000054007a73cd

        ErrorResponse errorResponse = response
                .then()
                .extract()
                .body()
                .as(ErrorResponse.class);

        assertTrue(errorResponse.error.errorcode == 400);
        assertTrue(errorResponse.error.validationErro.equals("invalid_email"));
        assertTrue(errorResponse.error.message.equals("your email is invalid"));

        assertTrue(response.getHeader("Content-Type").equals("application/json"));
        assertTrue(response.getHeader("Server").equals("Cowboy"));
    }

    @Test
    @DisplayName("Test Maps to Response")
    public void mapsToResponse() {
        Map<String, String> params = new LinkedHashMap<>();
        params.put("id", "1");
        params.put("name", "Piotr");

        Response response = RestAssured
                .given()
                .spec(Specificator.requestSpecification)
                .queryParam("id", "1")
                .queryParam("name", "Piotr")
                .when()
                .get("/5a6a58222e0000d0377a7789")
                .andReturn();

    }

    @Test
    @DisplayName("Post Test")
    public void postTest() {
        Person person = new Person("Rafał", "Nowak");

        Response response = TestResponse.responsePost("5a690b452e000054007a73cb",person);
        //url -- 5a690b452e000054007a73cd

        String responsePost = Arrays.asList(response
                .then()
                .statusCode(201)
                .extract()
                .body()
                .as(String[].class)).toString();
// co to jest .as(String[])
        // zrób sobie tablice stringów, zamień to na kolekcję i zrzuć na toStringa

        System.out.println(responsePost);
        //assertThat(responsePost.("[]"));
       // assertTrue(response.getStatusCode()==201);
        assertTrue(response.getHeader("Content-Type").equals("application/json"));

    }

    @Test
    @DisplayName("Test of generic User")
    public void genericTest() throws IOException {
        Person person = new Person("Rafał", "Nowak");
        Response response = TestResponse.responseWithList2("5b05bf3f3200007100ebfa04");

        ObjectMapper objectMapper = new ObjectMapper();
        TestUserGeneric<Integer> testUserGeneric = objectMapper.readValue(
                response
                .then()
                .extract()
                .body()
                .asInputStream(),new TypeReference<TestUserGeneric<Integer>>(){}
        );
        System.out.println(testUserGeneric);
        assertTrue(testUserGeneric.id==1);
        assertTrue(response.statusCode()==200);
        assertTrue(response.contentType().equals("application/json"));
    }


    @Test
    @DisplayName("Test of generic type")
    public void genericType() throws IOException {
        Person person = new Person("Rafał", "Nowak");
        Response response = TestResponse.responseWithList2("5b05c83e3200009700ebfa2b");

        ObjectMapper objectMapper = new ObjectMapper();
        TestUserGeneric<String> testUserGeneric = objectMapper.readValue(
                response
                        .then()
                        .extract()
                        .body()
                        .asInputStream(),new TypeReference<TestUserGeneric<String>>(){}
        );
        System.out.println(testUserGeneric);
        assertTrue(testUserGeneric.id.equals("1a"));
        assertTrue(response.statusCode()==200);
        assertTrue(response.contentType().equals("application/json"));
    }

    @Test
    @DisplayName("GET: /api/books/ - Test of Books")
    public void fakeRestApiBook()  {

        Response response = TestResponse.responseFakeRestApiBook("/api/Books/{id}",1);
//        Response response = RestAssured
//                .given()
//                .spec(Specificator.requestSpecification)
//                .when()
//                .get("/api.books/{id}")
//                .andReturn();
    FakeBook books = response
            .then()
            .extract()
            .body()
            .as(FakeBook.class);
        System.out.println(books);
        assertTrue(books.id == 1);

    }

    }


