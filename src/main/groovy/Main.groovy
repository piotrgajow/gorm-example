import entities.Book
import org.grails.orm.hibernate.HibernateDatastore

import java.time.LocalDate

class Main {

    static void main(String[] args) {
        Map configuration = [
                'hibernate.hbm2ddl.auto'    : 'update',
                'dataSource.dialect'        : 'org.hibernate.dialect.MySQL57InnoDBDialect',
                'dataSource.driverClassName': 'com.mysql.cj.jdbc.Driver',
                'dataSource.url'            : 'jdbc:mysql://localhost:3306/gorm_example?serverTimezone=UTC&useSSL=false',
                'dataSource.username'       : 'root',
                'dataSource.password'       : '',
        ]
        HibernateDatastore datastore = new HibernateDatastore(configuration, Book)
        datastore.withNewSession {
            new Book(
                    title: 'Hibernate: A Developers Notebook',
                    releaseDate: LocalDate.of(2004, 5, 20),
                    hasHardCover: true,
                    numberOfPages: 192,
            ).save()

            new Book(
                    title: 'Just Hibernate',
                    releaseDate: LocalDate.of(2014, 6, 10),
                    hasHardCover: false,
                    numberOfPages: 140,
            ).save()

            println Book.count()
            println Book.list()
            println Book.findAllByNumberOfPagesGreaterThan(150)
            println Book.findAllByNumberOfPagesGreaterThan(200)
            println Book.findAllByReleaseDateBetween(LocalDate.of(2010, 1, 1), LocalDate.now())
        }
    }

}
