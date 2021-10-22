package com.katadiamondtdd.katadiamond;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import testasyouthink.TestAsYouThink;

import static testasyouthink.TestAsYouThink.whenOutsideOperatingConditions;


class DiamondTest {

    @Nested
    class Valid_Letter {

            @Test
            void create_a_diamond_if_A() {
            	TestAsYouThink.resultOf(() -> Diamond.draw("A")).isEqualTo("A");
            }

            @Test
            void create_a_diamond_if_B() {
                TestAsYouThink.resultOf(() -> Diamond.draw("B")).isEqualTo(" A\n" //
                        + "B B\n" //
                        + " A");
            }

            @Test
            void create_a_diamond_if_C() {
            	TestAsYouThink.resultOf(() -> Diamond.draw("C")).isEqualTo("  A\n" //
                        + " B B\n" //
                        + "C   C\n" //
                        + " B B\n" //
                        + "  A");
            }

        }

    @Nested
    class Invalid_Letter {

        @Test
        void fail_to_create_a_diamond_if_null() {
            whenOutsideOperatingConditions(() -> Diamond.draw(null))
                    .thenItFails()
                    .becauseOf(IllegalArgumentException.class)
                    .withMessage("Letter missing!");
        }

        @Test
        void fail_to_create_a_diamond_if_no_letter() {
            whenOutsideOperatingConditions(() -> Diamond.draw(""))
                    .thenItFails()
                    .becauseOf(IllegalArgumentException.class)
                    .withMessage("A letter is expected!");
        }

        @Test
        void fail_to_create_a_diamond_if_anything_but_a_letter() {
            whenOutsideOperatingConditions(() -> Diamond.draw("5"))
                    .thenItFails()
                    .becauseOf(IllegalArgumentException.class)
                    .withMessage("Only letters are expected!");
        }

        @Test
        void fail_to_create_a_diamond_if_several_letters() {
            whenOutsideOperatingConditions(() -> Diamond.draw("AB"))
                    .thenItFails()
                    .becauseOf(IllegalArgumentException.class)
                    .withMessage("Only one letter is expected!");
        }
    }
}