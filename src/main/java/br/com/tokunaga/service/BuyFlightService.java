package br.com.tokunaga.service;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BuyFlightService {
    private final FlightSearchService service;

    @Retry(name = "flightSearch")
    public List<Flight> searchFlights(String country) {
        System.out.println("Here:" + LocalDateTime.now());
        return service.searchFlightsThrowingException(country);
    }
}
