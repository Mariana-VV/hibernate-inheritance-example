package core.basesyntax.dao.ma;

import core.basesyntax.model.ma.Mentor;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class MentorDaoImpl extends PersonDaoImpl implements MentorDao {
    public MentorDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<Mentor> findByAgeGreaterThan(int age) {
        try (Session session = sessionFactory.openSession()) {
            Query<Mentor> query = null;
            query = session.createQuery("select a from Mentor as a "
                    + "where a.age > " + age, Mentor.class);

            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Can't get animals with first letter: " + age, e);
        }
    }
}
