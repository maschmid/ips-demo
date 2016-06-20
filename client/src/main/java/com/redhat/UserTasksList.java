package com.redhat;

import org.kie.server.api.model.instance.TaskInstance;
import org.kie.server.api.model.instance.TaskSummary;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;
import org.kie.server.client.ProcessServicesClient;
import org.kie.server.client.UserTaskServicesClient;

import com.redhat.xpaas.qe.loanapproval.Application;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by maschmid on 20/06/16.
 */
public class UserTasksList {
	private static final String ENDPOINT = "http://kie-app-maschmid.apps.latest.xpaas/kie-server/services/rest/server";

	//private static final String USERNAME = "joe";
	//private static final String PASSWORD = "joejoejoe123!";

	public static void main(String[] args) {

		final String username = args[0];
		final String password = args[1];

		KieServicesConfiguration config = KieServicesFactory.newRestConfiguration(ENDPOINT, username, password);

		Set<Class<?>> classes = new HashSet<>();
		classes.add(Application.class);
		config.addJaxbClasses(classes);

		KieServicesClient client = KieServicesFactory.newKieServicesClient(config);

		final UserTaskServicesClient userTaskServicesClient = client.getServicesClient(UserTaskServicesClient.class);

		for (TaskSummary taskSummary : userTaskServicesClient.findTasks(username, 0, 50)) {
			System.out.println("task: " + taskSummary.getName() + " owned by: " + taskSummary.getActualOwner());
		}
	}
}
