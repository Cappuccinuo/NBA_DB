package com.example.easynotes.dao;

import com.example.easynotes.model.GameInfo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class GameInfoDao {
    @PersistenceContext
    EntityManager em;

    public List<GameInfo> getGamesOnDate(String date) {
        try {
            Query query = em.createNamedQuery("TeamGame.getGameOnDate");
            query.setParameter(1, date);
            return (List<GameInfo>)query.getResultList();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
