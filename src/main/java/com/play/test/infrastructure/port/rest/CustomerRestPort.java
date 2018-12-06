package com.play.test.infrastructure.port.rest;

import com.play.test.domain.dto.Customer;
import reactor.core.publisher.Flux;

import java.util.List;

public interface CustomerRestPort {

    Flux<Customer> sortGivenCustomerListByDueTime(List<Customer> unsortedCustomerList);
}