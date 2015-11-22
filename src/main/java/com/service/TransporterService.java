package com.service;

import com.model.Transporter;

import java.util.List;

public interface TransporterService {

    public void addTransporter(Transporter transporter);

    public void deleteTransporter(int id_tran);

    public void updateTransporter(Transporter transporter);

    public Transporter getTransporter(int id_tran);

    public List<Transporter> getTransporters();
}
