package com.testask.shortenerURL.repository;

import com.testask.shortenerURL.domain.Tag;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of {@link TagRepository} interface.
 *
 * @author Sergey Katashevich
 * @version 1.0
 */

@Repository
@Transactional
public class TagRepositoryImpl implements TagRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addTag(Tag tag) {
        this.sessionFactory.getCurrentSession().save(tag);
    }

    @Override
    public Tag tagByName(String nameTag) {
        Criteria cr = this.sessionFactory.getCurrentSession()
                .createCriteria(Tag.class, "tag")
                .add(Restrictions.like("nameTag", nameTag));
        return (Tag) cr.uniqueResult();
    }
}
