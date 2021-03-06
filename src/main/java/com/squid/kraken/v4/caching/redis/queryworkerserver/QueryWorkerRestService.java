/*******************************************************************************
 * Copyright © Squid Solutions, 2016
 *
 * This file is part of Open Bouquet software.
 *  
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation (version 3 of the License).
 *
 * There is a special FOSS exception to the terms and conditions of the 
 * licenses as they are applied to this program. See LICENSE.txt in
 * the directory of this program distribution.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * Squid Solutions also offers commercial licenses with additional warranties,
 * professional functionalities or services. If you purchase a commercial
 * license, then it supersedes and replaces any other agreement between
 * you and Squid Solutions (above licenses and LICENSE.txt included).
 * See http://www.squidsolutions.com/EnterpriseBouquet/
 *******************************************************************************/
package com.squid.kraken.v4.caching.redis.queryworkerserver;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QueryWorkerRestService {

	private IQueryWorkerServer serv;

	static final Logger logger = LoggerFactory.getLogger(QueryWorkerRestService.class);

	public QueryWorkerRestService(IQueryWorkerServer s) {
		logger.info(" new Query Worker Rest");
		this.serv = s;
	}

	@GET
	@Path("/fetch")
	public int fetch(@QueryParam("request") QueryWorkerJobRequest request) throws InterruptedException {
		return this.serv.fetch(request);
	}

	@GET
	@Path("/hello")
	public String hello() {
		return serv.hello();
	}

	@GET
	@Path("/load")
	public int getLoad() {
		return this.serv.getLoad();
	}

	@GET
	@Path("/ongoing")
	public boolean fetch(@QueryParam("key") String key, @QueryParam("sqlquery") String SQLQuery)
			throws InterruptedException {
		return this.serv.isQueryOngoing(key);
	}
	
	@GET
	@Path("/queries")
	public List<QueryWorkerJobStatus> queries(@QueryParam("customerId") String customerId) {
		return this.serv.getOngoingQueries(customerId);
	}

}
