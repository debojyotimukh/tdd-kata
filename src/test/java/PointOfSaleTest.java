import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PointOfSaleTest {

    @Test
    public void testBarcodeEmpty() {
        Assertions.assertEquals("Error: empty barcode", PointOfSale.getDisplayPrice(""));
    }

    @Test
    public void testBarcode12345() {
        Assertions.assertEquals("$7.25", PointOfSale.getDisplayPrice("12345"));
    }

    @Test
    public void testBarcode23456() {
        Assertions.assertEquals("$12.50", PointOfSale.getDisplayPrice("23456"));
    }

    @Test
    public void testBarcode99999() {
        Assertions.assertEquals("Error: barcode not found", PointOfSale.getDisplayPrice("99999"));
    }

    @Test
    public void testTotal() {
        Assertions.assertEquals("$19.75", PointOfSale.total("12345", "23456"));
    }

    @Test
    public void testTotalWithError() {
        Assertions.assertEquals("$12.50", PointOfSale.total("99999", "23456"));
    }
}
