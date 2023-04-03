package com.example.invbike;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ProduktDao_Impl implements ProduktDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Produkt> __insertionAdapterOfProdukt;

  private final EntityDeletionOrUpdateAdapter<Produkt> __deletionAdapterOfProdukt;

  public ProduktDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfProdukt = new EntityInsertionAdapter<Produkt>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Produkt` (`Name`,`nazwa`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Produkt value) {
        if (value.getName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getName());
        }
        if (value.getN() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getN());
        }
      }
    };
    this.__deletionAdapterOfProdukt = new EntityDeletionOrUpdateAdapter<Produkt>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Produkt` WHERE `Name` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Produkt value) {
        if (value.getName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getName());
        }
      }
    };
  }

  @Override
  public void insert(final Produkt cart) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfProdukt.insert(cart);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Produkt cart) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfProdukt.handle(cart);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Produkt> getAll() {
    final String _sql = "SELECT * FROM produkt";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "Name");
      final int _cursorIndexOfN = CursorUtil.getColumnIndexOrThrow(_cursor, "nazwa");
      final List<Produkt> _result = new ArrayList<Produkt>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Produkt _item;
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final Integer _tmpN;
        if (_cursor.isNull(_cursorIndexOfN)) {
          _tmpN = null;
        } else {
          _tmpN = _cursor.getInt(_cursorIndexOfN);
        }
        _item = new Produkt(_tmpName,_tmpN);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Produkt findByName(final String name) {
    final String _sql = "SELECT * FROM produkt WHERE name = ? limit 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (name == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, name);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "Name");
      final int _cursorIndexOfN = CursorUtil.getColumnIndexOrThrow(_cursor, "nazwa");
      final Produkt _result;
      if(_cursor.moveToFirst()) {
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final Integer _tmpN;
        if (_cursor.isNull(_cursorIndexOfN)) {
          _tmpN = null;
        } else {
          _tmpN = _cursor.getInt(_cursorIndexOfN);
        }
        _result = new Produkt(_tmpName,_tmpN);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
