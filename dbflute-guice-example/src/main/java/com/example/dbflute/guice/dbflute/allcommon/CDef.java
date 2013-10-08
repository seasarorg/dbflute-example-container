package com.example.dbflute.guice.dbflute.allcommon;

import java.util.*;

import org.seasar.dbflute.jdbc.Classification;
import org.seasar.dbflute.jdbc.ClassificationCodeType;
import org.seasar.dbflute.jdbc.ClassificationMeta;

/**
 * The definition of classification.
 * @author DBFlute(AutoGenerator)
 */
public interface CDef extends Classification {

    /** The empty array for no sisters. */
    String[] EMPTY_SISTERS = new String[]{};

    /** The empty map for no sub-items. */
    @SuppressWarnings("unchecked")
    Map<String, Object> EMPTY_SUB_ITEM_MAP = (Map<String, Object>)Collections.EMPTY_MAP;

    /**
     * general boolean classification for every flg-column
     */
    public enum Flg implements CDef {
        /** Yes: means valid */
        True("1", "Yes", EMPTY_SISTERS)
        ,
        /** No: means invalid */
        False("0", "No", EMPTY_SISTERS)
        ;
        private static final Map<String, Flg> _codeValueMap = new HashMap<String, Flg>();
        static {
            for (Flg value : values()) {
                _codeValueMap.put(value.code().toLowerCase(), value);
                for (String sister : value.sisters()) { _codeValueMap.put(sister.toLowerCase(), value); }
            }
        }
        private static final Map<String, Map<String, Object>> _subItemMapMap = new HashMap<String, Map<String, Object>>();
        static {
            {
                Map<String, Object> subItemMap = new HashMap<String, Object>();
                subItemMap.put("key1", "value1");
                _subItemMapMap.put(True.code(), Collections.unmodifiableMap(subItemMap));
            }
            {
                Map<String, Object> subItemMap = new HashMap<String, Object>();
                subItemMap.put("key1", "value1");
                _subItemMapMap.put(False.code(), Collections.unmodifiableMap(subItemMap));
            }
        }
        private String _code; private String _alias; private String[] _sisters;
        private Flg(String code, String alias, String[] sisters)
        { _code = code; _alias = alias; _sisters = sisters; }
        public String code() { return _code; } public String alias() { return _alias; }
        private String[] sisters() { return _sisters; }
        public Map<String, Object> subItemMap() { return _subItemMapMap.get(code()); }
        public ClassificationMeta meta() { return CDef.DefMeta.Flg; }

        public String key1() {
            return (String)subItemMap().get("key1");
        }

        public boolean inGroup(String groupName) {
            return false;
        }

        /**
         * Get the classification by the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static Flg codeOf(Object code) {
            if (code == null) { return null; }
            if (code instanceof Flg) { return (Flg)code; }
            return _codeValueMap.get(code.toString().toLowerCase());
        }

        /**
         * Get the classification by the name (also called 'value' in ENUM world).
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         */
        public static Flg nameOf(String name) {
            if (name == null) { return null; }
            try { return valueOf(name); } catch (RuntimeException ignored) { return null; }
        }

        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The list of all classification elements. (NotNull)
         */
        public static List<Flg> listAll() {
            return new ArrayList<Flg>(Arrays.asList(values()));
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br />
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The list of classification elements in the group. (NotNull)
         */
        public static List<Flg> groupOf(String groupName) {
            return new ArrayList<Flg>(4);
        }

        @Override public String toString() { return code(); }
    }

    /**
     * status of member from entry to withdrawal
     */
    public enum MemberStatus implements CDef {
        /** Formalized: as formal member, allowed to use all service */
        Formalized("FML", "Formalized", EMPTY_SISTERS)
        ,
        /** Withdrawal: withdrawal is fixed, not allowed to use service */
        Withdrawal("WDL", "Withdrawal", EMPTY_SISTERS)
        ,
        /** Provisional: first status after entry, allowed to use only part of service */
        Provisional("PRV", "Provisional", EMPTY_SISTERS)
        ;
        private static final Map<String, MemberStatus> _codeValueMap = new HashMap<String, MemberStatus>();
        static {
            for (MemberStatus value : values()) {
                _codeValueMap.put(value.code().toLowerCase(), value);
                for (String sister : value.sisters()) { _codeValueMap.put(sister.toLowerCase(), value); }
            }
        }
        private static final Map<String, Map<String, Object>> _subItemMapMap = new HashMap<String, Map<String, Object>>();
        static {
            {
                Map<String, Object> subItemMap = new HashMap<String, Object>();
                subItemMap.put("key1", "1");
                subItemMap.put("key2", "as formal member, allowed to use all service");
                _subItemMapMap.put(Formalized.code(), Collections.unmodifiableMap(subItemMap));
            }
            {
                Map<String, Object> subItemMap = new HashMap<String, Object>();
                subItemMap.put("key1", "2");
                subItemMap.put("key2", "withdrawal is fixed, not allowed to use service");
                _subItemMapMap.put(Withdrawal.code(), Collections.unmodifiableMap(subItemMap));
            }
            {
                Map<String, Object> subItemMap = new HashMap<String, Object>();
                subItemMap.put("key1", "3");
                subItemMap.put("key2", "first status after entry, allowed to use only part of service");
                _subItemMapMap.put(Provisional.code(), Collections.unmodifiableMap(subItemMap));
            }
        }
        private String _code; private String _alias; private String[] _sisters;
        private MemberStatus(String code, String alias, String[] sisters)
        { _code = code; _alias = alias; _sisters = sisters; }
        public String code() { return _code; } public String alias() { return _alias; }
        private String[] sisters() { return _sisters; }
        public Map<String, Object> subItemMap() { return _subItemMapMap.get(code()); }
        public ClassificationMeta meta() { return CDef.DefMeta.MemberStatus; }

        public String key1() {
            return (String)subItemMap().get("key1");
        }

        public String key2() {
            return (String)subItemMap().get("key2");
        }

        public boolean inGroup(String groupName) {
            return false;
        }

        /**
         * Get the classification by the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static MemberStatus codeOf(Object code) {
            if (code == null) { return null; }
            if (code instanceof MemberStatus) { return (MemberStatus)code; }
            return _codeValueMap.get(code.toString().toLowerCase());
        }

        /**
         * Get the classification by the name (also called 'value' in ENUM world).
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         */
        public static MemberStatus nameOf(String name) {
            if (name == null) { return null; }
            try { return valueOf(name); } catch (RuntimeException ignored) { return null; }
        }

        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The list of all classification elements. (NotNull)
         */
        public static List<MemberStatus> listAll() {
            return new ArrayList<MemberStatus>(Arrays.asList(values()));
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br />
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The list of classification elements in the group. (NotNull)
         */
        public static List<MemberStatus> groupOf(String groupName) {
            return new ArrayList<MemberStatus>(4);
        }

        @Override public String toString() { return code(); }
    }

    /**
     * rank of service member gets
     */
    public enum ServiceRank implements CDef {
        /** PLATINUM: platinum rank */
        Platinum("PLT", "PLATINUM", EMPTY_SISTERS)
        ,
        /** GOLD: gold rank */
        Gold("GLD", "GOLD", EMPTY_SISTERS)
        ,
        /** SILVER: silver rank */
        Silver("SIL", "SILVER", EMPTY_SISTERS)
        ,
        /** BRONZE: bronze rank */
        Bronze("BRZ", "BRONZE", EMPTY_SISTERS)
        ,
        /** PLASTIC: plastic rank */
        Plastic("PLS", "PLASTIC", EMPTY_SISTERS)
        ;
        private static final Map<String, ServiceRank> _codeValueMap = new HashMap<String, ServiceRank>();
        static {
            for (ServiceRank value : values()) {
                _codeValueMap.put(value.code().toLowerCase(), value);
                for (String sister : value.sisters()) { _codeValueMap.put(sister.toLowerCase(), value); }
            }
        }
        private String _code; private String _alias; private String[] _sisters;
        private ServiceRank(String code, String alias, String[] sisters)
        { _code = code; _alias = alias; _sisters = sisters; }
        public String code() { return _code; } public String alias() { return _alias; }
        private String[] sisters() { return _sisters; }
        public Map<String, Object> subItemMap() { return EMPTY_SUB_ITEM_MAP; }
        public ClassificationMeta meta() { return CDef.DefMeta.ServiceRank; }

        public boolean inGroup(String groupName) {
            return false;
        }

        /**
         * Get the classification by the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static ServiceRank codeOf(Object code) {
            if (code == null) { return null; }
            if (code instanceof ServiceRank) { return (ServiceRank)code; }
            return _codeValueMap.get(code.toString().toLowerCase());
        }

        /**
         * Get the classification by the name (also called 'value' in ENUM world).
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         */
        public static ServiceRank nameOf(String name) {
            if (name == null) { return null; }
            try { return valueOf(name); } catch (RuntimeException ignored) { return null; }
        }

        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The list of all classification elements. (NotNull)
         */
        public static List<ServiceRank> listAll() {
            return new ArrayList<ServiceRank>(Arrays.asList(values()));
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br />
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The list of classification elements in the group. (NotNull)
         */
        public static List<ServiceRank> groupOf(String groupName) {
            return new ArrayList<ServiceRank>(4);
        }

        @Override public String toString() { return code(); }
    }

    public enum DefMeta implements ClassificationMeta {
        /** general boolean classification for every flg-column */
        Flg
        ,
        /** status of member from entry to withdrawal */
        MemberStatus
        ,
        /** rank of service member gets */
        ServiceRank
        ;
        public Classification codeOf(Object code) {
            if ("Flg".equals(name())) { return CDef.Flg.codeOf(code); }
            if ("MemberStatus".equals(name())) { return CDef.MemberStatus.codeOf(code); }
            if ("ServiceRank".equals(name())) { return CDef.ServiceRank.codeOf(code); }
            throw new IllegalStateException("Unknown definition: " + this); // basically unreachable
        }

        public Classification nameOf(String name) {
            if ("Flg".equals(name())) { return CDef.Flg.valueOf(name); }
            if ("MemberStatus".equals(name())) { return CDef.MemberStatus.valueOf(name); }
            if ("ServiceRank".equals(name())) { return CDef.ServiceRank.valueOf(name); }
            throw new IllegalStateException("Unknown definition: " + this); // basically unreachable
        }

        public List<Classification> listAll() {
            if ("Flg".equals(name())) { return toClassificationList(CDef.Flg.listAll()); }
            if ("MemberStatus".equals(name())) { return toClassificationList(CDef.MemberStatus.listAll()); }
            if ("ServiceRank".equals(name())) { return toClassificationList(CDef.ServiceRank.listAll()); }
            throw new IllegalStateException("Unknown definition: " + this); // basically unreachable
        }

        public List<Classification> groupOf(String groupName) {
            if ("Flg".equals(name())) { return toClassificationList(CDef.Flg.groupOf(groupName)); }
            if ("MemberStatus".equals(name())) { return toClassificationList(CDef.MemberStatus.groupOf(groupName)); }
            if ("ServiceRank".equals(name())) { return toClassificationList(CDef.ServiceRank.groupOf(groupName)); }
            throw new IllegalStateException("Unknown definition: " + this); // basically unreachable
        }

        @SuppressWarnings("unchecked")
        private List<Classification> toClassificationList(List<?> clsList) {
            return (List<Classification>)clsList;
        }

        public ClassificationCodeType codeType() {
            if ("Flg".equals(name())) { return ClassificationCodeType.Number; }
            if ("MemberStatus".equals(name())) { return ClassificationCodeType.String; }
            if ("ServiceRank".equals(name())) { return ClassificationCodeType.Number; }
            return ClassificationCodeType.String; // as default
        }
    }
}
