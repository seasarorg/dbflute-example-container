package com.example.dbflute.cdi.unit;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.sql.DataSourceDefinition;
import javax.sql.XADataSource;

import org.seasar.dbflute.util.DfResourceUtil;
import org.seasar.extension.dbcp.impl.XADataSourceImpl;
import org.seasar.junitcdi.jta.datasource.AbstractDataSource;

import com.example.dbflute.cdi.dbflute.allcommon.DBFluteModule;

@DataSourceDefinition(name = "jdbc/exampledb",
                      className = "org.h2.Driver",
                      user = "exampledb",
                      password = "exampledb")
public class ExampleDBDataSource extends AbstractDataSource {

    /**
     * {@inheritDoc}
     *
     */
    @Override
    protected XADataSource createXADataSource(final DataSourceDefinition definition) throws SQLException {
        final XADataSourceImpl xaDataSource = new XADataSourceImpl();
        xaDataSource.setDriverClassName(definition.className());
        xaDataSource.setURL(this.getUrl("/exampledb/exampledb"));
        xaDataSource.setUser(definition.user());
        xaDataSource.setPassword(definition.password());
        xaDataSource.setLoginTimeout(definition.loginTimeout());
        return xaDataSource;
    }

    private String getUrl(final String urlSuffix) {
        try {
            final File f = DfResourceUtil.getBuildDir(DBFluteModule.class);
            final String canonicalPath = f.getCanonicalPath();
            final String url = "jdbc:h2:file:" + canonicalPath.replace('\\', '/') + urlSuffix;
            return url;
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }
}
