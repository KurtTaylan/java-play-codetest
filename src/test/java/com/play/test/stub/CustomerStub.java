package com.play.test.stub;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.play.test.domain.dto.Customer;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CustomerStub {

    public static List<Customer> generateUnsortedCustomerJsonDataSampleOne() {
        return getCustomers("/data/customers.json");
    }

    public static List<Customer> generateSortedCustomerJsonDataSampleOne() {
        return getCustomers("/data/sortedCustomers.json");
    }

    private static List<Customer> getCustomers(String filePath) {
        ObjectMapper mapper = new ObjectMapper().registerModule(new JodaModule());
        TypeReference<List<Customer>> mapType = new TypeReference<List<Customer>>() {
        };
        InputStream is = TypeReference.class.getResourceAsStream(filePath);
        List<Customer> customerList = new ArrayList<>();
        try {
            customerList = mapper.readValue(is, mapType);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return customerList;
    }
}
