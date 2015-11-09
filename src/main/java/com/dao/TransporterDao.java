package com.dao;

import com.model.Transporter;

import java.util.List;

public interface TransporterDao {
    public void addTransporter(Transporter transporter);

    public void deleteTransporter(int id_tran);

    public void updateTransporter(int id_tran);

    public Transporter getTransporter(int id_tran);

    public List<Transporter> getTransporters();
}
