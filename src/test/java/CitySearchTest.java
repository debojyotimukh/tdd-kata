import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CitySearchTest {
    @Test
    public void testSearchAll() {
        String expected = "Paris, Budapest, Skopje, Rotterdam, Valencia, Vancouver, Amsterdam, Vienna, Sydney, New York City, London, Bangkok, Hong Kong, Dubai, Rome, Istanbul";
        Assertions.assertEquals(expected, CitySearch.search("*"));
    }

    @Test
    public void testLessThanTwoCharacters() {
        Assertions.assertEquals("", CitySearch.search("a"));
    }

    @Test
    public void testSearch() {
        Assertions.assertEquals("Valencia, Vancouver", CitySearch.search("Va"));
    }

    @Test
    public void testSearchCaseInsensitive() {
        Assertions.assertEquals("Valencia, Vancouver", CitySearch.search("va"));
    }

    @Test
    public void testSearch2() {
        Assertions.assertEquals("Budapest", CitySearch.search("ape"));
    }
}
