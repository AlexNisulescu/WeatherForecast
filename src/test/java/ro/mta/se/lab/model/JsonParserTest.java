package ro.mta.se.lab.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class JsonParserTest {

    @Mock
    Weather mockweather;
    @Mock
    City mockcity;
    @InjectMocks
    JsonParser parser;

    @Before
    public void setup(){
        when(mockweather.getCity()).thenReturn(mockcity);
    }

    @Test
    public void getWeather() {
        assertSame(parser.getWeather(), mockweather);
    }

    @Test
    public void getCity(){
        assertSame(parser.getWeather().getCity(), mockcity);
    }
}