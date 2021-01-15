package ro.mta.se.lab.model;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class LoggerTest {

    @Test
    void checkExistence() {
        Logger data=new Logger();
        City city=new City();
        city.setName("Bucuresti");
        Throwable exception=assertThrows(FileNotFoundException.class, ()->data.checkExistence(city, "nonexistent.txt"));
        assertEquals("The file you are trying to open doesn't exist", exception.getMessage());
    }
}