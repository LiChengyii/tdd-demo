package com.junit.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColourTest {

    public Colour colour;

    @DisplayName("test color value range")
    @Test
    public void testColorValueRange() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    colour = new Colour(Colour.DEFAULT_MODEL,-1, 0, 0);
                });
        assertThrows(IllegalArgumentException.class,
                () -> {
                    colour = new Colour(Colour.DEFAULT_MODEL,256, 0, 0);
                });
        assertThrows(IllegalArgumentException.class,
                () -> {
                    colour = new Colour(Colour.DEFAULT_MODEL,255, -1, 0);
                });
        assertThrows(IllegalArgumentException.class,
                () -> {
                    colour = new Colour(Colour.DEFAULT_MODEL,255, 256, 0);
                });
        assertThrows(IllegalArgumentException.class,
                () -> {
                    colour = new Colour(Colour.DEFAULT_MODEL,255, 255, -1);
                });
        assertThrows(IllegalArgumentException.class,
                () -> {
                    colour = new Colour(Colour.DEFAULT_MODEL,255, 255, 256);
                });
    }

    @DisplayName("Check that two objects are equal")
    @Test
    public void testColorEquals() {
        Colour colour1 = new Colour(Colour.DEFAULT_MODEL,255, 255, 0);
        Colour colour2 = new Colour(Colour.DEFAULT_MODEL,255, 251, 1);


        assertFalse(colour1.equals(colour2));

        Colour colour3 = new Colour(Colour.DEFAULT_MODEL,255, 255, 0);
        Colour colour4 = new Colour(Colour.DEFAULT_MODEL,255, 255, 0);

        assertTrue(colour3.equals(colour4));


        Colour colour5 = new Colour("RGB", 255, 255, 0);
        Colour colour6 = new Colour("XYZ", 255, 255, 0);

        assertFalse(colour5.equals(colour6));

        Colour colour7 = new Colour("RGB", 255, 255, 0);
        Colour colour8 = new Colour("RGB", 255, 255, 0);

        assertTrue(colour7.equals(colour8));


    }


}