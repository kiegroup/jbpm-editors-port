package org.jboss.bpm.console.server.integration;

import java.util.List;

public interface UserManagement {

    List<String> getGroupsForActor(String actorId);

    List<String> getActorsForGroup(String groupName);
}
