package com.lyshnia.pcari.ui.util.converters;

import com.vaadin.flow.templatemodel.ModelEncoder;

import java.time.LocalDate;

import static com.lyshnia.pcari.ui.util.FormattingUtils.FULL_DATE_FORMATTER;
import static com.lyshnia.pcari.ui.util.dataproviders.DataProviderUtil.convertIfNotNull;


public class LocalDateConverter implements ModelEncoder<LocalDate, String> {


    private static final LocalTimeConverter TIME_FORMATTER = new LocalTimeConverter();

    @Override
    public String encode(LocalDate modelValue) {
        return convertIfNotNull(modelValue,
                FULL_DATE_FORMATTER::format);
    }

    @Override
    public LocalDate decode(String presentationValue) {
        throw new UnsupportedOperationException();
    }
}
