package com.example.tugaspppl.dao.user;

import com.example.tugaspppl.model.User;

import java.util.List;

public interface UserDaoCustom {
    List<User> getUserByUsername(String username);
    List<User> getUserByIdPelanggan(int idPelanggan);
    List<User> getUserByIdPegawai(int idPegawai);
    void inputUserPelanggan(User u,int idnext);
    int cekUsernameSama(User user);
    int cekPeranUser(User user);
    int cekKeaktifan(User user,int idPeran);

}
