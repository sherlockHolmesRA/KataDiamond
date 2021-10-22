package com.katadiamondtdd.katadiamond;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.String.valueOf;
import static java.util.Collections.reverse;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.generate;

public class Diamond {
	
	private static final String LINE_SEPARATOR = "\n";
    private static final String ONE_SPACE = " ";
    private final LetterChoice givenLetter;

    private Diamond(String letter) {
        givenLetter = new LetterChoice(letter);
    }

    public static String draw(String letter) {
        Diamond diamond = new Diamond(letter);
        return diamond.constructDiamond();
    }

    private String constructDiamond() {
        List<String> topHalf = givenLetter
                .streamOfCodes()
                .mapToObj(Line::new)
                .map(Line::build)
                .collect(toList());
        List<String> downHalf = new ArrayList<>(topHalf.subList(0, topHalf.size() - 1));
        reverse(downHalf);
        return assembly(topHalf, downHalf);
    }

    private String assembly(List<String> topHalf, List<String> downHalf) {
        return Stream
                .of(topHalf, downHalf)
                .flatMap(List::stream)
                .collect(joining(LINE_SEPARATOR));
    }
    
    
    
    private class Line {

        private final Integer code;

        private Line(Integer code) {
            this.code = code;
        }

        private String build() {
            String letterForLine = valueOf((char) code.intValue());
            return indentation() + (isA() ? letterForLine : letterForLine + spacing() + letterForLine);
        }

        private boolean isA() {
            return code == LetterChoice.CODE_A;
        }

        private String indentation() {
            return repeatSpace(givenLetter.getCode() - code);
        }

        private String spacing() {
            return repeatSpace(2 * (code - givenLetter.getMatchingFirstCode() - 1) + 1);
        }

        private String repeatSpace(Integer times) {
            return generate(() -> ONE_SPACE)
                    .limit(times)
                    .collect(joining());
        }
    }

}
