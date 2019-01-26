package tech.lapsa.eurasia.facade.beans;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import tech.lapsa.eurasia.dao.CompanyPointOfSaleDAO.CompanyPointOfSaleDAORemote;
import tech.lapsa.eurasia.domain.CompanyPointOfSale;
import tech.lapsa.eurasia.facade.CompanyPointOfSaleFacade;
import tech.lapsa.eurasia.facade.CompanyPointOfSaleFacade.CompanyPointOfSaleFacadeLocal;
import tech.lapsa.eurasia.facade.CompanyPointOfSaleFacade.CompanyPointOfSaleFacadeRemote;

@Stateless(name = CompanyPointOfSaleFacade.BEAN_NAME)
public class CompanyPointOfSaleFacadeBean implements CompanyPointOfSaleFacadeLocal, CompanyPointOfSaleFacadeRemote {

    // READERS

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<CompanyPointOfSale> findAll() {
	return _findAll();

    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<CompanyPointOfSale> findAllAvailable() {
	return _findAllAvailable();

    }

    // MODIFIERS

    // PRIVATE

    @EJB
    private CompanyPointOfSaleDAORemote dao;

    private List<CompanyPointOfSale> _findAll() {
	return dao.findAll();
    }

    private List<CompanyPointOfSale> _findAllAvailable() {
	return dao.findAllByAvailable(true);
    }
}
