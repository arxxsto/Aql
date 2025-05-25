package org.example;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class OrderControllerTest {
    private OrderController orderController;
    @Mock
    private OrderService mockOrderService;
    @Mock
    private OrderDao mockOrderDao;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        orderController = new OrderController(mockOrderService);
    }
    @Test
    public void test_CreateOrder_Success() {

        Order order = new Order(1,"basset",19);
        when(mockOrderService.createOrder(order)).thenReturn(true);
        boolean result = orderController.createOrder(order);
        verify(mockOrderService).createOrder(order);
        assertTrue(result);
    }



    @Test
    public void test_CreateOrder_Failure() {
        Order order = new Order(1,"ghirai_abdelbasset",2000);
        when(mockOrderService.createOrder(order)).thenReturn(false);
        boolean result = orderController.createOrder(order);
        verify(mockOrderService).createOrder(order);
        assertFalse(result);
    }
    @Test
    public void test_CreateOrder_FailureToSave() {
        OrderService orderService = new OrderService(mockOrderDao);
        Order order = new Order(1,"basset",19);
        when(mockOrderDao.saveOrder(order)).thenReturn(false);
        boolean result = orderService.createOrder(order);
        verify(mockOrderDao).saveOrder(order);
        assertFalse(result);
    }



}