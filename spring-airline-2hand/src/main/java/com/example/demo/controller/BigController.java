package com.example.demo.controller;

import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BigController {
    @Autowired
    private AirlineRepository airlineRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private FilghtRepository filghtRepository;

    @Autowired
    private RefClassRepository refClassRepository;

    @Autowired
    private RefPayMentMethodsRepository refPayMentMethodsRepository;

    @Autowired
    private RefReservationStatusRepository refReservationStatusRepository;

    @Autowired
    private ReservationRepository reservationRepository;

}
