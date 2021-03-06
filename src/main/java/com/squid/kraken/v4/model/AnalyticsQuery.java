package com.squid.kraken.v4.model;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squid.kraken.v4.model.AnalyticsQueryImpl.AnalysisFacetImpl;
import com.squid.kraken.v4.model.NavigationQuery.Style;

@JsonDeserialize(as = AnalyticsQueryImpl.class)
public interface AnalyticsQuery extends AnalyticsSelection {
	
	public String getBBID();
	
	void setBBID(String BBID);

	public String getDomain();

	public void setDomain(String domain);

	public List<String> getGroupBy();
	
	public void setGroupBy(List<String> facets);
	
	public List<String> getMetrics();

	public void setMetrics(List<String> facets);

	public List<String> getOrderBy();

	public void setOrderBy(List<String> orderBy);

	public List<String> getRollups();

	public void setRollups(List<String> rollups);

	public Long getOffset();

	public void setOffset(Long offset);

	public Long getLimit();

	public void setLimit(Long limit);
	
	public String getBookmarkId();

	public void setBookmarkId(String bookmarkId);
	
	void setStyle(Style style);

	Style getStyle();

	void setLazy(String lazy);

	String getLazy();

	void setStartIndex(Integer startIndex);

	Integer getStartIndex();

	void setMaxResults(Integer maxResults);

	Integer getMaxResults();
	
	// temporary support for beyondLimit
	
	List<String> getBeyondLimit();
	
	void setBeyondLimit(List<String> cols);

	/**
	 * return an unique identifier based on the query value, i.e. two identical queries will have the same ID.
	 * @return
	 */
	String getQueryID();
	
	List<Problem> getProblems();
	
	void setProblems(List<Problem> problems);
	
	void add(Problem problem);

	@JsonDeserialize(as = AnalysisFacetImpl.class)
	static public interface AnalysisFacet {
		
		public String getName();
		
		public void setName(String name);
		
		public String getExpression();
		
		public void setExpression(String expression);
		
	}

}