package cc.xpbootcamp.warmup.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Util {
    public static String formatMoney(double money) {
        DecimalFormat moneyFormat = new DecimalFormat("#.00");
        return moneyFormat.format(money);
    }

    public static String getFormatDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日, EEEE\n\r", Locale.CHINA);

        return simpleDateFormat.format(date);
    }

    public static int getCurrentWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }
}
