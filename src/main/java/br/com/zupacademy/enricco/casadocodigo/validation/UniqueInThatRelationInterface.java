package br.com.zupacademy.enricco.casadocodigo.validation;

public interface UniqueInThatRelationInterface<U,R> {
    public U getUniqueValue();

    public R getRelationValue();
}
