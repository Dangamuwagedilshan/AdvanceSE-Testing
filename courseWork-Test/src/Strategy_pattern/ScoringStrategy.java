package Strategy_pattern;

public class ScoringStrategy implements Marks {

	private String level;
	private int count;
	
	private ScoringStrategy(String Inclevel, int IncCount) {
		this.level = Inclevel;
		this.count = IncCount;
	}
	
	@Override
	public void player1Marks(int value) {
		// TODO Auto-generated method stub
		System.out.println(value+"is the scoring marks value");
	}

}
