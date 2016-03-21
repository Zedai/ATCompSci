package algebraCalc;

public class Term {
	private double coefficient, power;
	
	public Term(double c, double p){
		coefficient = c;
		power = p;
	}
	
	public String toString(){
		if(coefficient == 0)
			return "";
		else if(power == 0)
			if(coefficient < 0)
				return "- " + -coefficient;
			else
				return "+ " + coefficient;
		else if(coefficient < 0)
			return "- " + -coefficient + "x^" + power + " ";
		else 
			return "+ " + coefficient + "x^" + power + " ";
	}
	
	public double getCoefficient(){
		return coefficient;
	}
	
	public double getPower(){
		return power;
	}
	
	//Term must be able to be added
	public Term add(Term other){
		if(other.getPower() != this.getPower())
			throw new IllegalStateException();
		
		return new Term(this.getCoefficient() + other.getCoefficient(), this.getPower());
	}
	
	public Term multiply(Term other){
		return new Term(this.getCoefficient() * other.getCoefficient(), this.getPower() + other.getPower());
	}
}