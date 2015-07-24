/**
 *
 */
package jp.ac.asojuku.jousen.rpg;

import android.content.Context;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author user
 *
 */
public class DBManager extends SQLiteOpenHelper {

	/* (鬮ｱ繝ｻJavadoc)
	 * @see android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite.SQLiteDatabase)
	 */

	public DBManager(Context context){
		super(context, "rpg.sqlite3", null, 2);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO 髢ｾ�ｽｪ陷肴�募�ｽ隰瑚�鯉ｼ�郢ｧ蠕娯螺郢晢ｽ｡郢ｧ�ｽｽ郢昴�ｻ繝ｩ郢晢ｽｻ郢ｧ�ｽｹ郢ｧ�ｽｿ郢昴�ｻ

		db.execSQL("create table if not exists player(player_id integer primary key autoincrement, name text, job_id integer)");
		db.execSQL("insert into Player (player_id) values (1)");

		db.execSQL("create table if not exists job(job_id integer primary key autoincrement, name text, hp integer, atk integer, mag integer)");
		db.execSQL("insert into job (name, hp, atk, mag) values ('戦士', " + 150 + ", " + 15 + ", " + 20 + ")");
		db.execSQL("insert into job (name, hp, atk, mag) values ('魔導士', " + 100 + ", " + 10 + ", " + 1000 + ")");

		db.execSQL("create table if not exists enemy(enemy_id integer primary key autoincrement, name text, hp integer, atk integer, mag integer)");
		db.execSQL("insert into enemy (name, hp, atk, mag) values ('ザコ', " + 100 + ", " + 10 + ", " + 20 + ")");
		db.execSQL("insert into enemy (name, hp, atk, mag) values ('中ボス', " + 500 + ", " + 30 + ", " + 1000 + ")");
	}

	/* (鬮ｱ繝ｻJavadoc)
	 * @see android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database.sqlite.SQLiteDatabase, int, int)
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO 髢ｾ�ｽｪ陷肴�募�ｽ隰瑚�鯉ｼ�郢ｧ蠕娯螺郢晢ｽ｡郢ｧ�ｽｽ郢昴�ｻ繝ｩ郢晢ｽｻ郢ｧ�ｽｹ郢ｧ�ｽｿ郢昴�ｻ
		db.execSQL("DROP TABLE player");
		onCreate(db);
	}

	public void insertName(SQLiteDatabase db, String inputName){

		String sql = "insert into player(name) values(?)";
		db.execSQL(sql, new String[]{inputName});
	}

	public void updateName(SQLiteDatabase db, String inputName){

		String sql = "update player set name = (?) where player_id = 1";
		db.execSQL(sql, new String[]{inputName});
	}

	public void deletePlayer(SQLiteDatabase db){
		String sql = "drop table player";
		db.execSQL(sql);
		String del = "drop table job";
		db.execSQL(del);

		db.execSQL("create table if not exists player(player_id integer primary key autoincrement, name text, job_id integer)");
		db.execSQL("insert into Player (player_id) values (1)");

		db.execSQL("create table if not exists job(job_id integer primary key autoincrement, name text, hp integer, atk integer, mag integer)");
		db.execSQL("insert into job (name, hp, atk, mag) values ('戦士', " + 150 + ", " + 15 + ", " + 20 + ")");
		db.execSQL("insert into job (name, hp, atk, mag) values ('魔導士', " + 100 + ", " + 10 + ", " + 1000 + ")");

		db.execSQL("create table if not exists enemy(enemy_id integer primary key autoincrement, name text, hp integer, atk integer, mag integer)");
		db.execSQL("insert into enemy (name, hp, atk, mag) values ('ザコ', " + 100 + ", " + 10 + ", " + 20 + ")");
		db.execSQL("insert into enemy (name, hp, atk, mag) values ('中ボス', " + 500 + ", " + 30 + ", " + 1000 + ")");

	}

	public SQLiteCursor selectPlayer(SQLiteDatabase db){
		String sql = "select name from player order by player_id";

		SQLiteCursor cursor = (SQLiteCursor)db.rawQuery(sql, null);

		return cursor;
	}

	public SQLiteCursor selectJob(SQLiteDatabase db){
		String sql = "select j.name from player p, job j where p.job_id = j.job_id and p.player_id = 1 order by player_id";

		SQLiteCursor cursor = (SQLiteCursor)db.rawQuery(sql, null);

		return cursor;
	}
	public SQLiteCursor selectHp(SQLiteDatabase db){
		String sql = "select j.hp from player p, job j where p.job_id = j.job_id and p.player_id = 1 order by player_id";

		SQLiteCursor cursor = (SQLiteCursor)db.rawQuery(sql, null);

		return cursor;
	}
	public SQLiteCursor selectMp(SQLiteDatabase db){
		String sql = "select j.mag from player p, job j where p.job_id = j.job_id and p.player_id = 1 order by player_id";

		SQLiteCursor cursor = (SQLiteCursor)db.rawQuery(sql, null);

		return cursor;
	}

	public void insertJobAtk(SQLiteDatabase db){

		String sql = "update player set job_id = 1 where player_id = 1";
		db.execSQL(sql);

	}

	public void insertJobMag(SQLiteDatabase db){

		String sql = "update player set job_id = 2 where player_id = 1";
		db.execSQL(sql);

	}
	public SQLiteCursor selectEnemyHp(SQLiteDatabase db){
		String sql = "select hp from enemy where enemy_id = 1";

		SQLiteCursor cursor = (SQLiteCursor)db.rawQuery(sql, null);

		return cursor;
	}

}