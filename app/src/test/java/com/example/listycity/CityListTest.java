package com.example.listycity;

import org.junit.Test;
import static org.junit.Assert.*;

public class CityListTest {

    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        cityList.add(city);
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();

        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    public void testHasCity() {
        CityList cityList = mockCityList();
        City city = new City("Edmonton", "Alberta");
        assertTrue(cityList.hasCity(city));
    }

    @Test
    public void testHasCityNotFound() {
        CityList cityList = mockCityList();
        City notInList = new City("Vancouver", "British Columbia");
        assertFalse(cityList.hasCity(notInList));
    }

    @Test
    public void testDelete() {
        CityList cityList = mockCityList();
        City city = mockCity();

        assertEquals(1, cityList.countCities());
        assertTrue(cityList.hasCity(city));

        cityList.delete(city);

        assertEquals(0, cityList.countCities());
        assertFalse(cityList.hasCity(city));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteException() {
        CityList cityList = mockCityList();
        City city = new City("Vancouver", "British Columbia");
        cityList.delete(city);
    }

    @Test
    public void testCountCities() {
        CityList cityList = new CityList();

        assertEquals(0, cityList.countCities());

        cityList.add(mockCity());
        assertEquals(1, cityList.countCities());

        City city = new City("Toronto", "Ontario");
        cityList.add(city);
        assertEquals(2, cityList.countCities());

        cityList.delete(city);
        assertEquals(1, cityList.countCities());
    }
}
