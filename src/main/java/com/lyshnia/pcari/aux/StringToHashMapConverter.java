package com.lyshnia.pcari.aux;

import com.vaadin.flow.data.binder.Result;
import com.vaadin.flow.data.binder.ValueContext;
import com.vaadin.flow.data.converter.Converter;

import java.util.HashSet;

abstract class StringToHashMapConverter implements Converter<String, HashSet> {
    @Override
    public Result<HashSet> convertToModel(String fieldValue, ValueContext context) {
        // Produces a converted value or an error
        try {
            // ok is a static helper method that creates a Result
            return Result.ok(new HashSet());
//                return Result.ok(Integer.valueOf(fieldValue));
        } catch (NumberFormatException e) {
            // error is a static helper method that creates a Result
            return Result.error("");
        }
    }

    @Override
    public String convertToPresentation(HashSet integer, ValueContext context) {
        // Converting to the field type should always succeed,
        // so there is no support for returning an error Result.
        return integer.toString();
    }


}
