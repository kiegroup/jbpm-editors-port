/*
 * Copyright 2012 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jboss.bpm.console.client;

import org.jboss.bpm.console.client.model.PluginInfo;
import org.jboss.bpm.console.client.model.ServerStatus;

public class ServerPlugins {

    private static ServerStatus status;

    public static void setStatus(ServerStatus s) {
        status = s;
    }

    public static ServerStatus getStatus() {
        return status;
    }

    public static boolean has(String type) {
        boolean match = false;

        if (status != null) {
            for (PluginInfo p : status.getPlugins()) {
                if (p.getType().equals(type)) {
                    match = p.isAvailable();
                    break;
                }
            }
        }
        return match;
    }
}