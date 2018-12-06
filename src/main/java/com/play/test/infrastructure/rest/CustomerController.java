package com.play.test.infrastructure.rest;

import com.play.test.domain.dto.Customer;
import com.play.test.infrastructure.port.rest.CustomerRestPort;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController implements CustomerRestPort {

    @Override
    @PostMapping(value = "/sort-by-due-time")
    public Flux<Customer> sortGivenCustomerListByDueTime(@RequestBody List<Customer> unsortedCustomerList) {
        return Flux.fromStream(unsortedCustomerList.stream()
                .sorted(Comparator.comparing(Customer::getDueTime).reversed()));
    }
}
