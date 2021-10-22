package com.katadiamondtdd.katadiamond;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static testasyouthink.TestAsYouThink.resultOf;
import static testasyouthink.TestAsYouThink.whenOutsideOperatingConditions;

@SpringBootTest
class DiamondTest {

	@Test
	void drawDiamondA() {
		Assertions.assertThat(Diamond.draw("A")).contains("A");
	}
	
	@Test
	void drawDiamondB() {
		Assertions.assertThat(Diamond.draw("B")).contains(" A\n" //
            	+ "B B\n" //
            	+ " A"
);		
	}
	
	@Test
	void drawDiamondC() {
		Assertions.assertThat(Diamond.draw("C")).contains("  A\n" //
            	+ " B B\n" //
            	+ "C   C\n" //
            	+ " B B\n" //
            	+ "  A");
		
	}
	
	
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
