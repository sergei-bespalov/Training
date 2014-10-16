class Task2_2_Main{
	public static void main(String[] args){
		Node list = new Node(10);
		for(int i = 11; i < 20; i++)
			list.appendToTail(i);
		System.out.println(getFromEnd(0,list));
		
	}
	public static int getFromEnd(int k, Node A ){
		while(!Proof(A,k)){
			A = A.next;}
		return A.data;
	}
	
	public static boolean Proof(Node A, int k){
		while(k != 0 && A != null){
			A = A.next;
			k--;
		}
		if (A == null) return true;
		else return false;
	}
}