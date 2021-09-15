public class HashSetTrick {

	
	public static void main(String[] args) {
		
		HashSet shortSet = new HashSet();
		for (short i = 0; i < 100; i++) {
		shortSet.add(i);
		shortSet.remove(i - 1);
		}
		System.out.println(shortSet.size());
		
		// Answer is remove method passes integer in argument and hence size of the hashset soesnot get reduced.  https://stackoverflow.com/questions/2988135/java-hashset-and-data-type-short-incompatibility
		
		
		
		
	}
	
	
}
