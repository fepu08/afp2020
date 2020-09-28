package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.model.ComplexNumber;

import java.util.Collection;

public interface ComplexNumberDao {

    void create(ComplexNumber complexNumber);

    Collection<ComplexNumber> readAll();

    void update(ComplexNumber original, ComplexNumber updated);

    void delete(ComplexNumber complexNumber);
}
