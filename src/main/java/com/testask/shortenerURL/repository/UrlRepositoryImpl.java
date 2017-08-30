package com.testask.shortenerURL.repository;

import com.testask.shortenerURL.domain.Url;
import org.hibernate.SessionFactory;
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


}

