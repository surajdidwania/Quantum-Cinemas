package com.cs442.dsuraj.quantumc;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Suraj Didwania on 04-11-2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Movie.db";
    public static final String TABLE_NAME1 = "Movies";
    public static final String TABLE_NAME3 = "Movies_Booked";
    public static final String TABLE_NAME4 = "User_Info";
    public static final String T1_COL_1 = "MovieName";
    public static final String T1_COL_2 = "Movie_Id";
    public static final String T1_COL_3 = "Information";
    public static final String T1_COL_4 = "Ratings";
    public static final String T1_COL_5 = "User_Reviews";
    public static final String T1_COL_6 = "ComingSoon";
    public static final String T1_COL_7 = "Seats_Available";
    public static final String T2_COL_1 = "Theatres";
    public static final String T2_COL_2 = "Timings";
    public static final String T2_COL_3 = "Price";
    public static final String T2_COL_4 = "Movie_ID";
    public static final String T3_COL_1 = "Movie_Id";
    public static final String T3_COL_2 = "Timings";
    public static final String T3_COL_3 = "Theatres";
    public static final String T3_COL_4 = "Email";
    public static final String T3_COL_5 = "Phone";
    public static final String T3_COL_6 = "Booking_ID";
    public static final String T3_COL_7 = "Quantity";

    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME1 +" (NAME VARCHAR, MOVIE_ID INTEGER PRIMARY KEY AUTOINCREMENT,INFORMATION VARCHAR, RATINGS INTEGER)");
        db.execSQL("create table " + TABLE_NAME3 +" (BOOKINGID INTEGER PRIMARY KEY AUTOINCREMENT,MOVIE_ID INTEGER,TIMINGS TIME,THEATRES VARCHAR,EMAIL VARCHAR,PRICE INTEGER,SHOW_DATE DATE, PHONE  VARCHAR,SEATS_NO  VARCHAR,FOREIGN KEY(MOVIE_ID) REFERENCES Movies(MOVIE_ID))");
        db.execSQL("create table " + TABLE_NAME4 +" (USER_ID VARCHAR, NAME VARCHAR,EMAIL VARCHAR )");
        ContentValues content = new ContentValues();
        db.execSQL("insert into " + TABLE_NAME1 +" (NAME,INFORMATION, RATINGS)" + "VALUES" + "('Fly Paper','A man caught in the middle of two simultaneous robberies at the same bank desperately tries to protect the teller with whom he secretly in love.','5')");
        db.execSQL("insert into " + TABLE_NAME1 + " (NAME,INFORMATION,RATINGS)"+ "VALUES" + "('Mission: Impossible - Rogue Nation','Ethan and team take on their most impossible mission yet, eradicating the Syndicate - an International rogue organization as highly skilled as they are, committed to destroying the IMF.','4')");
        db.execSQL("insert into " + TABLE_NAME1 + " (NAME,INFORMATION,RATINGS)"+ "VALUES"+ "('Avengers: Age of Ultron','Earths mightiest heroes must come together and learn to fight as a team if they are to stop the mischievous Loki and his alien army from enslaving humanity.','3')");
        db.execSQL("insert into " + TABLE_NAME1 + " (NAME,INFORMATION,RATINGS)"+ "VALUES"+ "('The Amazing Spider-Man 2','When New York is put under siege by Oscorp, it is up to Spider-Man to save the city he swore to protect as well as his loved ones.','4')");
       // db.execSQL("insert into " + TABLE_NAME4 + " (SEAT,THEATRE,TIMINGS,DATE_CURRENT, MOVIE_ID)" + "VALUES" + "('A1','AMC RIVER EAST 21',''11:55',)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME1);
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME3);
        onCreate(db);
    }
    //Sushma Database part
    public boolean insertmoviebooked(int id, String Seats, String theatre, String time, String date, int price, String Email, String phone)
    {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("Movie_ID",id);
        content.put("TIMINGS",time);
        content.put("THEATRES",theatre);
        content.put("SHOW_DATE", date);
        content.put("PRICE", price);
        content.put("EMAIL",Email);
        content.put("PHONE",phone);
        content.put("SEATS_NO",Seats);
        long result = db.insert(TABLE_NAME3,null,content);
        if(result == -1) return false; else return true;
    }
    public boolean insertuser(String id,String name, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("USER_ID",id);
        content.put("NAME", name);
        content.put("EMAIL", email);
        long result = db.insert(TABLE_NAME4, null, content);
        if (result == -1) return false;
        else return true;
    }
    //Seat Selection
    /*
    public boolean insertseatbooked(int id, String Seats, String theatre, String time, String date)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("Movie_ID",id);
        content.put("TIMINGS",time);
        content.put("THEATRES",theatre);
        content.put("DATE_CURRENT", date);
        content.put("SEATS", Seats);
        long result = db.insert(TABLE_NAME4,null,content);
        if(result == -1) return false; else return true;
    }*/
    /*
    public boolean insertdatamovie(String movie_name, String Details, String ratings, String User_review, boolean comingsoon, int seats_available )
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME1);
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME3);
        onCreate(db);

        ContentValues content = new ContentValues();
        content.put("NAME",movie_name);
        content.put("INFORMATION",Details);
        content.put("RATINGS",ratings);
        long result = db.insert(TABLE_NAME1,null,content);
        if(result == -1) return false; else return true;
    }
    */
    /*
    public boolean insertdatatimimgs(int MOVIE_ID,String Theatres, String Timings, int price)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("MOVIE_ID",MOVIE_ID);
        content.put("THEATRES",Theatres);
        content.put("TIMINGS",Timings);
        content.put("PRICE",price);
        long result = db.insert(TABLE_NAME2,null,content);
        if(result == -1) return false; else return true;
    }
*/
    //Max Booking ID
    public Cursor getmaxbooking(SQLiteDatabase db)
    {
        Cursor cursor;
        String sql = "Select max(BOOKINGID) from "  + TABLE_NAME3;
        cursor = db.rawQuery(sql,null);
        return cursor;
    }
    public Cursor getData(SQLiteDatabase db,String  Booking_ID)
    {
        Cursor cursor;
        String sql="SELECT t1.NAME,t2.THEATRES,t2.PRICE,t2.SHOW_DATE,t2.TIMINGS,t2.EMAIL,t2.PHONE,t2.SEATS_NO FROM Movies_Booked t2,Movies t1 WHERE  t1.MOVIE_ID=t2.MOVIE_ID AND t2.BOOKINGID=? ";

        cursor = db.rawQuery(sql,new String[]{Booking_ID});
        System.out.println(Booking_ID);

        return cursor;
    }
    //Suraj Part
    public Cursor getseats( SQLiteDatabase db, String Theatre, String date, String time, int movie_id)
    {
        Cursor cursor=null;
        System.out.print(Theatre + date + time + movie_id);
        String sql = "select SEATS_NO from " + TABLE_NAME3 + " where MOVIE_ID = ? and THEATRES = ? and TIMINGS = ? AND SHOW_DATE = ?";
            cursor = db.rawQuery(sql, new String[]{Integer.toString(movie_id), Theatre, time, date});
            Cursor md = getAllDataMovies();
            while(md.moveToNext())
            {
                System.out.print(md);
            }
            System.out.print(cursor);
            System.out.print(cursor.getCount());

        return cursor;

    }
    public Cursor getAllDataMovies()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "select * from " +TABLE_NAME1;
        Cursor res = db.rawQuery(sql,null);
        return res;

    }
    /*
    public Cursor getAllDataTimings()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select MovieName,Information,Rating from " + TABLE_NAME2,null);
        return res;

    }*/
    public Cursor getMoviename(SQLiteDatabase db, String movie_id)
    {
        Cursor cursor;
       String sql = "select NAME FROM "+ TABLE_NAME1+ " where MOVIE_ID = ?";
        cursor = db.rawQuery(sql, new String[]{movie_id});
        System.out.print(movie_id);
        return cursor ;
    }
    /*
    public Cursor getAllDataBooked()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select MovieName,Theatre,Timing from " + TABLE_NAME2,null);
        return res;

    }
*/
}

