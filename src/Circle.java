public class Circle  implements Cloneable,Comparable<Circle>{
	
	private int radius;
	
	public Circle(int r) { this.radius = r;}
	public void setRadius(int r) {this.radius = r;}
	public int getRadius() { return this.radius; }
	
	@Override
	public boolean equals(Object o){ 
		boolean output = false;
		if (o instanceof Circle){
			if (((Circle)o).radius == this.radius)
				output =  true;
		}
		return output;
	}
	
	@Override
	public int compareTo(Circle o) {
		
		int output = -1;
		if (this.radius > o.radius)
			output = 1;
		else if (this.radius == o.radius)
			output = 0;
		return output;
	}
	
	@Override
	public String toString(){
		String output = this.radius+"\n";
		return output;
	}
	
	@Override
	public Circle clone(){
		
		Circle output = null;
		
		try{
			output = (Circle) super.clone();
		}catch(Exception e){ System.out.println("Cannot clone a circle");}
		
		return  output;
	}
	
}
