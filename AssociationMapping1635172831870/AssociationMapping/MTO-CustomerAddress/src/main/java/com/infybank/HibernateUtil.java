package com.infybank;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.apache.log4j.Logger;

public class HibernateUtil {
	static Logger logger = Logger.getLogger(HibernateUtil.class);
private static final SessionFactory sessionFactory;
private static StandardServiceRegistry standardServiceRegistry;
private HibernateUtil( ) {}
static {
  try {
	  standardServiceRegistry = new StandardServiceRegistryBuilder()	.configure("/com/infybank/Hibernate.cfg.xml").build();
		
		Metadata metaData = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
		
		sessionFactory = metaData.getSessionFactoryBuilder().build();
  } catch (Exception ex) {
   logger.error("Initial SessionFactory creation failed. " + ex);
   throw new ExceptionInInitializerError(ex);
  }
}
 public static SessionFactory getSessionFactory() {
  return sessionFactory;
  }
}
