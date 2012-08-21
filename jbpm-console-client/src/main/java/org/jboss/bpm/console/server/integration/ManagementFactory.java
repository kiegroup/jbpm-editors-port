package org.jboss.bpm.console.server.integration;


import org.jboss.bpm.console.server.util.ServiceLoader;

/**
 * Construct management implementation.
 * It uses the {@link org.jboss.bpm.console.server.util.ServiceLoader} to load concrete
 * factory implementations.
 */
public abstract class ManagementFactory {
    public static ManagementFactory newInstance() {
        return (ManagementFactory)
                ServiceLoader.loadService(
                        ManagementFactory.class.getName(),
                        "org.jboss.bpm.console.server.integration.implementation.ManagementFactory"
                );
    }

    public abstract ProcessManagement createProcessManagement();

    public abstract TaskManagement createTaskManagement();

    public abstract UserManagement createUserManagement();

}
