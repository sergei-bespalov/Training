class Task2_2_MainV2{
	public static void main(String[] args){
		Node list = new Node(10);
		for(int i = 11; i < 20; i++)
			list.appendToTail(i);
		nthToLast(list,2);
	}
	public static int nthToLast(Node head, int k){
		if (head == null) return 0;
		int i = nthToLast(head.next,k)+1;
		if (i==k){
			System.out.println(head.data);
		}
		return i;
	}
}
	