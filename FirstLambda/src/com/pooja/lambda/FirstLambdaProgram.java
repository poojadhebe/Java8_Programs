package com.pooja.lambda;

import java.io.File;
import java.io.FileFilter;

public class FirstLambdaProgram {
	
	static FileFilter fileFilter = new FileFilter(){
		
		@Override
		public boolean accept(File file) {
			return file.getName().endsWith(".java");
		}
	};
	
	static FileFilter lambdaFileFilter = (File file) -> file.getName().endsWith(".java");
	public static void main(String args[]) {
		File dir=new File("C:\\Pooja\\Workspace\\SpringHelloworldExample\\src\\com\\pooja\\spring");
		System.out.println("Using anonymous class...");
		File files[]=dir.listFiles(fileFilter);
		for(File file:files) {
			System.out.println(file);
		}
		System.out.println("Using lambda expressions");
		File lambdaFiles[]=dir.listFiles(lambdaFileFilter);
		for(File file:lambdaFiles) {
			System.out.println(file);
		}
	}

}
