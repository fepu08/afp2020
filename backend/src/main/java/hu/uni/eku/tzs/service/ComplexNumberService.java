package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.model.ComplexNumber;
import hu.uni.eku.tzs.service.exceptions.ComplexNumberAlreadyExistsException;

import java.util.Collection;

public interface ComplexNumberService {

    void record(ComplexNumber complexNumber) throws ComplexNumberAlreadyExistsException;

    Collection<ComplexNumber> readAll();
}
