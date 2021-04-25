package Project.appClasses;

public enum Group implements Comparable<Group> {

	Favourites, Favoriten, Family, Familie, Work, Arbeit, University, Universität, Leisure, Freizeit, Other, Sonstige;
	
	public boolean contains(String searchString) {
		return (this.name().contains(searchString));
	}
	
	public boolean equals(String searchString) {
		return (this.name().equals(searchString));
	}

}
	

