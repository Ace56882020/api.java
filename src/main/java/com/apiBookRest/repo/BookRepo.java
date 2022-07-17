

package com.apiBookRest.repo;

import com.apiBookRest.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ACE
 */
@Repository
public interface BookRepo extends JpaRepository<Book, Integer>{

}
