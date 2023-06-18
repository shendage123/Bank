package sington;

import java.util.Random;

public class Driver {
	public static void main(String[] args) {
		Random r=new Random();
		long a=r.nextLong(10000000000000l);
		System.out.println(a);
	}

}