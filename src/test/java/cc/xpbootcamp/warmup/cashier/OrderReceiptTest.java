package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Spy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

class OrderReceiptTest {
    @Test
    void shouldPrintCustomerInformationOnOrder() {
        Order order = new Order("Mr X", "Chicago, 60601", new ArrayList<LineItem>());
        OrderReceipt receipt = new OrderReceipt(order);

        String output = receipt.printReceipt();


        assertThat(output, containsString("Mr X"));
        assertThat(output, containsString("Chicago, 60601"));
    }

    @Test
    public void shouldPrintLineItemAndSalesTaxInformation() throws ParseException {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("milk", 10.0, 2));
            add(new LineItem("biscuits", 5.0, 5));
            add(new LineItem("chocolate", 20.0, 1));
        }};
        Order order = spy(new Order(null, null, lineItems));
        OrderReceipt receipt = new OrderReceipt(order);

        doReturn(new SimpleDateFormat("yyyy-MM-dd").parse("2020-02-18")).when(order).getDate();

        String output = receipt.printReceipt();

        assertThat(output, containsString("======老王超市，值得信赖======\n"));
        assertThat(output, containsString("2020年02月18日, Tue\n"));
        assertThat(output, containsString("milk, 10.0 * 2, 20.0\n"));
        assertThat(output, containsString("biscuits, 5.0 * 5, 25.0\n"));
        assertThat(output, containsString("chocolate, 20.0 * 1, 20.0\n"));
        assertThat(output, containsString("Sales Tax: 6.5"));
        assertThat(output, containsString("Total Amount: 71.5"));

//        assertEquals(output, "");
    }

}
