package doubleAss.pijama.dao;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "2.27.1" }, date = "2020-03-08T23:16:05.304+0700")
public class ContactDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements doubleAss.pijama.dao.ContactDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("2.27.1");
    }

    private static final java.lang.reflect.Method __method0 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(doubleAss.pijama.dao.ContactDao.class, "selectAll", java.util.function.Function.class);

    private static final java.lang.reflect.Method __method1 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(doubleAss.pijama.dao.ContactDao.class, "insert", doubleAss.pijama.entity.Contact.class);

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public ContactDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<doubleAss.pijama.entity.Contact> selectAll(java.util.function.Function<java.util.stream.Stream<doubleAss.pijama.entity.Contact>, java.util.List<doubleAss.pijama.entity.Contact>> result) {
        entering("doubleAss.pijama.dao.ContactDaoImpl", "selectAll", result);
        try {
            if (result == null) {
                throw new org.seasar.doma.DomaNullPointerException("result");
            }
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method0);
            __query.setMethod(__method0);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/doubleAss/pijama/dao/ContactDao/selectAll.sql");
            __query.setEntityType(doubleAss.pijama.entity._Contact.getSingletonInternal());
            __query.setCallerClassName("doubleAss.pijama.dao.ContactDaoImpl");
            __query.setCallerMethodName("selectAll");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<java.util.List<doubleAss.pijama.entity.Contact>> __command = getCommandImplementors().createSelectCommand(__method0, __query, new org.seasar.doma.internal.jdbc.command.EntityStreamHandler<doubleAss.pijama.entity.Contact, java.util.List<doubleAss.pijama.entity.Contact>>(doubleAss.pijama.entity._Contact.getSingletonInternal(), result));
            java.util.List<doubleAss.pijama.entity.Contact> __result = __command.execute();
            __query.complete();
            exiting("doubleAss.pijama.dao.ContactDaoImpl", "selectAll", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("doubleAss.pijama.dao.ContactDaoImpl", "selectAll", __e);
            throw __e;
        }
    }

    @Override
    public int insert(doubleAss.pijama.entity.Contact Contact) {
        entering("doubleAss.pijama.dao.ContactDaoImpl", "insert", Contact);
        try {
            if (Contact == null) {
                throw new org.seasar.doma.DomaNullPointerException("Contact");
            }
            org.seasar.doma.jdbc.query.AutoInsertQuery<doubleAss.pijama.entity.Contact> __query = getQueryImplementors().createAutoInsertQuery(__method1, doubleAss.pijama.entity._Contact.getSingletonInternal());
            __query.setMethod(__method1);
            __query.setConfig(__config);
            __query.setEntity(Contact);
            __query.setCallerClassName("doubleAss.pijama.dao.ContactDaoImpl");
            __query.setCallerMethodName("insert");
            __query.setQueryTimeout(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.setNullExcluded(false);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.jdbc.command.InsertCommand __command = getCommandImplementors().createInsertCommand(__method1, __query);
            int __result = __command.execute();
            __query.complete();
            exiting("doubleAss.pijama.dao.ContactDaoImpl", "insert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("doubleAss.pijama.dao.ContactDaoImpl", "insert", __e);
            throw __e;
        }
    }

}
