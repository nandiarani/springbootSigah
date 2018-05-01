package com.example.tugaspppl.dao.reservasi;

import com.example.tugaspppl.model.Kamar;
import com.example.tugaspppl.model.TempReservasi;

import java.util.List;

public interface ReservasiDaoCustom {
    String generateIDBooking();
    List<Kamar> cariKamarTersedia(TempReservasi tempReservasi);
}
