import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.example.simpleparadox.listycity.City;
import com.example.simpleparadox.listycity.CustomList;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    @Before
    public void createList(){
        list = new CustomList(null, new ArrayList<City>());
    }

    @Test
    public void addCityTest(){
        int listSize = list.getCount();
        list.addCity(new City("Halifax", "NS"));
        assertEquals(list.getCount(), listSize+1);
    }

    @Test
    public void hasCityTest(){
        City city = new City("Charlottetown", "Prince Edward Island");

        list.addCity(city);
        assertTrue(list.hasCity(city));
    }

    @Test
    public void deleteCityTest(){
        int listSize = list.getCount();
        City city = new City("Halifax", "NS");
        list.addCity(city);
        list.deleteCity(city);
        assertEquals(list.getCount(), listSize);
    }

    @Test
    public void countCitiesTest(){
        City city = new City("Regina", "Saskatchewan");
        list.addCity(city);
        assertEquals(1, list.countCities());

        City city1 = new City("Halifax", "NS");
        list.addCity(city1);
        assertEquals(2, list.countCities());

        list.deleteCity(city);
        assertEquals(1, list.countCities());
    }
}
