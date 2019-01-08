public class IntNode {
	
	private int data;
	private IntNode link;
	
	public IntNode(int initialData, IntNode initialLink){
		this.data = initialData;
		this.link = initialLink;
	}
	
	public int getData() { return this.data;}
	public void setData(int data) { this.data = data;}
	
	public IntNode getLink() {return this.link; }
	public void setLink(IntNode link) { this.link = link; }
	
	public void addNodeAfter(int element){
		//System.out.println(element+" "+this.data+"  "+this.link);
		link = new IntNode(element,this.link);
	}
	
	public void removeNodeAfter(){
		this.link = this.link.link;
	}
	
	public static void display(IntNode list){
		
		IntNode cursor = list;
		
		while (cursor != null){
			System.out.print(cursor.data+",");
			cursor = cursor.link;
		}
		System.out.println("\n");
	}
	
	public static int listLength(IntNode head){
		
		IntNode cursor = head;
		int answer = 0;
		
		while (cursor != null){
			answer++;
			cursor = cursor.link;
		}
		
		return answer;
	}
	
	

	public static IntNode listSearch(IntNode head, int target){
		
		IntNode cursor = head;
		
		while (cursor != null){
			if (cursor.getData() == target)
				return cursor;
			cursor = cursor.getLink();
		}
		
		return null;
	}
	
	public static IntNode listPosition(IntNode head, int position){
		
		IntNode cursor = head;
		int index = 1;
		
		while (cursor != null && index < position){
			index++;
			cursor = cursor.getLink();
		}
		
		return cursor;
		
	}
	
	public static IntNode listCopy(IntNode source){
		
		IntNode copyHead;
		IntNode copyTail;
		IntNode cursor = source;
		
		if (source == null)
			return null;
		
		//make the first node in the new list
		copyHead  = new IntNode(source.getData(),null);
		copyTail = copyHead;
		
		while (cursor !=null){
			cursor = cursor.getLink();
			copyTail.addNodeAfter(cursor.getData());
			copyTail = copyTail.link;
		}
		
		return copyHead;
	}

	public static void reverse(IntNode head){
		
		int size = IntNode.listLength(head);
		int[] listArray = new int[size];
		IntNode cursor = head;
		int index = 0;
		
		while (cursor != null){
			listArray[index] = cursor.getData();
			index++;
			cursor = cursor.getLink();
		}
		
		for (int j = size-1; j >=0; j--)
			System.out.println(listArray[j]);
	}
	
	public static void insertKth(IntNode head,int val, int k){
		int length = IntNode.listLength(head);
		
		if (( k < 0 ) || (k > length+1))
			throw new IllegalArgumentException("No such position");
		
		IntNode prev = IntNode.listPosition(head, k-1);
		IntNode newNode = new IntNode(val,prev.getLink());
		prev.setLink(newNode);
			
		
	}
}

