package weekop.service;

import java.util.Date;
import java.sql.Timestamp;

import weekop.dao.DAOFactory;
import weekop.dao.DiscoveryDAO;
import weekop.model.Discovery;
import weekop.model.User;

public class DiscoveryService {

	public void addDiscovery(String name, String desc, String url, User user) {
		Discovery discovery = creatDiscoveryObject(name, desc, url, user);
		DAOFactory factory = DAOFactory.getDAOFactory();
		DiscoveryDAO discoveryDAO = factory.getDiscoveryDAO();
		discoveryDAO.create(discovery);
	}

	private Discovery creatDiscoveryObject(String name, String desc, String url, User user) {
		Discovery discovery = new Discovery();
		discovery.setName(name);
		discovery.setDescription(desc);
		discovery.setUrl(url);
		User userCopy = new User(user);
		discovery.setUser(userCopy);
		discovery.setTimestamp(new Timestamp(new Date().getTime()));
		return discovery;
	}

}
