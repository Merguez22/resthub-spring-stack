package   org.resthub.identity.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.resthub.identity.model.Group;
import org.resthub.identity.model.User;
import org.resthub.oauth2.provider.service.AuthenticationService;

/*
 * This implementation is based on the UserService implementation from resthub-identity<br/>
 * The user Identifier is the Login
 * 
 * */
@Named("authenticationService")
public class AuthenticationServiceImpl extends UserServiceImpl implements
		AuthenticationService {

	@Override
	public String getUser(String userName, String password) {
		System.out.println("locking for "+userName+"wih pwd"+password);
		User u = this.authenticateUser(userName, password);
		return (u!=null)? u.getLogin() : null;
		}

	@Override
	public List<String> getUserPermissions(String userId) {
		List<String> userPermissisons = new ArrayList<String>();
		userPermissisons.addAll(this.findByLogin(userId).getPermissions());
		for( Group g : this.findByLogin(userId).getGroups()){
			userPermissisons.addAll(g.getPermissions());
		}
		return userPermissisons;
	}

}