package com.example.tugaspppl.dao.season;

import com.example.tugaspppl.dao.My_Connection;
import com.example.tugaspppl.model.Season;

import java.sql.Statement;

public class SeasonDaoImpl extends My_Connection implements SeasonDaoCustom {
    @Override
    public void saveSeason(Season season){
        System.out.println("masuk insert season");
        String query="INSERT INTO `tbl_season`(`idSeason`, `idCabang`, `startDate`, " +
                "`endDate`, `namaSeason`, `persentase`, `jenisPersentase`, `statusSeason`) " +
                "VALUES (NULL,"+season.getSeasonCabangMap().getIdCabang()+",'"+season.getStartDate()+"','"+season.getEndDate()+"'," +
                "'"+season.getNamaSeason()+"',"+season.getPersentase()+",'"+season.getJenisPersentase()+"',1)";
        try {
            this.makeConnection();
            System.out.println("test");
            Statement statement = this.con.createStatement();
            System.out.println("test");
            statement.executeUpdate(query);
            System.out.println(query);
            System.out.println("berhasil input season shay");
            this.disconnect();
        } catch (Exception e) {
            System.out.println("Error while get nextval.."+e.toString());
        }
    }
}
