package com.katadiamondtdd.katadiamond;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.String.join;

@SpringBootApplication
public class KatadiamondApplication {

	public static void main(String[] args) {
        try {
            System.out.println(Diamond.draw(args == null ? null : join("", args)));
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }

}
