package com.inter_test.intern_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = com.inter_test.intern_test.HttpMethods.class)
public class InternTestApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(InternTestApplication.class, args);
	}
}
