package app.dao.hibernate;

import app.dao.BaseHibernateDAO;
import app.dao.CampoDAO;
import app.model.Campo;
import app.model.Local;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("campoDAO")
public class CampoDAOH extends BaseHibernateDAO implements CampoDAO {

    public List<Campo> list() {
        Criteria criteria = this.getSession().createCriteria(Campo.class);
        criteria.addOrder(Order.desc("descripcion"));
        criteria.addOrder(Order.asc("costoHora"));
        return criteria.list();
    }

    public List<Campo> allByLocal(Local local) {
        Criteria criteria = this.getSession().createCriteria(Campo.class);
        criteria.add(Restrictions.eq("local", local));
        criteria.addOrder(Order.desc("descripcion"));
        criteria.addOrder(Order.asc("costoHora"));
        return criteria.list();
    }

    public Campo get(Campo t) {
        Criteria criteria = this.getSession().createCriteria(Campo.class);
        criteria.add(Restrictions.eq("id", t.getId()));
        return (Campo) criteria.uniqueResult();
    }

    @Transactional
    public void save(Campo t) {
        this.getSession().save(t);
    }

    @Transactional
    public void update(Campo t) {
        this.getSession().merge(t);
    }

    @Transactional
    public void delete(Campo t) {
        this.getSession().delete(t);
    }

    public Campo getByName(String descripcion) {
       Criteria criteria = this.getSession().createCriteria(Campo.class);
        criteria.add(Restrictions.like("descripcion", descripcion, MatchMode.ANYWHERE));
        return (Campo) criteria.uniqueResult();
    
    }

    @Override
    public List<Local> allLocal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
