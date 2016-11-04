package patternOne.singleton;

import java.util.Random;

public class SingleSort {
	public static final int DIGIT_PORUADOK = 999;//1 10 100 1000 и т.д.
	static private SingleSort one;

	private SingleSort(){
	}

	public static SingleSort getOne(){
		if (one == null){
			one = new SingleSort();
		}
		return one;
	}

	public void showArray(int[] arrayToShow){
		arrayShow(arrayToShow);	
	}

	public void arrayFill(int[] arrayToShow){
		randomFill(arrayToShow, 1234567890);	
	}

	public int[] sortBubble(int[] arrayToSort){
		Bubble(arrayToSort);
		return arrayToSort;
	}

	public int[] sortBrush(int[] arrayToSort){
		Brush(arrayToSort);
		return arrayToSort;
	}

	public int[] sortShaker(int[] arrayToSort){
		Shaker(arrayToSort);
		return arrayToSort;
	}

	public int[] sortEvenOdd(int[] arrayToSort){
		EvenOdd(arrayToSort);
		return arrayToSort;
	}	


	private int[] randomFill(int[] arrayToFill, long digit) {
		final Random random = new Random();
		if (digit == 0) return arrayToFill;
		for (int i =0; i < arrayToFill.length;i++){
			arrayToFill[i]= random.nextInt(DIGIT_PORUADOK);
			//			arrayToFill[i]= random.nextInt();//big digits
		}
		return arrayToFill;
	}

	private void arrayShow(int[] arrayToShow){
		for (int i = 0; i < arrayToShow.length;i++){
			System.out.print(arrayToShow[i] + " ");
		}
		System.out.println();
	}	

	private int[] EvenOdd(int[] arrayToSort) {
		int temp;
		int evenOddTemp = 0;
		boolean changeFlg = false;
		if (arrayToSort.length == 0) return arrayToSort;
		while(true){
			for (int i = 0; i < arrayToSort.length-1;i+=2){
				if (arrayToSort[i] > arrayToSort[i+1]){
					temp = arrayToSort[i+1];
					arrayToSort[i+1] = arrayToSort[i];
					arrayToSort[i]= temp;
					changeFlg = true;
				}
			}
			if (arrayToSort.length%2 == 0){evenOddTemp = arrayToSort.length - 2;}
			else{evenOddTemp = arrayToSort.length -1;}


			for (int i = 1; i < evenOddTemp;i+=2){
				if (arrayToSort[i] > arrayToSort[i+1]){
					temp = arrayToSort[i+1];
					arrayToSort[i+1] = arrayToSort[i];
					arrayToSort[i]= temp;
					changeFlg = true;
				}
			}
			if (!changeFlg){
				break;
			}
			else {
				changeFlg = false;
			}
		}
		return arrayToSort;
	}

	private int[] Shaker(int[] arrayToSort){
		int temp;
		int counter1 = 0;
		int counter2 = 0;
		int reverseFlag=0;
		int fullArrayCounter = 0;
		if (arrayToSort.length == 0) return arrayToSort;
		while(true){
			if (fullArrayCounter % 2 == 1) reverseFlag = 1;
			else reverseFlag = 0;

			if (reverseFlag == 0){ 
				for(int i = counter1; i < arrayToSort.length-counter1-1;i++){
					if (arrayToSort[i] > arrayToSort[i+1]){
						temp = arrayToSort[i+1];
						arrayToSort[i+1] = arrayToSort[i];
						arrayToSort[i]= temp;						
					}
				}
				counter1++;
			}
			else{
				for(int i = arrayToSort.length-counter2-2; i > counter2; i--){
					if (arrayToSort[i] < arrayToSort[i-1]){
						temp = arrayToSort[i-1];
						arrayToSort[i-1] = arrayToSort[i];
						arrayToSort[i]= temp;

					}
				}
				counter2++;
			}
			if (fullArrayCounter == arrayToSort.length-1) {
				break;
			}
			fullArrayCounter++;
		}
		return arrayToSort;		
	}

	private int[] Brush(int[] arrayToSort){
		int temp;
		int step = (int)(arrayToSort.length/1.24);
		boolean changeFlg = false;
		if (arrayToSort.length == 0) return arrayToSort;
		while (true){
			for (int i = 0;i <arrayToSort.length - step;i++){
				if(arrayToSort[i] > arrayToSort[i+step]){
					temp = arrayToSort[i+step];
					arrayToSort[i+step] = arrayToSort[i];
					arrayToSort[i]= temp;
					changeFlg = true;
				}
			}
			if (step > 1){
				step = (int)(step/1.24);

			}
			else {
				if (!changeFlg) break;
			}
			changeFlg = false;
		}
		return arrayToSort;
	}

	private int[] Bubble(int[] arrayToSort){
		int temp;
		if (arrayToSort.length == 0) return arrayToSort;
		for (int i =0; i < arrayToSort.length;i++){
			for (int j =0; j < arrayToSort.length-1-i;j++){
				if (arrayToSort[j] > arrayToSort[j+1]){
					temp = arrayToSort[j+1];
					arrayToSort[j+1] = arrayToSort[j];
					arrayToSort[j]= temp;
				}
			}
		}
		return arrayToSort;
	}


	public static void main(String[] args) {
		final Random random = new Random();
		int razmer = random.nextInt(1000);//ограничиваемый максимальный возможный размер массива
		int [] array1 = new int[razmer];

		SingleSort sortirovka = SingleSort.getOne(); // создаем уникальный объект
		//sortirovka = SingleSort.getOne(); debug
		//---------------------------------------
		sortirovka.arrayFill(array1);
		System.out.println("Исходный массив:");
		sortirovka.showArray(array1);
		sortirovka.sortBubble(array1);
		System.out.println("Пузырьком:");
		sortirovka.showArray(array1);
		System.out.println();
		//---------------------------------------
		sortirovka.arrayFill(array1);
		System.out.println("Исходный массив:");
		sortirovka.showArray(array1);
		sortirovka.sortBrush(array1);
		System.out.println("Расческой:");
		sortirovka.showArray(array1);				
		System.out.println();
		//---------------------------------------
		sortirovka.arrayFill(array1);
		System.out.println("Исходный массив:");
		sortirovka.showArray(array1);
		sortirovka.sortShaker(array1);
		System.out.println("Шейкером:");
		sortirovka.showArray(array1);				
		System.out.println();
		//---------------------------------------
		sortirovka.arrayFill(array1);
		System.out.println("Исходный массив:");
		sortirovka.showArray(array1);
		sortirovka.sortEvenOdd(array1);
		System.out.println("Чёт-нечет:");
		sortirovka.showArray(array1);				
		System.out.println();
		//---------------------------------------
	}
}
