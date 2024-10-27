package io.github.Ital023.MovieflixDesafioItal023.controllers.dto;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorDTO extends StandardErrorDTO{

    private List<FieldMessage> err = new ArrayList<>();

    public void addError(String FieldName, String message) {
        err.add(new FieldMessage(FieldName, message));
    }

    public List<FieldMessage> getErr() {
        return err;
    }

}
