package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.dao.ComplexNumberDao;
import hu.uni.eku.tzs.model.ComplexNumber;
import hu.uni.eku.tzs.service.exceptions.ComplexNumberAlreadyExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class ComplexNumberServiceImplTest {

    private final ComplexNumberDao dao = mock(ComplexNumberDao.class);
    private ComplexNumberService service;


    @BeforeEach
    void setUp() {
        Mockito.reset(dao);
        service = new ComplexNumberServiceImpl(dao);
    }

    @Test
    void record() throws ComplexNumberAlreadyExistsException {
        ComplexNumber complexNumber = new ComplexNumber(0,0);
        service.record(complexNumber);
        verify(dao).create(any());
    }

    @Test
    void recordExistingComplexNumber() {
        ComplexNumber complexNumber = new ComplexNumber(0,0);
        when(dao.readAll()).thenReturn(List.of(complexNumber));
        assertThrows(ComplexNumberAlreadyExistsException.class, () -> service.record(complexNumber));
        verify(dao, never()).create(any());
    }

    @Test
    void readAll() {
        Collection<ComplexNumber> daoResponse = List.of(
                new ComplexNumber(0,0),
                new ComplexNumber(1,0),
                new ComplexNumber(0,1),
                new ComplexNumber(1,1)
        );
        when(dao.readAll()).thenReturn(daoResponse);

        Collection<ComplexNumber> actual = service.readAll();

        assertEquals(daoResponse,actual);
    }
}