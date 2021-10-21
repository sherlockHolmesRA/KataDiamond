package com.katadiamondtdd.katadiamond;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static testasyouthink.TestAsYouThink.when;


class KatadiamondApplicationTests {

    @Nested
    class Given_a_valid_letter {
    @Test
    void should_print_a_diamond_in_the_console() {
        when(() -> KatadiamondApplication.main(new String[]{"C"})).thenStandardOutput(
                stdout -> assertThat(stdout).hasContent(
                		  
                		  "  A\n" //
                        + " B B\n" //
                        + "C   C\n" //
                        + " B B\n" //
                        + "  A"));
    }
    }

    @Nested
    class Given_an_invalid_letter {

        @Test
        void should_print_an_error_message_given_nil() {
            when(() -> KatadiamondApplication.main(null)).thenStandardOutput(
                    stdout -> assertThat(stdout).hasContent("Letter missing!"));
        }

        @Test
        void should_print_an_error_message_given_several_letters() {
            when(() -> KatadiamondApplication.main(new String[]{"A", "B"})).thenStandardOutput(
                    stdout -> assertThat(stdout).hasContent("Only one letter is expected!"));
        }
    }

}
