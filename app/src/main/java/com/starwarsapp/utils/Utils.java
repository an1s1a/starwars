package com.starwarsapp.utils;

import com.starwarsapp.data.model.People;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Utils {

    public static ArrayList<People> sortByName(ArrayList<People> people) {
        if (people == null || people.isEmpty()) {
            return null;
        }

        Collections.sort(people, new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                return o1.name.compareToIgnoreCase(o2.name);
            }
        });
        return people;
    }

    public static ArrayList<People> sortByBirth(ArrayList<People> people) {
        if (people == null || people.isEmpty()) {
            return null;
        }

        Collections.sort(people, new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                o1.setBirthFloat(trimBirthYear(o1.birthYear));
                o2.setBirthFloat(trimBirthYear(o2.birthYear));
                return Float.compare(o2.birthFloat, o1.birthFloat);
            }
        });
        return people;
    }

    public static ArrayList<People> sortByFavourite(ArrayList<People> people) {
        if (people == null || people.isEmpty()) {
            return null;
        }

        Collections.sort(people, new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                int value1 = (String.valueOf(o2.isFavourite)).compareTo(String.valueOf(o1.isFavourite));
                if (value1 == 0) {
                    return o1.name.compareToIgnoreCase(o2.name);
                } else return value1;
            }
        });
        return people;
    }

    private static float trimBirthYear(String birthString) {
        String years = "";
        if (!birthString.equals("unknown")) {
            for (int i = 0; i < birthString.length(); i++) {
                if (Character.isDigit(birthString.charAt(i))) {
                    years = birthString.substring(0, i + 1);
                }

            }
            return Float.parseFloat(years);
        }
        return 0;

    }

    public static String trimUrl(String url) {
        boolean isNumber = true;
        int urlLength = url.length() - 2;
        String test = "";
        while (isNumber) {

            if (Character.isDigit(url.charAt(urlLength))) {
                urlLength--;
            } else {
                isNumber = false;
                test = url.substring(urlLength + 1, url.length() - 1);
            }
        }
        return test;
    }
}
