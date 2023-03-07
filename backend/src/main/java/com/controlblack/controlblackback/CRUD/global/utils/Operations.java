package com.controlblack.controlblackback.CRUD.global.utils;

import org.springframework.data.mongodb.core.aggregation.StringOperators.ReplaceAll;

public class Operations {

    public static String trimBrackets(String message) {
        return message.replaceAll("[\\[\\]]", "");
    }
}
