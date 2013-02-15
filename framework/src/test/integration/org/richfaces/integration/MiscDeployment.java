package org.richfaces.integration;

import org.jboss.shrinkwrap.api.Filters;
import org.jboss.shrinkwrap.api.GenericArchive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ExplodedImporter;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.richfaces.deployment.Deployment;
import org.richfaces.shrinkwrap.descriptor.FaceletAsset;

public class MiscDeployment extends Deployment {

    public MiscDeployment(Class<?> testClass) {
        super(testClass);

        JavaArchive miscArchive = ShrinkWrap.create(JavaArchive.class, "richfaces-framework.jar");
        miscArchive.merge(ShrinkWrap.create(GenericArchive.class).as(ExplodedImporter.class)
                .importDirectory("target/classes/").as(GenericArchive.class),
                "/", Filters.includeAll());
        archive().addAsLibrary(miscArchive);
    }



    public FaceletAsset baseFacelet(String name) {
        FaceletAsset p = new FaceletAsset();

        this.archive().add(p, name);

        return p;
    }
}