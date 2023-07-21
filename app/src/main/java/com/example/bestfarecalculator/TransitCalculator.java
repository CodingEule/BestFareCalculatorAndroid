package com.example.bestfarecalculator;


public class TransitCalculator {
        int numberDays;
        int rides;
        double payPerRide;
        double unlimited7Days;
        double unlimited30Days;

        TransitCalculator(int days, int rides){
            this.numberDays = days;
            this.rides = rides;
        }
        double unlimited7Price(){
            double ticketsToBuy = Math.ceil(this.numberDays / 7.0);
            double priceTotal = ticketsToBuy * unlimited7Days;

            return priceTotal / this.rides;
        }
        double unlimited30Price(){
            double ticketsToBuy = Math.ceil(this.numberDays / 30.0);
            double priceTotal = ticketsToBuy * unlimited30Days;

            return priceTotal / this.rides;
        }
        double[] getRidePrices(){
            double[] prices = new double[3];
            prices[0] = payPerRide;
            prices[1] = this.unlimited7Price();
            prices[2] = this.unlimited30Price();
            return prices;
        }
        String getBestFare(){
            double[] prices = this.getRidePrices();
            int count = 0;
            double bestFare = 0;
            for (double price : prices) {
                System.out.println(price);
                if (bestFare > price || bestFare == 0) {
                    count++;
                    bestFare = price;

                }
            }
            switch (count) {
                case (1) : {
                    return "You should get the Pay-per-ride option at " + bestFare + " per ride";
                }
                case (2): {
                    return "You should get the 7 Day option at " + bestFare + " per ride";
                }
                case (3) : {
                    return "You should get the 30 Day option at " + bestFare + " per ride";
                }
                case(4) : {
                    return "You should get the Unlimited Days option at " + bestFare + " per ride";
                }
                default : {
                    return null;
                }
            }

        }
}
