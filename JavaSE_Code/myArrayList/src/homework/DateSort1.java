package homework;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create :  2020-06-02
 */
public class DateSort1 {

    public static void main(String[] args) {

        final Random random = new Random();

        final Calendar calendar = Calendar.getInstance();

        final Date[] dates = new Date[5];

        // 使用循环对 dates 数组进行初始化
        for (int i = 0; i < dates.length; i++) {
            // 随机产生 年份、月份、日期，并将其设置到 calendar 对象中
            int year = random.nextInt(2048) + 1;
            int month = random.nextInt(12) + 1;
            int day = 0;
            switch (month) {
                case 2:
                    if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                        day = random.nextInt(29) + 1;
                    } else {
                        day = random.nextInt(28) + 1;
                    }
                    break;

                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    day = random.nextInt(31) + 1;
                    break;

                default:
                    day = random.nextInt(30) + 1;
                    break;
            }
            calendar.set(year, month, day, 0, 0, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            // 随后使用 calendar 的 getTime 来获取 Date 实例
            Date date = calendar.getTime();
            dates[i] = date;
        }

        // 使用循环输出排序前的日期
        for (int i = 0; i < dates.length; i++) {
            System.out.println(dates[i]);
        }
        // 使用 Date 类提供的方法，对日期进行比较并排序
        for (int i = 0; i < dates.length - 1; i++) {
            for (int j = 0; j < dates.length - 1 - i; j++)
                if (dates[i].compareTo(dates[i + 1]) > 0) {
                    Date temp = dates[i];
                    dates[i] = dates[i + 1];
                    dates[i + 1] = temp;
                }
        }
        System.out.println("--------------------");
        // 使用循环输出排序后的日期
        for (int i = 0; i < dates.length; i++) {
            System.out.println(dates[i]);
        }

    }
}