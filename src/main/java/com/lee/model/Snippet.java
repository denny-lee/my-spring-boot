package com.lee.model;

public class Snippet {

	private Long id;
	
	private String tag;
	
	private String content;
	
	private String description;
	
	private String language;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Snippet) || null == obj) {
			return false;
		}
		Snippet s = (Snippet) obj;
		if(getId() == null || s.getId() == null) {
			return false;
		}
		return getId().equals(s.getId());
	}
	
}
