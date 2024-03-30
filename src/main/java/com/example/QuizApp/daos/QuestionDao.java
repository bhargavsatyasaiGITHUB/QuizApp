package com.example.QuizApp.daos;

import com.example.QuizApp.models.Question;
import lombok.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {
    List<Question> findByCategory(String category);

  //  @Query(value ="SELECT q.id from question q where q.category=:category ORDER BY RANDOM() LIMIT:numQues",nativeQuery = true)
    //List<Question> findRandomQuestionsByCategory(String category, int numQues);

  @Query(value = "SELECT * FROM Question q Where q.category=:category  LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numQ);
}
