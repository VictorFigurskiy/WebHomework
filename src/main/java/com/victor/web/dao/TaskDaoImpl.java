package com.victor.web.dao;

import com.victor.web.entities.Goal;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sonikb on 19.07.2017.
 */
public class TaskDaoImpl implements TaskDAO {

    private static final Logger logger = Logger.getLogger(TaskDaoImpl.class);
    private static final java.util.logging.Logger logger2 = java.util.logging.Logger.getLogger(TaskDaoImpl.class.getName());


    @Override
    public void add(Goal goal) {
        EntityManager em = null;
        try {
            em = JpaUtil.getEntityManager();
            em.getTransaction().begin();
            em.persist(goal);
            em.getTransaction().commit();
            logger.info("Goal successfully saved. Goal details: " + goal);
        } catch (RuntimeException e) {
            logger.error(e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Goal read(int id) {
        EntityManager em = null;
        Goal goal = null;
        try {
            em = JpaUtil.getEntityManager();
            em.getTransaction().begin();
            goal = em.find(Goal.class, id);
            em.getTransaction().commit();
            logger.info("Goal successfully loaded. Goal details: " + goal);
        } catch (RuntimeException e) {
            logger.error(e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return goal;
    }

    @Override
    public void delete(Goal goal) {
        EntityManager em = null;
        try {
            em = JpaUtil.getEntityManager();
            em.getTransaction().begin();
            em.remove(em.contains(goal) ? goal : em.merge(goal));
            em.getTransaction().commit();
            logger.info("Goal successfully removed. Goal details: " + goal);
        } catch (RuntimeException e) {
            logger.error(e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void update(Goal goal) {
        EntityManager em = null;
        try {
            em = JpaUtil.getEntityManager();
            em.getTransaction().begin();
            em.merge(goal);
            em.getTransaction().commit();
            logger.info("Goal successfully update. Goal details: " + goal);
        } catch (RuntimeException e) {
            logger.error(e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Goal> readAll() {
        EntityManager em = null;
        List<Goal> goalList = new ArrayList<>();
        try {
            em = JpaUtil.getEntityManager();
            em.getTransaction().begin();
            TypedQuery<Goal> query = em.createQuery("select g from Goal g", Goal.class);
            goalList = query.getResultList();
            em.getTransaction().commit();
            for (Goal goal : goalList) {
                logger.info("Book list: " + goal);
            }
        } catch (RuntimeException e) {
            logger.error(e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return goalList;
    }
}
