package ro.mta.se.lab.model;

import org.junit.jupiter.api.Test;
import static junit.framework.TestCase.assertEquals;

class CityTest {
    private City city;
    @Test
    void getId() {
        city=new City();
        city.setId(123);
        assertEquals(123, city.getId());
    }

    @Test
    void getName() {
        city=new City();
        city.setName("Las Fierbinti");
        assertEquals("Las Fierbinti", city.getName());
    }

    @Test
    void getLat() {
        city=new City();
        city.setLat((float) 123.4);
        assertEquals((float) 123.4, city.getLat());
    }

    @Test
    void getLon() {
        city=new City();
        city.setLon((float) 123.4);
        assertEquals((float) 123.4, city.getLon());
    }

    @Test
    void getCountryCode() {
        city=new City();
        city.setCountryCode("RO");
        assertEquals("RO", city.getCountryCode());
    }
}