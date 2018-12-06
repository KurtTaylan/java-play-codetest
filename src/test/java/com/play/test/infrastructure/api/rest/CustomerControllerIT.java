package com.play.test.infrastructure.api.rest;

import com.play.test.domain.dto.Customer;
import com.play.test.stub.CustomerStub;
import io.restassured.response.ResponseBody;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerIT {

    @LocalServerPort
    private int randomServerPort;

    @Test
    void should_sort_given_customer_list_by_due_time_ASC() {
        ResponseBody body =
        given()
                .port(randomServerPort)
                .contentType("application/json")
                .body(CustomerStub.generateUnsortedCustomerJsonDataSampleOne())
        .when()
                .post("/customers/sort-by-due-time").getBody();

        //then
        assertThat(body).isNotNull();
        assertThat(body.as(Customer[].class)).containsExactlyElementsOf(CustomerStub.generateSortedCustomerJsonDataSampleOne());
    }
}