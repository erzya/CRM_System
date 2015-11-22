package com.service.impl;

import com.dao.TransporterDao;
import com.model.Transporter;
import com.service.TransporterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TransporterServiceImpl implements TransporterService {

    @Autowired
    TransporterDao transporterDao;

    public void addTransporter(Transporter transporter) {
        transporterDao.addTransporter(transporter);
    }

    public void deleteTransporter(int id_tran) {
        transporterDao.deleteTransporter(id_tran);
    }

    public void updateTransporter(Transporter transporter) {
        transporterDao.updateTransporter(transporter);
    }

    public Transporter getTransporter(int id_tran) {
        return transporterDao.getTransporter(id_tran);
    }

    public List<Transporter> getTransporters() {
        return transporterDao.getTransporters();
    }
}
