package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
    In Spring’s approach to building RESTful web services, HTTP
    requests are handled by a controller. These components are
    identified by the @RestController annotation, and the
    GreetingController handles GET requests for /greeting by
    returning a new instance of the Greeting class.

    When the @RestController annotation, every method from the
    class returns a domain object instead of a view.
*/

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    // The @GetMapping annotation ensures that HTTP GET requests
    // to /greeting are mapped to the greeting() method.
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}

/*
    @RequestParam binds the value of the query string parameter
    name into the name parameter of the greeting() method. If
    the name parameter is absent in the request, the defaultValue
    of World is used.
 */