package doubleAss.pijama.common.sql;

public class ContactSql {
    public static final String SEARCH_BY_NAME_EMAIL = "SELECT id, create_date, "
            + "update_date, email, name, phone FROM CONTACT "
            + "WHERE name LIKE :term OR email LIKE :term "
            + "LIMIT :offset, :size";
    
    public static final String COUNT_BY_NAME_EMAIL = "SELECT COUNT(1) "
            + "FROM CONTACT WHERE name LIKE :term OR email LIKE :term";
    
    public static final String UPDATE_STATUS_CONTACT = "UPDATE contact "
            + "SET status = :status "
            + "WHERE id = :id";
}
