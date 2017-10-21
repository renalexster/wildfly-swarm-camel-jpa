package org.swarm_cdi.utils;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Resources {
	@Produces
	Logger getLogger(InjectionPoint ip) {
		return LoggerFactory.getLogger(ip.getClass());
	}
}