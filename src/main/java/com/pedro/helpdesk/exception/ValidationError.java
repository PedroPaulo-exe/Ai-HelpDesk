package com.pedro.helpdesk.exception;

import org.apache.logging.log4j.message.Message;
import org.hibernate.validator.constraints.kor.KorRRN;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StanderError {
    private static final long serialVersionUID = 1L;

    private List<FieldMessage> fieldMessagesErros = new ArrayList<>();

    public ValidationError(Long timestamp,Integer status, String error, String message, String path ) {
        super(timestamp, status, error, path);
    }

    public List<FieldMessage> getFieldMessagesErros() {
        return fieldMessagesErros;
    }

    public void addErros(String field, String message) {
        this.fieldMessagesErros.add(new FieldMessage(field, message));
    }
}
