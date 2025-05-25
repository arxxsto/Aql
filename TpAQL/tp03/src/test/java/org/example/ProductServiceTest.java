package org.example;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;


public class ProductServiceTest {

    private ProductService productService;
    private ProductApiClient productApiClient;

    @Before
    public void setUp() {
        productApiClient = mock(ProductApiClient.class);
        productService = new ProductService(productApiClient);
    }

    @Test
    public void testGetProduct_Success() {
        String productId = "12";
        Product expectedProduct = new Product(productId, "Sample Product", 200.0);
        when(productApiClient.getProduct(productId)).thenReturn(expectedProduct);
        Product actualProduct = productService.getProduct(productId);
        assertEquals(expectedProduct, actualProduct);
        verify(productApiClient, times(1)).getProduct(productId);
    }

    @Test(expected = RuntimeException.class)
    public void testGetProduct_APIFailure() {
        String productId = "56";
        when(productApiClient.getProduct(productId)).thenThrow(new RuntimeException("API unavailable"));
        productService.getProduct(productId);
    }

    @Test
    public void testGetProduct_IncompatibleDataFormat() {
        String productId = "56";
        when(productApiClient.getProduct(productId)).thenReturn(null);
        Product actualProduct = productService.getProduct(productId);
        assertNull(actualProduct); // We expect null when data format is incompatible
        verify(productApiClient, times(1)).getProduct(productId);
    }



}