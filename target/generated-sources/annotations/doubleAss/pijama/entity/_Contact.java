package doubleAss.pijama.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "2.27.1" }, date = "2020-03-08T23:16:04.937+0700")
public final class _Contact extends org.seasar.doma.jdbc.entity.AbstractEntityType<doubleAss.pijama.entity.Contact> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("2.27.1");
    }

    private static final _Contact __singleton = new _Contact();

    private final org.seasar.doma.jdbc.entity.NamingType __namingType = null;

    private final org.seasar.doma.jdbc.id.BuiltinIdentityIdGenerator __idGenerator = new org.seasar.doma.jdbc.id.BuiltinIdentityIdGenerator();

    /** the create_date */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<doubleAss.pijama.entity.Contact, java.time.LocalDateTime, java.time.LocalDateTime> $create_date = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(doubleAss.pijama.entity.Contact.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.LocalDateTimeWrapper::new), "create_date", "create_date", __namingType, true, true, false);

    /** the update_date */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<doubleAss.pijama.entity.Contact, java.time.LocalDateTime, java.time.LocalDateTime> $update_date = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(doubleAss.pijama.entity.Contact.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.LocalDateTimeWrapper::new), "update_date", "update_date", __namingType, true, true, false);

    /** the id */
    public final org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<doubleAss.pijama.entity.Contact, java.lang.Integer, java.lang.Integer> $id = new org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<>(doubleAss.pijama.entity.Contact.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.IntegerWrapper::new), "id", "id", __namingType, false, __idGenerator);

    /** the name */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<doubleAss.pijama.entity.Contact, java.lang.String, java.lang.String> $name = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(doubleAss.pijama.entity.Contact.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.StringWrapper::new), "name", "name", __namingType, true, true, false);

    /** the email */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<doubleAss.pijama.entity.Contact, java.lang.String, java.lang.String> $email = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(doubleAss.pijama.entity.Contact.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.StringWrapper::new), "email", "email", __namingType, true, true, false);

    /** the phone */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<doubleAss.pijama.entity.Contact, java.lang.String, java.lang.String> $phone = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(doubleAss.pijama.entity.Contact.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.StringWrapper::new), "phone", "phone", __namingType, true, true, false);

    /** the content */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<doubleAss.pijama.entity.Contact, java.lang.String, java.lang.String> $content = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(doubleAss.pijama.entity.Contact.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.StringWrapper::new), "content", "content", __namingType, true, true, false);

    /** the file */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<doubleAss.pijama.entity.Contact, java.lang.String, java.lang.String> $file = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(doubleAss.pijama.entity.Contact.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.StringWrapper::new), "file", "file", __namingType, true, true, false);

    /** the status */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<doubleAss.pijama.entity.Contact, java.lang.Integer, java.lang.Integer> $status = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(doubleAss.pijama.entity.Contact.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.IntegerWrapper::new), "status", "status", __namingType, true, true, false);

    /** the createDate */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<doubleAss.pijama.entity.Contact, java.lang.String, java.lang.String> $createDate = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(doubleAss.pijama.entity.Contact.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.StringWrapper::new), "createDate", "", __namingType, true, true, false);

    /** the updateDate */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<doubleAss.pijama.entity.Contact, java.lang.String, java.lang.String> $updateDate = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(doubleAss.pijama.entity.Contact.class, () -> new org.seasar.doma.internal.jdbc.scalar.BasicScalar<>(org.seasar.doma.wrapper.StringWrapper::new), "updateDate", "", __namingType, true, true, false);

    private final java.util.function.Supplier<org.seasar.doma.jdbc.entity.NullEntityListener<doubleAss.pijama.entity.Contact>> __listenerSupplier;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final boolean __isQuoteRequired;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<doubleAss.pijama.entity.Contact, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<doubleAss.pijama.entity.Contact, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<doubleAss.pijama.entity.Contact, ?>> __entityPropertyTypeMap;

    private _Contact() {
        __listenerSupplier = () -> ListenerHolder.listener;
        __immutable = false;
        __name = "Contact";
        __catalogName = "";
        __schemaName = "";
        __tableName = "contact";
        __isQuoteRequired = false;
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<doubleAss.pijama.entity.Contact, ?>> __idList = new java.util.ArrayList<>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<doubleAss.pijama.entity.Contact, ?>> __list = new java.util.ArrayList<>(11);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<doubleAss.pijama.entity.Contact, ?>> __map = new java.util.HashMap<>(11);
        __list.add($create_date);
        __map.put("create_date", $create_date);
        __list.add($update_date);
        __map.put("update_date", $update_date);
        __idList.add($id);
        __list.add($id);
        __map.put("id", $id);
        __list.add($name);
        __map.put("name", $name);
        __list.add($email);
        __map.put("email", $email);
        __list.add($phone);
        __map.put("phone", $phone);
        __list.add($content);
        __map.put("content", $content);
        __list.add($file);
        __map.put("file", $file);
        __list.add($status);
        __map.put("status", $status);
        __list.add($createDate);
        __map.put("createDate", $createDate);
        __list.add($updateDate);
        __map.put("updateDate", $updateDate);
        __idPropertyTypes = java.util.Collections.unmodifiableList(__idList);
        __entityPropertyTypes = java.util.Collections.unmodifiableList(__list);
        __entityPropertyTypeMap = java.util.Collections.unmodifiableMap(__map);
    }

    @Override
    public org.seasar.doma.jdbc.entity.NamingType getNamingType() {
        return __namingType;
    }

    @Override
    public boolean isImmutable() {
        return __immutable;
    }

    @Override
    public String getName() {
        return __name;
    }

    @Override
    public String getCatalogName() {
        return __catalogName;
    }

    @Override
    public String getSchemaName() {
        return __schemaName;
    }

    @Override
    public String getTableName() {
        return getTableName(org.seasar.doma.jdbc.Naming.DEFAULT::apply);
    }

    @Override
    public String getTableName(java.util.function.BiFunction<org.seasar.doma.jdbc.entity.NamingType, String, String> namingFunction) {
        if (__tableName.isEmpty()) {
            return namingFunction.apply(__namingType, __name);
        }
        return __tableName;
    }

    @Override
    public boolean isQuoteRequired() {
        return __isQuoteRequired;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preInsert(doubleAss.pijama.entity.Contact entity, org.seasar.doma.jdbc.entity.PreInsertContext<doubleAss.pijama.entity.Contact> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preInsert(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preUpdate(doubleAss.pijama.entity.Contact entity, org.seasar.doma.jdbc.entity.PreUpdateContext<doubleAss.pijama.entity.Contact> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preUpdate(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preDelete(doubleAss.pijama.entity.Contact entity, org.seasar.doma.jdbc.entity.PreDeleteContext<doubleAss.pijama.entity.Contact> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preDelete(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postInsert(doubleAss.pijama.entity.Contact entity, org.seasar.doma.jdbc.entity.PostInsertContext<doubleAss.pijama.entity.Contact> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postInsert(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postUpdate(doubleAss.pijama.entity.Contact entity, org.seasar.doma.jdbc.entity.PostUpdateContext<doubleAss.pijama.entity.Contact> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postUpdate(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postDelete(doubleAss.pijama.entity.Contact entity, org.seasar.doma.jdbc.entity.PostDeleteContext<doubleAss.pijama.entity.Contact> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<doubleAss.pijama.entity.Contact, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<doubleAss.pijama.entity.Contact, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<doubleAss.pijama.entity.Contact, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<doubleAss.pijama.entity.Contact, ?, ?> getGeneratedIdPropertyType() {
        return $id;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<doubleAss.pijama.entity.Contact, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.TenantIdPropertyType<doubleAss.pijama.entity.Contact, ?, ?> getTenantIdPropertyType() {
        return null;
    }

    @Override
    public doubleAss.pijama.entity.Contact newEntity(java.util.Map<String, org.seasar.doma.jdbc.entity.Property<doubleAss.pijama.entity.Contact, ?>> __args) {
        doubleAss.pijama.entity.Contact entity = new doubleAss.pijama.entity.Contact();
        if (__args.get("create_date") != null) __args.get("create_date").save(entity);
        if (__args.get("update_date") != null) __args.get("update_date").save(entity);
        if (__args.get("id") != null) __args.get("id").save(entity);
        if (__args.get("name") != null) __args.get("name").save(entity);
        if (__args.get("email") != null) __args.get("email").save(entity);
        if (__args.get("phone") != null) __args.get("phone").save(entity);
        if (__args.get("content") != null) __args.get("content").save(entity);
        if (__args.get("file") != null) __args.get("file").save(entity);
        if (__args.get("status") != null) __args.get("status").save(entity);
        if (__args.get("createDate") != null) __args.get("createDate").save(entity);
        if (__args.get("updateDate") != null) __args.get("updateDate").save(entity);
        return entity;
    }

    @Override
    public Class<doubleAss.pijama.entity.Contact> getEntityClass() {
        return doubleAss.pijama.entity.Contact.class;
    }

    @Override
    public doubleAss.pijama.entity.Contact getOriginalStates(doubleAss.pijama.entity.Contact __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(doubleAss.pijama.entity.Contact __entity) {
    }

    /**
     * @return the singleton
     */
    public static _Contact getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _Contact newInstance() {
        return new _Contact();
    }

    private static class ListenerHolder {
        private static org.seasar.doma.jdbc.entity.NullEntityListener<doubleAss.pijama.entity.Contact> listener = new org.seasar.doma.jdbc.entity.NullEntityListener<>();
    }

}
