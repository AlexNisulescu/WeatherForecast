package ro.mta.se.lab.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

public class LoggerMockitoTest {

    private Logger testLog=new Logger();

    @Test (expected = FileNotFoundException.class)
    public void testCheckExistence() throws FileNotFoundException {
        City city=new City();
        city.setName("Bucuresti");
        testLog.checkExistence(city, "notafile.txt");
    }
}