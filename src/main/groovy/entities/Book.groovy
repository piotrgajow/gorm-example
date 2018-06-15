package entities

import grails.gorm.annotation.Entity
import groovy.transform.ToString
import org.grails.datastore.gorm.GormEntity

import java.time.LocalDate

@Entity
@ToString
class Book implements GormEntity<Book> {

    String title
    Integer numberOfPages
    Boolean hasHardCover
    LocalDate releaseDate

}
