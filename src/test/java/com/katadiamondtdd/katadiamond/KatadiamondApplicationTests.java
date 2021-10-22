package com.katadiamondtdd.katadiamond;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static testasyouthink.TestAsYouThink.when;


class KatadiamondApplicationTests {

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
