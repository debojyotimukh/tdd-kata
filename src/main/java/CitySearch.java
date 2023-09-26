public class CitySearch {
    private static final String database = "Paris, Budapest, Skopje, Rotterdam, Valencia, Vancouver, Amsterdam, Vienna, Sydney, New York City, London, Bangkok, Hong Kong, Dubai, Rome, Istanbul";

    private static final String SEPARATOR = ", ";

    public static String search(String text) {
        String result = "";

        if (text.length() >= 2) {
            String[] cities = database.split(SEPARATOR);
            for (String city : cities) {
                if (city.toLowerCase().contains(text.toLowerCase())) {
                    result = result.isEmpty() ? city : result + SEPARATOR + city;
                }
            }
        }

        return "*".equals(text) ? database : result;
    }
}
