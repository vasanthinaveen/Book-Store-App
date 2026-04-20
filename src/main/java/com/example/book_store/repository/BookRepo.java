package com.example.book_store.repository;

import com.example.book_store.entity.Book;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

public interface BookRepo extends MongoRepository<Book,String>
{
@Query("{bookId:'?0'}")
    Book findBookId(String bookId);

@Query(value="{'bookId':{$eq:?0}}")
    @Update(pipeline={"{'$set':{'name':?1}}"})
    void updateBookNameByBookId(String bookId,String name);


}
