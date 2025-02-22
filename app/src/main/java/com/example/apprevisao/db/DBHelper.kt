package com.example.apprevisao.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DBHelper (context: Context, factory: SQLiteDatabase.CursorFactory?) :
        SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val query = ("CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY, " +
                NAME_COL + " TEXT," +
                END_COL + " TEXT," +
                BAR_COL + " TEXT," +
                CEP_COL + " TEXT," +
                TEL_COL + " TEXT" + ")")

        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    fun addPessoa(name : String, endereco : String, bairro : String, cep : String, tel : String){
        val values = ContentValues()
        values.put(NAME_COL, name)
        values.put(END_COL, endereco)
        values.put(BAR_COL, bairro)
        values.put(CEP_COL, cep)
        values.put(TEL_COL, tel)


        val db = this.writableDatabase

        db.insert(TABLE_NAME, null, values)

        db.close()
    }

    companion object{

        private val DATABASE_NAME = "FormsPam"
        private val DATABASE_VERSION = 2
        val TABLE_NAME = "CadastForms"
        val ID_COL = "id"
        val NAME_COL = "name"
        val END_COL = "endereco"
        val BAR_COL = "bairro"
        val CEP_COL = "cep"
        val TEL_COL = "telefone"
    }
        }
