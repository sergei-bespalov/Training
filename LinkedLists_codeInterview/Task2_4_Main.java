class Task2_4_Main{
	public static void main(String[] args){
	Node list = new Node(1);
	list.appendToTail(10);
	list.appendToTail(13);
	list.appendToTail(3);
	list.appendToTail(5);
	list.appendToTail(7);
	list.appendToTail(8);
	sort(list);
	showNode(list);
	}
	public static void sort(Node head){
		boolean sorted = false;
		while (!sorted){
			Node n = head;
			sorted = true;
			while (n.next != null){
				if (n.data  > n.next.data){
					sorted = false;
					int tmp = n.data;
					n.data = n.next.data;
					n.next.data = tmp;
				}
				n = n.next; 
			}
		}
	}
	public static void showNode(Node head){
		Node n = head;
		while(n.next != null){
			System.out.print(n.data+" ");
			n = n.next;
		}
		System.out.print(n.data + "\n");
	}
}