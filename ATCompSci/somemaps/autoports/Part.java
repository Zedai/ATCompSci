package autoports;

public class Part implements Comparable<Part>
{
	private String make, model, rest = "";
	private int year;

	public Part(String line) 
	{
		String[] list = line.split(" ");
		year = Integer.parseInt(list[list.length - 1]);
		model = list[list.length - 2];
		make = list[list.length - 3];

		for(int i = 0; i < list.length - 3; i++)
			rest += list[i] + " ";
		
		rest = rest.trim();
	}

	//have to have compareTo if implements Comparable
	public int compareTo( Part rhs )
	{
		if(rhs.make.equals(this.make)){
			if(this.model.equals(rhs.model)){
				if(this.year == rhs.year)
					return this.rest.compareTo(rhs.rest);
				else
					return this.year - rhs.year;
			}
			else
				return this.model.compareTo(rhs.model);
		}
		else
			return this.make.compareTo(rhs.make);
	}

	public boolean equals(Part rhs){
		return this.make.equals(rhs.make) && this.model.equals(rhs.model) && this.year == rhs.year && this.rest.equals(rhs.rest);
	}
	
	public String toString()
	{
		return make + " " + model + " " + year + "  " + rest;
	}
}