package ru.geekbrains.java2.dz.dz2.vladimir_postnov;

// Я не успел разобраться как делать собственные исключения, так что я умышленно допустил оверинженеринг, чтобы вставить исключения.
// На занятии пожалуйста еще раз расскажите о создании собственных исключений.

public class Export {
	
	private String[][] array = new String[4][4];
	private int z = 0;
	private int razmer = 0;
	private int sum = 0;
	
	public int StringToArray (String string)	
	{			
		String[] arrayLength = (string.replaceAll("\n"," ")).split(" ");
		
		String [] array_2 = new String[16];
		
		
		razmer = arrayLength.length/4+(arrayLength.length%4);
		
		
		for (int i= 0; i < (razmer); i++) {
			for (int j = 0; j < (razmer); j++) {

// Исключение на матрицу больше или меньше  [4][4]
				try {
				array_2[z] = arrayLength[z];
				array[i][j] = array_2[z];
				}
				catch (ArrayIndexOutOfBoundsException e){
					System.out.println("Error: Матрица не 4х4.");
					return 0;
					}
	
// Исключение на нахождение в матрице не числа
				try {
				sum += Integer.valueOf(array[i][j]);	
				}
				catch (NumberFormatException e){
				System.out.println("Error: В массиве есть не цифровые элементы.");
				return 0;
				}
				
				z+=1;
			}				
		}
		
		return sum/2;
	}

}