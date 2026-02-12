package com.example.listycity;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable<City> {
    /**
     * The name of the city
     */
    private String city;

    /**
     * The name of the province
     */
    private String province;

    /**
     * Constructor for City
     * @param city The name of the city
     * @param province The name of the province
     */
    City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * Get the city name
     * @return The name of the city
     */
    String getCityName(){
        return this.city;
    }

    /**
     * Get the province name
     * @return The name of the province
     */
    String getProvinceName(){
        return this.province;
    }

    /**
     * Compare this city with another city based on city name
     * @param o The object to compare
     * @return 0 if equal, negative if this city comes before, positive if after
     */
    @Override
    public int compareTo(City o) {
        return this.city.compareTo(o.getCityName());
    }
    /**
     * Check if this city equals another city
     * @param o The object to compare
     * @return true if cities are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City otherCity = (City) o;
        return city.equals(otherCity.city) && province.equals(otherCity.province);
    }

    /**
     * Generate hash code for the city
     * @return hash code based on city and province
     */
    @Override
    public int hashCode() {
        int result = city.hashCode();
        result = 31 * result + province.hashCode();
        return result;
    }
}
