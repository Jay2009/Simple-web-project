package org.zerock.domain;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class ProjectPageMaker {

	  private int totalCount;
	  private int startPage;
	  private int endPage;
	  private boolean prev;
	  private boolean next;

	  private int displayPageNum = 10;

	  private ProjectCriteria projectcri;

	  public void setCri(ProjectCriteria projectcri) {
	    this.projectcri = projectcri;
	  }

	  public void setTotalCount(int totalCount) {
	    this.totalCount = totalCount;

	    calcData();
	  }

	  private void calcData() {

	    endPage = (int) (Math.ceil(projectcri.getPage() / (double) displayPageNum) * displayPageNum);

	    startPage = (endPage - displayPageNum) + 1;

	    int tempEndPage = (int) (Math.ceil(totalCount / (double) projectcri.getPerPageNum()));

	    if (endPage > tempEndPage) {
	      endPage = tempEndPage;
	    }

	    prev = startPage == 1 ? false : true;

	    next = endPage * projectcri.getPerPageNum() >= totalCount ? false : true;

	  }

	  public int getTotalCount() {
	    return totalCount;
	  }

	  public int getStartPage() {
	    return startPage;
	  }

	  public int getEndPage() {
	    return endPage;
	  }

	  public boolean isPrev() {
	    return prev;
	  }

	  public boolean isNext() {
	    return next;
	  }

	  public int getDisplayPageNum() {
	    return displayPageNum;
	  }

	  public ProjectCriteria getCri() {
	    return projectcri;
	  }

	  public String makeQuery(int page) {

	    UriComponents uriComponents = UriComponentsBuilder.newInstance().queryParam("page", page)
	        .queryParam("PageNum", projectcri.getPerPageNum()).build();

	    return uriComponents.toUriString();
	  }
	  
	  
	  public String makeSearch(int page){
	    
	    UriComponents uriComponents =
	              UriComponentsBuilder.newInstance()
	              .queryParam("page", page)
	              .queryParam("perPageNum", projectcri.getPerPageNum())
	              .queryParam("searchType", ((ProjectSearchCriteria)projectcri).getSearchType())
	              .queryParam("keyword", ((ProjectSearchCriteria)projectcri).getKeyword())
	              .build();             
	    
	    return uriComponents.toUriString();
	  } 
}
