package com.sahil.Week7.TestingApp;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Slf4j
class TestingAppApplicationTests {

    @BeforeEach
    void setUp(){
        log.info("Starting the method, setting up config");
    }

    @AfterEach
    void tearDown(){
        log.info("Tearing down the method");
    }

    @BeforeAll
    static void setUpOnce(){
        log.info("Setup Once ....");
    }

    @AfterAll
    static void tearDownOnce(){
        log.info("Tearing down all ....");
    }

	@Test
//    @Disabled
	void testNumberOne() {
        int a = 5;
        int b = 3;
        int result = addTwoNumber(a,b);

//        Assertions.assertEquals(8,result);
//        assertThat(result)
//                .isEqualTo(8)
//                .isCloseTo(9, Offset.offset(1));

        assertThat("Apple")
                .isEqualTo("Apple")
                .startsWith("App")
                .endsWith("l")
                .hasSize(3);

	}

    int addTwoNumber(int a, int b){
        return a+b;
    }

    @Test
//    @DisplayName("displayTestNameTwo")
    void testDivideTwoNumbers_whenDenominatorIsZero_ThenArithmeticException(){

        int a = 5;
        int b = 0;

//        double result = divideTwoNumber(a,b);
//        System.out.println(result);
        assertThatThrownBy(()-> divideTwoNumber(a,b))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Tried to divide by zero");
    }

    double divideTwoNumber(int a , int b){
        try{
            return a/b;
        } catch (ArithmeticException e) {
            log.error("Arithmethic Exception occurred: "+ e.getLocalizedMessage());
            throw new ArithmeticException("Tried to divide by zero");
        }
    }
}
