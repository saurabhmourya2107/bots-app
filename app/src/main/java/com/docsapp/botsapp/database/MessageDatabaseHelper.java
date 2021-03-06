package com.docsapp.botsapp.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MessageDatabaseHelper extends SQLiteOpenHelper {


        // Table Name
        public static final String TABLE_NAME = "MESSAGES";

        // Table columns
        //The _ID is unique ID for each message in DB
        //The MESSAGE is actual message sent or received being stored in DB
        //The SENDER is the sender of the message
        //The IS_SYNCED notifies if this message is pushed to the server or not

        public static final String _ID = "_id";
        public static final String MESSAGE = "message";
        public static final String SENDER = "sender";
        public static final String IS_SYNCED = "isSynced";

        // Database Information
        static final String DB_NAME = "BOTS_CHAT.DB";

        // database version
        static final int DB_VERSION = 1;

        // Creating table query
        private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + _ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT, " + MESSAGE + " TEXT NOT NULL, " + SENDER + " TEXT NOT NULL, " +
                IS_SYNCED +" INTEGER DEFAULT 0" +")";

        public MessageDatabaseHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
}
