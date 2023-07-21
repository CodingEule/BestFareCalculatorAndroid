package com.example.bestfarecalculator;

public class SyltSVG extends TransitCalculator{

    boolean spar;
    int zone;

    final double[] payPerRideZones = {2.35, 2.95, 4.20, 5.40, 6.60, 7.45, 8.60};
    final double[] payPerRideZonesSpar = {2.00, 2.50, 3.60, 4.55, 5.65, 6.35, 7.30};
    final double[] unlimitedDays = {10.90, 20.20, 28.70, 37.30, 45.50, 53.20, 58.00};
    final double[] unlimited7DaysZones = {13.00, 19.80, 27.70, 36.10, 43.30, 50.60, 58.00};
    final double[] unlimited30DaysZones = {36.90, 64.60, 99.30, 126.30, 139.00, 151.00, 164.00};



    SyltSVG(int days, int rides, int zone, boolean spar) {
        super(days, rides);
        this.zone = zone;
        this.spar = spar;
        this.payPerRidePrice();


    }
    void payPerRidePrice(){
        if(this.spar){
            this.payPerRide = payPerRideZonesSpar[zone-1];
        }else{
            this.payPerRide = payPerRideZones[zone-1];
        }
    }
    double unlimitedDaysPrice() {
        double price = 0;
        if (numberDays < unlimitedDays.length) {
            price = unlimitedDays[numberDays];
        } else {
            int i = numberDays;
            while (i > 0) {
                if (i < 7) {
                    price += unlimitedDays[i];
                    i-= i;
                } else {
                    price += unlimitedDays[6];
                    i -= 7;
                }
            }
        }
        return price / this.rides;
    }
    @Override
    double unlimited7Price(){
        this.unlimited7Days = unlimited7DaysZones[this.zone-1];
        return super.unlimited7Price();
    }
    @Override
    double unlimited30Price(){
        this.unlimited30Days = unlimited30DaysZones[this.zone-1];
        return super.unlimited30Price();
    }
    @Override
    double[] getRidePrices(){
        double[] prices0 = super.getRidePrices();
        double[] prices = new double[4];
        System.arraycopy(prices0, 0, prices, 0, prices0.length);
        prices[3]= this.unlimitedDaysPrice();
        /* 0 = payPerRide
        1= unlimited7Price
        2= unlimited30Price
        3= unlimitedDaysPrice
         */
        return prices;
    }

}

