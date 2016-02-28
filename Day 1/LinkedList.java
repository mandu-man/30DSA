
class Node{

	private Node next;
	private int data;

	public Node(int dataValue){
		next = null;
		data = dataValue;
	}

	public Node(int dataValue, Node nextValue){
		next = nextValue;
		data = dataValue;
	}

	public int getData() {
		return data;
	}


	public Node getNext() {
		return next;
	}

	public void setNext(Node nextValue){
		next = nextValue;
	}

}

class LlOps{
	private int count;
	private Node first;
	
	public void add(int e){
		Node newData = null;
	
		if(first==null)
			first = new Node(e);
		else
			newData = new Node(e);
		Node start = first;
		while(start.getNext()!=null)
			start = start.getNext();

		start.setNext(newData);
		count += 1;
	}
	
	public boolean delPos(int pos){
		int i=1;
		Node start = first;
		if(pos>count || pos<1)
			return false;
		if(pos == 1){
			first = first.getNext();
			count -= 1;
			return true;
		}
		start = start.getNext();
		for(i=2;i<pos-1;i++){
			if(start!=null){
				start = start.getNext();
				continue;
			}
			break;
		}
		if(i==(pos-1) && start.getNext()!=null ){
			start.setNext(start.getNext().getNext());
			count -= 1;
		}
		
		return true;
	}
	

	public void display(){
		Node start = first;
		do{
			System.out.print(start.getData()+" ");
			start = start.getNext();
		}
		while(start!=null);
		System.out.println();
	}
	
	public void display(int k){
		Node start = first;
		int i=1;
		do{
			if(i>=k)
				System.out.print(start.getData()+" ");
			start = start.getNext();
		}
		while(start!=null);
		System.out.println();
	}
	
	public int find(int e, Node start,int i){
		int j = -1;
		do{
			if(start!=null){
				if(start.getData() == e)
					return i;
				start = start.getNext();
				i++;
			}
		}
		while(start!=null);
		return j;
	}
	
	public int find(int e){
		Node start = first;
		int i = 1;
		int j = -1;
		do{
			if(start!=null){
				if(start.getData() == e)
					return i;
				start = start.getNext();
				i++;
			}
		}
		while(start!=null);
		return j;
	}
	
	public void duplicateDel(){
		Node start = first;
		int temp;
		int i = 1;
		do{
			temp = 0;
			while(temp!=-1 && start.getNext()!=null){
				temp = find(start.getData(),start.getNext(),(i+1));
				if(temp!=-1)
					delPos(temp);
			}
			start = start.getNext();
			i++;
		}
		while(start!=null);
		System.out.println("After deletion of duplicate items");
		display();
	}
	
	
	public boolean palindrome(){
		boolean pal = true;
		int i;
		Node start =  first;
		Node reverse = new Node(start.getData());
		start = start.getNext();
		for(i=2;i<=count;i++){
			Node newData = new Node(start.getData(),reverse);
			start = start.getNext();
			reverse = newData;
		}
		start = first;
		for(i=1;i<=count;i++){
			if(start.getData()!=reverse.getData())
				pal = false;
		}
		System.out.println("Reversed Linked List");
		do{
			System.out.print(reverse.getData()+" ");
			reverse = reverse.getNext();
		}
		while(reverse!=null);
		System.out.println();
		return pal;
	}
}

public class LinkedList {
	public static void main(String[] args) {
		LlOps ll = new LlOps();
		ll.add(1);
		ll.add(5);
		ll.add(3);
		ll.add(5);
		ll.add(3);
		ll.add(5);
		ll.add(1);
		System.out.println("Original Linked List");
		ll.display();
		if(ll.palindrome())
			System.out.println("Linked List is palindrome");
		else
			System.out.println("Linked List is not palindrome");
		ll.duplicateDel();

	}
}
