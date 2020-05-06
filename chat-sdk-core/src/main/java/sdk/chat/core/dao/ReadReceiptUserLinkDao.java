package sdk.chat.core.dao;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.SqlUtils;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import org.joda.time.DateTime;
import sdk.chat.core.utils.DaoDateTimeConverter;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "READ_RECEIPT_USER_LINK".
*/
public class ReadReceiptUserLinkDao extends AbstractDao<ReadReceiptUserLink, Long> {

    public static final String TABLENAME = "READ_RECEIPT_USER_LINK";

    /**
     * Properties of entity ReadReceiptUserLink.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property MessageId = new Property(1, Long.class, "messageId", false, "MESSAGE_ID");
        public final static Property UserId = new Property(2, Long.class, "userId", false, "USER_ID");
        public final static Property Status = new Property(3, Integer.class, "status", false, "STATUS");
        public final static Property Date = new Property(4, Long.class, "date", false, "DATE");
    }

    private DaoSession daoSession;

    private final DaoDateTimeConverter dateConverter = new DaoDateTimeConverter();
    private Query<ReadReceiptUserLink> message_ReadReceiptLinksQuery;

    public ReadReceiptUserLinkDao(DaoConfig config) {
        super(config);
    }
    
    public ReadReceiptUserLinkDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"READ_RECEIPT_USER_LINK\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"MESSAGE_ID\" INTEGER," + // 1: messageId
                "\"USER_ID\" INTEGER," + // 2: userId
                "\"STATUS\" INTEGER," + // 3: status
                "\"DATE\" INTEGER);"); // 4: date
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"READ_RECEIPT_USER_LINK\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, ReadReceiptUserLink entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long messageId = entity.getMessageId();
        if (messageId != null) {
            stmt.bindLong(2, messageId);
        }
 
        Long userId = entity.getUserId();
        if (userId != null) {
            stmt.bindLong(3, userId);
        }
 
        Integer status = entity.getStatus();
        if (status != null) {
            stmt.bindLong(4, status);
        }
 
        DateTime date = entity.getDate();
        if (date != null) {
            stmt.bindLong(5, dateConverter.convertToDatabaseValue(date));
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, ReadReceiptUserLink entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long messageId = entity.getMessageId();
        if (messageId != null) {
            stmt.bindLong(2, messageId);
        }
 
        Long userId = entity.getUserId();
        if (userId != null) {
            stmt.bindLong(3, userId);
        }
 
        Integer status = entity.getStatus();
        if (status != null) {
            stmt.bindLong(4, status);
        }
 
        DateTime date = entity.getDate();
        if (date != null) {
            stmt.bindLong(5, dateConverter.convertToDatabaseValue(date));
        }
    }

    @Override
    protected final void attachEntity(ReadReceiptUserLink entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public ReadReceiptUserLink readEntity(Cursor cursor, int offset) {
        ReadReceiptUserLink entity = new ReadReceiptUserLink( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // messageId
            cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2), // userId
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // status
            cursor.isNull(offset + 4) ? null : dateConverter.convertToEntityProperty(cursor.getLong(offset + 4)) // date
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, ReadReceiptUserLink entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setMessageId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setUserId(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
        entity.setStatus(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setDate(cursor.isNull(offset + 4) ? null : dateConverter.convertToEntityProperty(cursor.getLong(offset + 4)));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(ReadReceiptUserLink entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(ReadReceiptUserLink entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(ReadReceiptUserLink entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "readReceiptLinks" to-many relationship of Message. */
    public List<ReadReceiptUserLink> _queryMessage_ReadReceiptLinks(Long messageId) {
        synchronized (this) {
            if (message_ReadReceiptLinksQuery == null) {
                QueryBuilder<ReadReceiptUserLink> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.MessageId.eq(null));
                message_ReadReceiptLinksQuery = queryBuilder.build();
            }
        }
        Query<ReadReceiptUserLink> query = message_ReadReceiptLinksQuery.forCurrentThread();
        query.setParameter(0, messageId);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getUserDao().getAllColumns());
            builder.append(" FROM READ_RECEIPT_USER_LINK T");
            builder.append(" LEFT JOIN USER T0 ON T.\"USER_ID\"=T0.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected ReadReceiptUserLink loadCurrentDeep(Cursor cursor, boolean lock) {
        ReadReceiptUserLink entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        User user = loadCurrentOther(daoSession.getUserDao(), cursor, offset);
        entity.setUser(user);

        return entity;    
    }

    public ReadReceiptUserLink loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<ReadReceiptUserLink> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<ReadReceiptUserLink> list = new ArrayList<ReadReceiptUserLink>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<ReadReceiptUserLink> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<ReadReceiptUserLink> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}