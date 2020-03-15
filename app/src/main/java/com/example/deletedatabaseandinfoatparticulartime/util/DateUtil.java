package com.example.deletedatabaseandinfoatparticulartime.util;

import java.util.Date;

public class DateUtil {

    public static boolean checkBetween(Date dateToCheck, Date startDate, Date endDate) {
        return dateToCheck.compareTo(startDate) >= 0 && dateToCheck.compareTo(endDate) <=0;
    }
}
