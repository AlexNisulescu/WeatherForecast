package ro.mta.se.lab.model;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class LoggerTest {

    Logger data=new Logger();

    @Mock
    City mockcity;
    @Mock
    Weather mockweather;


    @Before
    public void setup(){
        when(mockweather.getCity()).thenReturn(mockcity);
    }

    @Test
    void getColsTest(){
        Throwable exception=assertThrows(IOException.class,
                ()->data.getCols("totallynotafile.txt"));
        assertEquals("The file you are trying to open doesn't exist", exception.getMessage());
    }

    @Test
    void checkExistenceTest() {

        City city=new City();
        city.setName("Bucuresti");
        Throwable exception=assertThrows(FileNotFoundException.class,
                ()->data.checkExistence(city, "nonexistent.txt"));
        assertEquals("The file you are trying to open doesn't exist",
                exception.getMessage());
    }


    @org.junit.Test(expected = FileNotFoundException.class)
    public void testCheckExistence() throws FileNotFoundException {
        City city=new City();
        city.setName("Bucuresti");
        data.checkExistence(city, "notafile.txt");
    }
}