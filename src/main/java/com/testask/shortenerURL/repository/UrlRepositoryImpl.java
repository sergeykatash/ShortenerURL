package com.testask.shortenerURL.repository;

import com.testask.shortenerURL.domain.Url;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UrlRepositoryImpl implements UrlRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void addUrl(Url url) {
        this.sessionFactory.getCurrentSession().save(url);
    }

    public List<Url> listUrls() {
        return this.sessionFactory.getCurrentSession().createQuery("from Url").list();
    }

    public void removeUrl(long id) {
        Url url = (Url) this.sessionFactory.getCurrentSession().load(Url.class, new Long(id));

        if (url!=null){
            this.sessionFactory.getCurrentSession().delete(url);
        }

    }

    @Override
    public Url getUrlById(long id) {
        return (Url)this.sessionFactory.getCurrentSession().get(Url.class, new Long(id));
    }

    @Override
    public List<Url> getUrlsByTag(String nameTag) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Url.class, "url");
        criteria.createAlias("url.tag", "tag");
        criteria.add(Restrictions.eq("tag.nameTag", nameTag));
        return (List<Url>) criteria.list();
    }

    @Override
    public void updateUrl(Url url) {
        this.sessionFactory.getCurrentSession().update(url);
    }


}

