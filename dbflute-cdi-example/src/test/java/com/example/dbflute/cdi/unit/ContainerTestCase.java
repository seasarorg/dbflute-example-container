package com.example.dbflute.cdi.unit;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.seasar.dbflute.AccessContext;
import org.seasar.dbflute.BehaviorSelector;
import org.seasar.dbflute.bhv.DeleteOption;
import org.seasar.dbflute.cbean.PagingResultBean;
import org.seasar.dbflute.util.DfTypeUtil;
import org.seasar.junitcdi.core.runner.CDI;

import com.example.dbflute.cdi.dbflute.cbean.MemberAddressCB;
import com.example.dbflute.cdi.dbflute.cbean.MemberLoginCB;
import com.example.dbflute.cdi.dbflute.cbean.MemberSecurityCB;
import com.example.dbflute.cdi.dbflute.cbean.MemberServiceCB;
import com.example.dbflute.cdi.dbflute.cbean.MemberWithdrawalCB;
import com.example.dbflute.cdi.dbflute.cbean.PurchaseCB;
import com.example.dbflute.cdi.dbflute.exbhv.MemberAddressBhv;
import com.example.dbflute.cdi.dbflute.exbhv.MemberLoginBhv;
import com.example.dbflute.cdi.dbflute.exbhv.MemberSecurityBhv;
import com.example.dbflute.cdi.dbflute.exbhv.MemberServiceBhv;
import com.example.dbflute.cdi.dbflute.exbhv.MemberWithdrawalBhv;
import com.example.dbflute.cdi.dbflute.exbhv.PurchaseBhv;

/**
 * The test base of the application.
 * @author taktos
 * @since 0.9.8.3 (2011/05/15 Sunday)
 */
@RunWith(CDI.class)
public abstract class ContainerTestCase extends PlainTestCase {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Log instance for sub class. */
    private static final Log _log = LogFactory.getLog(ContainerTestCase.class);

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected Timestamp accessTimestamp;

    protected String accessUser;

    protected String accessProcess;

    @Inject
    protected UserTransaction userTransaction;

    // ===================================================================================
    //                                                                            Settings
    //                                                                            ========
    @Before
    public void setUp() {
        this.initializeTestCaseAccessContext();
    }

    protected void initializeTestCaseAccessContext() {
        // save common column values as expected values for assertion
        this.accessTimestamp = this.currentTimestamp();
        this.accessUser = "testUser";
        this.accessProcess = DfTypeUtil.toClassTitle(this);

        // create an access context, set to a thread local
        this.prepareAccessContextOnThread();
    }

    protected void prepareAccessContextOnThread() {
        // create an access context, set to a thread local
        final AccessContext context = new AccessContext();
        context.setAccessTimestamp(this.accessTimestamp);
        context.setAccessUser(this.accessUser);
        context.setAccessProcess(this.accessProcess + "[" + Thread.currentThread().getName() + "]");
        AccessContext.setAccessContextOnThread(context);
    }

    @After
    public void tearDown() {
        this.destroyAccessContext();
    }

    protected void destroyAccessContext() {
        AccessContext.clearAccessContextOnThread();
    }

    protected TransactionResource beginNewTransaction() {
        try {
            this.userTransaction.begin();
        } catch (final SystemException e) {
            throw new IllegalStateException(e);
        } catch (final NotSupportedException e) {
            throw new IllegalStateException(e);
        }
        final TransactionResource resource = new TransactionResource();
        resource.setUserTransaction(this.userTransaction);
        return resource;
    }

    protected static class TransactionResource {
        protected UserTransaction userTransaction;

        public void commit() {
            try {
                this.userTransaction.commit();
            } catch (final Exception e) {
                throw new IllegalStateException(e);
            }
        }

        public void rollback() {
            try {
                this.userTransaction.rollback();
            } catch (final SystemException e) {
                throw new IllegalStateException(e);
            }
        }

        public UserTransaction getUserTransaction() {
            return this.userTransaction;
        }

        public void setUserTransaction(final UserTransaction transactionManager) {
            this.userTransaction = transactionManager;
        }
    }

    // ===================================================================================
    //                                                                       Assist Helper
    //                                                                       =============
    @Inject
    private BehaviorSelector _behaviorSelector;

    protected void deleteMemberReferrer() {
        {
            final MemberServiceBhv bhv = this._behaviorSelector.select(MemberServiceBhv.class);
            final MemberServiceCB cb = bhv.newMyConditionBean();
            bhv.varyingQueryDelete(cb, new DeleteOption<MemberServiceCB>().allowNonQueryDelete());
        }
        {
            final MemberAddressBhv bhv = this._behaviorSelector.select(MemberAddressBhv.class);
            final MemberAddressCB cb = bhv.newMyConditionBean();
            bhv.varyingQueryDelete(cb, new DeleteOption<MemberAddressCB>().allowNonQueryDelete());
        }
        {
            final MemberLoginBhv bhv = this._behaviorSelector.select(MemberLoginBhv.class);
            final MemberLoginCB cb = bhv.newMyConditionBean();
            bhv.varyingQueryDelete(cb, new DeleteOption<MemberLoginCB>().allowNonQueryDelete());
        }
        {
            final MemberSecurityBhv bhv = this._behaviorSelector.select(MemberSecurityBhv.class);
            final MemberSecurityCB cb = bhv.newMyConditionBean();
            bhv.varyingQueryDelete(cb, new DeleteOption<MemberSecurityCB>().allowNonQueryDelete());
        }
        {
            final MemberWithdrawalBhv bhv = this._behaviorSelector.select(MemberWithdrawalBhv.class);
            final MemberWithdrawalCB cb = bhv.newMyConditionBean();
            bhv.varyingQueryDelete(cb, new DeleteOption<MemberWithdrawalCB>().allowNonQueryDelete());
        }
        {
            final PurchaseBhv bhv = this._behaviorSelector.select(PurchaseBhv.class);
            final PurchaseCB cb = bhv.newMyConditionBean();
            bhv.varyingQueryDelete(cb, new DeleteOption<PurchaseCB>().allowNonQueryDelete());
        }
    }

    /**
     * Show the contents of pages.
     * @param pages The array of page. (NotNull)
     */
    protected void showPage(final PagingResultBean<? extends Object>... pages) {
        for (final PagingResultBean<? extends Object> page : pages) {
            this.log(page);
        }
        int count = 1;
        for (final PagingResultBean<? extends Object> page : pages) {
            this.log("[page" + count + "]");
            for (final Object entity : page) {
                this.log("  " + entity);
            }
            ++count;
        }
    }

    /**
     * Show the contents of lists.
     * @param lss The array of list. (NotNull)
     */
    protected void showList(final List<? extends Object>... lss) {
        for (final List<? extends Object> ls : lss) {
            this.log(ls);
        }
        int count = 1;
        for (final List<? extends Object> ls : lss) {
            this.log("[page" + count + "]");
            for (final Object entity : ls) {
                this.log("  " + entity);
            }
            ++count;
        }
    }

    // ===================================================================================
    //                                                                      General Helper
    //                                                                      ==============
    @Override
    protected void log(final Object msg) {
        _log.debug(msg);
    }

    @Override
    protected Date currentDate() {
        return new Date(System.currentTimeMillis());
    }

    @Override
    protected Timestamp currentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    protected static String getLineSeparator() {
        return System.getProperty("line.separator");
    }
}
