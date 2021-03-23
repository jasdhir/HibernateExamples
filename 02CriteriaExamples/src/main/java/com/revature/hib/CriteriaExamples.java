package com.revature.hib;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class CriteriaExamples {
	public static void main(String[] args) {
		Transaction transactionOne = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		/*
		 * Criteria crit = session.createCriteria(Student.class); List<Student> results
		 * = crit.list(); results.forEach(s
		 * ->System.out.println(s.getId()+"  "+s.getFirstName()));
		 */

		/*
		 * Criteria crit = session.createCriteria(Student.class);
		 * crit.add(Restrictions.ne("firstName","Sooraj")); List<Student> results =
		 * crit.list(); results.forEach(s ->
		 * System.out.println(s.getId()+"  "+s.getFirstName()));
		 */

		/*
		 * Criteria crit = session.createCriteria(Student.class);
		 * crit.add(Restrictions.like("firstName","Hun%",MatchMode.START));
		 * List<Student> results = crit.list();
		 * results.forEach(s->System.out.println(s.getId()+"  "+s.getFirstName()));
		 */

		/*
		 * Criteria crit = session.createCriteria(Student.class);
		 * crit.add(Restrictions.gt("id", 15)); List<Student> results = crit.list();
		 * results.forEach(s ->System.out.println(s.getId()+"  "+s.getFirstName()));
		 */

		/*
		 * Criteria crit = session.createCriteria(Student.class);
		 * crit.add(Restrictions.gt("id",10));
		 * crit.add(Restrictions.like("firstName","Hun%", MatchMode.ANYWHERE));
		 * List<Student> results = crit.list();
		 * results.forEach(s->System.out.println(s.getId()+"  "+s.getFirstName()));
		 */

		Criteria crit = session.createCriteria(Student.class);
		Criterion priceLessThan = Restrictions.lt("id", 20);
		Criterion mouse = Restrictions.ilike("firstName", "Hun%", MatchMode.ANYWHERE);
		LogicalExpression orExp = Restrictions.or(priceLessThan, mouse);
		crit.add(orExp);
		List<Student> results = crit.list();
		results.forEach(s -> System.out.println(s.getId() + "  " + s.getFirstName()));

		
		  Criteria crit1 = session.createCriteria(Student.class);
		  crit1.add(Restrictions.eq("id", 10)); Student student = (Student)
		  crit1.uniqueResult(); System.out.println(student.getId() + "   "
		  +student.getFirstName());
		 
	}
}
