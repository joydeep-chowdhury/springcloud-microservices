package joydeep.poc.springcloud.microservices.property.accessor.utils;

import java.net.InetAddress;

public class PropertyAccessServiceUtils {

	public static final String CONFIG_REFRESH_ENDPOINT = "/actuator/refresh";
	public static final String CONFIG_HOST_ADDRESS = InetAddress.getLoopbackAddress().getHostAddress();
	public static final String PROTOCOL = "http://";
}
