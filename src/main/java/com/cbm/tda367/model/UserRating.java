package com.cbm.tda367.model;

public class UserRating implements Prototype<UserRating> {
    private double totalRating;
    private int sumOfRatings;
    private int nrRatings;

    public UserRating(double totalRating, int sumOfRatings, int nrRatings) {
        this.totalRating = totalRating;
        this.sumOfRatings = sumOfRatings;
        this.nrRatings = nrRatings;
    }

    private UserRating(UserRating userRating) {
        this.totalRating = userRating.totalRating;
        this.sumOfRatings = userRating.sumOfRatings;
        this.nrRatings = userRating.nrRatings;
    }

    /**
     * Returns a safe copy of object.
     *
     * @return safe copy of object.
     */
    @Override
    public UserRating cloneObject() {
        return new UserRating(this);
    }

    /**
     * adds users rating and updates the total
     *
     * @param rating rating to be added to this total rating.
     */
    void addRating(int rating) {
        /* if provided rating is invalid, return */
        if (!(0 <= rating && rating <= 5)) {
            return;
        }
        /* add rating to total sum of ratings */
        sumOfRatings += rating;
        /* increment number of raters */
        nrRatings++;
        /* round rating to one decimal place and split the total sum according to number of ratings */
        totalRating = round((double) sumOfRatings / nrRatings, 1);
    }

    /**
     * Returns this rating.
     *
     * @return this rating.
     */
    public double getRating() {
        return totalRating;
    }

    /**
     * rounds a double to a certain precision
     *
     * @param value     double to be rounded.
     * @param precision precision to round the double according to.
     * @return rounded double.
     */
    private double round(double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }
}
