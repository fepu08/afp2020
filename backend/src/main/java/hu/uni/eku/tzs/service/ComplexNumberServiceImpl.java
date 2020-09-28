package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.dao.ComplexNumberDao;
import hu.uni.eku.tzs.model.ComplexNumber;
import hu.uni.eku.tzs.service.exceptions.ComplexNumberAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
@Service
public class ComplexNumberServiceImpl implements ComplexNumberService {

    private final ComplexNumberDao dao;

    @Override
    public void record(ComplexNumber complexNumber) throws ComplexNumberAlreadyExistsException {
        final boolean isAlreadyRecorded = dao.readAll()
                .stream()
                .anyMatch( cn ->
                                cn.getReal() == complexNumber.getReal()
                                &&
                                cn.getImaginary() == complexNumber.getImaginary());
        if(isAlreadyRecorded){
            log.info("Complex Number {} is already recorded!", complexNumber);
            throw new ComplexNumberAlreadyExistsException(String.format("Complex Number (%s) already exists!", complexNumber.toString()));

        }
        dao.create(complexNumber);
    }

    @Override
    public Collection<ComplexNumber> readAll() {
        return dao.readAll();
    }
}
