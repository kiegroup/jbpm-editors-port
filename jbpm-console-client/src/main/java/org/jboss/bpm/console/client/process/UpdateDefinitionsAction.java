package org.jboss.bpm.console.client.process;

import java.util.List;

import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.Response;
import org.jboss.bpm.console.client.common.AbstractRESTAction;
import org.jboss.bpm.console.client.common.DataDriven;
import org.jboss.bpm.console.client.common.URLBuilder;
import org.jboss.bpm.console.client.model.JSOParser;
import org.jboss.bpm.console.client.model.ProcessDefinitionRef;
import org.jboss.bpm.console.client.util.ConsoleLog;

public class UpdateDefinitionsAction extends AbstractRESTAction {

    public final static String ID = UpdateDefinitionsAction.class.getName();
    private final DataDriven dataDriven;

    public UpdateDefinitionsAction(DataDriven dataDriven) {

        this.dataDriven = dataDriven;
    }

    public String getId() {
        return ID;
    }

    public String getUrl(Object event) {
        return URLBuilder.getInstance().getProcessDefinitionsURL();
    }

    public RequestBuilder.Method getRequestMethod() {
        return RequestBuilder.GET;
    }

    public void handleSuccessfulResponse(final Object event, Response response) {
        long start = System.currentTimeMillis();

        List<ProcessDefinitionRef> definitions =
                JSOParser.parseProcessDefinitions(response.getText());
        dataDriven.update(definitions);
        ConsoleLog.info("Loaded " + definitions.size() + " process definitions in " + (System.currentTimeMillis() - start) + " ms");
    }
}
