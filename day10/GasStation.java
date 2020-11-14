package day10;

public class GasStation {

	 public static int computeForIndex(int index,int[] gas,int[] cost){
	        int curr = gas[index];
	        int gasIndex = (index==gas.length-1)?0:index+1;
	        int costIndex = (index==gas.length-1)?gas.length-1:index;
	        while(true){
	            if(gasIndex==gas.length) gasIndex=0;
	            if(costIndex==gas.length) costIndex=0;
	            if(curr<0 || curr<cost[costIndex]) return -1;
	             if(gasIndex==index){
	                 return (curr-cost[costIndex]>=0)?1:-1;
	            }
	            curr = curr - cost[costIndex] + gas[gasIndex];
	            gasIndex++; costIndex++;
	        }
	    }
	    
	    public static int canCompleteCircuit(int[] gas, int[] cost) {
	        for(int i=0;i<gas.length;i++){
	            if(cost[i]<=gas[i]){
	                if(computeForIndex(i,gas,cost)==1) { return i; }
	            }
	        }
	        return -1;
	    }
	
	public static void main(String[] args) {
		int gas[] = {1,2,3,4,5};
		int cost[] = {3,4,5,1,2};
		
		System.out.println(canCompleteCircuit(gas,cost));

		int gas1[] = {5,1,2,3,4};
		int cost1[] = {4,4,1,5,1};
		System.out.println(canCompleteCircuit(gas1,cost1));
		
	}

}
