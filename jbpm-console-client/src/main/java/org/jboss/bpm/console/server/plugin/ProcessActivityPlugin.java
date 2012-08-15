package org.jboss.bpm.console.server.plugin;

public interface ProcessActivityPlugin {

    byte[] getProcessImage(String definitionId);

    byte[] getProcessInstanceImage(String definition, String instanceId);

}
