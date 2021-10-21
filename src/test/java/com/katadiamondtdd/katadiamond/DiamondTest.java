package com.katadiamondtdd.katadiamond;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static testasyouthink.TestAsYouThink.resultOf;
import static testasyouthink.TestAsYouThink.whenOutsideOperatingConditions;


class DiamondTest {

    @Nested
    class Given_a_valid_letter {

            @Test
            void should_create_a_diamond_splinter_given_A() {
                resultOf(() -> Diamond.draw("A")).isEqualTo("A");
            }

            @Test
            void should_create_a_diamond_given_B() {
                resultOf(() -> Diamond.draw("B")).isEqualTo(" A\n" //
                        + "B B\n" //
                        + " A");
            }

            @Test
            void should_create_a_diamond_given_C() {
                resultOf(() -> Diamond.draw("C")).isEqualTo("  A\n" //
                        + " B B\n" //
                        + "C   C\n" //
                        + " B B\n" //
                        + "  A");
            }

        }

    @Nested
    class Given_an_invalid_letter {

        @Test
        void should_fail_to_create_a_diamond_given_nil() {
            whenOutsideOperatingConditions(() -> Diamond.draw(null))
                    .thenItFails()
                    .becauseOf(IllegalArgumentException.class)
                    .withMessage("Letter missing!");
        }

        @Test
        void should_fail_to_create_a_diamond_given_no_letter() {
            whenOutsideOperatingConditions(() -> Diamond.draw(""))
                    .thenItFails()
                    .becauseOf(IllegalArgumentException.class)
                    .withMessage("A letter is expected!");
        }

        @Test
        void should_fail_to_create_a_diamond_given_anything_but_a_letter() {
            whenOutsideOperatingConditions(() -> Diamond.draw("1"))
                    .thenItFails()
                    .becauseOf(IllegalArgumentException.class)
                    .withMessage("Only letters are expected!");
        }

        @Test
        void should_fail_to_create_a_diamond_given_several_letters() {
            whenOutsideOperatingConditions(() -> Diamond.draw("AB"))
                    .thenItFails()
                    .becauseOf(IllegalArgumentException.class)
                    .withMessage("Only one letter is expected!");
        }
    }
}