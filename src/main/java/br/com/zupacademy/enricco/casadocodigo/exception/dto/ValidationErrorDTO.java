package br.com.zupacademy.enricco.casadocodigo.exception.dto;


public class ValidationErrorDTO {
    private String field;
    private String errorMessage;

    public ValidationErrorDTO(String field, String errorMessage) {
        this.field = field;
        this.errorMessage = errorMessage;
    }

    public String getField() {
        return field;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
