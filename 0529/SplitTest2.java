class  SplitTest2


		String []splitt = kittens.split(","); //하나의 문자열을 특정패턴으로 분리해서 배열에 넣는다.
		System.out.println(splitt.length); //배열의 길이  ==> 4
		for (int i=0; i<splitt.length ;i++ ) 
			System.out.println(splitt[i]); //배열은 0부터이므로 배열길이-1을 해줘야된다.
	}
}
