package org.example.server.rbac;

import org.picketlink.idm.IdentityManager;
import org.picketlink.idm.PartitionManager;
import org.picketlink.idm.RelationshipManager;
import org.picketlink.idm.credential.Password;
import org.picketlink.idm.model.basic.Role;
import org.picketlink.idm.model.basic.User;

import static org.picketlink.idm.model.basic.BasicModel.grantRole;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import static org.example.server.rbac.ApplicationRole.ADMINISTRATOR;
import static org.example.server.rbac.ApplicationRole.DEVELOPER;
import static org.example.server.rbac.ApplicationRole.PROJECT_MANAGER;

@Singleton
@Startup
public class SecurityInitializer {

	@Inject
	private PartitionManager partitionManager;

	@PostConstruct
	public void createUsers() {
		createUser("admin", ADMINISTRATOR);
		createUser("john", PROJECT_MANAGER);
		createUser("kate", DEVELOPER);
	}

	private void createUser(String loginName, String roleName) {
		User user = new User(loginName);

		IdentityManager identityManager = this.partitionManager.createIdentityManager();
		identityManager.add(user);

		Password password = new Password(loginName + "123");
		identityManager.updateCredential(user, password);

		Role role = new Role(roleName);
		identityManager.add(role);

		RelationshipManager relationshipManager = this.partitionManager.createRelationshipManager();
		grantRole(relationshipManager, user, role);
	}
}
