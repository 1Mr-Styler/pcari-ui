package com.lyshnia.pcari.ui.util.converters;

import com.lyshnia.pcari.ui.util.FormattingUtils;
import com.lyshnia.pcari.ui.util.dataproviders.DataProviderUtil;
import com.vaadin.flow.templatemodel.ModelEncoder;

public class CurrencyFormatter implements ModelEncoder<Integer, String> {

    @Override
    public String encode(Integer modelValue) {
        return DataProviderUtil.convertIfNotNull(modelValue, FormattingUtils::formatAsCurrency);
    }

    @Override
    public Integer decode(String presentationValue) {
        throw new UnsupportedOperationException();
    }
}
