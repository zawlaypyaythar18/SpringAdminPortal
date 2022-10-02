package com.adminportal.admin.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String title;
	private String author;
	private String publisher;
	private String publicationDate;
	private String language;
	private String category;
	private String numberOfPages;
	private String format;
	private Integer isbn;
	private Double shippingWeight;
	private Double listPrice;
	private Double ourPrice;
	private Boolean active = true;
	
	@Column(columnDefinition = "text")
	private String description;
	
	private Integer inStockNumber;
	
	@Transient
	private MultipartFile bookImage;
	
	public Book() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(String numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public Integer getIsbn() {
		return isbn;
	}

	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}

	public Double getShippingWeight() {
		return shippingWeight;
	}

	public void setShippingWeight(Double shippingWeight) {
		this.shippingWeight = shippingWeight;
	}

	public Double getListPrice() {
		return listPrice;
	}

	public void setListPrice(Double listPrice) {
		this.listPrice = listPrice;
	}

	public Double getOurPrice() {
		return ourPrice;
	}

	public void setOurPrice(Double ourPrice) {
		this.ourPrice = ourPrice;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getInStockNumber() {
		return inStockNumber;
	}

	public void setInStockNumber(Integer inStockNumber) {
		this.inStockNumber = inStockNumber;
	}

	public MultipartFile getBookImage() {
		return bookImage;
	}

	public void setBookImage(MultipartFile bookImage) {
		this.bookImage = bookImage;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", publicationDate=" + publicationDate + ", language=" + language + ", category=" + category
				+ ", numberOfPages=" + numberOfPages + ", format=" + format + ", isbn=" + isbn + ", shippingWeight="
				+ shippingWeight + ", listPrice=" + listPrice + ", ourPrice=" + ourPrice + ", active=" + active
				+ ", description=" + description + ", inStockNumber=" + inStockNumber + ", bookImage=" + bookImage
				+ ", getId()=" + getId() + ", getTitle()=" + getTitle() + ", getAuthor()=" + getAuthor()
				+ ", getPublisher()=" + getPublisher() + ", getPublicationDate()=" + getPublicationDate()
				+ ", getLanguage()=" + getLanguage() + ", getCategory()=" + getCategory() + ", getNumberOfPages()="
				+ getNumberOfPages() + ", getFormat()=" + getFormat() + ", getIsbn()=" + getIsbn()
				+ ", getShippingWeight()=" + getShippingWeight() + ", getListPrice()=" + getListPrice()
				+ ", getOurPrice()=" + getOurPrice() + ", getActive()=" + getActive() + ", getDescription()="
				+ getDescription() + ", getInStockNumber()=" + getInStockNumber() + ", getBookImage()=" + getBookImage()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
