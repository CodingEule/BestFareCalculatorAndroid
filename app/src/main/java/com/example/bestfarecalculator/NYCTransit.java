package com.example.bestfarecalculator;

public class NYCTransit extends TransitCalculator{

    NYCTransit(int days, int rides) {
        super(days, rides);
        this.payPerRide = 2.75;
        this.unlimited7Days =33.00;
        this.unlimited30Days= 127.00;
    }
}

