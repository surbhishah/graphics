package fillAlgorithms;

public class EdgeRecord implements Comparable<EdgeRecord> {
	// xmin = x value of coordinate with minimum y value
	double xmin;
	// ymax = y value of coordinate with max y value
	int ymax;
	// increment = inverse of slope of edge
	double increment;
	// ymin = y value pf coordinate with minimum y value 
	
	int ymin;
	public EdgeRecord(double xmin, int ymax, int ymin,double increment) {
		this.xmin = xmin;
		this.ymax = ymax;
		this.increment = increment;
		this.ymin = ymin;
	}
	@Override
	public int compareTo(EdgeRecord o) {
		if(this.xmin > o.xmin){
			return 1;
		}else if(this.xmin == o.xmin){
			return 0;
		}
		else{
			return -1;
		}
	}
	@Override
	public String toString(){
		return ":(" + this.xmin + ","
				+ this.ymin + "," + this.ymax + ","
				+ this.increment + ")";
	}
}
