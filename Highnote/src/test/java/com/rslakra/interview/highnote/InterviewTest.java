package com.rslakra.interview.highnote;

import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Rohtash Lakra
 * @created 4/29/22 12:43 PM
 */
public class InterviewTest {

    // LOGGER
    private static final Logger LOGGER = LoggerFactory.getLogger(InterviewTest.class);

    private Interview interview;

    @BeforeTest
    public void initObject() {
        LOGGER.debug("+initObject()");
        interview = new Interview();
        assertNotNull(interview);
        LOGGER.debug("{}", interview);
        LOGGER.debug("-initObject()");
    }

    @Test
    public void testInterview() {
        LOGGER.debug("+testInterview()");
        assertEquals(2023, interview.getYear());
        assertEquals("Rohtash", interview.getName());
        LOGGER.debug("-testInterview()");
    }

    @Test
    public void testMockito() {
        LOGGER.debug("+testInterview()");
        Interview mockInterview = Mockito.mock(Interview.class);
//        Mockito.when()

//        Mockito.verify(mockInterview).getName()
        assertEquals(2023, mockInterview.getYear());
        assertEquals("Rohtash", mockInterview.getName());
        LOGGER.debug("-testInterview()");
    }

}
