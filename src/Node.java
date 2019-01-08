public class Node<E> {
	
	private E data;
	private Node<E> link;
	
	
	public Node(E data, Node<E> link){
		
		this.data = data;
		this.link = link;
	}
	public E getData(){ return this.data; }
	public Node<E> getLink(){ return this.link;}
	public void setData(E element){ this.data = element; }
	public void setLink(Node<E> link){ this.link = link; }
	
	public void addNodeAfter(E element){
		this.link = new Node (element, this.link);
	}
	
	public void removeNodeAfter(){
		
		this.link = this.link.link;
	}
	
	public static <E> void display(Node head){
		
		Node<E> cursor = head;
		
		while (cursor != null){
			System.out.println(cursor.getData());
			cursor = cursor.getLink();
		}
	}
	

}
