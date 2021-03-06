package com.youcii.mvplearn.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.youcii.mvplearn.model.MovieEntity.MovieImages;
import com.youcii.mvplearn.model.MovieEntity.MovieImagesConverter;
import com.youcii.mvplearn.model.MovieEntity.MovieRating;
import com.youcii.mvplearn.model.MovieEntity.MovieRatingConverter;

import com.youcii.mvplearn.model.MovieEntity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "MOVIE_ENTITY".
*/
public class MovieEntityDao extends AbstractDao<MovieEntity, String> {

    public static final String TABLENAME = "MOVIE_ENTITY";

    /**
     * Properties of entity MovieEntity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, String.class, "id", true, "ID");
        public final static Property Title = new Property(1, String.class, "title", false, "TITLE");
        public final static Property Original_title = new Property(2, String.class, "original_title", false, "ORIGINAL_TITLE");
        public final static Property Alt = new Property(3, String.class, "alt", false, "ALT");
        public final static Property Images = new Property(4, String.class, "images", false, "IMAGES");
        public final static Property Rating = new Property(5, String.class, "rating", false, "RATING");
        public final static Property Year = new Property(6, String.class, "year", false, "YEAR");
        public final static Property Subtype = new Property(7, String.class, "subtype", false, "SUBTYPE");
    }

    private final MovieImagesConverter imagesConverter = new MovieImagesConverter();
    private final MovieRatingConverter ratingConverter = new MovieRatingConverter();

    public MovieEntityDao(DaoConfig config) {
        super(config);
    }
    
    public MovieEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"MOVIE_ENTITY\" (" + //
                "\"ID\" TEXT PRIMARY KEY NOT NULL ," + // 0: id
                "\"TITLE\" TEXT," + // 1: title
                "\"ORIGINAL_TITLE\" TEXT," + // 2: original_title
                "\"ALT\" TEXT," + // 3: alt
                "\"IMAGES\" TEXT," + // 4: images
                "\"RATING\" TEXT," + // 5: rating
                "\"YEAR\" TEXT," + // 6: year
                "\"SUBTYPE\" TEXT);"); // 7: subtype
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"MOVIE_ENTITY\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, MovieEntity entity) {
        stmt.clearBindings();
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(1, id);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(2, title);
        }
 
        String original_title = entity.getOriginal_title();
        if (original_title != null) {
            stmt.bindString(3, original_title);
        }
 
        String alt = entity.getAlt();
        if (alt != null) {
            stmt.bindString(4, alt);
        }
 
        MovieImages images = entity.getImages();
        if (images != null) {
            stmt.bindString(5, imagesConverter.convertToDatabaseValue(images));
        }
 
        MovieRating rating = entity.getRating();
        if (rating != null) {
            stmt.bindString(6, ratingConverter.convertToDatabaseValue(rating));
        }
 
        String year = entity.getYear();
        if (year != null) {
            stmt.bindString(7, year);
        }
 
        String subtype = entity.getSubtype();
        if (subtype != null) {
            stmt.bindString(8, subtype);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, MovieEntity entity) {
        stmt.clearBindings();
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(1, id);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(2, title);
        }
 
        String original_title = entity.getOriginal_title();
        if (original_title != null) {
            stmt.bindString(3, original_title);
        }
 
        String alt = entity.getAlt();
        if (alt != null) {
            stmt.bindString(4, alt);
        }
 
        MovieImages images = entity.getImages();
        if (images != null) {
            stmt.bindString(5, imagesConverter.convertToDatabaseValue(images));
        }
 
        MovieRating rating = entity.getRating();
        if (rating != null) {
            stmt.bindString(6, ratingConverter.convertToDatabaseValue(rating));
        }
 
        String year = entity.getYear();
        if (year != null) {
            stmt.bindString(7, year);
        }
 
        String subtype = entity.getSubtype();
        if (subtype != null) {
            stmt.bindString(8, subtype);
        }
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    @Override
    public MovieEntity readEntity(Cursor cursor, int offset) {
        MovieEntity entity = new MovieEntity( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // title
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // original_title
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // alt
            cursor.isNull(offset + 4) ? null : imagesConverter.convertToEntityProperty(cursor.getString(offset + 4)), // images
            cursor.isNull(offset + 5) ? null : ratingConverter.convertToEntityProperty(cursor.getString(offset + 5)), // rating
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // year
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7) // subtype
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, MovieEntity entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setTitle(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setOriginal_title(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setAlt(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setImages(cursor.isNull(offset + 4) ? null : imagesConverter.convertToEntityProperty(cursor.getString(offset + 4)));
        entity.setRating(cursor.isNull(offset + 5) ? null : ratingConverter.convertToEntityProperty(cursor.getString(offset + 5)));
        entity.setYear(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setSubtype(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
     }
    
    @Override
    protected final String updateKeyAfterInsert(MovieEntity entity, long rowId) {
        return entity.getId();
    }
    
    @Override
    public String getKey(MovieEntity entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(MovieEntity entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
