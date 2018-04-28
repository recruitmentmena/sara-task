package com.therealdanvega.domain;

import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
public class News {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @JsonInclude(Include.NON_NULL)
	private String id;
	@JsonInclude(Include.NON_NULL)
//	@JsonFormat(pattern = "yyyy-MM-dd")
	private String publishingdate;
	@JsonInclude(Include.NON_NULL)
	public String title;
	@JsonInclude(Include.NON_NULL)
	private String short_description;
	@JsonInclude(Include.NON_NULL)
	private String text;
	@JsonInclude(Include.NON_NULL)
	private String errorMessage;
	public News(String id, String publishingdate, String title,
			String short_description, String text) {
		super();
		this.id = id;
		this.publishingdate = publishingdate;
		this.title = title;
		this.short_description = short_description;
		this.text = text;
	}
	
	public News(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}



	public String getPublishingdate() {
		return publishingdate;
	}

	public void setPublishingdate(String publishingdate) {
		this.publishingdate = publishingdate;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getShort_description() {
		return short_description;
	}
	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}


    public News() {}
}
