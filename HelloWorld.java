package myCoreJavaProject;

import java.util.Arrays;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Hello World");
	
		System.out.println(4+6);
		System.out.println("4+6");
	
		int num1=9;
		int num2=30;
		
		System.out.println("the result is "+(num1+num2));
	
		String s="this is my first project";
		System.out.println(s.length());
		System.out.println(s.charAt(0));
		System.out.println(s.charAt(s.length()-1));
		System.out.println(s.toUpperCase());

		int[] arr1= {4,44,44};
		System.out.println(arr1.length);
		
		int tot=0;
		for(int i=0;i<arr1.length;i++)
		{
			tot = tot + arr1[i];
		}
		System.out.println(tot);
		
		System.out.println(Arrays.stream(arr1).sum());
	
		for(int i=2;i<=50;i+=2)
		{
			System.out.println(i);
		}
		
		int tot1=0;
		for(int value:arr1){
		tot1+=value;
		}

		System.out.println(tot1);
		
	
	String str2 = "hi how are you";
	System.out.println(str2.split(" ").length);
	

	
	String str1 = "I am feeling lucky";
	
	// rev the string and show in the output
	
	for(int k=str1.length()-1; k!=-1;k--)
	{
		System.out.print(str1.charAt(k));
	}
	
	System.out.println();

	// find the sum of all the digits in num2
	// find out the rev num of num1
	// do not convert this num into string

	int numA = 1028552023;
	int numB=0;	
	int sum=0;
	System.out.println("The given number = " +numA);
	System.out.print("reverse of the given number = ");
	while(numA!=1)
	{
	numB=numA%10;
	System.out.print(numB);
	
	if((numA-numB!=0))
	{numA=(numA-numB)/10;}
	
	sum=sum+numB;
	}System.out.print(numA + "\n");
//	System.out.println();
	System.out.println("sum of all digits = " +sum);
	
	}

}

