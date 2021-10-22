package com.katadiamondtdd.katadiamond;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static testasyouthink.TestAsYouThink.when;


class KatadiamondApplicationTests {

    @Nested
    class Given_a_valid_letter {
    @Test
    void print_a_diamond_in_the_console() {
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
        void error_message_given_null() {
            when(() -> KatadiamondApplication.main(null)).thenStandardOutput(
                    stdout -> assertThat(stdout).hasContent("Letter missing!"));
        }

        @Test
        void error_message_if_several_letters() {
            when(() -> KatadiamondApplication.main(new String[]{"A", "B"})).thenStandardOutput(
                    stdout -> assertThat(stdout).hasContent("Only one letter is expected!"));
        }
    }

}
