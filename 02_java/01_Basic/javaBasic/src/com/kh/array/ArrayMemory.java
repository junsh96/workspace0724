package com.kh.array;

public class ArrayMemory {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i = 10;
		int [] iArr = new int[5];
		
		System.out.println(iArr.hashCode());
		//기본적으로 자바는 메모리의 주소를 확인할수 없다.
		//다만 객체 메모리 주소의 암호화된 해시값을 hashCode라는 함수로 가져올수있다.
		
		double [] dArr = new double[5];
		/*
		 *	실제 리터럴값을 곧바로 담을수 있는 변수를 일반 변수
		 *
		 * 	다른 메모리의 주소값을 담고있는 변수를 참조변수
		 * 
		 * 
		 * 	기본 자료형(원시타입) : int , double, float, char, long
		 * 	-> 실제 리터럴 값을 바로 담을수 있음
		 * 
		 * 	그 외 자료형 : String Scanner int[] .... -> 참조변수
		 * 	필요한 메모리의 크기가 가변적이다.
		 *
		 */
		
		//iArr 전체 출력
		for (int j=0; j<iArr.length; j++) {
			System.out.println("iArr : "+iArr[j]);
		}
		//dArr 전체 출력 for each
		for (double k : dArr) {
			System.out.println("dArr : "+ k);
		}
		
		//배열 생성시에는 따로 초기화하지 않아도 기본값이 들어있다.
		//Heap라는 메모리공간은 빈공간을 허용하지 않는다.
		//-> 메모리가 할당될때 jvm이  기본값으로 모두 초기화.
		
		iArr = null;
		//-> null로 변경
		
		
		int [] arr = new int[5];
		//System.out.println(arr[5]);
		//ArrayIndexOutOfBoundsException -> 범위를 넘어서서 호출
		
		
		//배열의 가장 큰 단점 : 
		//크기 변경이 불가능 하다.
		// -> 수정시도시 새로운 메모리 공간을 할당한다
		
		/*
		 *	연결이 끊어진 기존 배열의 메모리 공간은 Heap영역에 남아있다.(어떤 변수에도 참조되지않는 상태)
		 * -> 일정 시간이 지나면 GC(가비지 컬렉터)가 알아서 수거한다.
		 * 
		 *  
		 */
		
		int[] arr4 = {1,1,1,1,1};
		int[] arr5 = {1,1,1,1,1};
		
		System.out.println(arr4 == arr5); // -> false 주소를 비교하기 때문에 false
		//false -> 각 참조변수는 == 통해서 비교시 주소값 비교
		
		arr4 = arr5;
		//-> true
		
		arr4[0] = 100;
		arr5[1] = 200;
		
		
		
		
		
	}

}
