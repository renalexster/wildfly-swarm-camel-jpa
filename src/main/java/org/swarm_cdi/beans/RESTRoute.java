package org.swarm_cdi.beans;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;
import org.slf4j.Logger;

@ApplicationScoped
@ContextName("rest")
public class RESTRoute extends RouteBuilder {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Logger logger;

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		logger.info("############### CONFIGURE CAMEL ROUTE ###############");
		restConfiguration().component("undertow").contextPath("/hello");
		
		rest("/ping").get().produces("text/plain").route().setBody().constant("Hello");
		
		rest("/person").get().produces("application/json").route().enrich("jpa://org.swarm_cdi.model.Person").endRest();
	}
	
	
}