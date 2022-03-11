import static org.junit.Assert.*;

import com.example.simpleparadox.listycity.City;
import com.example.simpleparadox.listycity.CustomList;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void createList(){
        list = new CustomList(null, new ArrayList<City>());
    }

    @Test
    public void addCityTest(){
        int listSize = list.getCount(); //4
        list.addCity(new City("Halifax", "NS"));
        assertEquals(list.getCount(), listSize+1); //5
    }

    @Test
    public void hasCityTest(){
        City city = new City("Rome", "IT");
        list.addCity(city);
        assertEquals(1, list.hasCity(city));
        assertEquals(0, list.hasCity(new City("Calgary", "AB")));
    }

    @Test
    public void deleteCityTest() {
        final City city = new City("London", "GB");
        list.addCity(city);
        list.deleteCity(city);
        assertEquals(0, list.getCount());
        exceptionRule.expect(IllegalArgumentException.class);
        list.deleteCity(city);
    }

    @Test
    public void countCitiesTest(){
        City city = new City("Athens", "Gr");
        City city2 = new City("Constantinople", "Bz");
        list.addCity(city);
        assertEquals(1, list.countCities());
        list.addCity(city2);
        assertEquals(2, list.countCities());
    }
}
