import java.util.HashMap;

public class PointOfSale {

    private static HashMap<String, String> priceMap = new HashMap<>();

    static {
        priceMap.put("12345", "7.25");
        priceMap.put("23456", "12.50");
    }

    public static String getDisplayPrice(String barcode) {
        String result = "Error: empty barcode";
        String price = priceMap.get(barcode);
        if (!barcode.isEmpty()) {
            result = price == null ? "Error: barcode not found" : "$" + price;
        }

        return result;
    }

    public static String total(String... barcodes) {
        double result = 0.0;
        for (String barcode : barcodes) {
            String priceStr = getDisplayPrice(barcode).replace("$", "");
            double price = priceStr.contains("Error") ? 0.0 : Double.parseDouble(priceStr);
            result = result + price;
        }
        return "$" + String.format("%.2f", result);
    }
}
