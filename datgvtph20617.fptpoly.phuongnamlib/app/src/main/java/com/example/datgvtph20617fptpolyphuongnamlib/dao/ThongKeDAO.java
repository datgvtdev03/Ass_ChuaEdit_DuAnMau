package com.example.datgvtph20617fptpolyphuongnamlib.dao;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.example.datgvtph20617fptpolyphuongnamlib.database.DBHelper;
import com.example.datgvtph20617fptpolyphuongnamlib.model.Sach;
import com.example.datgvtph20617fptpolyphuongnamlib.model.Top;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ThongKeDAO {
    private SQLiteDatabase sqLiteDatabase;
    private Context context;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public ThongKeDAO(Context context) {
        this.context = context;
        DBHelper dbHelper = new DBHelper(context);
        sqLiteDatabase = dbHelper.getWritableDatabase();
    }

    //thong ke top 10
    public List<Top> getTop() {
        String sqlTop = "SELECT maSach, count(maSach) as soLuong FROM phieumuon GROUP BY maSach ORDER BY soLuong DESC LIMIT 10";
        List<Top> list = new ArrayList<>();
        SachDAO sachDAO = new SachDAO(context);
        Cursor cursor = sqLiteDatabase.rawQuery(sqlTop, null);
        while (cursor.moveToNext()) {
            Top top = new Top();
            Sach sach = sachDAO.getIdSach(cursor.getString(cursor.getColumnIndex("maSach")));
            top.tenSach = sach.tenSach;
            top.soLuong = Integer.parseInt(cursor.getString(cursor.getColumnIndex("soLuong")));
            list.add(top);
        }
        return list;
    }

    //thong ke doanh thu
    @SuppressLint("Range")
    public int getDoanhThu(String tuNgay, String denNgay) {
        String sqlDoanhThu = "SELECT SUM (tienThue) as doanhThu FROM phieumuon WHERE ngay BETWEEN ? AND ?";
        List <Integer> list = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sqlDoanhThu, new String[] {tuNgay, denNgay});

        while (cursor.moveToNext()) {
            try {
                list.add(Integer.parseInt(cursor.getString(cursor.getColumnIndex("doanhThu"))));
            } catch (Exception e) {
                list.add(0);
            }
        }
        return list.get(0);
    }

}
