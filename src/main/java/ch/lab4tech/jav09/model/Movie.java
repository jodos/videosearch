package ch.lab4tech.jav09.model;

public class Movie {
	private int titleNo;
	private String title;
	private String description;
	private String rating;
	private int categoryCode;
	private String retailPrice;
	private String rentalPrice;
	private int copiesPurchased;

	public int getTitleNo() {
		return titleNo;
	}

	public void setTitleNo(int titleNo) {
		this.titleNo = titleNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public int getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(String retailPrice) {
		this.retailPrice = retailPrice;
	}

	public String getRentalPrice() {
		return rentalPrice;
	}

	public void setRentalPrice(String rentalPrice) {
		this.rentalPrice = rentalPrice;
	}

	public int getCopiesPurchased() {
		return copiesPurchased;
	}

	public void setCopiesPurchased(int copiesPurchased) {
		this.copiesPurchased = copiesPurchased;
	}
}
