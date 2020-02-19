package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

class OrderReceiptTest {
    @Test
    void shouldPrintHeaderInformationOnOrder() {
        Order order = new Order("Mr X", "Chicago, 60601", new ArrayList<LineItem>());
        OrderReceipt receipt = new OrderReceipt(order);

        String output = receipt.printReceipt();

        assertThat(output, containsString("======老王超市，值得信赖======\n"));
    }

    @Test
    public void shouldPrintLineItemAndSalesTaxInformation() throws ParseException {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("巧克力", 21.50, 2));
            add(new LineItem("小白菜", 10.00, 1));
        }};
        Order order = spy(new Order(null, null, lineItems));
        OrderReceipt receipt = new OrderReceipt(order);

        doReturn(new SimpleDateFormat("yyyy-MM-dd").parse("2020-02-18")).when(order).getDate();

        String output = receipt.printReceipt();

        assertThat(output, containsString("======老王超市，值得信赖======\n"));
        assertThat(output, containsString("2020年02月18日, Tue\n"));
        assertThat(output, containsString("巧克力, 21.5 * 2, 43.0\n"));
        assertThat(output, containsString("小白菜, 10.0 * 1, 10.0\n"));
        assertThat(output, containsString("Sales Tax: 5.30"));
        assertThat(output, containsString("Total Amount: 58.30"));
    }

    @Test
    public void shouldPrintLineItemAndSalesTaxAndDiscountInformationWhenWednesday() throws ParseException {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("巧克力", 21.50, 2));
            add(new LineItem("小白菜", 10.00, 1));
        }};
        Order order = spy(new Order(null, null, lineItems));
        OrderReceipt receipt = new OrderReceipt(order);

        doReturn(new SimpleDateFormat("yyyy-MM-dd").parse("2020-02-19")).when(order).getDate();

        String output = receipt.printReceipt();

        assertThat(output, containsString("======老王超市，值得信赖======\n"));
        assertThat(output, containsString("2020年02月19日, Wed\n"));
        assertThat(output, containsString("巧克力, 21.5 * 2, 43.0\n"));
        assertThat(output, containsString("小白菜, 10.0 * 1, 10.0\n"));
        assertThat(output, containsString("Sales Tax: 5.30"));
        assertThat(output, containsString("Discount: 1.17"));
        assertThat(output, containsString("Total Amount: 57.13"));
    }
}
