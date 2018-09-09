package kr.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.Scanner;

@SpringBootApplication
@ImportResource("classpath:integration.xml")
public class IntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntegrationApplication.class);
//		context.registerShutdownHook();
//
//		Scanner scanner = new Scanner(System.in);
//		System.out.print("Please enter q and press <enter> to exit the program: ");
//
//		while (true) {
//			String input = scanner.nextLine();
//			if ("q".equals(input.trim())) {
//				break;
//			}
//		}
//		System.exit(0);
	}
}
