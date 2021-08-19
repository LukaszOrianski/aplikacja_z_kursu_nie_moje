package weekop.service;

import weekop.dao.DAOFactory;
import weekop.dao.UserDAO;
import weekop.model.User;

public class UserService {
	public void addUser(String username, String email, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setActive(true);
		DAOFactory factory = DAOFactory.getDAOFactory();
		UserDAO userDAO = factory.getUserDAO();
		userDAO.create(user);
	}

	public User getUserById(long userid) {
		User user = null;
		DAOFactory factory = DAOFactory.getDAOFactory();
		UserDAO userDAO = factory.getUserDAO();
		user = userDAO.read(userid);
		return user;
	}

	public User getUserByUsername(String username) {
		User user = null;
		DAOFactory factory = DAOFactory.getDAOFactory();
		UserDAO userDAO = factory.getUserDAO();
		user = userDAO.getUserByUsername(username);
		return user;
	}
}
