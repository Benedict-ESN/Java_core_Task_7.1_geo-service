package ru.netology.geo;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.*;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class GeoServiceImplTest {

    @Test
    public void testByIpRussianIp() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location location = geoService.byIp("172.0.32.11");
        System.out.println(location.toString());
        assertEquals(new Location("Moscow", Country.RUSSIA, "Lenina", 15), location);
    }
    @Test
    public void testByIpAmericanIp() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location location = geoService.byIp("96.44.183.149");
        assertEquals(new Location("New York", Country.USA, " 10th Avenue", 32), location);
    }

    @Test
    public void testByIpUnknownIp() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location location = geoService.byIp("203.0.113.195");
        assertNull(location);
    }

}