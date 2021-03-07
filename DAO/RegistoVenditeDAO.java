package DAO;

import java.util.List;

import Classi.RegistroVendite;

public interface RegistoVenditeDAO {
	/**
	 *
	 * @return
	 */
	List<RegistroVendite> getAllRegistroVendite();

	/**
	 *
	 */
	void updateRegistroVendite();

	/**
	 *
	 */
	void delateRegistroVendite();

	/**
	 *
	 * @param o1
	 */
	void addRegistroVendite(RegistroVendite o1);

}