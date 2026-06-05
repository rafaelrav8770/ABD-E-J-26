package com.microservice.student;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogExample {

    private static final Logger logger =
            Logger.getLogger(LogExample.class.getName());

    public static void main(String[] args) {

        try {

            logger.info("Iniciando procesamiento de datos");

            int resultado = 10 / 0;

        } catch (ArithmeticException e) {

            logger.log(Level.SEVERE,
                    "Errors matemático detectado", e);

        }
    }
}