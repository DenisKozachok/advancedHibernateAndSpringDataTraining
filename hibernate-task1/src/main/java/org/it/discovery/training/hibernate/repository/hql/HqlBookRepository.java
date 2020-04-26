package org.it.discovery.training.hibernate.repository.hql;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.it.discovery.training.hibernate.model.Book;
import org.it.discovery.training.hibernate.model.tuple.BookInfo;
import org.it.discovery.training.hibernate.model.tuple.LibraryInfo;
import org.it.discovery.training.hibernate.repository.BookRepository;

import java.util.List;

@RequiredArgsConstructor
public class HqlBookRepository implements BookRepository {
    private final SessionFactory sessionFactory;

    @Override
    public List<Book> findAll() {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Query<Book> query = session.createQuery("FROM Book", Book.class);
            query.setCacheable(true);
            List<Book> books = query.list();
            session.getTransaction().commit();
            return books;
        } catch (Exception ex) {
            if (session != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Book> findWithName(String name) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Query<Book> query = session.createQuery("FROM Book WHERE name=:name", Book.class);
            query.setParameter("name", name);
            List<Book> books = query.list();
            session.getTransaction().commit();
            return books;
        } catch (Exception ex) {
            if (session != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Book> findWithHits() {
        return null;
    }

    @Override
    public List<Book> findWithMorePages(int pages) {
        return null;
    }

    @Override
    public List<Book> searchBooks(String name, int pages) {
        return null;
    }

    @Override
    public int findTotalPages() {
        return 0;
    }

    @Override
    public List<Book> findSortedBooks() {
        return null;
    }

    @Override
    public LibraryInfo findLibraryInfo() {
        //TODO
        return null;
    }

    @Override
    public BookInfo findBookInfo(int bookId) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Query<BookInfo> query = session.createQuery(
                    "select new org.it.discovery.training.hibernate.model.tuple.BookInfo(id, name) FROM Book "+
                            "WHERE id=:id", BookInfo.class);
            query.setParameter("id", bookId);
            List<BookInfo> books = query.getResultList();
            session.getTransaction().commit();
            return books.isEmpty()? null: books.get(0);
        } catch (Exception ex) {
            if (session != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            throw new RuntimeException(ex);
        }
    }
}
