package com.dao.impl;

import com.dao.TransporterDao;
import com.model.Transporter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransporterDaoImpl implements TransporterDao {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addTransporter(Transporter transporter) {
        getCurrentSession().save(transporter);
    }

    public void deleteTransporter(int id_tran) {
        Transporter transporter = getTransporter(id_tran);
        if (transporter != null) getCurrentSession().delete(transporter);
    }

    public void updateTransporter(Transporter transporter) {
        Transporter transporterToUpdate = getTransporter(transporter.getId_tran());
        transporterToUpdate.setName(transporter.getName());
        transporterToUpdate.setTelephone(transporter.getTelephone());
        transporterToUpdate.setDetails(transporter.getDetails());
        transporterToUpdate.setType(transporter.getType());
        transporterToUpdate.setOrders(transporter.getOrders());
        getCurrentSession().update(transporterToUpdate);
    }

    public Transporter getTransporter(int id_tran) {
        Transporter transporter = (Transporter) getCurrentSession().get(Transporter.class, id_tran);
        return transporter;
    }

    @SuppressWarnings("unchecked")
    public List<Transporter> getTransporters() {
        return getCurrentSession().createQuery("from Transporter").list();
    }
}
