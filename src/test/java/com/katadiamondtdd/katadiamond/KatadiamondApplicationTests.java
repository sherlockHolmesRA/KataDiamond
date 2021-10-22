package com.katadiamondtdd.katadiamond;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static testasyouthink.TestAsYouThink.when;


class KatadiamondApplicationTests {

    @Nested
    class Valid_Letter {
    @Test
    void print_the_diamond() {
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
    class Invalid_Letter {

        @Test
        void error_message_if_null() {
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
